package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.InHouse;
import model.Outsourced;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class inHouseImpl
{
    private static int buildNumb;


    public static ObservableList<InHouse> InHouseList = FXCollections.observableArrayList();

    public static ObservableList<InHouse> selectAllInHouse() throws Exception

    {


        ObservableList<InHouse> allInHouse = FXCollections.observableArrayList();
        String sqlGetAllInHouse = "SELECT * FROM INHOUSEPB";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlGetAllInHouse);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("IH_PB_ID");
            int buildNumber = rs.getInt("IN_PB_BUILD_NUMBER");
            String name = rs.getString("IN_PB_NAME");
            String description = rs.getString("IN_PB_DESCRIPTION");
            String processor = rs.getString("IN_PB_PROC_NAME");
            String caseName = rs.getString("IN_PB_CT_NAME");
            String graphicsCardName =rs.getString("IN_PB_GC_NAME");
            String motherboardName = rs.getString("IN_PB_MB_NAME");
            String powerSupplyName = rs.getString("IN_PB_PS_NAME");
            int ramCapacity = rs.getInt("IN_PB_RAM_capacity");
            int onHand = rs.getInt("IN_PB_QOH");
            int minOnHand = rs.getInt("IN_PB_MIN");
            Float price = rs.getFloat("IN_PB_PRICE");
            Float discount = rs.getFloat("IN_PB_DISCOUNT");

            InHouse addInHouse = new InHouse(id, name,buildNumber, description,processor,caseName,graphicsCardName,
                    motherboardName,powerSupplyName,ramCapacity,onHand,minOnHand,price,discount);

            allInHouse.add(addInHouse);
            InHouseList.addAll(addInHouse);




        }

        DBConnection.closeConnection();
        return allInHouse;
    }

    public static void addInHousePB (int buildNumber,String name,String description, String processorName,
                                     String caseName,
                                String graphicsCardName, String motherboardName, String powerSupplyName,
                                String ramName, int onHand, int minOnHand, Float price, Float discount)
    {

        String PBNumb = null;

        String sql = "INSERT INTO INHOUSEPB (IN_PB_BUILD_NUMBER, IN_PB_NAME,IN_PB_DESCRIPTION," +
                "IN_PB_PROC_NAME,IN_PB_CT_NAME,IN_PB_GC_NAME, IN_PB_MB_NAME, IN_PB_PS_NAME, IN_PB_RAM_CAPACITY," +
                "IN_PB_QOH," +
                " " +
                "IN_PB_MIN, " +
                "IN_PB_PRICE, IN_PB_DISCOUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();


            ps.setInt(1,buildNumber);
            ps.setString(2,name);
            ps.setString(3, description);
            ps.setString(4,processorName);
            ps.setString(5,caseName);
            ps.setString(6,graphicsCardName);
            ps.setString(7,motherboardName);
            ps.setString(8,powerSupplyName);
            ps.setString(9,ramName);
            ps.setInt(10,onHand);
            ps.setInt(11,minOnHand);
            ps.setFloat(12,price);
            ps.setFloat(13,discount);

            ps.execute();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        return;


    }
    public static int getLastBuildNumber()
    {

        String sql ="SELECT IN_PB_BUILD_NUMBER FROM INHOUSEPB where IN_PB_BUILD_NUMBER=(SELECT MAX(IN_PB_BUILD_NUMBER) FROM INHOUSEPB);";
        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();
            ResultSet rs = ps.executeQuery();
            rs.next();
            buildNumb = rs.getInt(1);
            if(buildNumb <=0)
            {
                buildNumb =1;
                return buildNumb;
            }
            else
            {
                buildNumb++;

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return buildNumb;
    }

    public static void updateInHousePB (String name,String description, String processorName,
                                        String caseName,
                                        String graphicsCardName, String motherboardName, String powerSupplyName,
                                        String ramName, int onHand, int minOnHand, Float price, Float discount,
                                        int buildNumb)
    {

        String PBNumb = null;

        String sql = "UPDATE INHOUSEPB SET IN_PB_NAME=?,IN_PB_DESCRIPTION=?, IN_PB_PROC_NAME=?,IN_PB_CT_NAME=?," +
                "IN_PB_GC_NAME=?, IN_PB_MB_NAME=?, IN_PB_PS_NAME=?, IN_PB_RAM_CAPACITY=?,IN_PB_QOH=?,IN_PB_MIN=?, " +
                "IN_PB_PRICE=?, IN_PB_DISCOUNT=? WHERE IH_PB_ID=?";

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();


            ps.setString(1,name);
            ps.setString(2, description);
            ps.setString(3,processorName);
            ps.setString(4,caseName);
            ps.setString(5,graphicsCardName);
            ps.setString(6,motherboardName);
            ps.setString(7,powerSupplyName);
            ps.setString(8,ramName);
            ps.setInt(9,onHand);
            ps.setInt(10,minOnHand);
            ps.setFloat(11,price);
            ps.setFloat(12,discount);
            ps.setInt(13,buildNumb);

            ps.execute();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void deleteIHPB (int id, InHouse selectedPC) throws Exception
    {
        try
        {
            InHouseList.remove(selectedPC);
            String sql = "DELETE FROM INHOUSEPB WHERE IH_PB_ID =?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
