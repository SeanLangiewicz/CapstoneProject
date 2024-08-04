package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import model.Customer_FullName;

import java.sql.*;

public class customerImpl
{

    public static ObservableList<Customer> customerList = FXCollections.observableArrayList();
    public static ObservableList<Customer_FullName> customerNamesList = FXCollections.observableArrayList();

    public static ObservableList<Customer> selectAllCustomers() throws SQLException, Exception
    {
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

        String sql = "SELECT * FROM CUSTOMERS";

        Connection conn = DBConnection.getConnection();

        DBQuery.setPreparedStatement(conn,sql);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("CUS_NUM");
            String firstName = rs.getString("CUS_FNAME");
            String lastName = rs.getString("CUS_LNAME");
            String initial = rs.getString("CUS_INITIAL");
            int areaCode = rs.getInt("CUS_AREACODE");
            int phoneNumber = rs.getInt("CUS_PHONE");
            Float balance = rs.getFloat("CUS_BALANCE");
            String address = rs.getString("CUS_ADDRESS");
            Time lastUpdated = rs.getTime("LAST_UPDATED");
            String last_Updated_by = rs.getString("LAST_UPDATED_BY");
            Date createdDate = rs.getDate("CUS_CREATE_DATE");
            String createdBy = rs.getString("CUS_CREATED_BY");

            Customer addedCustomer = new Customer(id,firstName,lastName,initial,areaCode,phoneNumber,balance,address,
                    lastUpdated,last_Updated_by,createdDate,createdBy);

            allCustomers.add(addedCustomer);
            customerList.addAll(allCustomers);

        }


        DBConnection.closeConnection();
        return allCustomers;
    }

    public static void updateCustomerRecord (String firstName, String lastName, String initial, int areaCode,
                                             int phoneNumber, Float balance, String address, String last_Updated_By, int id)
    {
        /*
        (firstName,lastName,initial,areaCode,phoneNumber,balance,address,
                lastUpdatedBy,createdBy,id)
         */
        try
        {
            String sql ="UPDATE CUSTOMERS SET CUS_FNAME=?,CUS_LNAME=?,CUS_INITIAL=?,CUS_AREACODE=?,CUS_PHONE=?," +
                    "CUS_BALANCE=?,CUS_ADDRESS=?,LAST_UPDATED=now(),LAST_UPDATED_BY=? WHERE CUS_NUM=?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            DBQuery.setPreparedStatement(conn,sql);

            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,initial);
            ps.setInt(4,areaCode);
            ps.setInt(5,phoneNumber);
            ps.setFloat(6,balance);
            ps.setString(7,address);
            ps.setString(8,last_Updated_By);
            ps.setInt(9,id);

            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void deleteCustomer (int customerID, Customer selectedCustomer)
    {
        try
        {
            customerList.remove(selectedCustomer);
            String sql = "DELETE FROM CUSTOMERS WHERE CUS_NUM=?";

            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setInt(1,customerID);
            pst.execute();
            return;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void addCustomer (String firstName, String lastName, String initial, int areaCode,
                                      int phoneNumber, Float balance, String address, String last_Updated_By, String createdBy)
    {
        String sql = "INSERT INTO CUSTOMERS (CUS_FNAME, CUS_LNAME,CUS_INITIAL,CUS_AREACODE, CUS_PHONE,CUS_BALANCE, " +
                "CUS_ADDRESS,LAST_UPDATED,LAST_UPDATED_BY,CUS_CREATE_DATE,CUS_CREATED_BY)" + "VALUES" +
                " (?,?,?,?,?,?," +
                "?,now(),?,now()" +
                ",?)";

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,initial);
            ps.setInt(4,areaCode);
            ps.setInt(5,phoneNumber);
            ps.setFloat(6,balance);
            ps.setString(7,address);
            ps.setString(8,last_Updated_By);
            ps.setString(9, createdBy);

           ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static ObservableList<Customer_FullName> customerFullName() throws SQLException
{

       ObservableList<Customer_FullName> allNames = FXCollections.observableArrayList();

    try
    {
        String sql = "SELECT CUS_NUM,concat(CUS_FNAME,' ', CUS_LNAME) AS FullName FROM CUSTOMERS;";
        Connection con = DBConnection.getConnection();

        DBQuery.setPreparedStatement(con,sql);
        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("CUS_NUM");
             String fullName = rs.getString("FullName");

            Customer_FullName addedName = new Customer_FullName(id,fullName);

            allNames.add(addedName);
            customerNamesList.addAll(allNames);

        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    DBConnection.closeConnection();
    System.out.println("Name: " + allNames);
    return allNames;
}
}
