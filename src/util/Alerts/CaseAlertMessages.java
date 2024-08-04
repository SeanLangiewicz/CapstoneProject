package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class CaseAlertMessages
{
    public static void ComputerCaseAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case Name Entered, please enter a name");
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

            alert.setContentText("No Case Type Entered, please enter a Type");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order Type Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case make Entered, please enter a make");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order make Alert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case model Entered, please enter a model");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order model Alert");

            alert.showAndWait();
        }
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No amount on hand, please enter an amount");
            alert.setTitle("Amount Alert");
            alert.setHeaderText("Custom Order Amount Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Minimum amount entered, please enter an amount");
            alert.setTitle("Minimum Alert");
            alert.setHeaderText("Custom Order min Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Case price Entered, please enter a price");
            alert.setTitle("Price Alert");
            alert.setHeaderText("Custom Order Price Alert");

            alert.showAndWait();
        }
        if(code ==9)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No discount, entered. Enter 0 if no discount");
            alert.setTitle("Discount Alert");
            alert.setHeaderText("Custom Order Discount Alert");

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
    public static void caseSelectionError(int code)
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
    public static void addCaseConfirmation(int code)
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

    public static void caseFieldErrors(int code, TextField name, TextField description, TextField type,
                                       TextField make, TextField model, TextField amountOnHand, TextField minOnHand,
                                       TextField price, TextField discount)

    {
        caseAllFieldErrors(name,description,type,make,model,amountOnHand,minOnHand,price,discount);
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

    private static void caseAllFieldErrors(TextField name, TextField description, TextField type, TextField make,
                                           TextField model, TextField amountOnHand, TextField minOnHand, TextField price, TextField discount)

    {
        if(name !=null)
        {
            name.setStyle("-fx-border-color: red");
        }
        if(description!=null)
        {
            description.setStyle("-fx-border-color: red");
        }
        if(type!=null)
        {
            type.setStyle("-fx-border-color: red");
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

