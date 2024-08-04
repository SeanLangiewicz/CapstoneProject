package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MotherboardAlertMessages
{
    public static void MotherBoardAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Motherboard Name Entered, please enter a name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order Name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Size, please enter a Size");
            alert.setTitle("Size Alert");
            alert.setHeaderText("Custom Order Size Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No make Entered, please enter a make");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order make Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No model Type Entered, please enter a model");
            alert.setTitle("model Alert");
            alert.setHeaderText("Custom Order Model Alert");

            alert.showAndWait();

        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Description, please enter a description");
            alert.setTitle("Description Alert");
            alert.setHeaderText("Custom Order Description Alert");

            alert.showAndWait();
        }
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Amount is less than or equal to 0, please enter another number higher than 0");
            alert.setTitle("Amount Alert");
            alert.setHeaderText("Custom Order Amount Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Min is less than or equal to 0, please enter another number higher than 0");
            alert.setTitle("Minimum Alert");
            alert.setHeaderText("Custom Order min Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Amount is less than or equal to min on hand. Please enter a number higher than min.");
            alert.setTitle("Amount Alert");
            alert.setHeaderText("Custom Order Amount Alert");

            alert.showAndWait();
        }
        if(code ==9)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No price is enter, please enter a valid price");
            alert.setTitle("Price Alert");
            alert.setHeaderText("Custom Order Price Alert");

            alert.showAndWait();
        }
        if(code ==10)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("amount of hand is less then min on hand");
            alert.setTitle("On Hand Alert");
            alert.setHeaderText("Custom Order On Hand Alert");

            alert.showAndWait();
        }




    }
    public static void motherboardSelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Motherboard selected, please select a Motherboard and try again");
            alert.setTitle("Motherboard selection Alert");
            alert.setHeaderText("Motherboard selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update Motherboard Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("Custom Order Update Alert");

            alert.showAndWait();

        }
    }
    public static void addMotherboardConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Motherboard Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Custom Order Add Alert");

            alert.showAndWait();

        }
    }

    public static void motherboardFieldErrors(int code, TextField name,TextField size, TextField make, TextField model,
                                              TextField description, TextField amountOnHand, TextField minOnHand,
                                              TextField price, TextField discount)

    {
        motherboardAllFieldErrors(name,description,size,make,model,amountOnHand,minOnHand,price,discount);
        if (code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Invalid Input, All Fields need to be filled out, please try again");
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

    private static void motherboardAllFieldErrors(TextField name,TextField size, TextField make, TextField model,
                                                  TextField description, TextField amountOnHand, TextField minOnHand,
                                                  TextField price, TextField discount)

    {
        if(name !=null)
        {
            name.setStyle("-fx-border-color: red");
        }
        if(description!=null)
        {
            description.setStyle("-fx-border-color: red");
        }
        if(size!=null)
        {
            size.setStyle("-fx-border-color: red");
        }
        if(make!=null)
        {
            make.setStyle("-fx-border-color: red");
        }
        if(model!=null)
        {
            model.setStyle("-fx-border-color: red");
        }
        if(amountOnHand !=null)
        {
            amountOnHand.setStyle("-fx-border-color: red");
        }
        if(minOnHand != null)
        {
            minOnHand.setStyle("-fx-border-color: red");
        }
        if(price != null)
        {
            price.setStyle("-fx-border-color: red");
        }
        if(discount!=null)
        {
            discount.setStyle("-fx-border-color: red");
        }
    }


}

