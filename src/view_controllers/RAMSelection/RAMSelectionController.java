package view_controllers.RAMSelection;
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
import util.Alerts.ItemSelectionAlert;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class RAMSelectionController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<Ram> ramList = FXCollections.observableArrayList();
    @FXML
    private TableView<Ram> ramListTableView;

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
            Ram selectedRam = ramListTableView.getSelectionModel().getSelectedItem();

            if(selectedRam == null)
            {
                System.out.println("No Record Selected");
                ItemSelectionAlert.SelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/RAMSelection/RamDetails.fxml"));
            loader.load();

            RamDetailsController detailsController = loader.getController();
            detailsController.sendRecord(ramListTableView.getSelectionModel().getSelectedItem());

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
    void onActionSearchBtn(ActionEvent event)
    {
        System.out.println("nyi");

    }
}
