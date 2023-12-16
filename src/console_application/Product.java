package console_application;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */

/**
 * Product class will be  the parent class for the both
 */
public class Product
{
    String productID;
    String name;
    double price;

    public Product(String productID, String name, double price)
    {

        this.productID = productID;
        this.name = name;
        this.price = price;

    }

    public String getProductID()
    {

        return productID;
    }

    public void setProductID(String productID)
    {

        this.productID = productID;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {

        this.price = price;
    }
}
