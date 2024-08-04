package util.Alerts;

import javafx.scene.control.Alert;

public class ShippingAlertMessages
{
    public static void shippingAlerts(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Employee Selected select an employee form the list and try again");
            alert.setTitle("Selection Alert");
            alert.setHeaderText("Selection Selection Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Customer Selected, select a customer and try again");
            alert.setTitle("Selection Alert");
            alert.setHeaderText("Selection  Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("Invalid Selection, make sure you select an employee and a customer from the list");
            alert.setTitle("Selection Alert");
            alert.setHeaderText("Selection Selection Alert");

            alert.showAndWait();
        }

    }

}
