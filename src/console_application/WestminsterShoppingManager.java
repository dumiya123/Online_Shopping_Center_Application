package console_application;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
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
public class WestminsterShoppingManager implements ShoppingManager
{
    private final int maximum_products = 50;

    private ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Electronics> electronics_products=new ArrayList<Electronics>();
    private static ArrayList<Clothing>   clothing_products=new ArrayList<Clothing>();








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
                A: ADD NEW PRODUCT
                B: DELETE PRODUCT
                C: VIEW PRODUCT LIST
                D: SAVE DETAILS IN TO A FILE
                                         
                ---------------------------------------------------------------------------------
                
                """);
    }

    /**
     * add_Product() method will add a product to the system.
     */

    public void add_Product()
    {
        try
        {
            if (products.size()>=maximum_products)
            {
                System.out.println("Maximum limit of products reached");
                return;
            }

            Scanner scanner=new Scanner(System.in);

            System.out.println("Enter product type(electronics/clothing):  ");
            String productType = scanner.nextLine().toLowerCase();

            System.out.print("Enter product ID: ");
            String productID = scanner.nextLine();

            System.out.println("Enter the product name: ");
            String name= scanner.nextLine();

            System.out.println("Enter the price of the product: ");
            int price=0;




        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);


        }





    }















}
