package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class InHouseAlertMessages
{
    public static void InHouseAlertMessages(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Graphics Card Name Entered, please enter a name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order Name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case Description entered, please enter a description");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order Description Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Amount on Hand less than or equal to 0, please enter a number above 0");
            alert.setTitle("QOH Alert");
            alert.setHeaderText("Custom Order Type Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Minimum on hand less than or equal to 0, please enter a number above 0");
            alert.setTitle("Min on hand Alert");
            alert.setHeaderText("Custom Order make Alert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Price than or equal to 0, please enter a number above 0\"");
            alert.setTitle("Price Alert");
            alert.setHeaderText("Custom Order model Alert");

            alert.showAndWait();
        }
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Please enter a discount above 0, if no discount than or equal to 0, please " +
                    "enter a number above 0\"");
            alert.setTitle("Amount Alert");
            alert.setHeaderText("Custom Order Amount Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No processor selected, please select a processor");
            alert.setTitle("Processor Alert");
            alert.setHeaderText("Custom Order Processor Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case selected, please select a case");
            alert.setTitle("Case Alert");
            alert.setHeaderText("Custom Order Price Alert");

            alert.showAndWait();
        }
        if(code ==9)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No graphics card selected, please select a graphics card");
            alert.setTitle("graphic card Alert");
            alert.setHeaderText("Custom Order Discount Alert");

            alert.showAndWait();
        }
        if(code ==10)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Motherboard selected, please select a motherboard");
            alert.setTitle("motherboard alert");
            alert.setHeaderText("Custom Order motherboard alert");

            alert.showAndWait();
        }
        if(code ==11)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Power Supply selected, please select a power supply");
            alert.setTitle("power supply alert");
            alert.setHeaderText("Custom Order power supply alert");

            alert.showAndWait();
        }
        if(code ==12)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No RAM selected, please select RAM");
            alert.setTitle("RAM alert");
            alert.setHeaderText("Custom Order motherboard alert");

            alert.showAndWait();
        }
        if(code ==13)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Amount on hand can not be less than min on hand, please enter a greater amount");
            alert.setTitle("QOH alert");
            alert.setHeaderText("Amount on hand Alert");

            alert.showAndWait();
        }





    }
    public static void inHouseSelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Computer selected, please select a computer and try again");
            alert.setTitle("Selection Alert");
            alert.setHeaderText("Selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update InHouse Computer Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("InHouse Update Complete");

            alert.showAndWait();

        }
    }
    public static void addinHouseConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Graphics Card Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Custom Order Add Alert");

            alert.showAndWait();

        }
    }

    public static void inHouseFieldErrors(int code,TextField name, TextField description, TextField onHand,
                                       TextField minOnHand, TextField price, TextField discount,
                                       TextField processor, TextField selectedCase,
                                       TextField graphicsCard, TextField motherBoard,
                                       TextField powerSupply, TextField ram)

    {
        inHouseAllFieldErrors(name,description,onHand,minOnHand,price,discount,processor,selectedCase,
                graphicsCard,motherBoard,powerSupply,ram);
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

    private static void inHouseAllFieldErrors(TextField name, TextField description, TextField onHand,
                                                   TextField minOnHand, TextField price, TextField discount,
                                                   TextField processor, TextField selectedCase,
                                                   TextField graphicsCard, TextField motherBoard,
                                                   TextField powerSupply, TextField ram)

    {
        if(name !=null)
        {
            name.setStyle("-fx-border-color: red");
        }
        if(description != null)
        {
            description.setStyle("-fx-border-color: red");
        }
        if(onHand != null)
        {
            onHand.setStyle("-fx-border-color: red");
        }
        if(minOnHand != null)
        {
            minOnHand.setStyle("-fx-border-color: red");
        }
        if(price != null)
        {
            price.setStyle("-fx-border-color: red");
        }
        if (discount != null)
        {
            discount.setStyle("-fx-border-color: red");
        }
        if(processor != null)
        {
            processor.setStyle("-fx-border-color: red");
        }
        if(selectedCase != null)
        {
            selectedCase.setStyle("-fx-border-color: red");
        }
        if( graphicsCard != null)
        {
            graphicsCard.setStyle("-fx-border-color: red");
        }
        if( motherBoard != null)
        {
            motherBoard.setStyle("-fx-border-color: red");
        }
        if ( powerSupply != null)
        {
            powerSupply.setStyle("-fx-border-color: red");
        }
        if( ram != null)
        {
            ram.setStyle("-fx-border-color: red");
        }
    }


}

