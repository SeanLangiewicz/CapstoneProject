package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PowerSupplyAlertMessages
{
    public static void PowerSupplyAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Name Entered, please enter a name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Power Supply Name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Make entered, please enter a make");
            alert.setTitle("Make Alert");
            alert.setHeaderText("Make Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Model not entered, please enter a model");
            alert.setTitle("Model Alert");
            alert.setHeaderText("Model Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Modular entered, please enter Yes (Y) or No (N).");
            alert.setTitle("Modular Alert");
            alert.setHeaderText("Modular Alert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid watteged entered, please enter 0 or more");
            alert.setTitle("Graphics Card Alert");
            alert.setHeaderText("Outsourced Graphics Card Alert");

            alert.showAndWait();
        }
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Motherboard entered, please enter a motherboard");
            alert.setTitle("Motherboard Alert");
            alert.setHeaderText("Outsourced Motherboard Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No min entered, please enter a min");
            alert.setTitle("Min Alert");
            alert.setHeaderText("Min Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid Price Entered, please enter a number greater than 0");
            alert.setTitle("Price Alert");
            alert.setHeaderText("Price Alert");

            alert.showAndWait();
        }
        if(code ==9)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("On hand less than or equal to 0. Please enter a number higher than 0");
            alert.setTitle("Onhand Alert");
            alert.setHeaderText("Outsourced OnHand Alert");

            alert.showAndWait();
        }
        if(code ==10)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Description entered, please enter a description");
            alert.setTitle("Description Alert");
            alert.setHeaderText("Description Alert");

            alert.showAndWait();
        }

        if(code ==11)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Discount less 0, please enter a number 0 or higher");
            alert.setTitle("Discount Alert");
            alert.setHeaderText("Outsourced Discount Alert");

            alert.showAndWait();
        }

        if(code ==12)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("amount of hand is less then min on hand");
            alert.setTitle("On Hand Alert");
            alert.setHeaderText("Custom Order On Hand Alert");

            alert.showAndWait();
        }




    }
    public static void powerSupplySelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Power Supply selected, please select a case and try again");
            alert.setTitle("Power Supply selection Alert");
            alert.setHeaderText("Power Supply selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update Power Supply Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("Power Supply Update Alert");

            alert.showAndWait();

        }
    }
    public static void powerSupplyAddConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Power Supply Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Power Supply Add Alert");

            alert.showAndWait();

        }
    }

    public static void powerSupplyllFieldErrors(int code, TextField name, TextField make, TextField model,
                                               TextField modular, TextField wattage, TextField minOnHand,
                                               TextField price, TextField amountOnHand, TextField description,
                                               TextField discount)

    {
        powerSupplyllFieldErrors(name,make,model,modular,wattage,minOnHand,price,amountOnHand,description,discount);
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

    private static void powerSupplyllFieldErrors(TextField name, TextField make, TextField model,
                                                TextField modular, TextField wattage, TextField minOnHand,
                                                TextField price, TextField amountOnHand, TextField description,
                                                TextField discount)

    {
        if(name !=null)
        {
            name.setStyle("-fx-border-color: red");
        }
        if(make !=null)
        {
            make.setStyle("-fx-border-color: red");
        }
        if(model !=null)
        {
            model.setStyle("-fx-border-color: red");
        }
        if(modular !=null)
        {
            modular.setStyle("-fx-border-color: red");
        }
        if(wattage !=null)
        {
            wattage.setStyle("-fx-border-color: red");
        }
        if(minOnHand !=null)
        {
            minOnHand.setStyle("-fx-border-color: red");
        }
        if(price !=null)
        {
            price.setStyle("-fx-border-color: red");
        }
        if(amountOnHand !=null)
        {
            amountOnHand.setStyle("-fx-border-color: red");
        }
        if(description !=null)
        {
            description.setStyle("-fx-border-color: red");
        }
        if(discount !=null)
        {
            discount.setStyle("-fx-border-color: red");
        }
    }


}

