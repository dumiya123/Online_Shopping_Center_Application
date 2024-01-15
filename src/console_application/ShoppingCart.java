package console_application;

import java.util.HashMap;

public class ShoppingCart
{
    private static HashMap<Product, Integer> products = new HashMap<>();

    public ShoppingCart()
    {

        // products=new ArrayList<Product>();

    }

    /**
     *
     * Declare a method to add product to the cart.
     *
     */

    public void add_Product(Product product, int quantity)
    {

        products.put(product, quantity);

    }

    /**
     * Declare a method to remove a product from cart.
     * @param product
     */

    public void remove_product(Product product)
    {

        products.remove(product);

    }

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
     * Declare a method to calculate the total cost
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


    public void setVisible(boolean b) {
    }
}
