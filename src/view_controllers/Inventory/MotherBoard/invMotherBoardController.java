package view_controllers.Inventory.MotherBoard;

import DAO.motherboardImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Inventory;
import model.Motherboards;
import util.Alerts.MotherboardAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invMotherBoardController implements Initializable
{
    @FXML
    private Label amountOnHandLbl;

    @FXML
    private Label minOnHandLbl;

    @FXML
    private Label priceLbl;

    @FXML
    private Label discountLbl;

    @FXML
    private TextField amntOnHandTxtFld;

    @FXML
    private TextField minOnHandTxtFld;

    @FXML
    private TextField priceTxtFld;

    @FXML
    private TextField discountTxtFld;

    @FXML
    private Label descriptionLbl;

    @FXML
    private TextField descriptionTxtField;

    @FXML
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label makeLbl;

    @FXML
    private Label modelLbl;

    @FXML
    private TextField idTxtField;

    @FXML
    private TextField nameTxtField;

    @FXML
    private TextField makeTxtFld;

    @FXML
    private TextField modelTxtFld;

    @FXML
    private TextField sizeTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button updateBtn;

    Parent scene;
    Stage stage;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/MotherBoard/invAllMotherBoard" +
                ".fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionUpdateBtn(ActionEvent event) throws IOException {

        ObservableList<Motherboards> motherBoardCheckList = FXCollections.observableArrayList();
        int id = Integer.parseInt(idTxtField.getText());
        String name = nameTxtField.getText();
        String make = makeTxtFld.getText();
        String model = modelTxtFld.getText();
        String size = sizeTxtFld.getText();
        String description = descriptionTxtField.getText();
        int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        float price = Float.parseFloat(priceTxtFld.getText());
        float discount = Float.parseFloat(discountTxtFld.getText());


        motherboardImpl.updateMotherBoard(name,make,model,size,description,amountOnHand,minOnHand,price,discount,id);
        MotherboardAlertMessages.updateConfirmation(1);


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtField.setDisable(true);
        idTxtField.setText("Not Editable");

    }

    public void sendRecord (Motherboards record)
    {
        int selectedID = record.getId();

        try
        {

            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            sizeTxtFld.setText(String.valueOf(record.getSize()));
            makeTxtFld.setText(String.valueOf(record.getMake()));
            modelTxtFld.setText(String.valueOf(record.getModel()));
            amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));
        }

        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
