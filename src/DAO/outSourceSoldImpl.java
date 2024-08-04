package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OutSourceSold;
import util.dateParse;

import java.sql.*;
import java.time.LocalDate;


public class outSourceSoldImpl
{
    public ObservableList<OutSourceSold> OS_Sold_List = FXCollections.observableArrayList();


    public ObservableList<OutSourceSold> selectAll_OS_Sold() throws SQLException {
        ObservableList<OutSourceSold> all_OS_Sold = FXCollections.observableArrayList();

        String sql = "SELECT * FROM OS_PB_SOLD";

        try
        {
            Connection con = DBConnection.getConnection();
            DBQuery.setPreparedStatement(con,sql);

            PreparedStatement ps = DBQuery.getPrepareStatement();
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next())
            {
                int soldID = rs.getInt("SOLD_ID");
                int computerID = rs.getInt("OS_COMPUTER_ID");
                int customerID = rs.getInt("OS_CUSTOMER_ID");
                Date soldDate = rs.getDate("OS_SOLD_DATE");
                Float price = rs.getFloat("OS_PRICE");

                OutSourceSold addedSold = new OutSourceSold(soldID,customerID,customerID,soldDate,price);
                all_OS_Sold.add(addedSold);
                OS_Sold_List.addAll(all_OS_Sold);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        DBConnection.closeConnection();
        return all_OS_Sold;
    }

    public static void addOS_Sold (int computerID,int customerID, Float price)
    {

        String sql = "INSERT INTO OS_PB_SOLD (OS_COMPUTER_ID,OS_CUSTOMER_ID,OS_SOLD_DATE,PRICE) \n" +
                "VALUES\n" +
                "((SELECT OS_ID FROM OUTSOURCEDPB WHERE OS_ID=? ),(SELECT CUS_NUM FROM CUSTOMERS WHERE CUS_NUM=?)," +
                "?,?)";
            LocalDate soldDate = dateParse.getTodaysDate();
        System.out.println("SQL Statment: " + sql);

        System.out.println(soldDate);

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            Connection con = DBConnection.getConnection();
            ps.setInt(1,computerID);
            ps.setInt(2,customerID);
            ps.setDate(3, Date.valueOf(soldDate));
            ps.setFloat(4,price);

            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
