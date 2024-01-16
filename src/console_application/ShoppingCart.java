/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage.
 @version 1 console application.
 */

package console_application;

import java.util.HashMap;

/**
 * The ShoppingCart class represents a shopping cart that can be used to store and manage products.
 */
public class ShoppingCart
{
    private static HashMap<Product, Integer> products = new HashMap<>();


    /**
     * Constructs a new ShoppingCart object.
     */

    public ShoppingCart()
    {

        // products=new ArrayList<Product>();

    }

    /**
     * Adds a product with a specified quantity to the shopping cart.
     *
     * @param product  The product to be added.
     * @param quantity The quantity of the product to be added.
     */

    public void add_Product(Product product, int quantity)
    {

        products.put(product, quantity);

    }

    /**
     * Removes a specified product from the shopping cart.
     *
     * @param product The product to be removed.
     */
    public void remove_product(Product product)
    {

        products.remove(product);

    }

    /**
     * Retrieves an array representing the products in the shopping cart.
     * @return A 2D array containing product information.
     */

    public static String[][] getProducts()
    {
        String[][] productsArray = new String[products.size()][5];
        int i = 0;
        for (Product product : products.keySet())
        {
            productsArray[i][0] = String.format("%s, %s", product.getProductID(), product.getName_of_product());
            productsArray[i][1] = Integer.toString(ShoppingCart.products.get(product));
            productsArray[i][2] = String.valueOf(product.getPrice());
            i++;
        }
        return productsArray;
    }


    /**
     * Calculates and returns the total cost of the products in the shopping cart.
     * @return The total cost of the products in the shopping cart.
     */

    public static double calculate_total_cost()
    {
        double total_cost=0.0;
        for (Product product: products.keySet())
        {

            total_cost += product.getPrice() * products.get(product);

        }
        return total_cost;


    }

    /**
     * Sets the visibility of the shopping cart window.
     *
     * @param b True to set the window visible, false otherwise.
     */
    public void setVisible(boolean b)
    {


    }
}
