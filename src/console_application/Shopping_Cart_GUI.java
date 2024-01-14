package console_application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Shopping_Cart_GUI extends JFrame
{

    public Shopping_Cart_GUI()
    {
        String[] columnNames = {"Product", "Size", "Color", "Quantity", "Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add some data to the table model
        Object[] row1 = {"B201", "M", "Black", 2, 45.80};
        Object[] row2 = {"B001", "S", "White", 1, 39.99};
        model.addRow(row1);
        model.addRow(row2);

        // Create the table using the table model
        JTable table = new JTable(model);

        // Set the table's row height
        table.setRowHeight(30);

        // Set the table's column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);

        // Create the scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Create the frame and add the scroll pane to it
        JFrame frame = new JFrame();
        frame.add(scrollPane, BorderLayout.CENTER);

        // Set the frame's title, size, and default close operation
        frame.setTitle("Shopping Cart");
        frame.setSize(500, 300); // Increase size for better visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set minimum size to enforce responsiveness
        frame.setMinimumSize(new Dimension(400, 200));

        // Show the frame
        frame.setVisible(true);

        JLabel lablel_one=new JLabel("Total");
        lablel_one.setSize(200,200);
        frame.add(lablel_one);





    }

    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(() -> new Shopping_Cart_GUI());

    }
}


