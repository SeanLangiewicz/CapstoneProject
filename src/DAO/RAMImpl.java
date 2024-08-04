package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Processor;
import model.Ram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RAMImpl
{
   public static ObservableList<Ram> ramList = FXCollections.observableArrayList();

    public static ObservableList<Ram> selectAllRam () throws SQLException,Exception

    {
        ramList.clear();

        ObservableList<Ram> allRam = FXCollections.observableArrayList();

        String sqlStatement = "Select * from RAM";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("R_ID");
            String name = rs.getString("R_NAME");
            String make = rs.getString("R_MAKE");
            String model = rs.getString("R_MODEL");
            int capacity = rs.getInt("R_CAPACITY");

            int speed = rs.getInt("R_SPEED");
            String description = rs.getString("R_DESCRIPTION");
            int onHand = rs.getInt("R_QOH");
            int minOnHand = rs.getInt("R_MIN");
            int price = rs.getInt("R_PRICE");
            int discount = rs.getInt("R_DISCOUNT");

            Ram addRam = new Ram(id,name,make,model,capacity,speed,description,onHand,minOnHand,price,discount);

            allRam.add(addRam);
            ramList.addAll(addRam);


        }

        DBConnection.closeConnection();
        return allRam;
    }

    public static void addRAM(String name, String make, String model, Integer capacity, Integer speed,
                              String description, Integer onHand, Integer minOnHand, Float price, Float discount)

    {
        String ramIDNumb = null;
        String sql = "INSERT INTO RAM (R_NAME, R_MAKE, R_MODEL, R_CAPACITY, R_SPEED, R_DESCRIPTION, R_QOH, R_MIN, " +
                "R_PRICE, R_DISCOUNT) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setInt(4,capacity);
            pst.setInt(5,speed);
            pst.setString(6,description);
            pst.setInt(7,onHand);
            pst.setInt(8,minOnHand);
            pst.setFloat(9,price);
            pst.setFloat(10,discount);

            pst.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void updateRAM(String name, String make, String model, Integer capacity, Integer speed,
                                 String description, Integer onHand, Integer minOnHand, Float price, Float discount,
                                 Integer id) throws SQLException
    {
        String ramIDNumb = null;
        String sql = "UPDATE RAM SET R_NAME=?, R_MAKE=?, R_MODEL=?, R_CAPACITY=?, R_SPEED=?, R_DESCRIPTION=?, " +
                "R_QOH=?, R_MIN=?,R_PRICE=?, R_DISCOUNT=? WHERE R_ID=?";
        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setInt(4,capacity);
            pst.setInt(5,speed);
            pst.setString(6,description);
            pst.setInt(7,onHand);
            pst.setInt(8,minOnHand);
            pst.setFloat(9,price);
            pst.setFloat(10,discount);
            pst.setInt(11,id);

            pst.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void deleteRAM(int id, Ram selectedRAM) throws Exception
    {
        String sql ="DELETE FROM RAM WHERE R_ID=?";
        ramList.remove(selectedRAM);
        PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.execute();
        return;
    }
}
