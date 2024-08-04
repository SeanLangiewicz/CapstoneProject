package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CustomerAlertMessages
{
    public static void customerAlerts(int code, TextField field)
    {
        fieldError(field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No First Name Entered");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Last Name Entered");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Name Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Initial Entered");
            alert.setTitle("Initial Alert");
            alert.setHeaderText("Initial Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No area code Entered");
            alert.setTitle( "Area code Alert");
            alert.setHeaderText("Area codeAlert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid phone number entered");
            alert.setTitle("Invalid phone number");
            alert.setHeaderText("Phone number alert");

            alert.showAndWait();
        }
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Balance less than 0, please enter a balance above 0");
            alert.setTitle("Balance Alert");
            alert.setHeaderText("Balance Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Address Entered");
            alert.setTitle("Address Alert");
            alert.setHeaderText("Address Alert");

            alert.showAndWait();
        }



    }
    public static void reportError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No sales in selected time period or with this specific employee");
            alert.setTitle("No Sales");
            alert.setHeaderText("No Sales");

            alert.showAndWait();
        }
    }







    public static void customerSelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No case selected, please select a case and try again");
            alert.setTitle("Case selection Alert");
            alert.setHeaderText("Case selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update Case Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("Custom Order Update Alert");

            alert.showAndWait();

        }
    }
    public static void addCustomerConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Case Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Custom Order Add Alert");

            alert.showAndWait();

        }
    }
    public static void customerAllFieldErrors( int code, TextField firstName, TextField lastName, TextField initial,
                                       TextField areaCode, TextField phoneNumber, TextField balanace,
                                       TextField address)
    {
        customerAllFieldErrors(firstName,lastName,initial,areaCode,phoneNumber,balanace,address);
        {
            if (code ==1)
            {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Invalid Input, All Fields need to be filled out, please try again");
                alert.showAndWait();
            }
        }

    }


    private static void customerAllFieldErrors(TextField firstName, TextField lastName, TextField initial,
                                           TextField areaCode, TextField phoneNumber, TextField balanace,
                                           TextField address)

    {
        if(firstName !=null)
        {
            firstName.setStyle("-fx-border-color: red");
        }
        if(lastName!=null)
        {
            lastName.setStyle("-fx-border-color: red");
        }
        if(initial!=null)
        {
            initial.setStyle("-fx-border-color: red");
        }
        if(areaCode!=null)
        {
            areaCode.setStyle("-fx-border-color: red");
        }
        if(phoneNumber!=null)
        {
            phoneNumber.setStyle("-fx-border-color: red");
        }
        if(balanace !=null)
        {
            balanace.setStyle("-fx-border-color: red");
        }
        if(address != null)
        {
            address.setStyle("-fx-border-color: red");
        }

    }





    private static void fieldError(TextField field)
    {
        if(field !=null)
        {
            field.setStyle("-fx-border-color: red");
        }
    }
}
