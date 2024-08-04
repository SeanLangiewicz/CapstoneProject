package view_controllers.Employees;

import DAO.employeesImpl;
import DAO.titlesImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Titles;
import util.Alerts.EmployeeAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addEmployeeController implements Initializable
{
    Parent scene;
    Stage stage;


    private String selectedTitle = null;
    @FXML
    private Label addEmployeeLbl;

    @FXML
    private TextField idTxtFld;

    @FXML
    private TextField titleTxtFld;

    @FXML
    private TextField firstNameTxtFld;

    @FXML
    private TextField lastNameTxtFld;

    @FXML
    private TextField initialTxtFld;

    @FXML
    private TextField addressTxtFld;

    @FXML
    private TextField areaCodeTxtFld;

    @FXML
    private TextField phoneNumberTxtFld;

    @FXML
    private Button saveBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<Titles> employeeTitleCmblBox;


    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Employees/AllEmployees" +
                ".fxml"));
        stage.setTitle("All Employees");
        stage.setScene(new Scene(scene));
        stage.show();

    }



    @FXML
    void onActionSave(ActionEvent event) throws IOException {
        {
            try
            {
                String title = titleTxtFld.getText();
                String firstName = firstNameTxtFld.getText();
                String lastName = lastNameTxtFld.getText();
                String initial = initialTxtFld.getText();
                String address = addressTxtFld.getText();
                int areaCode = Integer.parseInt(areaCodeTxtFld.getText());
                int phoneNumber = Integer.parseInt(phoneNumberTxtFld.getText());

                if(title == null)
                {
                    EmployeeAlertMessages.employeeAlerts(1,titleTxtFld);
                    return;
                }
                if(firstName == null)
                {
                    EmployeeAlertMessages.employeeAlerts(2,firstNameTxtFld);
                    return;
                }

                if(lastName == null) {
                    EmployeeAlertMessages.employeeAlerts(3, lastNameTxtFld);
                    return;
                }

                if(initial == null) {
                    EmployeeAlertMessages.employeeAlerts(4, initialTxtFld);
                    return;
                }

                if(address == null) {
                    EmployeeAlertMessages.employeeAlerts(5, addressTxtFld);
                    return;
                }

                if(areaCode <0) {
                    EmployeeAlertMessages.employeeAlerts(6, lastNameTxtFld);
                    return;
                }
                if( phoneNumber <=0)
                {
                    EmployeeAlertMessages.employeeAlerts(7,phoneNumberTxtFld);
                    return;
                }



                    employeesImpl.addEmployee(title,firstName,lastName,initial,address,areaCode,phoneNumber);
                EmployeeAlertMessages.addConfirmation(1);

                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view_controllers/Employees/AllEmployees" +
                        ".fxml"));
                stage.setTitle("All Employees");
                stage.setScene(new Scene(scene));
                stage.show();

            }
            catch (Exception e)
            {
                e.printStackTrace();
                EmployeeAlertMessages.employeeAllTxtFlds(1,titleTxtFld,firstNameTxtFld,lastNameTxtFld,initialTxtFld,
                        addressTxtFld,areaCodeTxtFld,phoneNumberTxtFld);
                return;
            }





        }




    }

    @FXML
    void onActionEmployeeTitleCmboBox(ActionEvent event)
    {

        selectedTitle = employeeTitleCmblBox.getValue().getTitle();
        titleTxtFld.setText(selectedTitle);



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {

            titleTxtFld.setDisable(true);
            idTxtFld.setDisable(true);
            idTxtFld.setText("Auto-Generated");


            ObservableList<Titles> titleList = titlesImpl.selectAllTitles();
            employeeTitleCmblBox.setItems(titleList);

            employeeTitleCmblBox.setVisibleRowCount(3);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
