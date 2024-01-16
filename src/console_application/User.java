package console_application;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */

/**
 * This class represent the user account.
 * this class hold information about the username and password.
 */
public class User
{
    private String username;  //declare String type private instance variable to store the username .
    private String password; //declare String type private instance variable to store the password.

    /**
     * default constructor for the User class
     */

    public User()
    {

    }

    /**
     * Constructor for the User class which accepts two parameters username and password.
     * @param username username of the user.
     * @param password password of the user.
     */
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    /**
     * getter for the username.
     * @return username get the username
     */

    public String getUsername()
    {
        return username;
    }

    /**
     * setter for the username
     * @param username set the username
     */

    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * getter for the password.
     * @return password
     */

    public String getPassword()
    {
        return password;
    }

    /**
     * setter for the password.
     * @param password password of the user.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

}
