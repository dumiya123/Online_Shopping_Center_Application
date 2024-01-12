package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIHome
{
    public static void main(String[] args) {
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
        else {
            panelBlue.add(lbSize);
            panelBlue.add(lbColour);
        }
        panelBlue.add(lbAvailable);



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

        //Yellow Button - Shopping Cart
        JButton shoppingCart = new JButton("Shopping Cart");
        panelYellow.setLayout(new FlowLayout(FlowLayout.RIGHT,13,10));
        panelYellow.add(shoppingCart);
        shoppingCart.setPreferredSize(new Dimension(150,30));

        //Green Table
        String[] column={"Product ID","Name","Category","Price(C)","Info"};
        String data[][]={{"A1000","TV","Electronics","299.39","Samsaung,12 weeks warranty"},{"A1000","TV","Electronics","299.39","Samsaung,12 weeks warranty"}};

        DefaultTableModel model = new DefaultTableModel(data, column);
        //model.setRowCount(5);
        JTable table=new JTable(model);


        //table.setBounds(0,0,900,200);
        table.setRowHeight(20);
        table.sizeColumnsToFit(1);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setMinimumSize(new Dimension(700,700));
        scrollPane.setPreferredSize(new Dimension(900,900));
        panelGreen.add(scrollPane);




        JFrame frame=new JFrame("Application");
        frame.setSize(750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.add(panelRed,BorderLayout.NORTH);
        frame.add(panelGreen,BorderLayout.CENTER);
        frame.add(panelOrange,BorderLayout.SOUTH);


    }
}
