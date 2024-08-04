package view_controllers.Inventory.PowerSupply;

import DAO.powersupplyImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.PowerSupply;
import util.Alerts.PowerSupplyAlertMessages;

import java.io.IOException;


public class invPowerSupplyController
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
    private TextField wattageTxtFld;

    @FXML
    private Label discountLbl;

    @FXML
    private TextField amntOnHandTxtFld;

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
    private TextField modularTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button updateBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/PowerSupply" +
                "/invAllPowerSupply.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionUpdateBtn(ActionEvent event) throws IOException {

        ObservableList<PowerSupply> powerSupplyCheckList = FXCollections.observableArrayList();

        try
        {

            int id = Integer.parseInt(idTxtField.getText());
            String name = nameTxtField.getText();
            String make = makeTxtFld.getText();
            String model = modelTxtFld.getText();
            String modular = modularTxtFld.getText();
            int wattage = Integer.parseInt(wattageTxtFld.getText());
            String description = descriptionTxtField.getText();
            int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
            int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            float price = Float.parseFloat(priceTxtFld.getText());
            float discount = Float.parseFloat(discountTxtFld.getText());
            if(name == null)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(1,nameTxtField);
                return;
            }
            if(make == null)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(2,makeTxtFld);
                return;
            }
            if(model == null)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(3,modelTxtFld);
                return;
            }
            if(modular ==null)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(5,modularTxtFld);
                return;
            }
            if(wattage <=0)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(6,wattageTxtFld);
                return;
            }

            if(minOnHand <=0)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(7,minOnHandTxtFld);
                return;
            }
            if(price <=0)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(8,priceTxtFld);
                return;
            }
            if(amountOnHand <=0)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(9,amntOnHandTxtFld);
                return;
            }
            if(description == null)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(10,descriptionTxtField);
                return;
            }
            if(discount <0 )
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(11,discountTxtFld);
                return;
            }
            if (amountOnHand <= minOnHand)
            {
                PowerSupplyAlertMessages.PowerSupplyAlerts(12,amntOnHandTxtFld);
            }

            powersupplyImpl.updatePowerSupply(name,make,model,modular,wattage,description,amountOnHand,minOnHand,price,
                    discount,id);

            PowerSupplyAlertMessages.updateConfirmation(1);
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();PowerSupplyAlertMessages.powerSupplyllFieldErrors(1,nameTxtField,makeTxtFld,modelTxtFld,modularTxtFld,
                wattageTxtFld,minOnHandTxtFld,priceTxtFld,amntOnHandTxtFld,descriptionTxtField,discountTxtFld);
            return;
        }


    }
    public void sendRecord (PowerSupply record)
    {
        idTxtField.setText(String.valueOf(record.getId()));
        nameTxtField.setText(String.valueOf(record.getName()));
        makeTxtFld.setText(String.valueOf(record.getMake()));
        modelTxtFld.setText(String.valueOf(record.getModel()));
        modularTxtFld.setText(String.valueOf(record.getModular()));
        wattageTxtFld.setText(String.valueOf(record.getWattage()));
        minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
        priceTxtFld.setText(String.valueOf(record.getPrice()));
        amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
        descriptionTxtField.setText(String.valueOf(record.getDescription()));
        discountTxtFld.setText(String.valueOf(record.getDiscount()));

    }
}
