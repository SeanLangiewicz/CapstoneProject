package view_controllers.LoginScreen;

import DAO.BuiltComputersImpl;
import DAO.userImpl;
import com.mysql.cj.log.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import util.Alerts.LoginAlerts;
import util.dateParse;

import java.io.IOException;

public class LoginScreenController
{
    Parent scene;
    Stage stage;

    public static ObservableList<User> signedInUser = FXCollections.observableArrayList();


    @FXML
    private Button screenSelectionBtn;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField logInTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button logInBtn;

    @FXML
    private Button cancelBtn;


    @FXML
    void onActionCancel(ActionEvent event) throws Exception
    {

        Float builtComputerSales = BuiltComputersImpl.sales();
        System.out.println(builtComputerSales);


    }

    @FXML
    void onActionLogin(ActionEvent event) throws Exception
    {
        String username = logInTextField.getText();
        String password = passwordTextField.getText();

        if(userImpl.userSignInCheck(username,password) == true)
        {

            signedInUser = userImpl.signedInUserList;
            User user = signedInUser.get(0);
            Integer id = user.getUserID();
            String name = user.getUserName();



            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection.fxml"));
            stage.setTitle("Screen Selection");
            stage.setScene(new Scene(scene));
            stage.show();
            return;
        }

        if(userImpl.userSignInCheck(username,password) == false);
        {
            LoginAlerts.loginErrors(1,logInTextField,passwordTextField);
            return;
        }

    }




}
