package view_controllers.ScreenSelection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Customer_FullName;
import util.dateParse;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class ScreenSelectionController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private ComboBox<Customer_FullName> txtBox;

    @FXML
    private Button reportsBtn;

    @FXML
    private Button computerTypeSelectionBtn;

    @FXML
    private Button backToLogInBtn;

    @FXML
    private Button employeeScheduleBtn;

    @FXML
    private Button customerSelectionBtn;


    @FXML
    private Button hardwareInventory;
    @FXML
    private Button Employees;

    @FXML
    private Button titlesBtn;


    @FXML
    void onActionBackToLogInBtn(ActionEvent event) throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will take you back to the login screen, are you " +
                "sure ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/LoginScreen/LoginScreen.fxml"));
            stage.setTitle("Login Screen");
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    void onActionComputerTypeSelectionBtn(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/TypeSelection/TypeSelection.fxml"));
        stage.setTitle("Type Selection");
        stage.setScene(new Scene(scene));
        stage.show();

    }



    @FXML
    void onActionToCustomerSelectionScreen(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Customers/AllCustomers.fxml"));
        stage.setTitle("Customer Selection Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionInventory(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Hardware Inventory Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }
    @FXML
    void onActionEmployee(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Employees/AllEmployees" +
                ".fxml"));
        stage.setTitle("All Employees");
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void onActionTitles(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Titles/AllTitles" +
                ".fxml"));
        stage.setTitle("All Titles");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionGetReports(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Reports/CustomBuilds/reports" +
                ".fxml"));
        stage.setTitle("Reports");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAboutScreen(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/AboutScreen/aboutScreen" +
                ".fxml"));
        stage.setTitle("About Screen");
        stage.setScene(new Scene(scene));
        stage.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


    }
}
