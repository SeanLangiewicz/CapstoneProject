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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Titles;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class allTitlesController implements Initializable
{
    Parent scene;
    Stage stage;

    ObservableList<Titles> titlesList = FXCollections.observableArrayList();


    @FXML
    private TableView<Titles> titlesTblView;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> t_Name;

    @FXML
    private TableColumn<?, ?> t_Salary;

    @FXML
    private Button addTitleBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button backBtn;

    @FXML
    void onActionAddTitle(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/Titles/addTitles.fxml"));
        stage.setTitle("All Employees");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view_controllers/ScreenSelection/ScreenSelection.fxml"));
        stage.setTitle("All Employees");
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDelete(ActionEvent event)
    {
        try
        {
            Titles selectedTitle = titlesTblView.getSelectionModel().getSelectedItem();
            int titleID = titlesTblView.getSelectionModel().getSelectedItem().getId();

            titlesImpl.deleteTitle(titleID,selectedTitle);
            titlesList.remove(selectedTitle);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionUpdate(ActionEvent event)
    {
        try
        {
            Titles selectedTitle = titlesTblView.getSelectionModel().getSelectedItem();

            if(selectedTitle == null)
            {
                System.out.println("Nothign selected");
                return;
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view_controllers/Titles/updateTitles.fxml"));
            loader.load();

            updateTitlesController details = loader.getController();
            details.sendRecord(titlesTblView.getSelectionModel().getSelectedItem());

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
            titlesList.addAll(titlesImpl.selectAllTitles());
            titlesTblView.setItems(titlesList);

            ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            t_Name.setCellValueFactory(new PropertyValueFactory<>("title"));
            t_Salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }

    }
}
