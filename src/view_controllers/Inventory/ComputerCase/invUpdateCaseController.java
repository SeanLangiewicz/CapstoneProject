package view_controllers.Inventory.ComputerCase;

import DAO.casesImpl;
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
import model.Cases;
import util.Alerts.CaseAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invUpdateCaseController implements Initializable
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
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label descriptionLbl;

    @FXML
    private Label typeLbl;

    @FXML
    private Label makeLbl;

    @FXML
    private Label modelLbl;

    @FXML
    private TextField idTxtField;

    @FXML
    private TextField nameTxtField;

    @FXML
    private TextField descriptionTxtField;

    @FXML
    private TextField typeTxtFld;

    @FXML
    private TextField makeTxtFld;

    @FXML
    private TextField modelTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button updateCaseBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionUpdateCaseBtn(ActionEvent event)
    {
        try
        {
            int id = Integer.parseInt(idTxtField.getText());
            String name = nameTxtField.getText();
            String description = descriptionTxtField.getText();
            String type = typeTxtFld.getText();
            String make = makeTxtFld.getText();
            String model = modelTxtFld.getText();
            int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
            int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            float price = Float.parseFloat(priceTxtFld.getText());
            float discount = Float.parseFloat(discountTxtFld.getText());
            if(name.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(1,nameTxtField);
                return;
            }
            if(description.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(2,descriptionTxtField);
                return;
            }
            if (type.isEmpty()){
                CaseAlertMessages.ComputerCaseAlerts(3,typeTxtFld);
                return;
            }
            if(make.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(4,makeTxtFld);
                return;
            }
            if(model.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(5,modelTxtFld);
                return;
            }

            if(amountOnHand <=0)
            {
                CaseAlertMessages.ComputerCaseAlerts(6,amntOnHandTxtFld);
                return;
            }

            if(minOnHand <=0)
            {
                CaseAlertMessages.ComputerCaseAlerts(7,minOnHandTxtFld);
                return;
            }

            if(price <0)
            {
                CaseAlertMessages.ComputerCaseAlerts(8,priceTxtFld);
                return;
            }

            if(discount <0)
            {
                CaseAlertMessages.ComputerCaseAlerts(9,discountTxtFld);
                return;
            }

            if(amountOnHand <= minOnHand || amountOnHand<= minOnHand)
            {
                CaseAlertMessages.ComputerCaseAlerts(10,amntOnHandTxtFld);
                return;
            }


            casesImpl.updateCase(name,type,make,model,description,amountOnHand,minOnHand,price,discount,id);
            CaseAlertMessages.updateConfirmation(1);

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
            stage.setTitle("All Inventory Screen");
            stage.setScene(new Scene(scene));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            CaseAlertMessages.caseFieldErrors(1,nameTxtField,descriptionTxtField,typeTxtFld,makeTxtFld,modelTxtFld,
                    amntOnHandTxtFld,minOnHandTxtFld,priceTxtFld,discountTxtFld);
            return;
        }

        defaultColorFields();
        resetFields();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtField.setDisable(true);

    }

    public void sendRecord (Cases record)
    {
        int selectedID = record.getId();
        String name = record.getName();

        try
        {
            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            typeTxtFld.setText(String.valueOf(record.getType()));
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
    public void resetFields() {
        nameTxtField.setText("");
        descriptionTxtField.setText("");
        typeTxtFld.setText("");
        makeTxtFld.setText("");
        modelTxtFld.setText("");
        amntOnHandTxtFld.setText("");
        minOnHandTxtFld.setText("");
        priceTxtFld.setText("");
        discountTxtFld.setText("");

    }

    public void defaultColorFields() {
        nameTxtField.setStyle("-fx-border-color: white");
        descriptionTxtField.setStyle("-fx-border-color: white");
        typeTxtFld.setStyle("-fx-border-color: white");
        makeTxtFld.setStyle("-fx-border-color: white");
        modelTxtFld.setStyle("-fx-border-color: white");
        amntOnHandTxtFld.setStyle("-fx-border-color: white");
        minOnHandTxtFld.setStyle("-fx-border-color: white");
        priceTxtFld.setStyle("-fx-border-color: white");
        discountTxtFld.setStyle("-fx-border-color: white");

    }
}
