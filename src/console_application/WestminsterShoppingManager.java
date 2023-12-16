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
public class WestminsterShoppingManager
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

    private void add_Product()
    {
        if (products.size() >= maximum_products)
        {
            System.out.println("Product Limit Reached.Cannot add more products.");
            return;
        }

        Scanner input=new Scanner(System.in);
        String productType;

        System.out.println("Enter product type (Electronics/Clothing):  ");
        productType= input.next();

        switch (productType)
        {
            case "electronics":

            case "clothing":





        }

    }

    private void add_clothing_product()
    {
        Scanner input_one=new Scanner(System.in);


    }













}
