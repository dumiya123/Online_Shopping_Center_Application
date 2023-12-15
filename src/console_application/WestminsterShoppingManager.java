package console_application;


import java.util.Scanner;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */

/**
 * This class contains main method of the program .
 * This class is responsible for managing all actions within the program.
 */
public class WestminsterShoppingManager
{
    /**
     * main method of the
     * @param args any arguments pass to the main method.
     */

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        while(true)
        {
            System.out.println("\nEnter Your Option: ");
            String usrInput= sc.next().toUpperCase();
        }





    }

    /**
     * showMenu() method will display the menu to the user.
     */

    public void showMenu()
    {
        System.out.println("""
                
                ---------------------------------------------------------------------------------
                                         WESTMINSTER SHOPPING MANAGER
                ---------------------------------------------------------------------------------
                
                M: SHOW MENU
                
                                         
                
                
                """);
    }







}
