package view_controllers.Titles;
import DAO.titlesImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Titles;
import util.Alerts.TitlesAlerts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addTitlesController implements Initializable
{
    Parent scene;
    Stage stage;
    ObservableList<Titles> titlesList = FXCollections.observableArrayList();

    @FXML
    private Label addRecordTitlelbl;

    @FXML
    private TextField titleTxtFld;

    @FXML
    private TextField salaryTxtFld;

    @FXML
    private Button addBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TextField idTxtFld;

    @FXML
    void onActionAddTitle(ActionEvent event) throws IOException {

        try
        {
            String title = titleTxtFld.getText();
            int salary = Integer.parseInt(salaryTxtFld.getText());

            if(title == null)
            {
                TitlesAlerts.salaryAlerts(1,titleTxtFld);
                return;
            }
            if(salary <=0)
            {
                TitlesAlerts.salaryAlerts(2,salaryTxtFld);
                return;
            }

            titlesImpl.addTitle(title,salary);

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view_controllers/Titles/allTitles.fxml"));
            stage.setTitle("All Titles");
            stage.setScene(new Scene(scene));
            stage.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            TitlesAlerts.titleAllFields(1,titleTxtFld,salaryTxtFld);
            return;
        }


    }

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Titles/allTitles.fxml"));
        stage.setTitle("All Titles");
        stage.setScene(new Scene(scene));
        stage.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtFld.setPromptText("Auto-Incremented");
        idTxtFld.setDisable(true);

    }
}
