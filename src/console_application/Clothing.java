package console_application;

/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage
 @version 1 Console application
 */
public class Clothing extends Product
{
    String size;
    String colour;

    /**
     * Default constructor for the Clothing class.
     */

    public Clothing(String productID, String name, double price, String size)
    {

    }

    /**
     *
     * @param productID The specific id of the clothing product.
     * @param name_of_product name of the clothing product.
     * @param no_of_available_items The availability status of the clothing product.
     * @param price  price of the clothing product.
     * @param size size of the clothing product.
     * @param colour colour of the clothing product.
     */

    public Clothing(String productID, String name_of_product, int no_of_available_items, double price, String size, String colour)
    {
        super(productID, name_of_product, no_of_available_items, price);
        this.setProductType(2);
        this.size = size;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    /**
     * getter for size of the clothing product.
     * @return size of the clothing product.
     */

    public String getSize()
    {
        return size;
    }

    /**
     * setter for size of the clothing product.
     * @param size size of the clothing product.
     */

    public void setSize(String size)
    {
        this.size = size;
    }

    /**
     * getter for the color of the product.
     * @return the color of the product.
     */

    public String getColour()
    {
        return colour;
    }

    /**
     * setter for the color of the product.
     * @param colour the color of the product.
     */

    public void setColour(String colour)
    {
        this.colour = colour;
    }


    /**
     *
     * @return
     */
    public String toCsv()
    {
        return super.toCSV() + " , " + size + "CLOTHING";
    }

}
