package view_controllers.AboutScreen;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutController
{
    Parent scene;
    Stage stage;

    @FXML
    private Button backBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection" +
                ".fxml"));
        stage.setTitle("Screen Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

}
