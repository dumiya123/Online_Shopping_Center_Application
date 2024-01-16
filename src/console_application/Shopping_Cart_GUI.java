/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 Object-Oriented Programming Coursework L5 sem 1
 @author Dumindu Induwara Gamage.
 @version 2 GUI application.
 */

package console_application;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * Represents a simple shopping cart GUI application .
 */
public class Shopping_Cart_GUI extends JFrame
{

    public Shopping_Cart_GUI()
    {
        // Define column names for the table
        String[] columnNames = {"Product", "Quantity", "Price"};
        // Create a table model with initial data from ShoppingCart class
        DefaultTableModel model = new DefaultTableModel(ShoppingCart.getProducts(), columnNames);

        // Create the table using the table model
        JTable table = new JTable(model);

        // Set the table's row height
        table.setRowHeight(30);

        // Set the table's column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);

        // Create the scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the label
        String total = String.format("Total\t\t\t%.2f", ShoppingCart.calculate_total_cost());
        JTextArea label_one = new JTextArea(total);

        // Set the frame's layout manager to GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Set constraints for the scroll pane
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

        // Set constraints for the label
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(label_one, gbc);

        // Set the frame's title, size, and default close operation
        setTitle("Shopping Cart");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set minimum size to enforce responsiveness
        setMinimumSize(new Dimension(400, 200));

        // Show the frame
        setVisible(true);


    }

    /**
     * Main method to create and display the Shopping_Cart_GUI.
     * @param args Command line arguments (not used).
     */

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Shopping_Cart_GUI());
    }
}



