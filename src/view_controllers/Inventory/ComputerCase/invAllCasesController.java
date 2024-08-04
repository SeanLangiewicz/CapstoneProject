package view_controllers.Inventory.ComputerCase;

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
import util.Alerts.CaseAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class invAllCasesController implements Initializable
{
    Parent scene;
    Stage stage;

    private static ObservableList<Cases> casesList = FXCollections.observableArrayList();
    private static ObservableList<Cases> caseInventorySearch = FXCollections.observableArrayList();

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
    private Button updateBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button searchTxtBtn;

    @FXML
    private Button deleteCaseBtn;

    @FXML
    private TextField searchTxtFld;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Screen Selection");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSearchBtn(ActionEvent event)
    {
        caseInventorySearch.clear();
        if(!searchTxtFld.getText().trim().isEmpty())
        {

            for (Cases c : casesList) {
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

    @FXML
    void onActionUpdateBtn(ActionEvent event)
    {
        try
        {
            Cases selectedCase = computerCasesTableView.getSelectionModel().getSelectedItem();
            if (selectedCase == null)
            {
                System.out.println("No record selected");
                CaseAlertMessages.caseSelectionError(1);
                return;


            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/ComputerCase/invUpdateCase.fxml"));
            loader.load();

            invUpdateCaseController details = loader.getController();
            details.sendRecord(computerCasesTableView.getSelectionModel().getSelectedItem());
            System.out.println(details);


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
           computerCasesTableView.getItems().clear();
           casesList.clear();

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
    void onActionDeleteCase(ActionEvent event) throws Exception
    {

        int id = computerCasesTableView.getSelectionModel().getSelectedItem().getId();

        Cases selectedCase = computerCasesTableView.getSelectionModel().getSelectedItem();

        if( selectedCase == null)
        {
            CaseAlertMessages.caseSelectionError(1);
            return;
        }

        casesImpl.deleteCase(id,selectedCase);

        casesList = casesImpl.selectAllCases();
        computerCasesTableView.setItems(casesList);
        computerCasesTableView.refresh();

    }

}
