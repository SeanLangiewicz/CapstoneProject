package view_controllers.Inventory.RAM;


import DAO.RAMImpl;
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
import model.Ram;
import util.Alerts.RAMAlertMessages;
import view_controllers.RAMSelection.RamDetailsController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAllRamController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<Ram> ramList = FXCollections.observableArrayList();
    ObservableList<Ram> ramSearchList = FXCollections.observableArrayList();

    @FXML
    private TableView<Ram> ramListTableView;

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
    private Button deleteRAMBtn;

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
        if (!searchTxtFld.getText().trim().isEmpty())
        {
            ramSearchList.clear();
            for (Ram r : ramList)
            {
                if(r.getName().contains(searchTxtFld.getText().trim()))
                {
                    ramSearchList.add(r);
                }
            }
            ramListTableView.setItems(ramSearchList);
            ramListTableView.refresh();
        }
        if (searchTxtFld.getText().isEmpty())
        {
            ramListTableView.setItems(ramList);
        }

    }

    @FXML
    void onActionViewDetailsBtn(ActionEvent event)
    {

        try
        {
            Ram selectedRam = ramListTableView.getSelectionModel().getSelectedItem();

            if(selectedRam == null)
            {
                System.out.println("No Record Selected");
                RAMAlertMessages.ramSelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/RAM/invRAM.fxml"));
            loader.load();

            invRAMController details = loader.getController();
            details.sendRecord(ramListTableView.getSelectionModel().getSelectedItem());

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
            ramList.addAll(RAMImpl.selectAllRam());

            ramListTableView.setItems(ramList);

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
    void onActionDeleteRAM(ActionEvent event) throws Exception {
        int id = ramListTableView.getSelectionModel().getSelectedItem().getId();
        Ram selectedRAM = ramListTableView.getSelectionModel().getSelectedItem();

        RAMImpl.deleteRAM(id,selectedRAM);

        ramList = RAMImpl.selectAllRam();
        ramListTableView.setItems(ramList);
        ramListTableView.refresh();


    }

    }

