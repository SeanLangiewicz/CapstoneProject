package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EmployeeAlertMessages
{
    public static void employeeAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Title Selected, select a title");
            alert.setTitle("Title Alert");
            alert.setHeaderText("Title Alert");

            alert.showAndWait();
        }
        fieldError (field);
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No First Name Entered, please enter a first name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Name Alert");

            alert.showAndWait();
        }
        fieldError (field);
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No last Name Entered, please enter a first name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Last Name Alert");

            alert.showAndWait();
        }
        fieldError (field);
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Initial entered");
            alert.setTitle("Initial Alert");
            alert.setHeaderText("Intial Alert");

            alert.showAndWait();
        }
        fieldError (field);
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Address entered, please enter an address");
            alert.setTitle("Address Alert");
            alert.setHeaderText("Address Alert");

            alert.showAndWait();
        }
        fieldError (field);
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Area Code Enter, please enter an area code");
            alert.setTitle("Area Alert");
            alert.setHeaderText("Area Code Alert");

            alert.showAndWait();
        }
        fieldError (field);
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Phone number or invalid phone number entered");
            alert.setTitle("Phone Alert");
            alert.setHeaderText("Phone Number Alert");

            alert.showAndWait();
        }


    }
    public static void employeeSelectionAlert(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Employee Selected, select an employee and try again.");
            alert.setTitle("Employee selection Alert");
            alert.setHeaderText("Employee selection alert");

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

    private static void employeeAllFieldErrors(TextField title, TextField firstName, TextField lName,
                                               TextField initial, TextField address, TextField areaCode,
                                               TextField phoneNumber)

    {

        if(title!=null)
        {
            title.setStyle("-fx-border-color: red");
        }
        if(firstName!=null)
        {
            firstName.setStyle("-fx-border-color: red");
        }
        if(lName!=null)
        {
            lName.setStyle("-fx-border-color: red");
        }
        if(initial!=null)
        {
            initial.setStyle("-fx-border-color: red");
        }
        if(address !=null)
        {
            address.setStyle("-fx-border-color: red");
        }
        if(areaCode != null)
        {
            areaCode.setStyle("-fx-border-color: red");
        }
        if(phoneNumber != null)
        {
            phoneNumber.setStyle("-fx-border-color: red");
        }

    }
    public static void employeeAllTxtFlds(int code, TextField title, TextField firstName, TextField lName,
                                       TextField initial, TextField address, TextField areaCode,
                                       TextField phoneNumber)

    {
        employeeAllFieldErrors(title,firstName,lName,initial,address,areaCode,phoneNumber);
        if (code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Invalid Input, All Fields need to be filled out, please try again");
            alert.showAndWait();

        }


    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("Employee Update Alert");

            alert.showAndWait();

        }
    }
    public static void addConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Employee Add Alert");

            alert.showAndWait();

        }
    }

}
