package view_controllers.Inventory.OutSourcedPreBuilt;

import DAO.outSourcedImpl;
import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InHouse;
import model.Outsourced;
import model.Prebuilt;
import util.Alerts.OutsourcePrebuiltAlertMessages;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAllOutSourcedPBController implements Initializable
{
    ObservableList<Outsourced> allOutsourcedList = FXCollections.observableArrayList();
    ObservableList<Outsourced> allSearchedOutsourcedList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;



    @FXML
    private TableView<Outsourced> outSourcedTblView;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private TableColumn<?, ?> onHand;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private Button viewDetailsBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button deleteOutsourcedBtn;

    @FXML
    private Button searchTxtBtn;

    @FXML
    private TextField searchTxtFld;




    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewDetailsBtn(ActionEvent event)
    {
        try
        {
            Outsourced selectedOutsourced = outSourcedTblView.getSelectionModel().getSelectedItem();

            if(selectedOutsourced == null)
            {
                System.out.println("no record selected");
                OutsourcePrebuiltAlertMessages.outsourcedSelectionError(1);
                return;
            }


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/OutsourcedPreBuilt" +
                    "/invUpdateOutsourcedPB.fxml"));
            loader.load();

            invUpdateOutsourcePBController detailsController = loader.getController();
            detailsController.sendRecord(outSourcedTblView.getSelectionModel().getSelectedItem());
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {

            allOutsourcedList.addAll(outSourcedImpl.selectAllOutsourced());

            System.out.println(allOutsourcedList);


            outSourcedTblView.setItems(allOutsourcedList);

            ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            onHand.setCellValueFactory(new PropertyValueFactory<>("onHand"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));


        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionDeleteOutsourced(ActionEvent event) throws Exception {
        int id = outSourcedTblView.getSelectionModel().getSelectedItem().getId();
        Outsourced selectedOutsource = outSourcedTblView.getSelectionModel().getSelectedItem();

        outSourcedImpl.deleteOutSourcedPC(id,selectedOutsource);
        allOutsourcedList = outSourcedImpl.selectAllOutsourced();

        outSourcedTblView.setItems(allOutsourcedList);
        outSourcedTblView.refresh();

    }
    @FXML
    void onActionSearchBtn(ActionEvent event)
    {
        if (!searchTxtFld.getText().trim().isEmpty())
        {
            allSearchedOutsourcedList.clear();
            for (Outsourced os : allOutsourcedList)
            {
                if(os.getName().contains(searchTxtFld.getText().trim()))
                {
                    allSearchedOutsourcedList.add(os);
                }
            }
            outSourcedTblView.setItems(allSearchedOutsourcedList);
            outSourcedTblView.refresh();
        }
        if (searchTxtFld.getText().isEmpty())
        {
            outSourcedTblView.setItems(allOutsourcedList);
        }

    }

}
