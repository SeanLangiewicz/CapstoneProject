package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.BuiltComputers;
import model.Built_by_Builder;
import util.Alerts.CustomerAlertMessages;
import util.dateParse;

import java.rmi.registry.LocateRegistry;
import java.sql.*;
import java.time.LocalDate;

public class BuiltComputersImpl
{

    public static ObservableList<Built_by_Builder> sevenDayList = FXCollections.observableArrayList();
    public static ObservableList<Built_by_Builder> builtByBuildersList = FXCollections.observableArrayList();
    public static ObservableList<Built_by_Builder> monthList = FXCollections.observableArrayList();
    public static ObservableList<Built_by_Builder> yearList = FXCollections.observableArrayList();
    public static ObservableList<BuiltComputers> builtComputersList = FXCollections.observableArrayList();

    public static ObservableList<BuiltComputers> selectAllBuiltComputers () throws SQLException, Exception
    {
        ObservableList<BuiltComputers> allBuiltComputers = FXCollections.observableArrayList();

        String sql = "SELECT * FROM BUILTCOMPUTERS";

        Connection con = DBConnection.getConnection();
        DBQuery.setPreparedStatement(con,sql);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int buildNumber = rs.getInt("BuildNumber");
            String caseName = rs.getString("caseName");
            String graphicsCardName = rs.getString("caseName");
            String motherboardName = rs.getString("motherboardName");
            String powerSupplyName = rs.getString("powerSupplyName");
            String processorName = rs.getString("processrName");
            String ramName = rs.getString("ramName");
            Float totalPrice = rs.getFloat("price");
            int builderID = rs.getInt("builderID");
            int customerID = rs.getInt("customerID");

            BuiltComputers addedComputer = new BuiltComputers(buildNumber,caseName,graphicsCardName,motherboardName,
                    powerSupplyName,processorName,ramName,totalPrice,builderID,customerID);

            allBuiltComputers.add(addedComputer);
            builtComputersList.addAll(allBuiltComputers);


        }

