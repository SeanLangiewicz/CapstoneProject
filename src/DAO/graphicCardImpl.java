package DAO;

import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.GraphicCards;
import model.Prebuilt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class graphicCardImpl
{
    public static ObservableList<GraphicCards> graphicCardsList = FXCollections.observableArrayList();
    public static ObservableList<GraphicCards> selectAllCards () throws SQLException,Exception
    {
        ObservableList<GraphicCards> allCards = FXCollections.observableArrayList();

        String sqlStatement = "select * from GRAPHICSCARDS;";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("GC_ID");
            String name = rs.getString("GC_NAME");
            String make = rs.getString("GC_MAKE");
            String model = rs.getString("GC_MODEL");
            String resolution = rs.getString("GC_MAX_RESOLUTION");
            String connectors = rs.getString("GC_DISPLAY_OUTPUT_CONNECTORS");
            String description = rs.getString("GC_DESCRIPTION");
            int onHand = rs.getInt("GC_QOH");
            int minOnHand = rs.getInt("GC_MIN");
            float price = rs.getFloat("GC_PRICE");
            float discount = rs.getFloat("GC_DISCOUNT");

            GraphicCards addCards = new GraphicCards(id,name,make,model,resolution,connectors,description,onHand,
                    minOnHand,price,discount);

            allCards.add(addCards);
            graphicCardsList.addAll(addCards);
        }
        DBConnection.closeConnection();;
        return allCards;
    }

    public static void updateGraphicsCard (String name, String make, String model, String resolution,
                                           String connectors, String description, Integer onHand,
                                           Integer minOnHand,Float price, Float discount, Integer id)
    {

        String graphicsCardIDNumb = null;
        String sqlUpdate ="UPDATE GRAPHICSCARDS SET GC_NAME=?,GC_MAKE=?, GC_MODEL=?,GC_MAX_RESOLUTION=?," +
                "GC_DISPLAY_OUTPUT_CONNECTORS=?,GC_DESCRIPTION=?,GC_QOH=?,GC_MIN=?,GC_PRICE=?,GC_DISCOUNT=? WHERE " +
                "GC_ID=?";



        try
        {

            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sqlUpdate);
            System.out.println(pst);

            Connection conn = DBConnection.getConnection();


               pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,resolution);
            pst.setString(5,connectors);
            pst.setString(6,description);
            pst.setInt(7,onHand);
            pst.setInt(8,minOnHand);
            pst.setFloat(9,price);
            pst.setFloat(10,discount);
            pst.setInt(11,id);



            pst.execute();



                  pst = conn.prepareStatement("SELECT LAST_INSERT_ID() FROM GRAPHICSCARDS");
            ResultSet rs = pst.executeQuery();
            rs.next();
            graphicsCardIDNumb = rs.getString(1);








        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(graphicsCardIDNumb);
    }
    public static void addGraphicsCard (String name, String make, String model, String resolution,String connectors,
                                        String description,
                                          Integer onHand, Integer minOnHand, Float price, Float discount)
    {
        String graphicsCardIDNumb = null;
        String sql = "INSERT INTO GRAPHICSCARDS(GC_NAME,GC_MAKE,GC_MODEL,GC_MAX_RESOLUTION," +
                "GC_DISPLAY_OUTPUT_CONNECTORS,GC_DESCRIPTION,GC_QOH,GC_MIN,GC_PRICE,GC_DISCOUNT) Values(?,?,?,?," +
                "?,?,?,?,?,?)";


        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setString(4,resolution);
            pst.setString(5,connectors);
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

    public static void deleteGraphicsCardByID(int id, GraphicCards selectedGraphicsCard) throws SQLException
    {
        String sql = "DELETE FROM GRAPHICSCARDS WHERE GC_ID=?";
        graphicCardsList.remove(selectedGraphicsCard);
        PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.execute();
        return;
    }


}
