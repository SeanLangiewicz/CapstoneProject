package DAO;

import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Motherboards;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class motherboardImpl
{
    public static ObservableList<Motherboards> motherboardList = FXCollections.observableArrayList();

    public static ObservableList<Motherboards> selectAllMotherboards () throws SQLException,Exception
    {
        motherboardList.clear();

        ObservableList<Motherboards> allMotherboards = FXCollections.observableArrayList();

        String sqlStatement = "Select * from MOTHERBOARDS";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("MB_ID");
            String name = rs.getString("MB_NAME");
            String make = rs.getString("MB_MAKE");
            String model = rs.getString("MB_MODEL");
            String size = rs.getString("MB_SIZE");
            String description = rs.getString("MB_DESCRIPTION");
            int onHand = rs.getInt("MB_QOH");
            int minOnHand = rs.getInt("MB_MIN");
            Float price = rs.getFloat("MB_PRICE");
            Float discount = rs.getFloat("MB_DISCOUNT");

            Motherboards addMotherboards = new Motherboards(id,name,make,model,size,description,onHand,minOnHand,
                    price,discount);

            allMotherboards.add(addMotherboards);
            motherboardList.addAll(allMotherboards);
        }

        DBConnection.closeConnection();
        return allMotherboards;
    }

    public static void updateMotherBoard(String name, String make, String model, String size, String description,
                                         Integer onHand, Integer minOnHand, Float price, Float discount, Integer id)
    {

        String motherboardIDNumb = null;

        String sql = "UPDATE MOTHERBOARDS SET MB_NAME=?, MB_MAKE=?, MB_MODEL=?, MB_SIZE=?, MB_DESCRIPTION=?, " +
                "MB_QOH=?,MB_MIN=?, MB_PRICE=?,MB_DISCOUNT=? WHERE MB_ID=?";

        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,size);
            pst.setString(5,description);
            pst.setInt(6,onHand);
            pst.setInt(7,minOnHand);
            pst.setFloat(8,price);
            pst.setFloat(9,discount);
            pst.setInt(10,id);



            pst.execute();

            pst = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM MOTHERBOARDS");
            ResultSet rs = pst.executeQuery();

            rs.next();
            motherboardIDNumb = rs.getString(1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void addMotherBoard(String name, String make, String model, String size, String description,
    Integer onHand, Integer minOnHand, Float price, Float discount)
    {
        String motherBoardIDNumb = null;

        String sql = "INSERT INTO MOTHERBOARDS (MB_NAME,MB_MAKE,MB_MODEL,MB_SIZE,MB_DESCRIPTION,MB_QOH,MB_MIN," +
                "MB_PRICE,MB_DISCOUNT) VALUES (?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,size);
            pst.setString(5,description);
            pst.setInt(6,onHand);
            pst.setInt(7,minOnHand);
            pst.setFloat(8,price);
            pst.setFloat(9,discount);

            pst.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteMotherBoard(int id, Motherboards selectedMotherboard) throws SQLException
    {
        String sql = "DELETE FROM MOTHERBOARDS WHERE MB_ID=?";
        motherboardList.remove(selectedMotherboard);
        PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.execute();
        return;
    }
}
