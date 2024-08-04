package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.PowerSupply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class powersupplyImpl
{
    public static ObservableList<PowerSupply> powersupplyList = FXCollections.observableArrayList();

    public static ObservableList<PowerSupply> selectAllPowerSupply () throws SQLException,Exception
    {
        powersupplyList.clear();

        ObservableList<PowerSupply> allPowerSupplies = FXCollections.observableArrayList();

        String sqlStatement = "Select * from POWERSUPPLIES";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("PS_ID");
            String name = rs.getString("PS_NAME");
            String make = rs.getString("PS_MAKE");
            String model = rs.getString("PS_MODEL");
            String modual = rs.getString("PS_MODULAR");
            int wattage = rs.getInt("PS_WATTAGE");
            String description = rs.getString("PS_DESCRIPTION");
            int onHand = rs.getInt("PS_QOH");
            int minOnHand = rs.getInt("PS_MIN");
            Float price = rs.getFloat("PS_PRICE");
            Float discount = rs.getFloat("PS_DISCOUNT");

            PowerSupply addPowerSupply = new PowerSupply(id,name,make,model,modual,wattage,description,onHand,
                    minOnHand,price,discount);

            allPowerSupplies.add(addPowerSupply);
            powersupplyList.addAll(allPowerSupplies);


        }
        DBConnection.closeConnection();
        return allPowerSupplies;
    }

    public static void addPowerSupply (String name, String make, String model, String modular, Integer wattage,
                                       String description, Integer amountOnHand, Integer minOnHand, Float price,
                                       Float discount) throws Exception {

        String powerSupplyIDNumb = null;
        String sql ="INSERT INTO POWERSUPPLIES (PS_NAME,PS_MAKE,PS_MODEL,PS_MODULAR,PS_WATTAGE, PS_DESCRIPTION, " +
                "PS_QOH," +
                "PS_MIN,PS_PRICE,PS_DISCOUNT) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try
        {

            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,modular);
            pst.setInt(5,wattage);
            pst.setString(6,description);
            pst.setInt(7,amountOnHand);
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

    public static void updatePowerSupply(String name, String make, String model, String modular, Integer wattage,
                                         String description, Integer amountOnHand, Integer minOnHand, Float price,
                                         Float discount, Integer id)
    {
        String powerSupplyIDNumb = null;
        String sql ="UPDATE POWERSUPPLIES SET PS_NAME=?, PS_MAKE=?, PS_MODEL=?, PS_MODULAR=?, PS_WATTAGE=?, " +
                "PS_DESCRIPTION=?, PS_QOH=?, PS_MIN=?, PS_PRICE=?, PS_DISCOUNT=? WHERE PS_ID=?";




        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);

            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,modular);
            pst.setInt(5,wattage);
            pst.setString(6,description);
            pst.setInt(7,amountOnHand);
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

    public static void deletePowerSupply(int id, PowerSupply selectedPowerSupply) throws Exception
    {
        String sql ="DELETE FROM POWERSUPPLIES WHERE PS_ID=?";
        powersupplyList.remove(selectedPowerSupply);
        PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.execute();
        return;
    }
}
