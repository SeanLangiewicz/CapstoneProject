package view_controllers.Inventory.GraphicsCard;
import DAO.graphicCardImpl;
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
import model.GraphicCards;
import model.Inventory;
import model.Motherboards;
import util.Alerts.GraphicsCardAlertMessages;
import view_controllers.GraphicsCardSelection.GraphicsCardDetailsController;
import view_controllers.MotherBoardSelection.MotherBoardDetailsController;

import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class invAllGraphicsCardController implements Initializable
{
    ObservableList<GraphicCards> graphicsCardList = FXCollections.observableArrayList();
    ObservableList<GraphicCards> graphicsCardInventorySearchList = FXCollections.observableArrayList();

    Parent scene;
    Stage stage;

    @FXML
    private TableView<GraphicCards> graphicsCardTblView;

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
    private Button deleteGCBtn;


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
            System.out.println("search not empty");

            graphicsCardInventorySearchList.clear();
            for (GraphicCards gc : graphicsCardList)
            {

               if(gc.getName().contains(searchTxtFld.getText().trim()))
               {
                    graphicsCardInventorySearchList.add(gc);
               }

                }
            graphicsCardTblView.setItems(graphicsCardInventorySearchList);
            graphicsCardTblView.refresh();
            }
        if(searchTxtFld.getText().isEmpty())
        {
            graphicsCardTblView.setItems(graphicsCardList);
        }

    }


    @FXML
    void onActionViewDetailsBtn(ActionEvent event)
    {

        try
        {
            GraphicCards selectedCard = graphicsCardTblView.getSelectionModel().getSelectedItem();

            if(selectedCard == null)
            {
                System.out.println("No Record Selected");
                GraphicsCardAlertMessages.graphicsCardSelectionError(1);
                return;
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Inventory/GraphicsCard/invGraphicsCard" +
                    ".fxml"));
            loader.load();

            InvGraphicsCardController detailsController = loader.getController();
            detailsController.sendRecord(graphicsCardTblView.getSelectionModel().getSelectedItem());

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            searchTxtFld.setPromptText("Search by name");

            graphicsCardList.addAll(graphicCardImpl.selectAllCards());

            graphicsCardTblView.setItems(graphicsCardList);

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
    void onActionDeleteGC(ActionEvent event) throws Exception {
        int id = graphicsCardTblView.getSelectionModel().getSelectedItem().getId();
        GraphicCards selectedGraphicsCard = graphicsCardTblView.getSelectionModel().getSelectedItem();


        graphicCardImpl.deleteGraphicsCardByID(id,selectedGraphicsCard);

        graphicsCardList = graphicCardImpl.selectAllCards();
        graphicsCardTblView.setItems(graphicsCardList);
        graphicsCardTblView.refresh();


    }
}
