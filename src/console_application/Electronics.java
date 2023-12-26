package console_application;

/**
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */

/**
 * This is the Electronics subclass .
 * Electronics subclass inherit from Product class.According to that,Product class is the super class And Parent Class.
 * This Electronics class hold specific information related to the Electronic Products.
 */
public class Electronics extends Product
{
    private String brand;
    private int warranty_duration;

    /**
     * Default constructor for the Electronics class.
     */
    public Electronics()
    {

    }

    public Electronics(String brand, int warranty_duration)
    {
        this.brand = brand;
        this.warranty_duration = warranty_duration;
    }

    public Electronics(String productID, String brand, int warranty_duration)
    {

        super(productID);
        this.brand = brand;
        this.warranty_duration = warranty_duration;
    }

    public Electronics(String productID, String name_of_product, String brand, int warranty_duration)
    {

        super(productID, name_of_product);
        this.brand = brand;
        this.warranty_duration = warranty_duration;
    }

    public Electronics(String productID, String name_of_product, String available_items, String brand, int warranty_duration)
    {

        super(productID, name_of_product, available_items);
        this.brand = brand;
        this.warranty_duration = warranty_duration;
    }

    public Electronics(String productID, String name_of_product, String available_items, double price, String brand, int warranty_duration)
    {

        super(productID, name_of_product, available_items, price);
        this.brand = brand;
        this.warranty_duration = warranty_duration;

    }













}