        DBConnection.closeConnection();
        return allBuiltComputers;
    }

    public static void addBuiltComputer(String caseName, String graphicsCardName, String motherboardName,
                                        String powerSupplyName,String processorName, String ramName, Float totalPrice
                                         , int builderID, int customerID)

    {

        String sql ="INSERT INTO BUILTCOMPUTERS (caseName, graphicsCardName, motherboardName, powerSupplyName, " +
                "processorName, ramName, price, builderID, customerID,soldDate)\n" +
                "VALUES (?,?,?,?,?,?,?,(SELECT EMP_NUM FROM EMPLOYEES WHERE EMP_NUM=?),(SELECT CUS_NUM FROM CUSTOMERS" +
                " WHERE CUS_NUM=?),?)";

        LocalDate date = dateParse.getTodaysDate();

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection con = DBConnection.getConnection();

            DBQuery.setPreparedStatement(con,sql);

            ps.setString(1,caseName);
            ps.setString(2,graphicsCardName);
            ps.setString(3,motherboardName);
            ps.setString(4,powerSupplyName);
            ps.setString(5,processorName);
            ps.setString(6,ramName);
            ps.setFloat(7,totalPrice);
            ps.setInt(8,builderID);
            ps.setInt(9,customerID);
            ps.setDate(10, Date.valueOf(date));

            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }
    public static Float sales()
    {
        Float totalSales = null;


        String sql = "SELECT sum(price) FROM BUILTCOMPUTERS";
        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection con = DBConnection.getConnection();

            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            totalSales = rs.getFloat(1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            CustomerAlertMessages.reportError(1);
        }


        return totalSales;
    }


    public static ObservableList<Built_by_Builder> salesLast7Days(int builderID) throws SQLException {
        ObservableList<Built_by_Builder> sevenDayBuiltList = FXCollections.observableArrayList();
        String sql = "SELECT * ,sum(price) as totalSum FROM BUILTCOMPUTERS WHERE soldDate > now() - INTERVAL 7 day " +
                "and builderID =?";

        Connection con = DBConnection.getConnection();

        try
        {
            DBQuery.setPreparedStatement(con,sql);
            PreparedStatement ps = DBQuery.getPrepareStatement();
            ps.setInt(1,builderID);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int buildNumber = rs.getInt("BuildNumber");
                String caseName = rs.getString("caseName");
                String graphicsCardName = rs.getString("graphicsCardName");
                String motherboardName = rs.getString("motherboardName");
                String powerSupplyName = rs.getString("powerSupplyName");
                String processorName = rs.getString("processorName");
                String ramName = rs.getString("ramName");
                Float price = rs.getFloat("price");
                int builder_ID = rs.getInt("builderID");
                int cus_ID = rs.getInt("customerID");
                LocalDate date = rs.getDate("soldDate").toLocalDate();




                Built_by_Builder addedBuiltComputer = new Built_by_Builder(buildNumber,caseName,graphicsCardName,
                        motherboardName,powerSupplyName,processorName,ramName,price,builder_ID,cus_ID,date);

                System.out.println(addedBuiltComputer);
                sevenDayBuiltList.add(addedBuiltComputer);
                sevenDayList.addAll(sevenDayBuiltList);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            CustomerAlertMessages.reportError(1);
        }
        return sevenDayBuiltList;
    }


        public static ObservableList<Built_by_Builder> salesByLastMonth(int builderID)
    {
        ObservableList<Built_by_Builder> monthBuildList = FXCollections.observableArrayList();
        String sql = "SELECT * ,sum(price) as totalSum FROM BUILTCOMPUTERS WHERE month(soldDate) = MONTH(current_date" +
                "())and builderID=?;";

        Connection con = DBConnection.getConnection();

        try
        {
            DBQuery.setPreparedStatement(con,sql);
            PreparedStatement ps = DBQuery.getPrepareStatement();
            ps.setInt(1,builderID);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int buildNumber = rs.getInt("BuildNumber");
                String caseName = rs.getString("caseName");
                String graphicsCardName = rs.getString("graphicsCardName");
                String motherboardName = rs.getString("motherboardName");
                String powerSupplyName = rs.getString("powerSupplyName");
                String processorName = rs.getString("processorName");
                String ramName = rs.getString("ramName");
                Float price = rs.getFloat("price");
                int builder_ID = rs.getInt("builderID");
                int cus_ID = rs.getInt("customerID");
                LocalDate date = rs.getDate("soldDate").toLocalDate();

                if (date == null)
                {
                    System.out.println("items for the date selected");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("No items in the selected time period");
                    alert.setTitle("No Report Generated");
                    alert.setHeaderText("No Report");
                    alert.showAndWait();
                }


                Built_by_Builder addedBuiltComputer = new Built_by_Builder(buildNumber,caseName,graphicsCardName,
                        motherboardName,powerSupplyName,processorName,ramName,price,builder_ID,cus_ID,date);

                monthBuildList.add(addedBuiltComputer);
                monthList.addAll(monthBuildList);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            CustomerAlertMessages.reportError(1);
        }
        return monthBuildList;

    }



    public static ObservableList<Built_by_Builder> salesLastYear(int builderID)
    {
        ObservableList<Built_by_Builder> yearBuildList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM BUILTCOMPUTERS WHERE soldDate > now() - INTERVAL 12 MONTH and builderID =?;";

        Connection con = DBConnection.getConnection();

        try
        {
            DBQuery.setPreparedStatement(con,sql);
            PreparedStatement ps = DBQuery.getPrepareStatement();
            ps.setInt(1,builderID);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int buildNumber = rs.getInt("BuildNumber");
                String caseName = rs.getString("caseName");
                String graphicsCardName = rs.getString("graphicsCardName");
                String motherboardName = rs.getString("motherboardName");
                String powerSupplyName = rs.getString("powerSupplyName");
                String processorName = rs.getString("processorName");
                String ramName = rs.getString("ramName");
                Float price = rs.getFloat("price");
                int builder_ID = rs.getInt("builderID");
                int cus_ID = rs.getInt("customerID");
                LocalDate date = rs.getDate("soldDate").toLocalDate();




                Built_by_Builder addedBuiltComputer = new Built_by_Builder(buildNumber,caseName,graphicsCardName,
                        motherboardName,powerSupplyName,processorName,ramName,price,builder_ID,cus_ID,date);

                yearBuildList.add(addedBuiltComputer);

                yearList.addAll(yearBuildList);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            CustomerAlertMessages.reportError(1);

        }
        return yearBuildList;
    }


}
