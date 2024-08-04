package view_controllers.TypeSelection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TypeSelectionController
{
    Parent scene;
    Stage stage;

    @FXML
    private Label tempLbl;

    @FXML
    private Button backBtn;

    @FXML
    private Button preBuiltBtn;

    @FXML
    private Button customOrderBtn;



    @FXML
    void onActionPrebuiltBtn(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PrebuiltComputers/allPrebuiltComputers" +
                ".fxml"));
        stage.setTitle("Pre-build computer Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActonCustomOrder(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/CustomOrder/CustomOrder.fxml"));
        stage.setTitle("Welcome Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException
    {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection.fxml"));
        stage.setTitle("Welcome Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

}
