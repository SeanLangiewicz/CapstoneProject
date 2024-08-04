package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RAMAlertMessages
{
    public static void ramAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No RAM Name Entered, please enter a name");
            alert.setTitle("RAM Alert");
            alert.setHeaderText("RAM name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No RAM Make Enter, please enter a make");
            alert.setTitle("RAM Alert");
            alert.setHeaderText("RAM Make Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Model Entered, please enter a model");
            alert.setTitle("Model Alert");
            alert.setHeaderText("Model Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Capacity Entered, please enter a number higher than 0");
            alert.setTitle("Capacity Alert");
            alert.setHeaderText("Capacity Alert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No speed entered, please enter a number higher than 0");
            alert.setTitle("Speed Alert");
            alert.setHeaderText("Speed Alert");

            alert.showAndWait();
        }

        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No description entered, please enter a description");
            alert.setTitle("Description Alert");
            alert.setHeaderText("Description Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No amount on hand, please enter an amount");
            alert.setTitle("Amount Alert");
            alert.setHeaderText("Custom Order Amount Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Minimum amount entered, please enter an amount");
            alert.setTitle("Minimum Alert");
            alert.setHeaderText("Custom Order min Alert");

            alert.showAndWait();
        }
        if(code ==9)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case price Entered, please enter a price");
            alert.setTitle("Price Alert");
            alert.setHeaderText("Custom Order Price Alert");

            alert.showAndWait();
        }
        if(code ==10)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No discount, entered. Enter 0 if no discount");
            alert.setTitle("Discount Alert");
            alert.setHeaderText("Custom Order Discount Alert");

            alert.showAndWait();
        }
        if(code ==11)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Amount of hand is less then min on hand");
            alert.setTitle("On Hand Alert");
            alert.setHeaderText("RAM Amount On Hand Alert");

            alert.showAndWait();
        }




    }
    public static void ramSelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No RAM selected, please select RAM and try again");
            alert.setTitle("RAM selection Alert");
            alert.setHeaderText("RAM selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update RAM Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("RAM Update Alert");

            alert.showAndWait();

        }
    }
    public static void addRAMConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add RAM Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("RAM Add Alert");

            alert.showAndWait();

        }
    }

    public static void RAMAllFieldErrors(int code, TextField name, TextField make, TextField model, TextField capacity,
                                         TextField speed, TextField description, TextField amountOnHand,
                                         TextField minOnHand, TextField price, TextField discount)

    {
        RAMAllFieldErrors(name,make,model,capacity,speed,description,amountOnHand,minOnHand,price,discount);
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

    private static void RAMAllFieldErrors(TextField name, TextField make, TextField model, TextField capacity,
                                          TextField speed, TextField description, TextField amountOnHand,
                                          TextField minOnHand, TextField price, TextField discount)

    {
        if(name !=null)
        {
            name.setStyle("-fx-border-color: red");
        }
        if(description!=null)
        {
            description.setStyle("-fx-border-color: red");
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
        if(capacity!=null)
        {
            capacity.setStyle("-fx-border-color: red");
        }
        if(speed!=null)
        {
            speed.setStyle("-fx-border-color: red");
        }
    }


}

