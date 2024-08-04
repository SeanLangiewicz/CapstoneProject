package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginAlerts
{
    public static void loginErrors (int code, TextField username, TextField password)
    {

        fieldError(username, password);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Unable to login");
            alert.setContentText("Invalid username / password. Please try again");
            alert.showAndWait();
        }

    }

    private static void fieldError (TextField username, TextField password)
    {
        if(username !=null)
        {
            username.setStyle("-fx-border-color: red");
        }
        if(password !=null)
        {
            password.setStyle("-fx-border-color: red");
        }
    }
}
