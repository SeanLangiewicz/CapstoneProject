package view_controllers.PowerSupplySelection;

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
import util.Alerts.ItemSelectionAlert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PowerSupplySelectionController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private TableView<PowerSupply> powerSupplyTblView;

    @FXML
    private TextField searchTxtFld;

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

    ObservableList<PowerSupply> powerSupplyList = FXCollections.observableArrayList();

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/RAMSelection/RAMSelection.fxml"));
        stage.setTitle("RAM Selection");
        stage.setScene(new Scene(scene));
        stage.show();

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
                ItemSelectionAlert.SelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/PowerSupplySelection/PowerSupplyDetails" +
                    ".fxml"));
            loader.load();

            PowerSupplyDetailsController detailsController = loader.getController();
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
    void onActionSearchBtn(ActionEvent event)
    {
        System.out.println("NYI");

    }
}
