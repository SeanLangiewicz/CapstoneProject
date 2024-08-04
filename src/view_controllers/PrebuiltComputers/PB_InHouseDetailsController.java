package view_controllers.PrebuiltComputers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PB_InHouseDetailsController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private TextField idTxtFld;

    @FXML
    private TextField numbrerTxtFld;

    @FXML
    private TextField nameTxtFld;

    @FXML
    private TextField descriptionTxtFld;

    @FXML
    private TextField discountTxtFld;

    @FXML
    private TextField priceTxtFld;

    @FXML
    private TextField onAmountOnHandTxtFld;

    @FXML
    private TextField minOnHandTxtFld;

    @FXML
    private TextField processorTxtFld;

    @FXML
    private TextField caseTxtFld;

    @FXML
    private TextField GCTxtFld;

    @FXML
    private TextField MBTxtFld;

    @FXML
    private TextField PSTxtFld;

    @FXML
    private TextField RAMTxtFld;

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
    public void sendRecord (InHouse record)
    {
        int selectedIH = record.getId();
        try
        {
            idTxtFld.setText(String.valueOf(record.getId()));
            nameTxtFld.setText(String.valueOf(record.getName()));
            descriptionTxtFld.setText(String.valueOf(record.getDescription()));
            processorTxtFld.setText(String.valueOf(record.getProcessor()));
            caseTxtFld.setText(String.valueOf(record.getCaseType()));
            GCTxtFld.setText(String.valueOf(record.getGraphicsCard()));
            MBTxtFld.setText(String.valueOf(record.getMotherBoard()));
            PSTxtFld.setText(String.valueOf(record.getPowerSupply()));
            RAMTxtFld.setText(String.valueOf(record.getRAM()));
            onAmountOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));
            numbrerTxtFld.setText(String.valueOf(record.getBuildNumber()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtFld.setDisable(true);
        nameTxtFld.setDisable(true);
        descriptionTxtFld.setDisable(true);
        processorTxtFld.setDisable(true);
        caseTxtFld.setDisable(true);
        GCTxtFld.setDisable(true);
        MBTxtFld.setDisable(true);
        PSTxtFld.setDisable(true);
        RAMTxtFld.setDisable(true);
        onAmountOnHandTxtFld.setDisable(true);
        minOnHandTxtFld.setDisable(true);
        priceTxtFld.setDisable(true);
        discountTxtFld.setDisable(true);
        numbrerTxtFld.setDisable(true);

    }
}
