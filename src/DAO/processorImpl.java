package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class processorImpl {
    public static ObservableList<Processor> processorList = FXCollections.observableArrayList();

    public static ObservableList<Processor> selectAllProcessors() throws SQLException, Exception
    {

        ObservableList<Processor> allProcessors = FXCollections.observableArrayList();

        allProcessors.clear();

        String sqlStatement = "Select * from PROCESSORS";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn, sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("P_ID");
            String name = rs.getString("P_NAME");
            String description = rs.getString("P_DESCRIPTION");
            String make = rs.getString("P_MAKE");
            String model = rs.getString("P_MODEL");
            int speed = rs.getInt("P_SPEED");
            String socket = rs.getString("P_SOCKET");
            int cores = rs.getInt("P_CORES");
            int onHand = rs.getInt("P_QOH");
            int minOnHand = rs.getInt("P_MIN");
            Float price = rs.getFloat("P_PRICE");
            Float discount = rs.getFloat("P_DISCOUNT");

            Processor addProcessor = new Processor(id, name, description, make, model, speed, socket, cores, onHand, minOnHand
                    , price, discount);

            allProcessors.add(addProcessor);
            processorList.addAll(allProcessors);


        }

        DBConnection.closeConnection();
        return allProcessors;
    }

    public static ObservableList<Processor> getProcessorByName (String processorName) throws SQLException
    {
        ObservableList<Processor> processorsByNameList = FXCollections.observableArrayList();
        Connection conn = DBConnection.getConnection();

        String sqlStatement = "Select * from PROCESSORS WHERE P_ID=?";

        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("P_ID");
            String name = rs.getString("P_NAME");
            String description = rs.getString("P_DESCRIPTION");
            String make = rs.getString("P_MAKE");
            String model = rs.getString("P_MODEL");
            int speed = rs.getInt("P_SPEED");
            String socket = rs.getString("P_SOCKET");
            int cores = rs.getInt("P_CORES");
            int onHand = rs.getInt("P_QOH");
            int minOnHand = rs.getInt("P_MIN");
            Float price = rs.getFloat("P_PRICE");
            Float discount = rs.getFloat("P_DISCOUNT");

            Processor addProcessor = new Processor(id, name, description, make, model, speed, socket, cores, onHand, minOnHand
                    , price, discount);

            processorsByNameList.add(addProcessor);
            processorList.addAll(processorsByNameList);


        }

        DBConnection.closeConnection();
        return processorsByNameList;

    }

    public static void addProcessor(String name, String description, String make, String model, Integer speed,
                                    String socket, Integer cores, Integer onHand, Integer minOnHand, Float price,
                                    Float discount) throws Exception
    {
        String powerSupplyIDNumb = null;
        String sql = "INSERT INTO PROCESSORS (P_NAME,P_DESCRIPTION,P_MAKE,P_MODEL,P_SPEED,P_SOCKET,P_CORES,P_QOH," +
                "P_MIN,P_PRICE,P_DISCOUNT) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try
        {

            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,description);
            pst.setString(3,make);
            pst.setString(4,model);
            pst.setInt(5,speed);
            pst.setString(6,socket);
            pst.setInt(7,cores);
            pst.setInt(8,onHand);
            pst.setInt(9,minOnHand);
            pst.setFloat(10,price);
            pst.setFloat(11,discount);

            pst.execute();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void updateProcessor (String name, String description, String make, String model, Integer speed,
    String socket, Integer cores, Integer onHand, Integer minOnHand, Float price, Float discount, Integer id)
    {
        String processorIDNumb = null;
        String sql ="UPDATE PROCESSORS SET P_NAME=?,P_DESCRIPTION=?,P_MAKE=?,P_MODEL=?,P_SPEED=?,P_SOCKET=?," +
                "P_CORES=?,P_QOH=?,P_MIN=?,P_PRICE=?,P_DISCOUNT=? WHERE P_ID=?";

        try
        {
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);

            Connection conn = DBConnection.getConnection();

            pst.setString(1,name);
            pst.setString(2,description);
            pst.setString(3,make);
            pst.setString(4,model);
            pst.setInt(5,speed);
            pst.setString(6,socket);
            pst.setInt(7,cores);
            pst.setInt(8,onHand);
            pst.setInt(9,minOnHand);
            pst.setFloat(10,price);
            pst.setFloat(11,discount);
            pst.setInt(12,id);

            pst.execute();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void deleteProcesor(int id, Processor selectedProcessor) throws Exception
    {
        String sql = "DELETE FROM PROCESSORS WHERE P_ID=?";
        processorList.remove(selectedProcessor);
        PreparedStatement pst = DBConnection.getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.execute();
        return;
    }
}
