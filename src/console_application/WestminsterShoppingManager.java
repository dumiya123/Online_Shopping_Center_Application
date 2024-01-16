package console_application;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/*
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
    private static final String product_details_file="product_data.csv";  //create a file to store
    public static ArrayList<Product> products = new ArrayList<Product>();
    public static  final WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();

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
                String usrInput = getUSerInput("Enter your Option:  ").toUpperCase();

                switch (usrInput)
                {
                    case "M":
                        shoppingManager.showMenu();
                        break;
                    case "A":
                        shoppingManager.add_Product();
                        break;
                    case "B":
                        shoppingManager.Show_details_of_product();
                        break;
                    case "D":
                        shoppingManager.deleteProduct();
                        break;
                    case "S":
                        shoppingManager.saveToFile();
                        break;
                    case "L":
                        shoppingManager.loadFromFile();
                        break;
                    case "G":
                        shoppingManager.Show_GUI();
                        break;
                    case "X":
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("SEEMS LIKE, YOU ARE ENTERING A WRONG MENU KEY.PLEASE CHECK IT AND TRY AGAIN.");
                }
            }
           catch (Exception e)
            {
               System.out.println("You cannot enter a numeric values.Please enter a Upper case Alphabetic character.(Hint:enter a character like A,B,C,D)");
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
                
                M: SHOW MENU.
                A: ADD NEW PRODUCT.
                B: SHOW PRODUCT DETAILS.
                D: DELETE PRODUCT.
                S: SAVE DETAILS IN TO A FILE.
                L: LOAD DETAILS FROM THE FILE.
                G: SHOW GRAPHICAL USER INTERFACE.
                X: EXIT FROM THE SYSTEM.
                                         
                ---------------------------------------------------------------------------------
                
                """);
    }

    /**
     *The add_Product method is responsible for adding a product to the system.
     *@throws  NumberFormatException If there is an error parsing numeric input for product type or price.
     */

    public void add_Product()
    {
        try
        {
            if (products.size() > maximum_products)  // Checking if the maximum number of products has been reached
            {
                System.out.println("Cannot add more products. Maximum products limit reached.");
                return;
            }

            // Getting user input for product details
            int productType = Integer.parseInt(getUSerInput("Enter product type (1 - electronics | 2 - clothing): "));
            String productID = getUSerInput("Enter the product ID:");
            String name = getUSerInput("Enter the product name: ");
            double price = Double.parseDouble(getUSerInput("Enter the price of the product: "));

            // Creating a product based on the user input.
            Product product = createProduct(productType, productID, name, price);

            //Checking whether the product creation was successful.
            if (product != null)
            {
                //if it is true add the particular product to the list.
                products.add(product);
                System.out.println();
                System.out.println("Product added successfully.");
            }
        }
        catch (NumberFormatException e)
        {
            // Handling invalid input format for numbers
            System.out.println("Error: Invalid input format. Please enter a valid number for price or product type.");
        }
        catch (Exception e)
        {
            //this will handle all other exceptions
            System.out.println("Error: " + e);
        }
    }

    /**
     *Show_details_of_product() will show the product details to the manager.
     *After  add a product to the arraylist he or she can see the details of the products using this method.
     */
    public void Show_details_of_product()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("| PRODUCT ID  | PRODUCT NAME   | PRODUCT TYPE   | NO OF PIECES AVAILABLE  | PRICE   |");
        System.out.println("-------------------------------------------------------------------------------------");

        if (products.isEmpty()) //check if the list of product is empty.
        {
            System.out.println(" No products available. Please add the products and check.");
        }
        else
        {
            for (Product product : products)  // Iterating through each product in the list
            {
                String productType = "No type";  // Setting a default value for productType.
                if( product.getProductType() == 1 )  // Mapping numeric product types to corresponding string names.
                {
                    productType = "Electronics";
                } else if ( product.getProductType() == 2 )
                {
                    productType = "Clothing";
                }

                // Displaying product details in a formatted table row
                System.out.printf("| %-12s| %-15s| %-15s| %-24s| %-8s|%n",
                        product.getProductID(),
                        product.getName_of_product(),
                        productType,
                        product.getAvailable_items(),
                        product.getPrice());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    /**
     *The deleteProduct method allows the user to remove a product from the ArrayList based on its ID.
     * This method handles potential exceptions, such as invalid input format, and provides appropriate
     *error messages in case of an exception.
     * @throws InputMismatchException If there is an error in the input format for the product ID.
     */
    public void deleteProduct()
    {
        try
        {
            String productId = getUSerInput("Enter the product ID to Delete: ");  // Getting user input for the product ID to delete

            Iterator<Product> iterator = products.iterator(); // Using an iterator to traverse the list of products
            boolean productFound = false;


            while (iterator.hasNext()) // Iterating through the products list to find and delete the specified product
            {
                Product product = iterator.next();
                if (productId.equals(product.getProductID()))
                {
                    iterator.remove(); //remove the product from the list
                    productFound = true;
                    System.out.println("Product deleted successfully.");
                    break; // Exiting the loop once the product is found and deleted
                }
            }

            if (!productFound)  //show a message if the specific product was unable to find.
            {
                System.out.println("Product not found with ID: " + productId);
            }

        }
        catch (InputMismatchException e)
        {
            // Handling invalid input format
            System.out.println("Invalid input.Please enter a valid Product ID.");
        }

    }

    /**
     * Creates a new product based on the specified product type and details.
     * @param productType  An integer representing the type of the product (1 for Electronics, 2 for Clothing).
     * @param productID   The unique identifier for the product
     * @param name      The name of the product.
     * @param price    The price of the product.
     * @return         A new product instance based on the provided details, or null if the input is invalid.
     * @throws        NumberFormatException If there is an error parsing the number of available items.
     */

    //String productID, String name_of_product, String no_of_available_items, double price, String brand, int warranty_duration

    private Product createProduct(int productType, String productID, String name, double price)
    {
        try
        {
            return switch (productType)
            {
                case 1 ->
                {
                    String brand = getUSerInput("Enter the brand of the electronic product: ");
                    String warrantyDuration = getUSerInput("Enter the warranty duration of the electronic product: ");
                    int no_of_available_items = Integer.parseInt(getUSerInput("Enter the number of available no of products: "));
                    yield new Electronics(productID, name, no_of_available_items, price, brand, warrantyDuration);
                }
                case 2 ->
                {
                    String size = getUSerInput("Enter the size of the clothing: ");
                    int no_of_available_items = Integer.parseInt(getUSerInput("Enter the number of available no of products: "));
                    String color = getUSerInput("Enter the color of the product: ");
                    yield new Clothing(productID, name, no_of_available_items, price, size, color);
                }
                default -> null;
            };
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input for number of available items. Please enter a valid integer.");
            return null; // Or handle it accordingly based on your application's requirements
        }
    }


    /**
     * Create a separate method to get user input with provided prompt
     * @param prompt USer input as a String.
     * @return  retrieve user Input as a String
     */

    public static String getUSerInput(String prompt)
    {
        System.out.println(prompt);
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * The Show_GUI method is responsible for displaying the graphical user interface (GUI) in a separate thread.
     */

    public void Show_GUI()
    {
        // Run GUI in a separate thread
        SwingUtilities.invokeLater(() -> {
            GUIHome GUI = new GUIHome();
//            GUI.setVisible(true);
        });
    }

    /**
     * The saveToFile method is responsible for saving product details to a CSV file.
     * It utilizes a FileWriter to write product information to the specified file in CSV format.
     */

    public void saveToFile()
    {
        try (FileWriter fileWriter = new FileWriter(product_details_file))
        {
            fileWriter.write("ProductType,ProductId,ProductName,AvailableItems,Price,AdditionalInfo1,AdditionalInfo2\n");   // Writing headers to the CSV file
            for (Product product : products)
            {
                if (product instanceof Electronics electronics)  //This line checks if the product is an instance of the Electronics class
                {
                    fileWriter.write(String.format("Electronics,%s,%s,%d,%.2f,%s,%s\n", electronics.getProductID(), electronics.getName_of_product(), // Writing data for Electronics products
                            electronics.getAvailable_items(), electronics.getPrice(), electronics.getBrand(), electronics.getWarranty_duration()));
                }
                else if (product instanceof Clothing clothing)  //This line checks if the product is an instance of the Electronic class
                {
                    fileWriter.write(String.format("Clothing,%s,%s,%d,%.2f,%s,%s\n", clothing.getProductID(), clothing.getName_of_product(), // Writing data for Clothing products
                            clothing.getAvailable_items(), clothing.getPrice(), clothing.getSize(), clothing.getColour()));
                }
            }
            System.out.println("Product data saved to CSV: " + product_details_file);
        }
        catch (IOException e)
        {
            System.out.println("Error while saving data: " + e); // Handling IOException during file writing
        }
    }

    /**
     *The loadFromFile method is responsible for loading product details from a CSV file.
     */
    public void loadFromFile()
    {
        products.clear(); // Clear existing data before loading from file
        try (Scanner scanner = new Scanner(new File(product_details_file)))
        {
            scanner.nextLine(); // Skip the header line
            while (scanner.hasNextLine())  // Skip the header line
            {
                String[] data = scanner.nextLine().split(",");
                if (data.length >= 7)
                {
                    int productType = -1;
                    if(data[0].equals("Electronics"))
                    {
                        productType = 1;
                    }
                    else if(data[0].equals("Clothing"))
                    {
                        productType = 2;
                    }
                    //String productType = data[0];
                    String productId = data[1];
                    String productName = data[2];
                    int availableItems = Integer.parseInt(data[3]);
                    double price = Double.parseDouble(data[4]);
                    if (productType == 1)
                    {
                        String brand = data[5];
                        String warrantyPeriod = data[6];
                        Electronics electronics = new Electronics(productId, productName, availableItems, price, brand, warrantyPeriod);
                        products.add(electronics);
                    }
                    else if (productType == 2)
                    {
                        String size = data[5];
                        String color = data[6];
                        Clothing clothing = new Clothing(productId, productName, availableItems, price, size, color);
                        products.add(clothing);
                    }
                }
            }
            System.out.println("Product data loaded from CSV: " + product_details_file);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("CSV file not found: " + product_details_file);// Handling FileNotFoundException during file reading
        }
    }


    // Helper method to create a product from CSV data
    private Product createProductFromCSV(String[] parts)
    {
        // Check if there are enough parts to create a product
        System.out.println(parts.length);
        if (parts.length < 4)
        {
            System.out.println("Invalid data format in CSV. Skipping line.");
            return null;
        }
        try
        {
            // Extracting data from CSV
            String productId = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);

            // Assuming the last part is a common field for all products (e.g., product type)
            String productType = parts[3];

            // Creating a product based on product type
            if ("ELECTRONICS".equalsIgnoreCase(productType))
            {
                return new Electronics(productId, name, price, "Electronics Brand");
            }
            else if ("CLOTHING".equalsIgnoreCase(productType))
            {
                return new Clothing(productId, name, 0, price, "Clothing Size", "Color");
            }
            else
            {
                System.out.println("Unknown product type: " + productType + ". Skipping line.");
                return null;
            }

        }
        catch (NumberFormatException e)
        {
            System.out.println("Error parsing numeric values in CSV. Skipping line.");
            return null;
        }
    }

}
