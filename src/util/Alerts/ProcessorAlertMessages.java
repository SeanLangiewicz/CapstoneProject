package util.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ProcessorAlertMessages
{
    public static void processorAlerts(int code, TextField field)
    {
        fieldError (field);
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Processor Name Entered, please enter a name");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order Name Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid speed entered, please enter speed that is above 0");
            alert.setTitle("Speed Alert");
            alert.setHeaderText("Speed Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Make Entered, please enter a Make");
            alert.setTitle("Make Alert");
            alert.setHeaderText("Make Alert");

            alert.showAndWait();
        }
        if(code ==4)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Socket Entered, Please enter a socket");
            alert.setTitle("Socket Alert");
            alert.setHeaderText("Socket Alert");

            alert.showAndWait();
        }
        if(code ==5)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No model Entered, please enter a model");
            alert.setTitle("Name Alert");
            alert.setHeaderText("Custom Order model Alert");

            alert.showAndWait();
        }
        if(code ==6)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Amount on hand less than or equal to 0, please enter a number above 0");
            alert.setTitle("Amount Alert");
            alert.setHeaderText("Custom Order Amount Alert");

            alert.showAndWait();
        }
        if(code ==7)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Minimum amount entered, please enter an amount above 0");
            alert.setTitle("Minimum Alert");
            alert.setHeaderText("Custom Order min Alert");

            alert.showAndWait();
        }
        if(code ==8)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No price Entered, please enter a price");
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

            alert.setContentText("No Description Entered, please enter a description");
            alert.setTitle("Description Alert");
            alert.setHeaderText("Description Alert");

            alert.showAndWait();
        }
        if(code ==11)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid amount of cores entered. Enter 1 or more cores");
            alert.setTitle("Cores Alert");
            alert.setHeaderText("Cores Alert");

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
    public static void processorSelectionError(int code)
    {
        if(code == 1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No processor selected, please select a processor and try again");
            alert.setTitle("Processor selection Alert");
            alert.setHeaderText("Processor selection alert");

            alert.showAndWait();

        }

    }
    public static void updateConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Update Processor Complete.");
            alert.setTitle("Update Complete.");
            alert.setHeaderText("Update Processor Alert");

            alert.showAndWait();

        }
    }
    public static void addProcessorConfirmation(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Add Processor Complete.");
            alert.setTitle("Add Complete.");
            alert.setHeaderText("Add Processor Alert");

            alert.showAndWait();

        }
    }

    public static void processorAllFieldErrors(int code, TextField name, TextField description,
                                             TextField make,
                                            TextField model, TextField amountOnHand, TextField minOnHand,
                                            TextField price, TextField discount, TextField speed,
                                            TextField socket, TextField cores)

    {
       processorAllFieldErrors(name,description,make,model,amountOnHand,minOnHand,price,discount,speed,socket,
               cores);
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

    private static void processorAllFieldErrors(TextField name, TextField description, TextField make,
                                                TextField model, TextField amountOnHand, TextField minOnHand,
                                                TextField price, TextField discount, TextField speed,
                                                TextField socket, TextField cores)

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
        if(socket!=null)
        {
            socket.setStyle("-fx-border-color: red");
        }
        if(speed!=null)
        {
            speed.setStyle("-fx-border-color: red");
        }
        if(cores!=null)
        {
            cores.setStyle("-fx-border-color: red");
        }
    }


}

