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
import util.Alerts.CaseAlertMessages;
import util.Alerts.GraphicsCardAlertMessages;
import util.Alerts.InHouseAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static SLHardwareOrderingSystem.SeanLangiewiczHardwareOrderingSystem.generateBuildNumber;



public class invAddIHPreBuiltController implements Initializable
{


    private String selectedProcessor = null;
    private String selectedCase = null;
    private String selectedGraphicsCard = null;
    private String selectedMotherboard = null;
    private String selectedPowerSupply = null;
    private int selectedRAM = 0;

    public int newBuildID = generateBuildNumber();


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
    private Button addBtn;

    Parent scene;
    Stage stage;

    @FXML
    private void onActionAddBtn(ActionEvent event) throws IOException
    {


        try
        {

            int buildNumber = inHouseImpl.getLastBuildNumber();
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
            if(QOH <= minOnHand)
            {
                InHouseAlertMessages.InHouseAlertMessages(13,onAmountOnHandTxtFld);
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
            if(selectedProcessor.isEmpty())
            {
                InHouseAlertMessages.InHouseAlertMessages(7,processorTxtFld);
                return;
            }
            if(selectedCase.isEmpty())
            {
                InHouseAlertMessages.InHouseAlertMessages(8,caseTxtFld);
                    return;

            }
            if(selectedGraphicsCard.isEmpty())
            {
                InHouseAlertMessages.InHouseAlertMessages(9,GCTxtFld);
                return;
            }
            if(selectedMotherboard.isEmpty())
            {
                InHouseAlertMessages.InHouseAlertMessages(10,MBTxtFld);
                return;
            }
            if(selectedPowerSupply.isEmpty())
            {
                InHouseAlertMessages.InHouseAlertMessages(11,PSTxtFld);
                return;
            }
            if(selectedRAM <=0)
            {
                InHouseAlertMessages.InHouseAlertMessages(12,RAMTxtFld);
                return;
            }




            inHouseImpl.addInHousePB(buildNumber,name,description,processorName,caseName,graphicsCard,motherBoard,
                    powerSupply,RAM,QOH,
                    minOnHand,price,discount);
            InHouseAlertMessages.addinHouseConfirmation(1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            InHouseAlertMessages.inHouseFieldErrors(1,nameTxtFld,descriptionTxtFld,onAmountOnHandTxtFld,
                    minOnHandTxtFld,priceTxtFld,discountTxtFld,processorTxtFld,caseTxtFld, GCTxtFld,MBTxtFld,
                    PSTxtFld,RAMTxtFld);
            return;
        }


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException
    {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
         scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
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




        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
