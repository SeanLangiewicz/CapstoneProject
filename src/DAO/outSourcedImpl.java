package DAO;

import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Outsourced;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class outSourcedImpl
{

    public static ObservableList<Outsourced> outsourcedList = FXCollections.observableArrayList();

    public static ObservableList<Outsourced> selectAllOutsourced() throws Exception
    {
        int count = 0;
        int outsourcedlistCount =0;


        ObservableList<Outsourced> allOutSourced = FXCollections.observableArrayList();
        String sql = "SELECT * FROM OUTSOURCEDPB";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sql);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();
        while (rs.next())
        {
            int id = rs.getInt("OS_ID");
            String vendor = rs.getString("OS_VENDOR_NAME");
            String name = rs.getString("OS_NAME");
            String description = rs.getString("OS_DESCRIPTION");
            String processorID = rs.getString("OS_PROCESSOR_NAME");
            String caseID = rs.getString("OS_CT_NAME");
            String graphicsCardID = rs.getString("OS_GC_NAME");
            String motherboardID = rs.getString("OS_MB_NAME");
            String powerSupplyID = rs.getString("OS_PS_NAME");
            int ramID = rs.getInt("OS_RAM_CAPACITY");
            int onHand = rs.getInt("OS_QOH");
            int minOnHand = rs.getInt("OS_MIN");
            Float price = rs.getFloat("OS_PRICE");
            Float discount = rs.getFloat("OS_DISCOUNT");

            Outsourced addedOutsource = new Outsourced(id, vendor, name, description, processorID, caseID,
                    graphicsCardID, motherboardID, powerSupplyID, ramID, onHand, minOnHand, price, discount);

            allOutSourced.add(addedOutsource);
            outsourcedList.addAll(allOutSourced);


        }



        DBConnection.closeConnection();
        return allOutSourced;


    }

    public static void deleteOutSourcedPC (int id, Outsourced selectedPC) throws Exception
    {
        try
        {
            outsourcedList.remove(selectedPC);
            String sql = "DELETE FROM OUTSOURCEDPB WHERE OS_ID =?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public static void updateOutSourcedPC ( String vendorName, String name, String description, String processorName,
                                            String caseName, String graphicsCardName, String motherBoardName,
                                            String powerSupplyName, int ramCapacity, int QOH, int minOnHand,
                                            Float price,
                                            Float discount, int id )
    {
        String OSIDNumb = null;

        String sql = "UPDATE OUTSOURCEDPB SET OS_VENDOR_NAME=?, OS_NAME=? ,OS_DESCRIPTION=?," +
                "OS_PROCESSOR_NAME=?,OS_CT_NAME=?,OS_GC_NAME=?, OS_MB_NAME=?, OS_PS_NAME=?, OS_RAM_CAPACITY=?," +
                "OS_QOH=?, OS_MIN=?, OS_PRICE=?, OS_DISCOUNT=? WHERE OS_ID=?";

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            ps.setString(1, vendorName);
            ps.setString(2, name);
            ps.setString(3,description);
            ps.setString(4, processorName);
            ps.setString(5, caseName);
            ps.setString(6, graphicsCardName);
            ps.setString(7, motherBoardName);
            ps.setString(8, powerSupplyName);
            ps.setInt(9, ramCapacity);
            ps.setInt(10, QOH);
            ps.setInt(11, minOnHand);
            ps.setFloat(12, price);
            ps.setFloat(13, discount);
            ps.setInt(14,id);
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void addOutSourcedPC (String vendorName, String name, String description, String processorName,
                                        String caseName, String graphicsCardName, String motherBoardName,
                                        String powerSupplyName, int ramCapacity, int QOH, int minOnHand,
                                        Float price,
                                        Float discount) {

        {

            String PBNumb = null;

            String sql = "INSERT INTO OUTSOURCEDPB (OS_VENDOR_NAME, OS_NAME,OS_DESCRIPTION," +
                    "OS_PROCESSOR_NAME,OS_CT_NAME,OS_GC_NAME, OS_MB_NAME, OS_PS_NAME, OS_RAM_CAPACITY,OS_QOH, OS_MIN," +
                    " " +
                    "OS_PRICE, OS_DISCOUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
                Connection conn = DBConnection.getConnection();


                ps.setString(1, vendorName);
                ps.setString(2, name);
                ps.setString(3,description);
                ps.setString(4, processorName);
                ps.setString(5, caseName);
                ps.setString(6, graphicsCardName);
                ps.setString(7, motherBoardName);
                ps.setString(8, powerSupplyName);
                ps.setInt(9, ramCapacity);
                ps.setInt(10, QOH);
                ps.setInt(11, minOnHand);
                ps.setFloat(12, price);
                ps.setFloat(13, discount);
                ps.execute();




            } catch (Exception e) {
                e.printStackTrace();
            }


            return;


        }
    }


}
