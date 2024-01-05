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
            try
            {
                shoppingManager.showMenu();
                Scanner sc=new Scanner(System.in);
                String usrInput=getUSerInput("Enter your Option:  ").toUpperCase();

                switch (usrInput)
                {
                    case "A":
                        shoppingManager.add_Product();
                        break;
                    case "B":
                        //Have to implement delete method
                        break;
                    case "C":
                        //have to implement a method to view product details.
                        break;
                    case "O":
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");

                }


            }
            catch (Exception e)
            {
                System.out.println("You cannot enter a numeric values.Please enter a Upper case Alphabetic character.(Hint:enter a character like A,B,C,D.)");
            }


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
                
                M:SHOW MENU
                A:ADD NEW PRODUCT
                B:DELETE PRODUCT
                C:VIEW PRODUCT LIST
                D:SAVE DETAILS IN TO A FILE
                E:LOAD DETAILS FROM THE FILE
                O:EXIT FROM THE SYSTEM.
                                         
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
            double price=Double.parseDouble(getUSerInput("Enter the price of the product: "));

            //creating a product based on the user input.
            Product product=createProduct(productType,productID,name,price);
            if(product!=null)
            {
                products.add(product);
                System.out.println();
                System.out.println(productType.substring(0,1).toUpperCase()+productType.substring(1)+" product added successfully.");
            }

        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);

        }

    }

    /**
     * Create a separate to create a Product
     * @param productType  type of the product.
     * @param productID
     * @param name
     * @param price
     * @return
     */

    private Product createProduct(String productType,int productID,String name,double price)
    {
        switch (productType)
        {
            case "electronics":
                String brand=getUSerInput("Enter the brand of the electronic product: ");
                return new Electronics(productID,name,price,brand);
            case "clothing":
                String size=getUSerInput("Enter the size of the clothing: ");
                return new Clothing(productID,name,price,size);
            default:
                return null;

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
