package view_controllers.Inventory.RAM;

import DAO.RAMImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Ram;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Alerts.PowerSupplyAlertMessages;
import util.Alerts.RAMAlertMessages;

import java.io.IOException;
import java.sql.SQLException;

public class invRAMController
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
    private Button updateRAMBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionUpdateRAMBtn(ActionEvent event) throws IOException, SQLException
    {
        try
        {
            int id = Integer.parseInt(idTxtField.getText());
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


            RAMImpl.updateRAM(name,make,model,capacity,speed,description,amountOnHand,minOnHand,price,discount,id);
            RAMAlertMessages.updateConfirmation(1);

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
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



    public void sendRecord (Ram record)
    {
        int selectedID = record.getId();

        try
        {
            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            makeTxtFld.setText(String.valueOf(record.getMake()));
            modelTxtFld.setText(String.valueOf(record.getModel()));
            capacityTxtFld.setText(String.valueOf(record.getCapacity()));
            speedTxtFld.setText(String.valueOf(record.getSpeed()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
