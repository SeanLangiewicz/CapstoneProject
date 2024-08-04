package util.Alerts;

import javafx.scene.control.Alert;

public class ReportsAlertMessages
{
    public static void reportAlerts(int code)
    {
        if(code ==1)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Employee Selected, select an employee");
            alert.setTitle("Employee Alert");
            alert.setHeaderText("Employee Alert");

            alert.showAndWait();
        }
        if(code ==2)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No time period selected, please selected a time period");
            alert.setTitle("Time period Alert");
            alert.setHeaderText("Time period Alert");

            alert.showAndWait();
        }
        if(code ==3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No Time period or employee selected. Selected an item from both dropdowns and try " +
                    "again");
            alert.setTitle("Selection Alert");
            alert.setHeaderText("Selection Alert");

            alert.showAndWait();
        }

    }
}
