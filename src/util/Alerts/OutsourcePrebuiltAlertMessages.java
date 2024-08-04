package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class OutsourcePrebuiltAlertMessages
{
    public static void OutsourceAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Name Entered, please enter a name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Outsourced Name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Description entered, please enter a description");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Outsourced Description Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Processor not entered, please enter a processor");
            alert.setTitle("Processor Alert");
            alert.setHeaderText("Outsourced Processor Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case make Entered, please enter a make");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Outsourced make Alert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Graphics Card Entered, please enter a Graphics Card");
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

            alert.setContentText("No power supply entered, please enter a power supply");
            alert.setTitle("Power Supply Alert");
            alert.setHeaderText("Outsourced Power Supply Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid RAM Entered, please enter a number greater than 0");
            alert.setTitle("RAM Alert");
            alert.setHeaderText("Outsourced RAM Alert");

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

            alert.setContentText("Minimum on hand less than or equal to 0, please enter a number higher than 0");
            alert.setTitle("Min Alert");
            alert.setHeaderText("Outsourced Min Alert");

            alert.showAndWait();
        }
        if(code ==11)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Price less than or equal to 0, please enter a number higher than 0");
            alert.setTitle("Price Alert");
            alert.setHeaderText("Outsourced Price Alert");

            alert.showAndWait();
        }
        if(code ==12)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Discount less 0, please enter a number 0 or higher");
            alert.setTitle("Discount Alert");
            alert.setHeaderText("Outsourced Discount Alert");

            alert.showAndWait();
        }

        if(code ==13)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No vendor name entered, please enter a vendor name");
            alert.setTitle("Vendor Alert");
            alert.setHeaderText("Outsourced Vendor Alert");

            alert.showAndWait();
        }




    }
    public static void outsourcedSelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Outsourced Computer selected, please select a case and try again");
            alert.setTitle("Outsourced selection Alert");
            alert.setHeaderText("Outsourced selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update Outsource Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("Outsource Update Alert");

            alert.showAndWait();

        }
    }
    public static void addOutsourceConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Outsource Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Outsource Add Alert");

            alert.showAndWait();

        }
    }

    public static void outSourceAllFieldErrors(int code, TextField name, TextField description, TextField processor,
                                       TextField caseType, TextField graphicsCard, TextField motherBoard,
                                       TextField powerSupply, TextField ram, TextField amountOnHand,
                                       TextField minOnHand, TextField price, TextField discount, TextField vendorName)

    {
        outSourceAllFieldErrors(name,description,processor,caseType,graphicsCard,motherBoard,powerSupply,ram,
                amountOnHand,minOnHand,price,discount,vendorName);
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

    private static void outSourceAllFieldErrors(TextField name, TextField description, TextField processor,
                                           TextField caseType, TextField graphicsCard, TextField motherBoard,
                                           TextField powerSupply, TextField ram, TextField amountOnHand,
                                           TextField minOnHand, TextField price, TextField discount, TextField vendorName)

    {
        if(name !=null)
        {
            name.setStyle("-fx-border-color: red");
        }
        if(description!=null)
        {
            description.setStyle("-fx-border-color: red");
        }
        if(processor!=null)
        {
            processor.setStyle("-fx-border-color: red");
        }
        if(caseType!=null)
        {
            caseType.setStyle("-fx-border-color: red");
        }
        if(graphicsCard!=null)
        {
            graphicsCard.setStyle("-fx-border-color: red");
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
        if(motherBoard!=null)
        {
            motherBoard.setStyle("-fx-border-color: red");
        }
        if(powerSupply!=null)
        {
            powerSupply.setStyle("-fx-border-color: red");
        }
        if(ram!=null)
        {
            ram.setStyle("-fx-border-color: red");
        }
        if(vendorName!=null)
        {
            vendorName.setStyle("-fx-border-color: red");
        }
    }


}

