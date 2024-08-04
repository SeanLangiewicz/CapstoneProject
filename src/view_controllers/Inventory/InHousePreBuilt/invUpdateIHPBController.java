package view_controllers.Inventory.InHousePreBuilt;
import DAO.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import util.Alerts.InHouseAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invUpdateIHPBController implements Initializable
{
    Parent scene;
    Stage stage;
    private String selectedProcessor = null;
    private String selectedCase = null;
    private String selectedGraphicsCard = null;
    private String selectedMotherboard = null;
    private String selectedPowerSupply = null;
    private int selectedRAM = 0;

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
    private ComboBox<Processor> processorComboBox;

    @FXML
    private ComboBox<Cases> caseComboBox;

    @FXML
    private ComboBox<GraphicCards> graphicsCardComboBox;

    @FXML
    private ComboBox<Motherboards> motherboardComboBox;

    @FXML
    private ComboBox<PowerSupply> powerSupplyComboBox;

    @FXML
    private ComboBox<Ram> ramComboBox;

    @FXML
    private Button backBtn;

    @FXML
    private Button updateBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/InHousePreBuilt" +
                "/invAllIHPB.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionCaseComboBox(ActionEvent event)
    {
        selectedCase = caseComboBox.getValue().getName();
        caseTxtFld.setText(selectedCase);

    }

    @FXML
    void onActionGCComboBox(ActionEvent event)
    {
        selectedGraphicsCard = graphicsCardComboBox.getValue().getName();
        GCTxtFld.setText(selectedGraphicsCard);


    }

    @FXML
    void onActionMBComboBox(ActionEvent event)
    {
        selectedMotherboard = motherboardComboBox.getValue().getName();
        MBTxtFld.setText(selectedMotherboard);

    }

    @FXML
    void onActionPSComboBox(ActionEvent event)
    {
        selectedPowerSupply = powerSupplyComboBox.getValue().getName();
        PSTxtFld.setText(selectedPowerSupply);


    }

    @FXML
    void onActionProcessorComboBox(ActionEvent event)
    {
        selectedProcessor = processorComboBox.getValue().getName();
        processorTxtFld.setText(selectedProcessor);

    }

    @FXML
    void onActionRAMComboBox(ActionEvent event)
    {

        selectedRAM = ramComboBox.getValue().getCapacity();
        RAMTxtFld.setText(String.valueOf(selectedRAM));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            ObservableList<Processor> processorList = processorImpl.selectAllProcessors();
            processorComboBox.setItems(processorList);

            ObservableList<Cases> caseList = casesImpl.selectAllCases();
            caseComboBox.setItems(caseList);

            ObservableList<GraphicCards> graphicsCardList = graphicCardImpl.selectAllCards();
            graphicsCardComboBox.setItems(graphicsCardList);

            ObservableList<Motherboards> motherboardList = motherboardImpl.selectAllMotherboards();
            motherboardComboBox.setItems(motherboardList);

            ObservableList<PowerSupply> powerSupplyList = powersupplyImpl.selectAllPowerSupply();
            powerSupplyComboBox.setItems(powerSupplyList);

            ObservableList<Ram> ramList = RAMImpl.selectAllRam();
            ramComboBox.setItems(ramList);

            idTxtFld.setText("Auto-Incremented");
            idTxtFld.setDisable(true);

            numbrerTxtFld.setText("Auto-Incremented");
            numbrerTxtFld.setDisable(true);

            processorTxtFld.setEditable(false);
            caseTxtFld.setEditable(false);
            GCTxtFld.setEditable(false);
            MBTxtFld.setEditable(false);
            PSTxtFld.setEditable(false);
            RAMTxtFld.setEditable(false);




        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void onActionUpdateBtn(ActionEvent event) throws IOException {
        int buildNumber = Integer.parseInt(idTxtFld.getText());
        String name = nameTxtFld.getText();
        String description = descriptionTxtFld.getText();
        String processorName = processorTxtFld.getText();
        String caseName = caseTxtFld.getText();
        String graphicsCard = GCTxtFld.getText();
        String motherBoard = MBTxtFld.getText();
        String powerSupply = PSTxtFld.getText();
        String RAM = RAMTxtFld.getText();
        int QOH = Integer.parseInt(onAmountOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        Float price = Float.parseFloat(priceTxtFld.getText());
        Float discount = Float.parseFloat(discountTxtFld.getText());

        if(name.isEmpty())
        {
            InHouseAlertMessages.InHouseAlertMessages(1,nameTxtFld);
            return;
        }
        if(description.isEmpty())
        {
            InHouseAlertMessages.InHouseAlertMessages(2,descriptionTxtFld);
            return;
        }
        if(QOH <=0)
        {
            InHouseAlertMessages.InHouseAlertMessages(3,onAmountOnHandTxtFld);
            return;
        }
        if( minOnHand<=0)
        {
            InHouseAlertMessages.InHouseAlertMessages(4,minOnHandTxtFld);
            return;
        }
        if(price <=0)
        {
            InHouseAlertMessages.InHouseAlertMessages(5,priceTxtFld);
            return;
        }
        if(discount <=-1)
        {
            InHouseAlertMessages.InHouseAlertMessages(6,discountTxtFld);
            return;
        }
        if(processorTxtFld == null)
        {
            InHouseAlertMessages.InHouseAlertMessages(7,processorTxtFld);
            return;
        }
        if(caseTxtFld ==null)
        {
            InHouseAlertMessages.InHouseAlertMessages(8,caseTxtFld);
            return;

        }
        if(GCTxtFld == null)
        {
            InHouseAlertMessages.InHouseAlertMessages(9,GCTxtFld);
            return;
        }
        if(MBTxtFld == null)
        {
            InHouseAlertMessages.InHouseAlertMessages(10,MBTxtFld);
            return;
        }
        if(PSTxtFld == null)
        {
            InHouseAlertMessages.InHouseAlertMessages(11,PSTxtFld);
            return;
        }
        if(RAMTxtFld == null)
        {
            InHouseAlertMessages.InHouseAlertMessages(12,RAMTxtFld);
            return;
        }
        if(QOH <= minOnHand)
        {
            InHouseAlertMessages.InHouseAlertMessages(13,onAmountOnHandTxtFld);
            return;
        }


        inHouseImpl.updateInHousePB(name,description,processorName,caseName,graphicsCard,motherBoard,
                powerSupply,RAM,QOH,
                minOnHand,price,discount,buildNumber);
        InHouseAlertMessages.updateConfirmation(1);

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
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


}
