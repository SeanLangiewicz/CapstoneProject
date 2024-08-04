package view_controllers.Inventory.MotherBoard;

import DAO.motherboardImpl;
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
import model.Motherboards;
import util.Alerts.MotherboardAlertMessages;
import view_controllers.MotherBoardSelection.MotherBoardDetailsController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class invAllMotherboardController implements Initializable
{
    ObservableList<Motherboards> motherboardList = FXCollections.observableArrayList();
    ObservableList<Motherboards> motherBoardInventorySearchList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;

    @FXML
    private TableView<Motherboards> motherboardTableView;

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
    private Button searchTxtBtn;

    @FXML
    private TextField searchTxtFld;
    @FXML
    private Button deleteMotherboardBtn;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSearchBtn(ActionEvent event)
    {
        if(!searchTxtFld.getText().trim().isEmpty())
        {
            motherBoardInventorySearchList.clear();
            for (Motherboards m : motherboardList)
            {
                if(m.getName().contains(searchTxtFld.getText().trim()))
                {
                    motherBoardInventorySearchList.add(m);
                }
            }
            motherboardTableView.setItems(motherBoardInventorySearchList);
            motherboardTableView.refresh();
        }
        if (searchTxtFld.getText().trim().isEmpty())
        {
            motherboardTableView.setItems(motherboardList);
        }


}

    @FXML
    void onActionViewDetailsBtn(ActionEvent event)
    {
        try
        {
            Motherboards selectedMotherboard = motherboardTableView.getSelectionModel().getSelectedItem();


            if(selectedMotherboard == null)
            {
                System.out.println("No record selected");
                MotherboardAlertMessages.motherboardSelectionError(1);
                return;
            }


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/MotherBoard" +
                    "/invMotherBoard.fxml"));
            loader.load();
            System.out.println(loader);

            invMotherBoardController detailsController = loader.getController();
            detailsController.sendRecord(motherboardTableView.getSelectionModel().getSelectedItem());

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

            motherboardList.addAll(motherboardImpl.selectAllMotherboards());

            motherboardTableView.setItems(motherboardList);

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
    void onActionDeleteMotherboard(ActionEvent event) throws Exception {
        int id = motherboardTableView.getSelectionModel().getSelectedItem().getId();
        Motherboards selectedMotherboard = motherboardTableView.getSelectionModel().getSelectedItem();

        motherboardImpl.deleteMotherBoard(id,selectedMotherboard);

        motherboardList = motherboardImpl.selectAllMotherboards();
        motherboardTableView.setItems(motherboardList);
        motherboardTableView.refresh();


    }
}
