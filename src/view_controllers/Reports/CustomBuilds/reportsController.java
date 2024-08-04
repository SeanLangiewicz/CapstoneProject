package view_controllers.Reports.CustomBuilds;

import DAO.BuiltComputersImpl;
import DAO.employeesImpl;
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
import model.Built_by_Builder;
import model.Employees_Builders;
import util.Alerts.ReportsAlertMessages;
import util.dateParse;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class reportsController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<Built_by_Builder> builtByBuilderList = FXCollections.observableArrayList();
    ObservableList<String>reportIntervals = FXCollections.observableArrayList("7 Days","Past Month","Past Year");
    ObservableList<Employees_Builders> buildersList = FXCollections.observableArrayList();

    boolean employeeSelected = false;
    boolean timePeriodSelected = false;

    String timePeriodSelection = null;
    int builderID=0;
    Float totalSales = null;
    String sales = null;

    @FXML
    private Label dateTimeDisplayLbl;

    @FXML
    private Label dateTimeLbl;

    @FXML
    private TableView<Built_by_Builder> reportsTbl;

    @FXML
    private TableColumn<?, ?> caseTC;

    @FXML
    private TableColumn<?, ?> graphicsTC;

    @FXML
    private TableColumn<?, ?> motherboardTC;

    @FXML
    private TableColumn<?, ?> powerSupplyTC;

    @FXML
    private TableColumn<?, ?> processorTC;

    @FXML
    private TableColumn<?, ?> ramTC;

    @FXML
    private TableColumn<?, ?> priceTC;

    @FXML
    private Button reportBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label salesLbl;

    @FXML
    private TableColumn<?, ?> dateTC;


    @FXML
    private ComboBox<String> timePeriodCboBx;

    @FXML
    private ComboBox<Employees_Builders> selectEmployCbBx;

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection.fxml"));
        stage.setTitle("Screen Selection");
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @FXML
    void onActionGetReport(ActionEvent event) throws SQLException
    {


        try
        {

            if(employeeSelected == false)
            {
                ReportsAlertMessages.reportAlerts(1);
                return;
            }
            if (timePeriodSelected == false)
            {
                ReportsAlertMessages.reportAlerts(2);
                return;
            }

            if((employeeSelected == false) && (timePeriodSelected == false))
            {
                ReportsAlertMessages.reportAlerts(3);
                return;
            }

            switch (timePeriodSelection)
            {
                case ("7 Days"):

                    builtByBuilderList.clear();
                    builtByBuilderList = BuiltComputersImpl.salesLast7Days(builderID);


                    reportsTbl.setItems(builtByBuilderList);

                    caseTC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
                    graphicsTC.setCellValueFactory(new PropertyValueFactory<>("graphicCardName"));
                    motherboardTC.setCellValueFactory(new PropertyValueFactory<>("motherboardName"));
                    powerSupplyTC.setCellValueFactory(new PropertyValueFactory<>("powerSupply"));
                    processorTC.setCellValueFactory(new PropertyValueFactory<>("processorName"));
                    ramTC.setCellValueFactory(new PropertyValueFactory<>("ramName"));
                    priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
                    dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));


                    salesLbl.setText("Total Sales by " + selectEmployCbBx.getValue());



                    break;
                case ("Past Month"):

                    builtByBuilderList.clear();
                    builtByBuilderList = BuiltComputersImpl.salesByLastMonth(builderID);


                    reportsTbl.setItems(builtByBuilderList);

                    caseTC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
                    graphicsTC.setCellValueFactory(new PropertyValueFactory<>("graphicCardName"));
                    motherboardTC.setCellValueFactory(new PropertyValueFactory<>("motherboardName"));
                    powerSupplyTC.setCellValueFactory(new PropertyValueFactory<>("powerSupply"));
                    processorTC.setCellValueFactory(new PropertyValueFactory<>("processorName"));
                    ramTC.setCellValueFactory(new PropertyValueFactory<>("ramName"));
                    priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
                    dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

                    salesLbl.setText("Total Sales by " + selectEmployCbBx.getValue());

                    break;
                case ("Past Year"):
                    builtByBuilderList.clear();





                    builtByBuilderList = BuiltComputersImpl.salesLastYear(builderID);



                    reportsTbl.setItems(builtByBuilderList);

                    caseTC.setCellValueFactory(new PropertyValueFactory<>("caseName"));
                    graphicsTC.setCellValueFactory(new PropertyValueFactory<>("graphicCardName"));
                    motherboardTC.setCellValueFactory(new PropertyValueFactory<>("motherboardName"));
                    powerSupplyTC.setCellValueFactory(new PropertyValueFactory<>("powerSupply"));
                    processorTC.setCellValueFactory(new PropertyValueFactory<>("processorName"));
                    ramTC.setCellValueFactory(new PropertyValueFactory<>("ramName"));
                    priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
                    dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));


                    salesLbl.setText("Total Sales by " + selectEmployCbBx.getValue());


                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ReportsAlertMessages.reportAlerts(3);
            return;
        }


    }

    @FXML
    void onActionSelectionEmployee(ActionEvent event)
    {

        builderID = selectEmployCbBx.getValue().getEmployeeID();
        System.out.println(builderID);
        employeeSelected = true;

    }

    @FXML
    void onActionSelectTimePeriod(ActionEvent event)
    {

        timePeriodSelection = timePeriodCboBx.getValue();
        timePeriodSelected = true;



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try
        {

            String title = "Report Generated on ";
            dateTimeDisplayLbl.setText(title);
            LocalDateTime ldt = LocalDateTime.now();

            Timestamp ts = Timestamp.valueOf(ldt);

            String dateFormat = dateParse.dateFormat(ts);



            System.out.println("****");
            System.out.println(dateFormat);
            System.out.println("****");
            dateTimeLbl.setText(dateFormat);

            buildersList = employeesImpl.selectAllBuilders();
            selectEmployCbBx.setItems(buildersList);

            timePeriodCboBx.setItems(reportIntervals);

            caseTC.setCellValueFactory(new PropertyValueFactory<>("caseName"));





        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
