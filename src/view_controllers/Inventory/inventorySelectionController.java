package view_controllers.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class inventorySelectionController
{
    Parent scene;
    Stage stage;
    @FXML
    private Button casesBtn;

    @FXML
    private Button graphicsCardsBtn;

    @FXML
    private Button IHPrebuiltsBtn;

    @FXML
    private Button outsourcedPBBtn;

    @FXML
    private Button motherboardsBtn;

    @FXML
    private Button powerSuppliesBtn;

    @FXML
    private Button processorsBtn;

    @FXML
    private Button ramBtn;

    @FXML
    private Button addCaseBtn;

    @FXML
    private Button addGraphicsCardBtn;

    @FXML
    private Button addInHouseBtn;

    @FXML
    private Button addOutSourceBtn;

    @FXML
    private Button addMotherBoardBtn;

    @FXML
    private Button addPowerSupply;

    @FXML
    private Button addProcessor;

    @FXML
    private Button addRAM;

    @FXML
    private Button backBtn;


    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection" +
                ".fxml"));
        stage.setTitle("Screen Selection");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewAllGraphicsCards(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene =
                FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/GraphicsCard/invAllGraphics" +
                        ".fxml"));
        stage.setTitle("View All Graphics Cards");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewAllMotherboardsBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene =
                FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/Motherboard/invAllMotherBoard" +
                        ".fxml"));
        stage.setTitle("View All Power Supplies");
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void onActionViewAllOSPB(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/OutsourcedPreBuilt" +
                "/invAllOutsourcePB.fxml"));
        stage.setTitle("View All Outsourced Computers");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewAllPowerSupplies(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/PowerSupply/invAllPowerSupply.fxml"));
        stage.setTitle("View All Power Supplies");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewAllProcessors(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/Processor/invAllProcessor.fxml"));
        stage.setTitle("View All Processors");
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionViewAllRAM(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/RAM/invAllRAM.fxml"));
        stage.setTitle("View All RAM");
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void onActionViewAlllInHousePB(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/InHousePreBuilt/invAllIHPB.fxml"));
        stage.setTitle("View All In-House Prebuilt Computers");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionviewAllCases(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/ComputerCase/invAllCases.fxml"));
        stage.setTitle("View all Cases");
        stage.setScene(new Scene(scene));
        stage.show();

    }
    @FXML
    void onActionAddCase(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/ComputerCase/invAddCase.fxml"));
        stage.setTitle("Add Case");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddGraphicsCard(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/GraphicsCard/invAddGraphicsCard" +
                ".fxml"));
        stage.setTitle("Add a Graphics Card");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddInHouseBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/InHousePreBuilt" +
                "/invAddIHPreBuilt" +
                ".fxml"));
        stage.setTitle("Add an InHouse Computer");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddMotherBoard(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/MotherBoard" +
                "/invAddMotherBoard.fxml"));
        stage.setTitle("Add a Motherboard Card");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddOutsource(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/OutSourcedPreBuilt" +
                "/invAddOutSourcePreBuilt.fxml"));
        stage.setTitle("Add an Outsourced Computer");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddPowerSupply(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/PowerSupply" +
                "/invAddPowerSupply.fxml"));
        stage.setTitle("Add a Power Supply");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddProcessor(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/Processor/invAddProcessor" +
                ".fxml"));
        stage.setTitle("Add a Processor Card");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddRAM(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Inventory/RAM/invAddRAM" +
                ".fxml"));
        stage.setTitle("Add RAM");
        stage.setScene(new Scene(scene));
        stage.show();

    }


}
