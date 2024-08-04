package view_controllers.ShippingScreen;

import DAO.BuiltComputersImpl;
import DAO.customerImpl;
import DAO.employeesImpl;
import DAO.processorImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import util.Alerts.ShippingAlertMessages;
import util.calcDiscount;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShippingController implements Initializable
{

    ObservableList<Employees_Builders> buildersList = FXCollections.observableArrayList();
    ObservableList<Customer_FullName> customersList = FXCollections.observableArrayList();

    ObservableList<Cases> getCase = FXCollections.observableArrayList();
    ObservableList<GraphicCards> getgraphicsCard = FXCollections.observableArrayList();
    ObservableList<Motherboards> getMotherBoard = FXCollections.observableArrayList();
    ObservableList<PowerSupply> getPowerSupply = FXCollections.observableArrayList();
    ObservableList<Processor> getProcessor = FXCollections.observableArrayList();
    ObservableList<Ram> getRam = FXCollections.observableArrayList();



    int customerID = 0;
    String customerName = null;
    int builderID =0;
    String builderName = null;

    String caseName = null;
    String motherBoardName = null;
    String graphicsCardName = null;
    String powerSupplyName = null;
    String processorName = null;
    String ramName = null;
    String selectedEmployee;
    String selectedCustomer;

    Float casePrice = null;
    Float cardPrice = null;
    Float motherboardPrice = null;
    Float powerSupplyPrice = null;
    Float processorPrice = null;
    Float ramPrice = null;
    Float totalPrice = null;

    Float caseDiscount = null;
    Float motherboardDiscount = null;
    Float graphicsCardDiscount = null;
    Float powerSupplyDiscount = null;
    Float processorDiscount = null;
    Float ramDiscount = null;

    //Convert total price to string for the text box
    String price = null;

    @FXML
    private TextField customerTxtFld;

    @FXML
    private TextField employeeTxtFld;

    @FXML
    private ComboBox<Employees_Builders> builderCmboBx;

    @FXML
    private ComboBox<Customer_FullName> customerCmbList;

    @FXML
    private Button backBtn;

    @FXML
    private Button orderBtn;

    @FXML
    private TextField caseTxtFld;

    @FXML
    private TextField mbTxtFld;

    @FXML
    private TextField graphicsCardTxtFld;

    @FXML
    private TextField powerSupplyTxtFld;

    @FXML
    private TextField processorTxtFld;

    @FXML
    private TextField RamTxtFld;

    @FXML
    private TextField totalPriceTxtFld;

    Parent scene;
    Stage stage;



    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/GraphicsCardSelection/GraphicsCardSelection" +
                ".fxml"));
        stage.setTitle("Graphics Card");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionorderBtn(ActionEvent event) throws IOException {


        System.out.println(selectedEmployee);
        System.out.println(selectedCustomer);

        try
        {
            if(selectedEmployee == null)
            {
                ShippingAlertMessages.shippingAlerts(1);
                return;
            }
            if (selectedCustomer == null)
            {
                ShippingAlertMessages.shippingAlerts(2);
                return;
            }
            if (selectedCustomer == null && selectedEmployee == null)
            {
                ShippingAlertMessages.shippingAlerts(3);
                return;
            }

             BuiltComputersImpl.addBuiltComputer(caseName,graphicsCardName,motherBoardName,powerSupplyName,
                    processorName,ramName,totalPrice,builderID,customerID);
                       stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection.fxml"));
            stage.setTitle("Screen Selection");
            stage.setScene(new Scene(scene));
            stage.show();



        }
        catch (Exception e)
        {
            e.printStackTrace();
           ShippingAlertMessages.shippingAlerts(3);
            return;
        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        caseTxtFld.setDisable(true);
        mbTxtFld.setDisable(true);
        graphicsCardTxtFld.setDisable(true);
        powerSupplyTxtFld.setDisable(true);
        processorTxtFld.setDisable(true);
        RamTxtFld.setDisable(true);
        totalPriceTxtFld.setDisable(true);


        try
        {




            getCase = Inventory.getAllCases();
            getgraphicsCard = Inventory.getAllGraphicsCards();
            getMotherBoard = Inventory.getAllMotherBoards();
            getPowerSupply = Inventory.getAllPowerSupplies();
            getProcessor = Inventory.getAllProcessors();
            getRam = Inventory.getAllRam();


            buildersList=  employeesImpl.selectAllBuilders();

            builderCmboBx.setItems(buildersList);

            customersList = customerImpl.customerFullName();
            customerCmbList.setItems(customersList);




            System.out.println(caseName);

            caseName = getCase.get(0).getName();
            motherBoardName = getMotherBoard.get(0).getName();
            graphicsCardName = getgraphicsCard.get(0).getName();
            powerSupplyName = getPowerSupply.get(0).getName();
            processorName = getProcessor.get(0).getName();
            ramName = getRam.get(0).getName();

            casePrice = getCase.get(0).getPrice();
            motherboardPrice = getMotherBoard.get(0).getPrice();
            cardPrice = getgraphicsCard.get(0).getPrice();
            powerSupplyPrice = getPowerSupply.get(0).getPrice();
            processorPrice = getProcessor.get(0).getPrice();
            ramPrice = getRam.get(0).getPrice();



            //Add item names to text fields
            caseTxtFld.setText(caseName);
            mbTxtFld.setText(motherBoardName);
            graphicsCardTxtFld.setText(graphicsCardName);
            powerSupplyTxtFld.setText(powerSupplyName);
            processorTxtFld.setText(processorName);
            RamTxtFld.setText(ramName);

            caseDiscount = getCase.get(0).getDiscount();
            motherboardDiscount = getMotherBoard.get(0).getDiscount();
            graphicsCardDiscount = getgraphicsCard.get(0).getDiscount();
            powerSupplyDiscount = getPowerSupply.get(0).getDiscount();
            processorDiscount = getProcessor.get(0).getDiscount();
            ramDiscount = getRam.get(0).getDiscount();



            calcDiscount();
            calcPrice(casePrice,motherboardPrice,cardPrice,powerSupplyPrice,processorPrice,ramPrice);






            price = totalPrice.toString();
            totalPriceTxtFld.setText(price);








        }

        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @FXML
    void onActionCusList(ActionEvent event)
    {
        customerID = customerCmbList.getValue().getId();
        customerName = customerCmbList.getValue().getFullName();

       customerTxtFld.setText(customerName);

       selectedCustomer = customerName;



    }

    @FXML
    void onActionEmpList(ActionEvent event)

    {

       builderID = builderCmboBx.getValue().getEmployeeID();
        builderName = builderCmboBx.getValue().getFullName();


        employeeTxtFld.setText(builderName);
        selectedEmployee = builderName;


    }

    public void calcDiscount()

    {
        //Calculate price with discount
        casePrice = calcDiscount.pricewithDiscount(casePrice,caseDiscount);

        motherboardPrice = calcDiscount.pricewithDiscount(motherboardPrice,motherboardDiscount);
        cardPrice = calcDiscount.pricewithDiscount(cardPrice,graphicsCardDiscount);
        powerSupplyPrice = calcDiscount.pricewithDiscount(powerSupplyPrice,powerSupplyDiscount);
        processorPrice = calcDiscount.pricewithDiscount(processorPrice,processorDiscount);
        ramPrice = calcDiscount.pricewithDiscount(ramPrice,ramDiscount);
    }
    public Float calcPrice(Float casePrice, Float motherboardPrice, Float cardPrice, Float powerSupplyPrice,
                            Float processorPrice, Float ramPrice)
    {


       //Total price for all items
        totalPrice = casePrice+ motherboardPrice +cardPrice + powerSupplyPrice + processorPrice + ramPrice;
        System.out.println("In Calc " + totalPrice);


        return totalPrice;

    }


}
