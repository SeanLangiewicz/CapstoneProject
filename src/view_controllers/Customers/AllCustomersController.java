package view_controllers.Customers;

import DAO.customerImpl;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Cases;
import model.Customer;
import util.Alerts.CustomerAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllCustomersController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @FXML
    private TableView<Customer> customerTblView;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> F_Name;

    @FXML
    private TableColumn<?, ?> L_Name;

    @FXML
    private TableColumn<?, ?> balance;

    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button backBtn;
    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection" +
                ".fxml"));
        stage.setTitle("Screen Selection");
        stage.setScene(new Scene(scene));
        stage.show();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            customerList.addAll(customerImpl.selectAllCustomers());
            customerTblView.setItems(customerList);

            ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            F_Name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            L_Name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }

    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Customers/AddCustomer.fxml"));
        stage.setTitle("Add A Customer");
        stage.setScene(new Scene(scene));
        stage.show();

    }


    @FXML
    void onActionDelete(ActionEvent event)
    {
        try
        {
            Customer selectedCustomer = customerTblView.getSelectionModel().getSelectedItem();
            int customerID = customerTblView.getSelectionModel().getSelectedItem().getId();

            customerImpl.deleteCustomer(customerID,selectedCustomer);
            customerList.remove(selectedCustomer);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        customerTblView.refresh();

    }

    @FXML
    void onActionUpdate(ActionEvent event)
    {
        try
        {
            Customer selectedCustomer = customerTblView.getSelectionModel().getSelectedItem();

            if(selectedCustomer == null)
            {
                System.out.println("Nothing selected");
                CustomerAlertMessages.customerSelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Customers/UpdateCustomer.fxml"));
            loader.load();

            UpdateCustomerController details = loader.getController();
            details.sendRecord(customerTblView.getSelectionModel().getSelectedItem());

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

}
