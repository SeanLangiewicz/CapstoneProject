package view_controllers.CustomOrder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomOrderController
{
    Parent scene;
    Stage stage;

    @FXML
    private Button backBtn;

    @FXML
    private Button computerCaseSelectionBtn;

    @FXML
    private Button graphicsCardBtn;

    @FXML
    private Button powerSupplyBtn;

    @FXML
    private Button motherboardBtn;

    @FXML
    private Button ramBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/TypeSelection/TypeSelection.fxml"));
        stage.setTitle("Type Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionComputerCaseSelectionBtn(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ComputerCaseType/ComputerCase.fxml"));
        stage.setTitle("Computer Case Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionGraphicsCardBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/GraphicsCardSelection/GraphicsCardSelection" +
                ".fxml"));
        stage.setTitle("Graphics Card Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionMotherboardBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/MotherBoardSelection/MotherBoardSelection" +
                ".fxml"));
        stage.setTitle("Motherboard Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionPowerSupplyBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PowerSupplySelection/PowerSupplySelection" +
                ".fxml"));
        stage.setTitle("Power Supply Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionRAMBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/RAMSelection/RAMSelection.fxml"));
        stage.setTitle("RAM Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }



}
