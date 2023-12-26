package console_application;


/**
 * COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 * Object-Oriented Programming Coursework L5 sem 1
 * @author Dumindu Induwara Gamage
 * @version 1 Console application
 */

/**
 * The Product class is the parent class for both Electronic and Clothing classes.
 */
public abstract class Product
{
    public Product(String productID)
    {
        this.productID = productID;
    }

    public Product(String productID, String name_of_product)
    {

        this.productID = productID;
        this.name_of_product = name_of_product;

    }


    public Product(String productID, String name_of_product, String available_items)
    {
        this.productID = productID;
        this.name_of_product = name_of_product;
        this.available_items = available_items;
    }

    private String productID;
    private String name_of_product;
    private String available_items;
    private double price;

    /**
     * Default constructor for the Product class.
     */
    public Product()
    {

    }

    public Product(String productID, String name_of_product, String available_items, double price)
    {

        this.productID = productID;
        this.name_of_product = name_of_product;
        this.available_items = available_items;
        this.price = price;

    }

    public void setProductID(String productID)
    {
        this.productID = productID;
    }

    public void setName_of_product(String name_of_product)
    {
        this.name_of_product = name_of_product;
    }

    public void setAvailable_items(String available_items)
    {
        this.available_items = available_items;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }



    public String getProductID()
    {
        return productID;
    }

    public String getName_of_product()
    {
        return name_of_product;
    }

    public String getAvailable_items()
    {
        return available_items;
    }

    public double getPrice()
    {
        return price;
    }







}
