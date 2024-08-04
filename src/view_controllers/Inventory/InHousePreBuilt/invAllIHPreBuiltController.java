package view_controllers.Inventory.InHousePreBuilt;

import DAO.inHouseImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Prebuilt;
import util.Alerts.InHouseAlertMessages;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class invAllIHPreBuiltController implements Initializable
{
    ObservableList<InHouse> AllInHousePBList = FXCollections.observableArrayList();
    ObservableList<InHouse> AllInHousePBSearchList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;

    @FXML
    private TableView<InHouse> preBuiltTableView;

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
    private Button deletePBBtn;

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
    void onActionViewDetailsBtn(ActionEvent event) throws Exception
    {
        try
        {
            Prebuilt selectedPreBuilt = preBuiltTableView.getSelectionModel().getSelectedItem();

            if(selectedPreBuilt == null)
            {
                System.out.println("no record selected");
                InHouseAlertMessages.inHouseSelectionError(1);
                return;
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/InHousePreBuilt/invUpdateIHPB.fxml"));
            loader.load();

            invUpdateIHPBController detailsController = loader.getController();
            detailsController.sendRecord(preBuiltTableView.getSelectionModel().getSelectedItem());
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
            AllInHousePBList.addAll(inHouseImpl.selectAllInHouse());


            preBuiltTableView.setItems(AllInHousePBList);

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
    void onActionDeletePB(ActionEvent event) throws Exception
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"This will delete the selected pre-built computer, do " +
                "you want to contiunue?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get()== ButtonType.OK)
        {

            int id = preBuiltTableView.getSelectionModel().getSelectedItem().getId();
            InHouse selectedInHouse = preBuiltTableView.getSelectionModel().getSelectedItem();

            inHouseImpl.deleteIHPB(id,selectedInHouse);

            AllInHousePBList = inHouseImpl.selectAllInHouse();
            preBuiltTableView.setItems(AllInHousePBList);
            preBuiltTableView.refresh();


        }



    }
    @FXML
   private void onActionSearchBtn(ActionEvent event)
    {
        if (!searchTxtFld.getText().trim().isEmpty())
        {
            AllInHousePBSearchList.clear();
            for (InHouse ih : AllInHousePBList)
            {
                if(ih.getName().contains(searchTxtFld.getText().trim()))
                {
                    AllInHousePBSearchList.add(ih);
                }
            }
            preBuiltTableView.setItems(AllInHousePBSearchList);
            preBuiltTableView.refresh();
        }
        if (searchTxtFld.getText().isEmpty())
        {
            preBuiltTableView.setItems(AllInHousePBList);
        }

    }
}
