package view_controllers.Employees;

import DAO.employeesImpl;
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
import model.Customer;
import model.Employees;
import util.Alerts.EmployeeAlertMessages;
import view_controllers.Customers.UpdateCustomerController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllEmployeesController implements Initializable
{
    Parent scene;
    Stage stage;
    ObservableList<Employees> employeeList = FXCollections.observableArrayList();


    @FXML
    private TableView<Employees> employeeTblView;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> F_Name;

    @FXML
    private TableColumn<?, ?> L_Name;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private Button addEmployee;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button backBtn;

    @FXML
    void onActionAddEmployee(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Employees/addEmployee" +
                ".fxml"));
        stage.setTitle("Add Employees");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionBack(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection.fxml"));
        stage.setTitle("All Employees");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDelete(ActionEvent event) throws SQLException
    {
        try
        {
            int selectedID = employeeTblView.getSelectionModel().getSelectedItem().getEmployeeNumber();
            Employees selectedEmployee = employeeTblView.getSelectionModel().getSelectedItem();

            employeesImpl.deleteEmployee(selectedID,selectedEmployee);
            employeeList.remove(selectedEmployee);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        employeeTblView.refresh();



    }

    @FXML
    void onActionUpdate(ActionEvent event) throws IOException
    {
        Employees selectedEmployee = employeeTblView.getSelectionModel().getSelectedItem();

        if(selectedEmployee == null)
        {
            System.out.println("Nothing selected");
            EmployeeAlertMessages.employeeSelectionAlert(1);
            return;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view_controllers/Employees/UpdateEmployee.fxml"));
        loader.load();

        UpdateEmployeeController details = loader.getController();
        details.sendRecord(employeeTblView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {


                employeeList.addAll(employeesImpl.selectAllEmployees());

            employeeTblView.setItems(employeeList);


            ID.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));
            F_Name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            L_Name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            title.setCellValueFactory(new PropertyValueFactory<>("title"));


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
