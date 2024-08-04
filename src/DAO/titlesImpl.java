package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Titles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class titlesImpl
{
    public static ObservableList<Titles> titlesList = FXCollections.observableArrayList();

    public static ObservableList<Titles> selectAllTitles() throws SQLException, Exception
    {
        ObservableList<Titles> allTitles = FXCollections.observableArrayList();

        String sql = "SELECT * FROM TITLES";

        Connection conn = DBConnection.getConnection();

        DBQuery.setPreparedStatement(conn,sql);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("titleID");
            String title = rs.getString("titleName");
            int salary = rs.getInt("titleSalary");

            Titles addTitle = new Titles(id,title,salary);

           allTitles.add(addTitle);
           titlesList.addAll(allTitles);

        }


        DBConnection.closeConnection();
        return allTitles;

    }

    public static void updateTitle (String titleName, int titleSalary, int titleID)
    {
        try
        {
            String sql = "UPDATE TITLES SET titleName=?, titleSalary=? WHERE titleID=?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            DBQuery.setPreparedStatement(conn,sql);

            ps.setString(1,titleName);
            ps.setInt(2,titleSalary);
            ps.setInt(3,titleID);

            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteTitle (int titleID, Titles selectedTile) throws SQLException
    {
        try
        {
            titlesList.remove(selectedTile);
            String sql ="DELETE FROM TITLES WHERE titleID=?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,titleID);
            ps.execute();
            return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void addTitle (String title, int salary)
    {
        String sql = "INSERT INTO TITLES (titleName, titleSalary) VALUES (?,?)";
        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            Connection conn = DBConnection.getConnection();

            ps.setString(1,title);
            ps.setInt(2,salary);

            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
