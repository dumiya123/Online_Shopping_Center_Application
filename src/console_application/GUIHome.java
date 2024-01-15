package console_application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage.
 @version 2 GUI application.
 */

public class GUIHome extends JFrame
{
    public GUIHome()
    {
        setTitle("Westminster Shopping Center");
        initializeComponents();

    }

    private void initializeComponents()
    {
        //Red - Top
        JPanel panelRed=new JPanel();
        panelRed.setPreferredSize(new Dimension(0,100));
        panelRed.setBackground(Color.RED);
        panelRed.setLayout(new BoxLayout(panelRed,BoxLayout.X_AXIS));

        //Green - Center
        JPanel panelGreen=new JPanel();
        panelGreen.setPreferredSize(new Dimension());
        panelGreen.setBackground(Color.GREEN);

        //Orange - Bottom
        JPanel panelOrange=new JPanel();
        panelOrange.setPreferredSize(new Dimension(0,325));
        panelOrange.setBackground(Color.ORANGE);
        panelOrange.setLayout(new BoxLayout(panelOrange,BoxLayout.Y_AXIS));

        //Pink - Top Left
        JPanel panelPink=new JPanel();
        panelPink.setPreferredSize(new Dimension(450,0));
        panelPink.setBackground(Color.PINK);
        panelRed.add(panelPink);
        panelPink.setLayout(new FlowLayout(FlowLayout.LEFT,40,30));


        //Label - Select Product Type
        JLabel lb=new JLabel("Select Product Category ");
        panelPink.add(lb);

        //ComboBox -DropDown
        String proType[]={"All","Electronics","Clothing"};
        JComboBox dropDown=new JComboBox(proType);
        dropDown.setPreferredSize(new Dimension(150,30));
        panelPink.add(dropDown);

        //Yellow - Top Right
        JPanel panelYellow=new JPanel();
        panelYellow.setPreferredSize(new Dimension(300,0));
        panelYellow.setBackground(Color.YELLOW);
        panelRed.add(panelYellow);

        //Blue - Bottom Upper
        JPanel panelBlue=new JPanel();
        panelBlue.setPreferredSize(new Dimension(0,250));
        panelBlue.setBackground(Color.white);
        panelOrange.add(panelBlue);
        panelBlue.setLayout(new GridLayout(7,1,10,10));
        panelBlue.setBorder(BorderFactory.createEmptyBorder(10,40,0,0));


        //Label List

        Label lbHead=new Label("Selected Product - Details");
        Font newLabelFont=new Font("Arial",Font.BOLD,12);
        lbHead.setFont(newLabelFont);
        Label lbId=new Label("Product Id :");
        Label lbName=new Label("Name :");
        Label lbCategory=new Label("Category :");
        Label lbAvailable=new Label("Items Available :");

        Label lbSize=new Label("Size :");
        Label lbColour=new Label("Colour :");

        Label lbWarranty=new Label("Warranty :");
        Label lbBrand=new Label("Brand :");

        panelBlue.add(lbHead);
        panelBlue.add(lbId);
        panelBlue.add(lbCategory);
        panelBlue.add(lbName);


        if(true)
        {
            panelBlue.add(lbBrand);
            panelBlue.add(lbWarranty);
        }
        else
        {
            panelBlue.add(lbSize);
            panelBlue.add(lbColour);
        }
        panelBlue.add(lbAvailable);


        //Yellow Button - Shopping Cart
        JButton shoppingCart = new JButton("Shopping Cart");
        panelYellow.setLayout(new FlowLayout(FlowLayout.RIGHT,13,10));
        panelYellow.add(shoppingCart);
        shoppingCart.setPreferredSize(new Dimension(150,30));

        shoppingCart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Shopping_Cart_GUI shoppingCartGui=new Shopping_Cart_GUI();
                shoppingCartGui.setVisible(true);

            }
        });


        //Green Table
        String[] column={"Product ID","Name","Category","Price(C)","Info"};
        DefaultTableModel model = new DefaultTableModel(column,0);
        String[] rowData = new String[5];
        for(Product i:WestminsterShoppingManager.products)
        {
            rowData[0] = i.getProductID();
            rowData[1] = i.getName_of_product();
            if(i instanceof Electronics)
            {
                rowData[2] ="Electronics";
            }
            else{
                rowData[2] ="Clothing";
            }
            rowData[3] = String.valueOf(i.getPrice());
            rowData[4] = getProductInfo(i);
            model.addRow(rowData);
        }
        //model.setRowCount(5);
        JTable table=new JTable(model);


        //table.setBounds(0,0,900,200);
        table.setRowHeight(20);
        table.sizeColumnsToFit(1);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setMinimumSize(new Dimension(700,700));
        scrollPane.setPreferredSize(new Dimension(900,900));
        panelGreen.add(scrollPane);


        //Purple Bottom Lower
        JPanel panelPurple=new JPanel();
        panelPurple.setPreferredSize(new Dimension(0,75));
        panelPurple.setBackground(new Color(128,0,128));
        panelOrange.add(panelPurple);

        //Add to Shopping Cart Button
        JButton addToCart=new JButton("Add to Shopping Cart");
        panelPurple.setLayout(new FlowLayout(1,10,25));
        panelPurple.add(addToCart);
        addToCart.setPreferredSize(new Dimension(200,30));
        ShoppingCart cart=new ShoppingCart();
        addToCart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selectedRow = table.getSelectedRow();
                String selectedProductID = (String) table.getValueAt(selectedRow, 0);
                Product selectedProduct = findSelectedProduct(selectedProductID);
                String quantity = JOptionPane.showInputDialog(GUIHome.this, "Enter Quantity");
                cart.add_Product(selectedProduct, Integer.parseInt(quantity));
            }
        });


        JFrame frame=new JFrame("Application");
        frame.setSize(1000,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.add(panelRed,BorderLayout.NORTH);
        frame.add(panelGreen,BorderLayout.CENTER);
        frame.add(panelOrange,BorderLayout.SOUTH);
    }
    public String getProductInfo(Product product) {
        if (product instanceof Electronics) {
            String info = ((Electronics) product).getBrand() + ", " + ((Electronics) product).getWarranty_duration();
            return info;
        }
        else if (product instanceof Clothing) {
            String info = ((Clothing) product).getSize() + ", " + ((Clothing) product).getColour();
            return info;
        }
        return "No Info";
    }
    public Product findSelectedProduct(String productID) {
        for (Product product : WestminsterShoppingManager.products) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }
}