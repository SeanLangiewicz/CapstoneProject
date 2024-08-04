package view_controllers.Inventory.RAM;

import DAO.RAMImpl;
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
import util.Alerts.PowerSupplyAlertMessages;
import util.Alerts.RAMAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAddRAMController implements Initializable
{
    Parent scene;
    Stage stage;
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
    private TextField capacityTxtFld;

    @FXML
    private TextField speedTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button addRAMBtn;

    @FXML
    void onActionAddRAMBtn(ActionEvent event) throws IOException
    {
        try
        {
            String name = nameTxtField.getText();
            String make = makeTxtFld.getText();
            String model = modelTxtFld.getText();
            int capacity = Integer.parseInt(capacityTxtFld.getText());
            int speed = Integer.parseInt(speedTxtFld.getText());
            String description = descriptionTxtField.getText();
            int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
            int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            float price = Float.parseFloat(priceTxtFld.getText());
            float discount = Float.parseFloat(discountTxtFld.getText());

            if(name == null)
            {
                RAMAlertMessages.ramAlerts(1,nameTxtField);
                return;
            }
            if(make == null)
            {
                RAMAlertMessages.ramAlerts(2,makeTxtFld);
                return;
            }

            if(model == null)
            {
                RAMAlertMessages.ramAlerts(3,modelTxtFld);
                return;
            }

            if(capacity <=0 )
            {
                RAMAlertMessages.ramAlerts(4,capacityTxtFld);
                return;
            }
            if(speed <= 0)
            {
                RAMAlertMessages.ramAlerts(5,speedTxtFld);
                return;
            }
            if(description == null)
            {
                RAMAlertMessages.ramAlerts(6,descriptionTxtField);
                return;
            }
            if(amountOnHand <0)
            {
                RAMAlertMessages.ramAlerts(7,amntOnHandTxtFld);
                return;
            }
            if(minOnHand <=0)
            {
                RAMAlertMessages.ramAlerts(8,minOnHandTxtFld);
                return;
            }
            if(price <=0)
            {
                RAMAlertMessages.ramAlerts(9,priceTxtFld);
                return;
            }

            if(discount <0)
            {
                RAMAlertMessages.ramAlerts(10,discountTxtFld);
                return;
            }
            if(amountOnHand < minOnHand)
            {
                RAMAlertMessages.ramAlerts(11,amntOnHandTxtFld);
                return;
            }

            RAMImpl.addRAM(name,make,model,capacity,speed,description,amountOnHand,minOnHand,price,discount);
            RAMAlertMessages.addRAMConfirmation(1);

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection" +
                    ".fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            RAMAlertMessages.RAMAllFieldErrors(1,nameTxtField,makeTxtFld,modelTxtFld,capacityTxtFld,speedTxtFld,
                    descriptionTxtField,amntOnHandTxtFld,minOnHandTxtFld,priceTxtFld,discountTxtFld);
            return;
        }


    }

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        idTxtField.setText("Auto-Incremented");
        idTxtField.setDisable(true);

    }
}