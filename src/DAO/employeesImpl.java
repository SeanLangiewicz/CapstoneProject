package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employees;
import model.Employees_Builders;

import java.sql.*;

public class employeesImpl {
    public static ObservableList<Employees> employeeList = FXCollections.observableArrayList();
    public static ObservableList<Employees_Builders> buildersList = FXCollections.observableArrayList();

    public static ObservableList<Employees> selectAllEmployees() throws SQLException, Exception
    {
        ObservableList<Employees> allEmployees = FXCollections.observableArrayList();

        Connection conn = DBConnection.getConnection();



            String sql = "SELECT * FROM EMPLOYEES";


            DBQuery.setPreparedStatement(conn, sql);

            PreparedStatement ps = DBQuery.getPrepareStatement();

            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                int employeeID = rs.getInt("EMP_NUM");
                String title = rs.getString("EMP_TITLE");
                String firstName = rs.getString("EMP_FNAME");
                String lastName = rs.getString("EMP_LNAME");
                String initial = rs.getString("EMP_INITIAL");
                String address = rs.getString("EMP_ADDRESS");
                int areaCode = rs.getInt("EMP_AREACODE");
                int phoneNumber = rs.getInt("EMP_PHONE");

                Employees addedEmployee = new Employees(employeeID, title, firstName, lastName, initial, address, areaCode,
                        phoneNumber);


                allEmployees.add(addedEmployee);
                employeeList.addAll(allEmployees);


            }

        DBConnection.closeConnection();
        return allEmployees;
    }



    public static void updateEmployeeRecord(String title, String firstName, String lastName, String initial, String address,
                                            int areaCode, int phoneNumber, int employeeNumber) throws SQLException
    {
        try
        {
            String sql = "UPDATE EMPLOYEES SET EMP_TITLE=?, EMP_FNAME=?, EMP_LNAME=?,EMP_INITIAL=?," +
                    "EMP_ADDRESS=?,EMP_AREACODE=?,EMP_PHONE=? WHERE EMP_NUM=?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            Connection conn = DBConnection.getConnection();

            DBQuery.setPreparedStatement(conn,sql);

            ps.setString(1,title);
            ps.setString(2,firstName);
            ps.setString(3,lastName);
            ps.setString(4,initial);
            ps.setString(5,address);
            ps.setInt(6,areaCode);
            ps.setInt(7,phoneNumber);
            ps.setInt(8,employeeNumber);


            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    public static void deleteEmployee (int employeeID, Employees selectedEmployee) throws SQLException
    {
        try
        {
            employeeList.remove(selectedEmployee);
            String sql ="DELETE FROM EMPLOYEES WHERE EMP_NUM=?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,employeeID);
            ps.execute();
            return;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void addEmployee(String title, String firstName, String lastName, String initial,
                                   String address, int areaCode, int phoneNumber)
    {
        String sql = "INSERT INTO EMPLOYEES (EMP_TITLE,EMP_FNAME,EMP_LNAME,EMP_INITIAL," +
                "EMP_ADDRESS," +
                "EMP_AREACODE,EMP_PHONE)Values(?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            Connection conn = DBConnection.getConnection();

            ps.setString(1,title);
            ps.setString(2,firstName);
            ps.setString(3,lastName);
            ps.setString(4,initial);
            ps.setString(5,address);
            ps.setInt(6,areaCode);
            ps.setInt(7,phoneNumber);


            ps.execute();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ObservableList<Employees_Builders> selectAllBuilders() throws SQLException {
        ObservableList<Employees_Builders> allBuilders = FXCollections.observableArrayList();


        try
        {
            String sql ="SELECT EMP_NUM,concat(EMP_FNAME,' ',EMP_LNAME) AS FULL_NAME FROM EMPLOYEES";
            Connection con = DBConnection.getConnection();

            DBQuery.setPreparedStatement(con,sql);
            PreparedStatement ps = DBQuery.getPrepareStatement();
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next())
            {
                int employeeID = rs.getInt("EMP_NUM");
                String employeeName = rs.getString("FULL_NAME");

                Employees_Builders addedBuilder = new Employees_Builders(employeeID,employeeName);

                allBuilders.add(addedBuilder);
                buildersList.addAll(allBuilders);


            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        DBConnection.closeConnection();
        return allBuilders;
    }

}
