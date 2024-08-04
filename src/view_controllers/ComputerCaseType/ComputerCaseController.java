package view_controllers.ComputerCaseType;

import DAO.casesImpl;
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
import model.Cases;
import util.Alerts.ItemSelectionAlert;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ComputerCaseController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private TableView<Cases> computerCasesTableView;

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

    private static ObservableList<Cases> casesList = FXCollections.observableArrayList();
    private static ObservableList<Cases> caseInventorySearch = FXCollections.observableArrayList();

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/CustomOrder/CustomOrder.fxml"));
        stage.setTitle("Computer Cases");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewDetailsBtn(ActionEvent event)
    {


        try
        {
            Cases selectedCase = computerCasesTableView.getSelectionModel().getSelectedItem();

            if(selectedCase == null)
            {
                System.out.println("No Record Selected");
                ItemSelectionAlert.SelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/view_controllers/ComputerCaseType/ComputerCaseDetails.fxml"));
            loader.load();

            ComputerCaseDetailsController detailsController = loader.getController();
            detailsController.sendRecord(computerCasesTableView.getSelectionModel().getSelectedItem());


            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();

        }

        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try
        {
           casesList.addAll(casesImpl.selectAllCases());


            computerCasesTableView.setItems(casesList);

            ID.setCellValueFactory(new PropertyValueFactory<>("id"));


            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            onHand.setCellValueFactory(new PropertyValueFactory<>("onHand"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));


            searchTxtFld.setPromptText("Search by Name");

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
            caseInventorySearch.clear();
            for (Cases c :casesList) {
                if (c.getName().contains(searchTxtFld.getText().trim()))
                {
                    caseInventorySearch.add(c);
                }
            }
            computerCasesTableView.setItems(caseInventorySearch);
            computerCasesTableView.refresh();
        }



        if(searchTxtFld.getText().isEmpty())
        {

            computerCasesTableView.setItems(casesList);
        }

    }


}
