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
 @author Dumindu Induwara Gamage.
 @version 1 Console application.
 */

/**
 * This class contains main method of the program .
 * This class is responsible for managing all actions within the program.
 */
public class WestminsterShoppingManager implements ShoppingManager
{
    private final int maximum_products = 50;

    private ArrayList<Product> products = new ArrayList<Product>();

    private static  final WestminsterShoppingManager shoppingManager=new WestminsterShoppingManager();




    /**
     * main method of the program.
     * @param args any arguments pass to the main method.
     */

    public static void main(String[] args)
    {



        while(true)
        {
            shoppingManager.showMenu();
            Scanner sc=new Scanner(System.in);




        }







    }

    /**
     * showMenu() method will display the menu to the user.
     */

    public  void showMenu()
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

                System.out.println("Cannot Add more products.Maximum products limit reached.");
                return;

            }

            //Getting user input for product details
            String productType=getUSerInput("Enter product type (electronics/clothing): ").toLowerCase();
            int productID=Integer.parseInt(getUSerInput("Enter the product ID:"));
            String name=getUSerInput("Enter the product name: ");
            double price=Double.parseDouble(getUSerInput("Enter the price ofm the product: "));







        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);

        }

    }

    /**
     * Create a separate method to get user input with provided
     * @param prompt USer input as a String.
     * @return  retrieve user Input as a String
     */



    public static String getUSerInput(String prompt)
    {

        System.out.println(prompt);
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();

    }




}
