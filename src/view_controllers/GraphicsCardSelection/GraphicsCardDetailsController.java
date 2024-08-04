package view_controllers.GraphicsCardSelection;

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
import model.GraphicCards;
import model.Inventory;

import java.io.IOException;

public class GraphicsCardDetailsController
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
    private Button orderBtn;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/GraphicsCardSelection/GraphicsCardSelection" +
                ".fxml"));
        stage.setTitle("Graphic Cards");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionOrderBtn(ActionEvent event) throws IOException
    {
        ObservableList<GraphicCards> graphicsCardCheckList = FXCollections.observableArrayList();


        int id = Integer.parseInt(idTxtField.getText());
        String name = nameTxtField.getText();
        String make = makeTxtFld.getText();
        String model = modelTxtFld.getText();
        String resolution = maxResTxtFld.getText();
        String connectors = connectorsTxtFld.getText();
        String description = descriptionTxtField.getText();
        int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        float price = Float.parseFloat(priceTxtFld.getText());
        float discount = Float.parseFloat(discountTxtFld.getText());

        GraphicCards newGraphicsCard = new GraphicCards(id,name,make,model,resolution,connectors,description,
                amountOnHand,minOnHand,price,discount);
        Inventory.addGraphicsCard(newGraphicsCard);

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ShippingScreen/Shipping.fxml"));
        stage.setTitle("Finalize Order");
        stage.setScene(new Scene(scene));
        stage.show();


    }


    public void sendRecord (GraphicCards record)
    {
        int selectedID = record.getId();

        try
        {

            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            makeTxtFld.setText(String.valueOf(record.getMake()));
            modelTxtFld.setText(String.valueOf(record.getModel()));
            maxResTxtFld.setText(String.valueOf(record.getResolution()));
            connectorsTxtFld.setText(String.valueOf(record.getConnectors()));
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
