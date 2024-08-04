package model;

public class User
{

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public  String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public User(int userID, String userName)
    {
        this.userID = userID;
        this.userName = userName;
    }

    private int userID;
    private String userName;
}
