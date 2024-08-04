package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userImpl
{

    public static ObservableList<User> allUsers = FXCollections.observableArrayList();
    public static ObservableList<User>signedInUserList = FXCollections.observableArrayList();



    public static boolean userSignInCheck (String userName, String password) throws SQLException

    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        conn = DBConnection.getConnection();
        System.out.println("conn" + conn);
        String sqlStatement = "SELECT USER_ID, USER_NAME FROM USERS WHERE User_Name =? and Password=? ";

        pst = conn.prepareStatement(sqlStatement);
        pst.setString(1,userName);
        pst.setString(2,password);

        rs = pst.executeQuery();

        System.out.println("Result set " + rs);

        if(rs.next())
        {
            Integer uID = rs.getInt("User_ID");
            String uName = rs.getString("User_Name");
            User loggedInUser = new User(uID,uName);
            signedInUserList.add(loggedInUser);
            password = null;
        }
        else
        {
            return false;
        }
        return true;

    }

    public static ObservableList<User> getAllUsers () throws SQLException, Exception
    {

        Connection conn = DBConnection.getConnection();
        String sqlStatement = "select user_ID, user_name from users;";
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();
        while (rs.next())
        {
            int userID = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");

            User addedUser = new User(userID,userName);
            allUsers.add(addedUser);



        }
        DBConnection.closeConnection();
        return allUsers;
    }
    public static ObservableList<User> searchByUserName (String userName)
    {
        ObservableList<User> returnedUser = FXCollections.observableArrayList();
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        Integer userID = null;

        for (User user : allUsers)
        {
            if( user.getUserName().contains(userName))
            {
                userID = user.getUserID();
                User newUser = new User(userID,userName);
                returnedUser.add(newUser);
            }

        }
        return returnedUser;
    }


}
