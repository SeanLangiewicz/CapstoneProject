package view_controllers.GraphicsCardSelection;

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
import util.Alerts.ItemSelectionAlert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GraphicsCardSelectionController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<GraphicCards> graphicsCardList = FXCollections.observableArrayList();
    ObservableList<GraphicCards> graphicsCardInventorySearch = FXCollections.observableArrayList();

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
    private TextField searchTxtFld;

    @FXML
    private Button searchTxtBtn;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/inventorySelection.fxml"));
        stage.setTitle("Inventory");
        stage.setScene(new Scene(scene));
        stage.show();

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
                ItemSelectionAlert.SelectionError(1);
                return;
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/GraphicsCardSelection/GraphicsCardDetails" +
                    ".fxml"));
            loader.load();

            GraphicsCardDetailsController detailsController = loader.getController();
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
    void onActionSearchBtn(ActionEvent event) {
        if (!searchTxtFld.getText().trim().isEmpty()) {
            graphicsCardInventorySearch.clear();
            for (GraphicCards g : graphicsCardList) {
                if (g.getName().contains(searchTxtFld.getText().trim())) {
                    graphicsCardInventorySearch.add(g);
                }
            }
            graphicsCardTblView.setItems(graphicsCardInventorySearch);
            graphicsCardTblView.refresh();
        }
    }
}
