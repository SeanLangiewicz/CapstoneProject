package view_controllers.Inventory.MotherBoard;

import DAO.motherboardImpl;
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
import util.Alerts.GraphicsCardAlertMessages;
import util.Alerts.MotherboardAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAddMotherBoardController implements Initializable
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
    private Button addBtn;

    Parent scene;
    Stage stage;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddBtn(ActionEvent event) throws IOException
    {
        try
        {
            String name = nameTxtField.getText();
            String make = makeTxtFld.getText();
            String model = modelTxtFld.getText();
            String size = sizeTxtFld.getText();
            String description = descriptionTxtField.getText();
            int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
            int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            float price = Float.parseFloat(priceTxtFld.getText());
            float discount = Float.parseFloat(discountTxtFld.getText());

            if(name.isEmpty())
            {
                MotherboardAlertMessages.MotherBoardAlerts(1,nameTxtField);
                return;
            }
            if(size.isEmpty())
            {
                MotherboardAlertMessages.MotherBoardAlerts(2,sizeTxtFld);
                return;
            }
            if(make.isEmpty())
            {
                MotherboardAlertMessages.MotherBoardAlerts(3,makeTxtFld);
                return;
            }
            if(model.isEmpty())
            {
                MotherboardAlertMessages.MotherBoardAlerts(4,modelTxtFld);
                return;
            }
            if(description.isEmpty())
            {
                MotherboardAlertMessages.MotherBoardAlerts(5,descriptionTxtField);
                return;
            }
            if(amountOnHand <=0)
            {
                MotherboardAlertMessages.MotherBoardAlerts(6,amntOnHandTxtFld);
                return;
            }
            if(minOnHand <= 0)
            {
                MotherboardAlertMessages.MotherBoardAlerts(7,minOnHandTxtFld);
                return;
            }
            if(amountOnHand < minOnHand)
            {
                MotherboardAlertMessages.MotherBoardAlerts(8,amntOnHandTxtFld);
                return;
            }
            if(price <=0)
            {
                MotherboardAlertMessages.MotherBoardAlerts(9,priceTxtFld);
                return;
            }


            defaultColorFields();
            resetFields();


            motherboardImpl.addMotherBoard(name,make,model,size,description,amountOnHand,minOnHand,price,discount);
            MotherboardAlertMessages.addMotherboardConfirmation(1);

            System.out.println("Motherboard added");
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
            stage.setTitle("All Inventory Screen");
            stage.setScene(new Scene(scene));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            MotherboardAlertMessages.motherboardFieldErrors(1,nameTxtField,sizeTxtFld,makeTxtFld,modelTxtFld,
                    descriptionTxtField,amntOnHandTxtFld,minOnHandTxtFld,priceTxtFld,discountTxtFld);
            return;
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtField.setText("Auto-Generated");
        idTxtField.setDisable(true);

    }
    public void resetFields() {
        nameTxtField.setText("");
        sizeTxtFld.setText("");
        makeTxtFld.setText("");
        modelTxtFld.setText("");
        descriptionTxtField.setText("");
        amntOnHandTxtFld.setText("");
        minOnHandTxtFld.setText("");
        priceTxtFld.setText("");
        discountTxtFld.setText("");

    }

    public void defaultColorFields() {
        nameTxtField.setStyle("-fx-border-color: white");
        makeTxtFld.setStyle("-fx-border-color: white");
        modelTxtFld.setStyle("-fx-border-color: white");
        sizeTxtFld.setStyle("-fx-border-color: white");
        descriptionTxtField.setStyle("-fx-border-color: white");
        amntOnHandTxtFld.setStyle("-fx-border-color: white");
        minOnHandTxtFld.setStyle("-fx-border-color: white");
        priceTxtFld.setStyle("-fx-border-color: white");
        discountTxtFld.setStyle("-fx-border-color: white");
    }
}
