package console_application;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
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
    private ArrayList<Product> products = new ArrayList<Product>();
    private static  final WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();


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
                    case "E":
                        shoppingManager.saveToFile();
                        break;
                    case "F":
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
                        System.out.println("Invalid choice.");
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
                E: SAVE DETAILS IN TO A FILE.
                F: LOAD DETAILS FROM THE FILE.
                G: SHOW GRAPHICAL USER INTERFACE.
                X: EXIT FROM THE SYSTEM.
                                         
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
            if (products.size() > maximum_products)
            {
                System.out.println("Cannot Add more products.Maximum products limit reached.");
                return;
            }

            //Getting user input for product details
            int productType = Integer.parseInt(getUSerInput("Enter product type (1 - electronics | 2 - clothing): "));
            String productID = getUSerInput("Enter the product ID:");
            String name =  getUSerInput("Enter the product name: ");
            double price = Double.parseDouble(getUSerInput("Enter the price of the product: "));

            //creating a product based on the user input.
            Product product = createProduct( productType, productID, name, price );
            if(product != null)
            {
                products.add(product);
                System.out.println();
                System.out.println(" product added successfully.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);

        }

    }

    public void Show_details_of_product()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("| PRODUCT ID  | PRODUCT NAME   | PRODUCT TYPE   | NO OF PIECES AVAILABLE  | PRICE   |");
        System.out.println("-------------------------------------------------------------------------------------");

        if (products.isEmpty())
        {
            System.out.println(" No products available. Please add the products and check.|");
        }
        else
        {
            for (Product product : products)
            {
                String productType = "No type";
                if( product.getProductType() == 1 )
                {
                    productType = "Electronics";
                } else if ( product.getProductType() == 2 )
                {
                    productType = "Clothing";
                }
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


    // Method to delete a product by product ID
    public void deleteProduct()
    {
        String productId = getUSerInput("Enter the product ID to Delete: ");

        Iterator<Product> iterator = products.iterator();
        boolean productFound = false;

        while (iterator.hasNext())
        {
            Product product = iterator.next();
            if (productId.equals(product.getProductID()))
            {
                iterator.remove();
                productFound = true;
                System.out.println("Product deleted successfully.");
                break;
            }
        }

        if (!productFound)
        {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    /**
     * Create a separate method to create a Product
     * @param productType  type of the product.
     * @param productID
     * @param name
     * @param price
     * @return
     */

    //String productID, String name_of_product, String no_of_available_items, double price, String brand, int warranty_duration

    private Product createProduct(int productType, String productID, String name, double price)
    {
        return switch (productType) {
            case 1 -> {
                String brand = getUSerInput("Enter the brand of the electronic product: ");
                String warrentyDuration = getUSerInput("Enter the warranty duration of the electronic product: ");
                int no_of_available_items = Integer.parseInt(getUSerInput("Enter the number of available no of products: "));
                yield new Electronics(productID, name, no_of_available_items, price, brand, warrentyDuration );
            }
            case 2 -> {
                //String productID, String name_of_product, String available_items, double price, String size, String colour

                String size = getUSerInput("Enter the size of the clothing: ");
                int no_of_available_items = Integer.parseInt(getUSerInput("Enter the number of available no of products: "));
                String color = getUSerInput("Enter the color of the product: ");
                yield new Clothing(productID, name, no_of_available_items, price, size, color);
            }
            default -> null;
        };
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

    public void Show_GUI()
    {
        // Run GUI in a separate thread
        SwingUtilities.invokeLater(() -> {
            GUIHome GUI = new GUIHome();
            GUI.setVisible(true);
        });
    }

    public void saveToFile()
    {
        try (FileWriter fileWriter = new FileWriter(product_details_file))
        {
            fileWriter.write("ProductType,ProductId,ProductName,AvailableItems,Price,AdditionalInfo1,AdditionalInfo2\n");
            for (Product product : products)
            {
                if (product instanceof Electronics electronics)
                {
                    fileWriter.write(String.format("Electronics,%s,%s,%d,%.2f,%s,%s\n", electronics.getProductID(), electronics.getName_of_product(),
                            electronics.getAvailable_items(), electronics.getPrice(), electronics.getBrand(), electronics.getWarranty_duration()));
                }
                else if (product instanceof Clothing clothing)
                {
                    fileWriter.write(String.format("Clothing,%s,%s,%d,%.2f,%s,%s\n", clothing.getProductID(), clothing.getName_of_product(),
                            clothing.getAvailable_items(), clothing.getPrice(), clothing.getSize(), clothing.getColour()));
                }
            }
            System.out.println("Product data saved to CSV: " + product_details_file);
        }
        catch (IOException e)
        {
            System.out.println("Error while saving data: " + e);
        }
    }

    // Method to load products from a CSV file
    public void loadFromFile()
    {
        products.clear(); // Clear existing data before loading from file
        try (Scanner scanner = new Scanner(new File(product_details_file))) {
            scanner.nextLine(); // Skip the header line
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length >= 7) {
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
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + product_details_file);
        }
    }



    // Helper method to create a product from CSV data
    private Product createProductFromCSV(String[] parts) {
        // Check if there are enough parts to create a product
        System.out.println(parts.length);
        if (parts.length < 4) {
            System.out.println("Invalid data format in CSV. Skipping line.");
            return null;
        }

        try {
            // Extracting data from CSV
            String productId = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);

            // Assuming the last part is a common field for all products (e.g., product type)
            String productType = parts[3];

            // Creating a product based on product type
            if ("ELECTRONICS".equalsIgnoreCase(productType)) {
                return new Electronics(productId, name, price, "Electronics Brand");
            } else if ("CLOTHING".equalsIgnoreCase(productType)) {
                return new Clothing(productId, name, 0, price, "Clothing Size", "Color");
            } else {
                System.out.println("Unknown product type: " + productType + ". Skipping line.");
                return null;
            }

        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric values in CSV. Skipping line.");
            return null;
        }
    }

}
