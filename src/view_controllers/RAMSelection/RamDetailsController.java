package view_controllers.RAMSelection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import model.Inventory;
import model.Ram;

import java.io.IOException;

public class RamDetailsController
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
    private TextField capacityTxtFld;

    @FXML
    private TextField speedTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button orderBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Processor/ProcessorSelection.fxml"));
        stage.setTitle("Processors");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionOrderBtn(ActionEvent event) throws IOException
    {

        int id = Integer.parseInt(idTxtField.getText());
        String name = nameTxtField.getText();
        String make = makeTxtFld.getText();
        String model = modelTxtFld.getText();
        int capacity = Integer.parseInt(capacityTxtFld.getText());
        int speed = Integer.parseInt(speedTxtFld.getText());
        String description = descriptionTxtField.getText();
        int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        float price = Float.parseFloat(priceTxtFld.getText());
        float discount = Float.parseFloat(discountTxtFld.getText());

        Ram newRam = new Ram(id,name,make,model,capacity,speed,description,amountOnHand,minOnHand,price,discount);

        Inventory.addRam(newRam);


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/PowerSupplySelection/PowerSupplySelection" +
                ".fxml"));
        stage.setTitle("Power Supply");
        stage.setScene(new Scene(scene));
        stage.show();

    }


    public void sendRecord (Ram record)
    {
        int selectedID = record.getId();

        try
        {
            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            makeTxtFld.setText(String.valueOf(record.getMake()));
            modelTxtFld.setText(String.valueOf(record.getModel()));
            capacityTxtFld.setText(String.valueOf(record.getCapacity()));
            speedTxtFld.setText(String.valueOf(record.getSpeed()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
