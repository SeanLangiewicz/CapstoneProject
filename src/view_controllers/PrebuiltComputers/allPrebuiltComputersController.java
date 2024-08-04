package view_controllers.PrebuiltComputers;


import DAO.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Cases;
import model.Customer_FullName;
import model.InHouse;
import model.Outsourced;
import util.Alerts.InHouseAlertMessages;
import util.Alerts.ItemSelectionAlert;
import util.Alerts.OutsourcePrebuiltAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class allPrebuiltComputersController implements Initializable

{
    ObservableList<InHouse> allInHouseList = FXCollections.observableArrayList();
    ObservableList<Outsourced> allOutSourcedList = FXCollections.observableArrayList();
    ObservableList<Customer_FullName> customersList = FXCollections.observableArrayList();
    private static ObservableList<InHouse> inHouseInventorySearch = FXCollections.observableArrayList();
    private static ObservableList<Outsourced> outSourceInventorySearch = FXCollections.observableArrayList();

    String customerName = null;
    Float totalPrice = null;

    Parent scene;
    Stage stage;

    int customerID = 0;


    @FXML
    private Button viewOSDetails;

    @FXML
    private Button IHDetails;

    @FXML
    private Button inHouseSearch;

    @FXML
    private TextField inHouseSearchTxtFld;

    @FXML
    private TableView<InHouse> inHouseTblView;

    @FXML
    private TableColumn<?, ?> IH_ID;

    @FXML
    private TableColumn<?, ?> IH_NAME;

    @FXML
    private TableColumn<?, ?> IH_DESCRIPTION;

    @FXML
    private TableColumn<?, ?> IH_ON_HAND;

    @FXML
    private TableColumn<?, ?> IH_PRICE;

    @FXML
    private Button IH_Purchased_Btn;

    @FXML
    private Button outSourceSrchBtn;

    @FXML
    private TextField outsourceSearchTxtView;

    @FXML
    private TableView<Outsourced> outSourceTblView;

    @FXML
    private TableColumn<?, ?> OS_ID;

    @FXML
    private TableColumn<?, ?> OS_Name;

    @FXML
    private TableColumn<?, ?> OS_Description;

    @FXML
    private TableColumn<?, ?> OS_OnHand;

    @FXML
    private TableColumn<?, ?> OS_Price;

    @FXML
    private Button OS_Purchased_Btn;

    @FXML
    private Button backBtn;


    @FXML
    private ComboBox<Customer_FullName> customerCbBx;



    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/TypeSelection/TypeSelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionInHouseSearch(ActionEvent event)
    {
        inHouseInventorySearch.clear();
        if(!inHouseSearchTxtFld.getText().trim().isEmpty()) {

            for (InHouse ih : allInHouseList) {
                if (ih.getName().contains(inHouseSearchTxtFld.getText().trim())) {
                    inHouseInventorySearch.add(ih);
                }
            }
            inHouseTblView.setItems(inHouseInventorySearch);
            inHouseTblView.refresh();
        }
        if( inHouseSearchTxtFld.getText().isEmpty())
        {
            inHouseTblView.setItems(allInHouseList);
        }


    }

    @FXML
    void onActionOutsourceSearch(ActionEvent event)
    {
        outSourceInventorySearch.clear();
        if(!outsourceSearchTxtView.getText().trim().isEmpty()) {

            for (Outsourced os : allOutSourcedList) {
                if (os.getName().contains(outsourceSearchTxtView.getText().trim())) {
                    outSourceInventorySearch.add(os);
                }
            }
            outSourceTblView.setItems(outSourceInventorySearch);
            outSourceTblView.refresh();
        }

        if (outsourceSearchTxtView.getText().isEmpty())
        {
            outSourceTblView.setItems(allOutSourcedList);
        }
        {

        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            allInHouseList.clear();
            allOutSourcedList.clear();

            allInHouseList.addAll(inHouseImpl.selectAllInHouse());

            inHouseTblView.setItems(allInHouseList);
            System.out.println(allInHouseList);
            IH_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            IH_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
            IH_DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("description"));
            IH_ON_HAND.setCellValueFactory(new PropertyValueFactory<>("onHand"));
            IH_PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));


            allOutSourcedList.addAll(outSourcedImpl.selectAllOutsourced());
            outSourceTblView.setItems(allOutSourcedList);

            OS_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            OS_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
            OS_Description.setCellValueFactory(new PropertyValueFactory<>("description"));
            OS_OnHand.setCellValueFactory(new PropertyValueFactory<>("onHand"));
            OS_Price.setCellValueFactory(new PropertyValueFactory<>("price"));

            customersList = customerImpl.customerFullName();
            customerCbBx.setItems(customersList);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionSelectCustomer(ActionEvent event)
    {

        // No action from this class


    }


    @FXML
    void onAction_IH(ActionEvent event) throws IOException {
        InHouse selectedPC = inHouseTblView.getSelectionModel().getSelectedItem();

        if(selectedPC == null)
        {
            InHouseAlertMessages.inHouseSelectionError(1);
            return;

        }
        if (selectedPC != null)
        {     int computerID = inHouseTblView.getSelectionModel().getSelectedItem().getId();
            customerID =customerCbBx.getValue().getId();
            Float price = inHouseTblView.getSelectionModel().getSelectedItem().getPrice();
            customerName = inHouseTblView.getSelectionModel().getSelectedItem().getName();
            totalPrice = inHouseTblView.getSelectionModel().getSelectedItem().getPrice();

             inHouseSoldImpl.add_IH_Sold(computerID,customerID,price);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Computer for " + customerName + " for the total price of " + totalPrice + " has " +
                    "been Completed");
            alert.setTitle("Purchase Complete");
            alert.setHeaderText("Purchase Has been Completed");
            alert.showAndWait();

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/TypeSelection/TypeSelection.fxml"));
            stage.setTitle("Inventory");
            stage.setScene(new Scene(scene));
            stage.show();
        }


    }

    @FXML
    void onActionOutsourced(ActionEvent event) throws IOException {

        Outsourced selectedPC = outSourceTblView.getSelectionModel().getSelectedItem();

        if(selectedPC == null)
        {
            OutsourcePrebuiltAlertMessages.outsourcedSelectionError(1);
            return;
        }
        if (selectedPC != null)
        {
            int computerID = outSourceTblView.getSelectionModel().getSelectedItem().getId();
            customerID =customerCbBx.getValue().getId();
            Float price = outSourceTblView.getSelectionModel().getSelectedItem().getPrice();
            customerName = outSourceTblView.getSelectionModel().getSelectedItem().getName();
            totalPrice = outSourceTblView.getSelectionModel().getSelectedItem().getPrice();


            outSourceSoldImpl.addOS_Sold(computerID,customerID,price);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Computer for " + customerName + " for the total price of " + totalPrice + " has been " +
                "Completed.");
        alert.setTitle("Purchase Complete");
        alert.setHeaderText("Purchase Has been Completed");
        alert.showAndWait();

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/TypeSelection/TypeSelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void onActionOSDetailsBtn(ActionEvent event)
    {
        try
        {
            Outsourced selectedOutSourced = outSourceTblView.getSelectionModel().getSelectedItem();

            if (selectedOutSourced == null)
            {
                System.out.println("No record Selected");
                ItemSelectionAlert.SelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/PrebuiltComputers/PB_OutSourcedDetails.fxml"));
            loader.load();

            PB_OutSourcedDetailsController detailsController = loader.getController();
            detailsController.sendRecord(outSourceTblView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();


        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

    }

    @FXML
    void onActionIHDetailsBtn(ActionEvent event)
    {
        try
        {
            InHouse selectedInHouse = inHouseTblView.getSelectionModel().getSelectedItem();
            if(selectedInHouse == null)
            {
                System.out.println("No item selected");
                InHouseAlertMessages.inHouseSelectionError(1);
                return;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/PrebuiltComputers/PB_InHouseDetails.fxml"));
            loader.load();

            PB_InHouseDetailsController detailsController = loader.getController();
            detailsController.sendRecord(inHouseTblView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();


        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }


}
