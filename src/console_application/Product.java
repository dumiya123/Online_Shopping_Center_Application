package console_application;


/**
 * COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 * Object-Oriented Programming Coursework L5 sem 1
 * @author Dumindu Induwara Gamage
 * @version 1 Console application.
 */

/**
 * The Product class is the parent class for both Electronic and Clothing classes.
 */
public abstract class Product
{
    private String productID;   //declare a private String variable to store the productID.
    private String name_of_product; //declare a private String variable to store the name_of_product
    private int no_of_available_items; //declare a private String variable to store information of the available items.
    private double price; //declare a private String variable to store product price.
    private int productType;

    /**
     *
     * Default constructor for the Product class.
     *
     */
    public Product()
    {

    }

    /**
     * Constructor for the Product class which accepts one parameter productID.
     * @param productID Specific code for identifying the product.
     */
    public Product(String productID)
    {
        this.productID = productID;
    }

    /**
     * Constructor for the Product class which accepts two  parameters productID and name of the product.
     * @param productID Specific code for identifying the product
     * @param name_of_product name of the product
     */

    public Product(String productID, String name_of_product)
    {
        this.productID = productID;
        this.name_of_product = name_of_product;
    }

    /**
     * Constructor for the Product class which accepts two  parameters productID , name_of_product and available_items.
     * @param productID Specific code for identifying the product.
     * @param name_of_product name of the product.
     * @param available_items information about items available.
     */

    public Product(String productID, String name_of_product, int available_items)
    {
        this.productID = productID;
        this.name_of_product = name_of_product;
        this.no_of_available_items = available_items;
    }

    /**
     * Constructor for the Product class which accepts two  parameters productID , name_of_product ,available_items .
     * @param productID Specific code for identifying the product.
     * @param name_of_product name of the product.
     * @param available_items information about items available.
     * @param price price of the product.
     */

    public Product(String productID, String name_of_product, int available_items, double price)
    {
        this.productID = productID;
        this.name_of_product = name_of_product;
        this.no_of_available_items = available_items;
        this.price = price;

    }

    /**
     * Setter for the productID.
     * @param productID productID identification code of the product.
     */

    public void setProductID(String productID)
    {
        this.productID = productID;
    }

    /**
     * Setter for the name_of_product
     * @param name_of_product name of the product.
     */

    public void setName_of_product(String name_of_product)
    {
        this.name_of_product = name_of_product;
    }

    /**
     * Setter for the Available_items
     * @param available_items information about items available.
     */

    public void setAvailable_items(int available_items)
    {
        this.no_of_available_items = available_items;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", name_of_product='" + name_of_product + '\'' +
                ", available_items='" + no_of_available_items + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Setter for the Price
     * @param price price of the product.
     */

    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Getter for the productID.
     * @return identification code of the product.
     */

    public String getProductID()
    {
        return productID;
    }

    /**
     * Getter for the name of the product
     * @return product name
     */

    public String getName_of_product()
    {
        return name_of_product;
    }

    /**
     * Getter for the available items
     *
     * @return information about items available.
     */

    public int getAvailable_items()
    {
        return no_of_available_items;
    }

    /**
     * Getter for the price.
     * @return price of the product.
     */

    public double getPrice()
    {
        return price;
    }

    public String toCSV()
    {
        return productID + "," + name_of_product + "," + price;
    }

    public int getProductType()
    {
        return productType;
    }

    public void setProductType(int productType)
    {
        this.productType = productType;
    }

}
