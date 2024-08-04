package view_controllers.ComputerCaseType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cases;
import model.Inventory;
import util.calcDiscount;

import java.io.IOException;

public class ComputerCaseDetailsController
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
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label descriptionLbl;

    @FXML
    private Label typeLbl;

    @FXML
    private Label makeLbl;

    @FXML
    private Label modelLbl;

    @FXML
    private TextField idTxtField;

    @FXML
    private TextField nameTxtField;

    @FXML
    private TextField descriptionTxtField;

    @FXML
    private TextField typeTxtFld;

    @FXML
    private TextField makeTxtFld;

    @FXML
    private TextField modelTxtFld;

    @FXML
    private TextField descriptionTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button orderBtn;

    public static ObservableList<Cases> caseList = FXCollections.observableArrayList();
    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException
    {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ComputerCaseType/ComputerCase.fxml"));
        stage.setTitle("Computer Cases");
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionOrderBtn(ActionEvent event) throws IOException
    {
        ObservableList<Cases> caseCheckList = FXCollections.observableArrayList();

        int id = Integer.parseInt(idTxtField.getText());
        String c_name = nameTxtField.getText();
        String description = descriptionTxtField.getText();
        String type = typeTxtFld.getText();
        String make = makeTxtFld.getText();
        String model = modelTxtFld.getText();
        int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        float price = Float.parseFloat(priceTxtFld.getText());
        float discount = Float.parseFloat(discountTxtFld.getText());



        Cases newCase = new Cases(id,c_name,type,make,model,description,amountOnHand,minOnHand,price,discount);
        Inventory.addCase(newCase);


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/MotherBoardSelection/MotherBoardSelection" +
                ".fxml"));
        stage.setTitle("Motherboards");
        stage.setScene(new Scene(scene));
        stage.show();




    }

    public void sendRecord (Cases record)
    {
        int selectedID = record.getId();
        String name = record.getName();

        try
        {
            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            typeTxtFld.setText(String.valueOf(record.getType()));
            makeTxtFld.setText(String.valueOf(record.getMake()));
            modelTxtFld.setText(String.valueOf(record.getModel()));
            amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));


        }

        catch (Exception e)
        {

            System.out.println(e.toString());
        }
    }



}
