package console_application;

/*
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
    private String warranty_duration;

    @Override
    public String toString()
    {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warranty_duration=" + warranty_duration +
                '}';
    }

    /**
     * Default constructor for the Electronics class.
     *
     */


    public Electronics(String productID, String name, double price, String brand)
    {

    }

    /**
     *
     * @param productID The specific id of the electronic product.
     * @param name_of_product name of the electronic product.
     * @param no_of_available_items The availability status of the electronic product.
     * @param price price of the electronic product.
     * @param brand The brand of the electronic product.
     * @param warranty_duration   warranty period of the specific electronic product.
     */

    public Electronics(String productID, String name_of_product, int no_of_available_items, double price, String brand, String warranty_duration)
    {
        super(productID, name_of_product, no_of_available_items, price);
        this.brand = brand;
        this.setProductType(1);
        this.warranty_duration = warranty_duration;
    }

    /**
     * getter for the brand.
     * @return The brand of the electronic product.
     */

    public String getBrand()
    {
        return brand;
    }

    /**
     * setter for the brand.
     * @param brand The brand of the electronic product.
     */

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    /**
     * getter for the warranty_duration.
     * @return warranty period of the specific electronic product.
     */

    public String getWarranty_duration()
    {
        return warranty_duration;
    }

    /**
     *setter for the warranty_duration
     * @param warranty_duration warranty period of the specific electronic product.
     */

    public void setWarranty_duration(String warranty_duration)
    {
        this.warranty_duration = warranty_duration;
    }



}
