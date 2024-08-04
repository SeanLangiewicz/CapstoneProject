package view_controllers.Inventory.OutSourcedPreBuilt;


import DAO.outSourcedImpl;
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
import util.Alerts.MotherboardAlertMessages;
import util.Alerts.OutsourcePrebuiltAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class invAddOutSourcePreBuiltController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private Label powerSupplyLbl;

    @FXML
    private Label RAMLbl;

    @FXML
    private Label onHandLbl;

    @FXML
    private Label minONHandLbl;

    @FXML
    private Label priceLbl;

    @FXML
    private Label discountLbl;

    @FXML
    private TextField powerSupplyTxtFld;

    @FXML
    private TextField RamTxtFld;

    @FXML
    private TextField onHandTxtFld;

    @FXML
    private TextField minOnHandTxtFld;

    @FXML
    private TextField priceTxtFld;

    @FXML
    private TextField discountTxtFld;

    @FXML
    private TextField vendorNameTxtFld;

    @FXML
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label descriptionLbl;

    @FXML
    private Label processorLbl;

    @FXML
    private Label caseTypeLbl;

    @FXML
    private Label graphicsCardLbl;

    @FXML
    private Label motherBoardLbl;

    @FXML
    private TextField idTxtField;

    @FXML
    private TextField nameTxtField;

    @FXML
    private TextField descriptionTxtField;

    @FXML
    private TextField processorTxtField;

    @FXML
    private TextField caseTypeTxtField;

    @FXML
    private TextField graphicsCardTxtField;

    @FXML
    private TextField motherBoardTxtField;

    @FXML
    private Button backBtn;

    @FXML
    private Button orderBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionOrderBtn(ActionEvent event)
    {
        try
        {
            String vendorName = vendorNameTxtFld.getText();
            String name = nameTxtField.getText();
            String description = descriptionTxtField.getText();
            String processor = processorTxtField.getText();
            String caseType = caseTypeTxtField.getText();
            String graphicsCard = graphicsCardTxtField.getText();
            String motherboard = motherBoardTxtField.getText();
            String powerSupply = powerSupplyTxtFld.getText();
            int ram = Integer.parseInt(RamTxtFld.getText());
            int onHand = Integer.parseInt(onHandTxtFld.getText());
            int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            Float price = Float.parseFloat(priceTxtFld.getText());
            Float discount = Float.parseFloat(discountTxtFld.getText());

            if(name.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(1,nameTxtField);
                return;
            }
            if(description.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(2,descriptionTxtField);
                return;
            }
            if(processor.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(3,processorTxtField);
                return;
            }
            if(caseType.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(4,caseTypeTxtField);
                return;
            }
            if(graphicsCard.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(5,graphicsCardTxtField);
                return;
            }
            if(motherboard.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(6,motherBoardTxtField);
                return;
            }
            if(powerSupply.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(7,powerSupplyTxtFld);
                return;
            }
            if(ram <=0)
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(8,RamTxtFld);
                return;
            }
            if(onHand <= 0)
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(9,onHandTxtFld);
                return;
            }
            if(minOnHand <=0)
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(10,minOnHandTxtFld);
                return;
            }
            if(price <=0)
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(11,priceTxtFld);
                return;
            }
            if(discount <0)
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(12,discountTxtFld);
                return;
            }
            if(vendorName.isEmpty())
            {
                OutsourcePrebuiltAlertMessages.OutsourceAlerts(13,vendorNameTxtFld);
                return;
            }
            defaultColorFields();
            resetFields();


            outSourcedImpl.addOutSourcedPC(vendorName,name,description,processor,caseType,graphicsCard,motherboard,
                    powerSupply,ram,onHand,minOnHand,price,discount);
            OutsourcePrebuiltAlertMessages.addOutsourceConfirmation(1);

            System.out.println("Outsourced added");
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
            stage.setTitle("All Inventory Screen");
            stage.setScene(new Scene(scene));
            stage.show();

        }

        catch (Exception e)
        {
            e.printStackTrace();
            OutsourcePrebuiltAlertMessages.outSourceAllFieldErrors(1,nameTxtField,descriptionTxtField,
                    processorTxtField,caseTypeTxtField,graphicsCardTxtField,motherBoardTxtField,powerSupplyTxtFld,
                    RamTxtFld,onHandTxtFld,minOnHandTxtFld,priceTxtFld,discountTxtFld,vendorNameTxtFld);
            return;
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idTxtField.setDisable(true);
        idTxtField.setText("Auto-Generated");
    }
    public void resetFields() {
        nameTxtField.setText("");
        descriptionTxtField.setText("");
        processorTxtField.setText("");
        caseTypeTxtField.setText("");
        graphicsCardTxtField.setText("");
        motherBoardTxtField.setText("");
        powerSupplyTxtFld.setText("");
        RamTxtFld.setText("");
        onHandTxtFld.setText("");
        minOnHandTxtFld.setText("");
        priceTxtFld.setText("");
        discountTxtFld.setText("");
        vendorNameTxtFld.setText("");

    }

    public void defaultColorFields() {
        nameTxtField.setStyle("-fx-border-color: white");
        descriptionTxtField.setStyle("-fx-border-color: white");
        processorTxtField.setStyle("-fx-border-color: white");
        caseTypeTxtField.setStyle("-fx-border-color: white");
        graphicsCardTxtField.setStyle("-fx-border-color: white");
        motherBoardTxtField.setStyle("-fx-border-color: white");
        powerSupplyTxtFld.setStyle("-fx-border-color: white");
        RamTxtFld.setStyle("-fx-border-color: white");
        onHandTxtFld.setStyle("-fx-border-color: white");
        minOnHandTxtFld.setStyle("-fx-border-color: white");
        priceTxtFld.setStyle("-fx-border-color: white");
        discountTxtFld.setStyle("-fx-border-color: white");
        vendorNameTxtFld.setStyle("-fx-border-color: white");
    }
}
