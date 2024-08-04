package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.InHouseSold;
import model.OutSourceSold;
import util.dateParse;

import java.sql.*;
import java.time.LocalDate;

public class inHouseSoldImpl
{
    public ObservableList<InHouseSold> IH_SOLD_LIST = FXCollections.observableArrayList();


    public ObservableList<InHouseSold> selectAll_IH_Sold() throws SQLException {
        ObservableList<InHouseSold> all_OS_Sold = FXCollections.observableArrayList();

        String sql = "SELECT * FROM IH_PB_SOLD";

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
                int computerID = rs.getInt("IH_COMPUTER_ID");
                int customerID = rs.getInt("IH_CUSTOMER_ID");
                Date soldDate = rs.getDate("IH_SOLD_DATE");


                InHouseSold addedSold = new InHouseSold(soldID,computerID,customerID,soldDate);
                all_OS_Sold.add(addedSold);
                IH_SOLD_LIST.addAll(all_OS_Sold);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        DBConnection.closeConnection();
        return all_OS_Sold;
    }

    public static void add_IH_Sold (int computerID,int customerID, Float price)
    {

        String sql = "INSERT INTO IH_PB_SOLD (IH_COMPUTER_ID,IH_CUSTOMER_ID,IH_SOLD_DATE,PRICE) \n" +
                "VALUES\n" +
                "((SELECT IH_PB_ID FROM INHOUSEPB WHERE IH_PB_ID=? ),(SELECT CUS_NUM FROM CUSTOMERS WHERE CUS_NUM=?)" +
                "," +
                "?,?)";
        LocalDate soldDate = dateParse.getTodaysDate();
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
