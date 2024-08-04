package util.Alerts;

import javafx.scene.control.Alert;

public class ItemSelectionAlert
{
    public static void SelectionError(int code) {
        if (code == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText("No item selected, please select an item and try again");
            alert.setTitle("Selection Alert");
            alert.setHeaderText("Selection alert");

            alert.showAndWait();

        }
    }
}
