package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBQuery
{
    //Statement reference
    private static PreparedStatement statement;

    //Create prepare statement object
    public static void setPreparedStatement (Connection conn, String sqlStatement) throws SQLException
    {
        statement = conn.prepareStatement(sqlStatement);
    }

    //Return statement object
    public static PreparedStatement getPrepareStatement()
    {
        return statement;
    }
}
