package console_application;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */
public class Clothing extends Product
{
    String size;

    public Clothing(String productID, String name, double price, String size)
    {

        super(productID, name, price);
        this.size = size;

    }
}
