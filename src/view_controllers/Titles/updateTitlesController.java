package view_controllers.Titles;
import DAO.titlesImpl;
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


public class updateTitlesController implements Initializable
{
    Parent scene;
    Stage stage;

    @FXML
    private Label addRecordTitlelbl;

    @FXML
    private TextField titleTxtFld;

    @FXML
    private TextField salaryTxtFld;

    @FXML
    private Button updateBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TextField idTxtFld;

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Titles/allTitles.fxml"));
        stage.setTitle("All Titles");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionUpdateBtn(ActionEvent event) throws IOException
    {
        try
        {
            int id = Integer.parseInt(idTxtFld.getText());
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
            titlesImpl.updateTitle(title,salary,id);

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

    public void sendRecord (Titles record)
    {


        try
        {
            idTxtFld.setText(String.valueOf(record.getId()));
            titleTxtFld.setText(String.valueOf(record.getTitle()));
            salaryTxtFld.setText(String.valueOf(record.getSalary()));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idTxtFld.setPromptText("Auto-Incremented");
        idTxtFld.setDisable(true);

    }
}
