package view_controllers.Customers;

import DAO.customerImpl;
import DAO.userImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import util.Alerts.CustomerAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable
{


    Parent scene;
    Stage stage;

    @FXML
    private Label addRecordTitlelbl;

    @FXML
    private TextField idTxtFld;

    @FXML
    private TextField firstNameTxtFld;

    @FXML
    private TextField lastNameTxtFld;

    @FXML
    private TextField initialTxtFld;

    @FXML
    private TextField areaCodeTxtFld;

    @FXML
    private TextField phoneNumberTxtFld;

    @FXML
    private TextField balanceTxtFld;

    @FXML
    private TextField addressTxtFld;

    @FXML
    private Button saveBtn;

    @FXML
    private Button backBtn;

    public static ObservableList<User> signedInUser = FXCollections.observableArrayList();
    String loggedInUser = null;
    Integer userID = null;



    public void onActionSave(ActionEvent event) throws IOException
    {
        try
        {
            String firstName = firstNameTxtFld.getText();
            String lastName = lastNameTxtFld.getText();
            String initial = initialTxtFld.getText();
            int areaCode = Integer.parseInt(areaCodeTxtFld.getText());
            int phoneNumber = Integer.parseInt(phoneNumberTxtFld.getText());
            Float balance = Float.parseFloat(balanceTxtFld.getText());
            String address = addressTxtFld.getText();

            if(firstName.isEmpty())
            {
                CustomerAlertMessages.customerAlerts(1,firstNameTxtFld);
                return;
            }
            if(lastName.isEmpty())
            {
                CustomerAlertMessages.customerAlerts(2,lastNameTxtFld);
                return;
            }
            if(areaCode <=0)
            {
                CustomerAlertMessages.customerAlerts(4,areaCodeTxtFld);
                return;
            }
            if(phoneNumber <=0)
            {
                CustomerAlertMessages.customerAlerts(5,phoneNumberTxtFld);
                return;
            }
            if(balance <0)
            {
                CustomerAlertMessages.customerAlerts(6,balanceTxtFld);
                return;
            }
            if (address.isEmpty())
            {
                CustomerAlertMessages.customerAlerts(7,addressTxtFld);
                return;
            }



            customerImpl.addCustomer(firstName,lastName,initial,areaCode,phoneNumber,balance,address,loggedInUser,
                    loggedInUser);
            CustomerAlertMessages.addCustomerConfirmation(1);


            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Customers/AllCustomers.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            CustomerAlertMessages.customerAllFieldErrors(1,firstNameTxtFld,lastNameTxtFld,initialTxtFld,
                    areaCodeTxtFld,phoneNumberTxtFld,balanceTxtFld,addressTxtFld);
            return;
        }


    }

    public void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Customers/AllCustomers.fxml"));
        stage.setTitle("Add A Customer Screen");
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        idTxtFld.setDisable(true);
        idTxtFld.setPromptText("Auto-Incremented");
        signedInUser = userImpl.signedInUserList;
        User user = signedInUser.get(0);
        loggedInUser = user.getUserName();


    }
}
