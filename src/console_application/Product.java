package console_application;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */

/**
 * Product class will be  the parent class for the both Electronic and Clothing classes.
 */
public class Product
{
    String productID;
    String name;
    double price;

    /**
     * Default constructor for the  Product class.
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

        this.productID=productID;

    }

    /**
     * Constructor for the Product class which accepts two parameters productID,name.
     * @param productID Specific code for identifying the product.
     * @param name name of the product.
     */

    public Product(String productID,String name)
    {

        this.productID = productID;
        this.name = name;


    }

    /**
     * Constructor for the Product class which accepts three parameters productID,name,price.
     * @param productID Specific code for identifying the product.
     * @param name name of the product.
     * @param price Price of the product.
     */

    public Product(String productID, String name, double price)
    {

        this.productID = productID;
        this.name = name;
        this.price = price;

    }

    /**
     * getter for productID
     * @return identification code of the product.
     */

    public String getProductID()
    {

        return productID;
    }

    /**
     * setter for the productID
     * @param productID identification code of the product.
     */

    public void setProductID(String productID)
    {
        this.productID = productID;
    }

    /**
     * getter for the name
     * @return name of the product.
     */

    public String getName()
    {

        return name;
    }

    /**
     * setter for the name
     * @param name  name of the product.
     */

    public void setName(String name)
    {

        this.name = name;
    }

    /**
     * getter for the price.
     * @return price of the product.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * setter for the price.
     * @param price price of the product.
     */

    public void setPrice(double price)
    {
        this.price = price;
    }
}
