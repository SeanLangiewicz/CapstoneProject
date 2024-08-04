package view_controllers.Inventory.PowerSupply;

import DAO.powersupplyImpl;
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
import model.PowerSupply;
import util.Alerts.PowerSupplyAlertMessages;
import view_controllers.PowerSupplySelection.PowerSupplyDetailsController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAllPowerSupplyController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<PowerSupply> powerSupplyList = FXCollections.observableArrayList();
    ObservableList<PowerSupply> powerSupplySearchList = FXCollections.observableArrayList();

    @FXML
    private TableView<PowerSupply> powerSupplyTblView;

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
    private Button deletePowerSupplyBtn;

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
            powerSupplySearchList.clear();
            for (PowerSupply p : powerSupplyList)
            {
                if(p.getName().contains(searchTxtFld.getText().trim()))
                {
                    powerSupplySearchList.add(p);
                }
            }
            powerSupplyTblView.setItems(powerSupplySearchList);
            powerSupplyTblView.refresh();
        }
        if (searchTxtFld.getText().isEmpty())
        {
            powerSupplyTblView.setItems(powerSupplyList);
        }

    }

    @FXML
    void onActionViewDetailsBtn(ActionEvent event)
    {
        try
        {
            PowerSupply selectedPowerSupply = powerSupplyTblView.getSelectionModel().getSelectedItem();

            if ( selectedPowerSupply == null)
            {
                System.out.println("No record selected");
                PowerSupplyAlertMessages.powerSupplySelectionError(1);
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/PowerSupply/invPowerSupply.fxml"));
            loader.load();

            invPowerSupplyController detailsController = loader.getController();
            detailsController.sendRecord(powerSupplyTblView.getSelectionModel().getSelectedItem());

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
            powerSupplyList.addAll(powersupplyImpl.selectAllPowerSupply());

            powerSupplyTblView.setItems(powerSupplyList);

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
    void onActionDeletePowerSupply(ActionEvent event) throws Exception {
        int id = powerSupplyTblView.getSelectionModel().getSelectedItem().getId();
        PowerSupply selectedPowerSupply = powerSupplyTblView.getSelectionModel().getSelectedItem();

        powersupplyImpl.deletePowerSupply(id,selectedPowerSupply);

        powerSupplyList = powersupplyImpl.selectAllPowerSupply();

        powerSupplyTblView.setItems(powerSupplyList);
        powerSupplyTblView.refresh();

    }
}
