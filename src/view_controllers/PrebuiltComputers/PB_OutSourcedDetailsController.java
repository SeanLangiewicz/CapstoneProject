package view_controllers.PrebuiltComputers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Outsourced;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PB_OutSourcedDetailsController implements Initializable
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
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PrebuiltComputers" +
                "/allPrebuiltComputers.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }


    public void sendRecord(Outsourced record)
    {
        int selectedOS = record.getId();
        try
        {
            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            processorTxtField.setText(String.valueOf(record.getProcessor()));
            caseTypeTxtField.setText(String.valueOf(record.getCaseType()));
            graphicsCardTxtField.setText(String.valueOf(record.getGraphicsCard()));
            motherBoardTxtField.setText(String.valueOf(record.getMotherBoard()));
            powerSupplyTxtFld.setText(String.valueOf(record.getPowerSupply()));
            RamTxtFld.setText(String.valueOf(record.getRAM()));
            onHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));
            vendorNameTxtFld.setText(String.valueOf(record.getVendorName()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtField.setDisable(true);
        nameTxtField.setDisable(true);
        descriptionTxtField.setDisable(true);
        processorTxtField.setDisable(true);
        caseTypeTxtField.setDisable(true);
        graphicsCardTxtField.setDisable(true);
        powerSupplyTxtFld.setDisable(true);
        RamTxtFld.setDisable(true);
        onHandTxtFld.setDisable(true);
        minOnHandTxtFld.setDisable(true);
        priceTxtFld.setDisable(true);
        discountTxtFld.setDisable(true);
        vendorNameTxtFld.setDisable(true);
        motherBoardTxtField.setDisable(true);

    }
}
