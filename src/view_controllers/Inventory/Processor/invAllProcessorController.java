package view_controllers.Inventory.Processor;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Processor;
import util.Alerts.ProcessorAlertMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class invAllProcessorController implements Initializable
{
    ObservableList<Processor> processorList = FXCollections.observableArrayList();
    ObservableList<Processor> processorSearchList = FXCollections.observableArrayList();
    Parent scene;
    Stage stage;

    @FXML
    private TableView<Processor> processorTableView;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private TableColumn<?, ?> onHand;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private Button viewDetailsBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button searchTxtBtn;

    @FXML
    private TextField searchTxtFld;


    @FXML
    private Button deleteProcessorBtn;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSearchBtn(ActionEvent event)
    {

        if (!searchTxtFld.getText().trim().isEmpty())
        {
            processorSearchList.clear();
            for (Processor p : processorList)
            {
                if(p.getName().contains(searchTxtFld.getText().trim()))
                {
                    processorSearchList.add(p);
                }
            }
            processorTableView.setItems(processorSearchList);
            processorTableView.refresh();
        }
        if (searchTxtFld.getText().isEmpty())
        {
            processorTableView.setItems(processorList);
        }

    }

    @FXML
    void onActionViewDetailsBtn(ActionEvent event) throws IOException {
        Processor selectedProcessor = processorTableView.getSelectionModel().getSelectedItem();

        if (selectedProcessor == null)
        {
            System.out.println("No Record Selected");
            ProcessorAlertMessages.processorSelectionError(1);
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view_controllers/Inventory/Processor/invProcessor.fxml"));
        loader.load();

        invProcessorController details = loader.getController();
        details.sendRecord(processorTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try
        {
            processorList.addAll(processorImpl.selectAllProcessors());

            processorTableView.setItems(processorList);

            ID.setCellValueFactory(new PropertyValueFactory<>("id"));


            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            onHand.setCellValueFactory(new PropertyValueFactory<>("onHand"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    @FXML
    void onActionDeleteProcessor(ActionEvent event) throws Exception {
        int id = processorTableView.getSelectionModel().getSelectedItem().getId();

        Processor selectedProcessor = processorTableView.getSelectionModel().getSelectedItem();

        processorImpl.deleteProcesor(id,selectedProcessor);

        processorList = processorImpl.selectAllProcessors();

        processorTableView.setItems(processorList);
        processorTableView.refresh();


    }

}
