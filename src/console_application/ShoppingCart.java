package console_application;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    private List<Product> products;

    public ShoppingCart()
    {

        products=new ArrayList<Product>();

    }

    /**
     *
     * Declare a method to add product to the cart.
     *
     */

    public void add_Product(Product product)
    {

        products.add(product);

    }

    /**
     * Declare a method to remove a product from cart.
     * @param product
     */

    public void remove_product(Product product)
    {

        products.remove(product);

    }

    /**
     * Declare a method to calculate the total cost
     */

    public double calculate_total_cost()
    {
        double total_cost=0.0;
        for (Product product:products)
        {

            total_cost += product.getPrice();

        }
        return total_cost;


    }


}
