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














}
