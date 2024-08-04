package view_controllers.Inventory.Processor;

import DAO.processorImpl;
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
import util.Alerts.ProcessorAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAddProcessorController implements Initializable
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
    private TextField coresTxtFld;

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
    private TextField speedTxtFld;

    @FXML
    private TextField socketTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button updateBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionUpdateBtn(ActionEvent event) throws Exception
    {
        try
        {
            String name = nameTxtField.getText();
            String description = descriptionTxtField.getText();
            String make = makeTxtFld.getText();
            String model = modelTxtFld.getText();
            int speed = Integer.parseInt(speedTxtFld.getText());
            String socket = socketTxtFld.getText();
            int cores = Integer.parseInt(coresTxtFld.getText());
            int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
            int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            float price = Float.parseFloat(priceTxtFld.getText());
            float discount = Float.parseFloat(discountTxtFld.getText());

            if(name == null)
            {
                ProcessorAlertMessages.processorAlerts(1,nameTxtField);
                return;
            }
            if(speed <=0)
            {
                ProcessorAlertMessages.processorAlerts(2,speedTxtFld);
                return;
            }
            if(make == null)
            {
                ProcessorAlertMessages.processorAlerts(3,makeTxtFld);
                return;
            }
            if(socket == null)
            {
                ProcessorAlertMessages.processorAlerts(4,socketTxtFld);
                return;
            }
            if(model == null)
            {
                ProcessorAlertMessages.processorAlerts(5,modelTxtFld);
                return;
            }
            if(amountOnHand <=0)
            {
                ProcessorAlertMessages.processorAlerts(6,amntOnHandTxtFld);
                return;
            }
            if(minOnHand <=0)
            {
                ProcessorAlertMessages.processorAlerts(7,minOnHandTxtFld);
                return;
            }
            if(price <=0)
            {
                ProcessorAlertMessages.processorAlerts(8,priceTxtFld);
                return;
            }
            if(discount <0)
            {
                ProcessorAlertMessages.processorAlerts(9,discountTxtFld);
                return;
            }
            if(description == null)
            {
                ProcessorAlertMessages.processorAlerts(10,descriptionTxtField);
                return;
            }
            if(cores <=0)
            {
                ProcessorAlertMessages.processorAlerts(11,coresTxtFld);
                return;
            }
            if(amountOnHand <= minOnHand)
            {
                ProcessorAlertMessages.processorAlerts(12,amntOnHandTxtFld);
                return;
            }

            processorImpl.addProcessor(name,description,make,model,speed,socket,cores,amountOnHand,minOnHand,price,
                    discount);

            ProcessorAlertMessages.addProcessorConfirmation(1);

            System.out.println("New Processor Added");

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
            stage.setTitle("All Inventory Screen");
            stage.setScene(new Scene(scene));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ProcessorAlertMessages.processorAllFieldErrors(1,nameTxtField,descriptionTxtField,makeTxtFld,modelTxtFld,
                    amntOnHandTxtFld,minOnHandTxtFld,priceTxtFld,discountTxtFld,speedTxtFld,socketTxtFld,coresTxtFld);
            return;
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtField.setText("Auto-Incremenated");
        idTxtField.setDisable(true);

    }
}
