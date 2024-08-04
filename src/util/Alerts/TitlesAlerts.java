package util.Alerts;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TitlesAlerts
{
    public static void salaryAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Title Entered, enter a title");
            alert.setTitle("Title Alert");
            alert.setHeaderText("Title Alert");

            alert.showAndWait();
        }
        if( code == 2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid Salary Entered, enter a Salary greater than 1");
            alert.setTitle("Salary Alert");
            alert.setHeaderText("Salary Alert");

            alert.showAndWait();

        }

    }



        private static void fieldError(TextField field)
        {
            if(field !=null)
            {
                field.setStyle("-fx-border-color: red");
            }
        }
    public static void TitleSelectionAlert(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Title Selected, select a title and try again.");
            alert.setTitle("title selection Alert");
            alert.setHeaderText("title selection alert");

            alert.showAndWait();

        }

    }

    private static void titleAllFieldErrors(TextField title, TextField salary)
    {
        if(title != null)
        {
            title.setStyle("-fx-border-color: red");
        }
        if(salary != null)
        {
            salary.setStyle("-fx-border-color: red");
        }
    }
    public static void titleAllFields(int code, TextField title, TextField salary)
    {
        titleAllFieldErrors(title,salary);
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Invalid Input, All Fields need to be filled out, please try again");
            alert.showAndWait();
        }
    }


}
