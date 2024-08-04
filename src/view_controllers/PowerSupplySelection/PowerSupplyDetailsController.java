package view_controllers.PowerSupplySelection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Inventory;
import model.PowerSupply;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PowerSupplyDetailsController
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
    private TextField wattageTxtFld;

    @FXML
    private Label discountLbl;

    @FXML
    private TextField amntOnHandTxtFld;

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
    private TextField modularTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button orderBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/RAMSelection/RAMSelection.fxml"));
        stage.setTitle("RAM");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionOrderBtn(ActionEvent event) throws IOException
    {

        ObservableList<PowerSupply> powerSupplyCheckList = FXCollections.observableArrayList();

        int id = Integer.parseInt(idTxtField.getText());
        String name = nameTxtField.getText();
        String make = makeTxtFld.getText();
        String model = modelTxtFld.getText();
        String modular = modularTxtFld.getText();
        int wattage = Integer.parseInt(wattageTxtFld.getText());
        String description = descriptionTxtField.getText();
        int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        float price = Float.parseFloat(priceTxtFld.getText());
        float discount = Float.parseFloat(discountTxtFld.getText());

        PowerSupply newPowerSupply = new PowerSupply(id,name,make,model,modular,wattage,description,amountOnHand,
                minOnHand,price,discount);
        Inventory.addPowerSupply(newPowerSupply);


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/GraphicsCardSelection" +
                "/GraphicsCardSelection.fxml"));
        stage.setTitle("GPU");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void sendRecord (PowerSupply record)
    {
        idTxtField.setText(String.valueOf(record.getId()));
        nameTxtField.setText(String.valueOf(record.getName()));
        makeTxtFld.setText(String.valueOf(record.getMake()));
        modelTxtFld.setText(String.valueOf(record.getModel()));
        modularTxtFld.setText(String.valueOf(record.getModular()));
        wattageTxtFld.setText(String.valueOf(record.getWattage()));
        minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
        priceTxtFld.setText(String.valueOf(record.getPrice()));
        amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
        descriptionTxtField.setText(String.valueOf(record.getDescription()));
        discountTxtFld.setText(String.valueOf(record.getDiscount()));

    }
}
