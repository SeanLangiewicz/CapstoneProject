package view_controllers.ProcessorSelection;
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
import model.Inventory;
import model.Processor;

import java.io.IOException;

public class ProcessorDetailsController
{
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
    private TextField coresTxtFld;

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
    private TextField speedTxtFld;

    @FXML
    private TextField socketTxtFld;

    @FXML
    private Button backBtn;

    @FXML
    private Button orderBtn;

    Parent scene;
    Stage stage;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ProcessorSelection/ProcessorSelection.fxml"));
        stage.setTitle("Processors");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionOrderBtn(ActionEvent event) throws IOException
    {
        ObservableList<Processor> processorCheckList = FXCollections.observableArrayList();

        int id = Integer.parseInt(idTxtField.getText());
        String name = nameTxtField.getText();
        String description = descriptionTxtField.getText();
        String make = makeTxtFld.getText();
        String model = modelTxtFld.getText();
        int speed = Integer.parseInt(speedTxtFld.getText());
        String socket = socketTxtFld.getText();
        int cores = Integer.parseInt(coresTxtFld.getText());
        int amountOnHand = Integer.parseInt(amntOnHandTxtFld.getText());
        int minOnHand = Integer.parseInt(minOnHandTxtFld.getText());
        float price = Float.parseFloat(priceTxtFld.getText());
        float discount = Float.parseFloat(discountTxtFld.getText());

        Processor newProcessor = new Processor(id,name,description,make,model,speed,socket,cores,amountOnHand,
                minOnHand,price,discount);

        Inventory.addProcessor(newProcessor);


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/RAMSelection/RAMSelection.fxml"));
        stage.setTitle("RAM");
        stage.setScene(new Scene(scene));
        stage.show();

    }


    public void sendRecord ( Processor record)
    {
        try
        {
            idTxtField.setText(String.valueOf(record.getId()));
            nameTxtField.setText(String.valueOf(record.getName()));
            speedTxtFld.setText(String.valueOf(record.getSpeed()));
            makeTxtFld.setText(String.valueOf(record.getMake()));
            socketTxtFld.setText(String.valueOf(record.getSocket()));
            modelTxtFld.setText(String.valueOf(record.getModel()));
            amntOnHandTxtFld.setText(String.valueOf(record.getOnHand()));
            minOnHandTxtFld.setText(String.valueOf(record.getMinOnHand()));
            priceTxtFld.setText(String.valueOf(record.getPrice()));
            discountTxtFld.setText(String.valueOf(record.getDiscount()));
            descriptionTxtField.setText(String.valueOf(record.getDescription()));
            coresTxtFld.setText(String.valueOf(record.getCores()));

        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }


    }
}
