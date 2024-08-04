package DAO;

import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Cases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class casesImpl
{
    public static ObservableList<Cases> caseList = FXCollections.observableArrayList();
    public static ObservableList<Cases> selectAllCases() throws SQLException,Exception
    {
        ObservableList<Cases> allCases = FXCollections.observableArrayList();

        String sqlStatement = "Select * from COMPUTERCASES";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("CC_ID");
            String name = rs.getString("CC_NAME");
            String type = rs.getString("CC_TYPE");
            String make = rs.getString("CC_MAKE");
            String model = rs.getString("CC_MODEL");
            String description = rs.getString("CC_DESCRIPTION");
            int onHand = rs.getInt("CC_QOH");
            int minOnHand = rs.getInt("CC_MIN");
            int price = rs.getInt("CC_PRICE");
            Float discount = rs.getFloat("CC_DISCOUNT");

            Cases addCases = new Cases(id,name,type,make,model,description,onHand,minOnHand,price,discount);

            allCases.add(addCases);
            caseList.addAll(allCases);


        }
        DBConnection.closeConnection();
        return allCases;


    }

    public static void deleteCase(int caseID, Cases selectedCase) throws Exception
    {
        String sql = "DELETE FROM COMPUTERCASES WHERE CC_ID =?";

        caseList.remove(selectedCase);

        PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
        pst.setInt(1,caseID);
        pst.execute();
        return;
    }
    public static void addCase(String name, String type, String make, String model, String description,
                               Integer onHand, Integer minOnHand, Float price, Float discount)
    {
        String caseIDNumb = null;
        String sql ="INSERT INTO COMPUTERCASES (CC_NAME, CC_TYPE,CC_MAKE, CC_MODEL, CC_DESCRIPTION, CC_QOH, CC_MIN," +
                "CC_PRICE, CC_DISCOUNT) Values (?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,type);
            pst.setString(3,make);
            pst.setString(4,model);
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
    public static void updateCase(String name, String type, String make, String model, String description,
                                  Integer onHand, Integer minOnHand, Float price, Float discount,Integer id)
    {
        String caseIDNumb = null;
        String sqlUpdate = "UPDATE COMPUTERCASES SET CC_NAME=?, CC_TYPE=?,CC_MAKE=?,CC_MODEL=?,CC_DESCRIPTION=?," +
                "CC_QOH=?, CC_MIN=?, CC_PRICE=?,CC_DISCOUNT=? WHERE CC_ID=?";

        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sqlUpdate);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,type);
            pst.setString(3,make);
            pst.setString(4,model);
            pst.setString(5,description);
            pst.setInt(6,onHand);
            pst.setInt(7,minOnHand);
            pst.setFloat(8,price);
            pst.setFloat(9,discount);
            pst.setInt(10,id);

            pst.execute();

            pst = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM COMPUTERCASES");
            ResultSet rs = pst.executeQuery();

            rs.next();
            caseIDNumb = rs.getString(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(caseIDNumb);
    }

}
