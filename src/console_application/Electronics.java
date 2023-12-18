package console_application;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */
public class Electronics extends Product
{
    String brand;

    public Electronics(String productID, String name, double price, String brand)
    {

        super(productID, name, price);
        this.brand = brand;

    }
}
