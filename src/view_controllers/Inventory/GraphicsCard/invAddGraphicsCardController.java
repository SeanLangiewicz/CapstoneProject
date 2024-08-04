package view_controllers.Inventory.GraphicsCard;
import DAO.graphicCardImpl;
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
import util.Alerts.CaseAlertMessages;
import util.Alerts.GraphicsCardAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class invAddGraphicsCardController implements Initializable
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
    private TextField maxResTxtFld;

    @FXML
    private TextField connectorsTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button addCardBtn;



    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddCard(ActionEvent event) throws IOException
    {
        try
        {


            String name = nameTxtField.getText();
            String make = makeTxtFld.getText();
            String model = modelTxtFld.getText();
            String resolution = maxResTxtFld.getText();
            String connectors = connectorsTxtFld.getText();
            String description = descriptionTxtField.getText();
            Integer onHand = Integer.parseInt(amntOnHandTxtFld.getText());
            Integer minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
            Float price = Float.parseFloat(priceTxtFld.getText());
            Float discount = Float.parseFloat(discountTxtFld.getText());


            if(name.isEmpty())
            {
                GraphicsCardAlertMessages.graphicsCardAlerts(1,nameTxtField);
                return;
            }
            if(description.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(2,descriptionTxtField);
                return;
            }
            if (model.isEmpty()){
                CaseAlertMessages.ComputerCaseAlerts(3,modelTxtFld);
                return;
            }
            if(make.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(4,makeTxtFld);
                return;
            }
            if(resolution.isEmpty())
            {
                CaseAlertMessages.ComputerCaseAlerts(5,maxResTxtFld);
                return;
            }

            if(onHand <=0)
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

            if(onHand <= minOnHand || onHand<= minOnHand)
            {
                CaseAlertMessages.ComputerCaseAlerts(10,amntOnHandTxtFld);
                return;
            }

            defaultColorFields();
            resetFields();

            GraphicsCardAlertMessages.addGraphicCardConfirmation(1);
            graphicCardImpl.addGraphicsCard(name,make,model,resolution,connectors,description,onHand,minOnHand,price,
                    discount);



            System.out.println("Graphics Card added");
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
            stage.setTitle("All Inventory Screen");
            stage.setScene(new Scene(scene));
            stage.show();
        }

        catch (Exception e)
        {
            e.printStackTrace();
            GraphicsCardAlertMessages.graphicCardFieldErrors(1,nameTxtField,makeTxtFld,modelTxtFld,maxResTxtFld,
                    connectorsTxtFld,descriptionTxtField,amntOnHandTxtFld,minOnHandTxtFld,priceTxtFld,discountTxtFld);
            return;
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtField.setDisable(true);
        idTxtField.setText("Auto-Incremented");

    }
    public void resetFields() {
        nameTxtField.setText("");
        makeTxtFld.setText("");
        modelTxtFld.setText("");
        maxResTxtFld.setText("");
        connectorsTxtFld.setText("");
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
        maxResTxtFld.setStyle("-fx-border-color: white");
        connectorsTxtFld.setStyle("-fx-border-color: white");
        descriptionTxtField.setStyle("-fx-border-color: white");
        amntOnHandTxtFld.setStyle("-fx-border-color: white");
        minOnHandTxtFld.setStyle("-fx-border-color: white");
        priceTxtFld.setStyle("-fx-border-color: white");
        discountTxtFld.setStyle("-fx-border-color: white");
    }

}
