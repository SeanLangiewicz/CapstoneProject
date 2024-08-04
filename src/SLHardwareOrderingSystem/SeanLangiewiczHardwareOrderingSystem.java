package SLHardwareOrderingSystem;
import DAO.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.dateParse;

import java.sql.SQLException;


public class SeanLangiewiczHardwareOrderingSystem extends Application
{
    public static Integer buildIDAutoGenNumb = 1000;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view_controllers/LoginScreen/LoginScreen.fxml"));
       Scene scene = new Scene(root);

       stage.setTitle("Login Screen");

       stage.setScene(scene);
       stage.show();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Connect to DB
        DBConnection.getConnection();

        


        launch(args);


        //Close DB Connection
        DBConnection.closeConnection();
    }

    public static Integer generateBuildNumber()
    {
        buildIDAutoGenNumb ++;

        return buildIDAutoGenNumb;
    }

}
