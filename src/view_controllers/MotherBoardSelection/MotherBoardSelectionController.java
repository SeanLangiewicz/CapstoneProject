package view_controllers.MotherBoardSelection;

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
import util.Alerts.ItemSelectionAlert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MotherBoardSelectionController implements Initializable
{
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
    private TextField searchTxtFld;

    @FXML
    private Button searchTxtBtn;

    ObservableList<Motherboards> motherboardList = FXCollections.observableArrayList();
    ObservableList<Motherboards> motherBoardInventorySearchList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ComputerCaseType/ComputerCase.fxml"));
        stage.setTitle("Motherboards");
        stage.setScene(new Scene(scene));
        stage.show();

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
                ItemSelectionAlert.SelectionError(1);
                return;
            }


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/MotherboardSelection" +
                    "/MotherBoardDetails.fxml"));
            loader.load();
            System.out.println(loader);

            MotherBoardDetailsController detailsController = loader.getController();
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
    }


}
