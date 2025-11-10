// Note: I had some help from ChatGPT to understand how to build the GUI and fix some errors.
// I changed some parts myself and learned how to connect buttons and menus in Java Swing.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class SalesProductGUI extends JFrame {

    private JTextArea textArea;
    private JLabel lblYearsProcessed;
    private ProductSales sales = new ProductSales();

    public SalesProductGUI() {
        setTitle("Product Sales Application");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenu menuTools = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        menuFile.add(exitItem);
        menuTools.add(loadItem);
        menuTools.add(saveItem);
        menuTools.add(clearItem);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);


        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel();
        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");
        lblYearsProcessed = new JLabel("Years Processed: ");

        bottomPanel.add(btnLoad);
        bottomPanel.add(btnSave);
        bottomPanel.add(lblYearsProcessed);

        add(bottomPanel, BorderLayout.SOUTH);


        ActionListener loadAction = e -> loadData();
        ActionListener saveAction = e -> saveData();
        ActionListener clearAction = e -> clearData();
        ActionListener exitAction = e -> System.exit(0);

        btnLoad.addActionListener(loadAction);
        btnSave.addActionListener(saveAction);
        loadItem.addActionListener(loadAction);
        saveItem.addActionListener(saveAction);
        clearItem.addActionListener(clearAction);
        exitItem.addActionListener(exitAction);
    }

    private void loadData() {
        int total = sales.GetTotalSales();
        double avg = sales.GetAverageSales();
        int over = sales.GetSalesOverLimit();
        int under = sales.GetSalesUnderLimit();
        int years = sales.GetProductsProcessed();

        textArea.setText("DATA LOG\n");
        textArea.append("**************************************\n");
        textArea.append("Total Sales: " + total + "\n");
        textArea.append("Average Sales: " + (int) avg + "\n");
        textArea.append("Sales over limit: " + over + "\n");
        textArea.append("Sales under limit: " + under + "\n");
        textArea.append("**************************************\n");

        lblYearsProcessed.setText("Years Processed: " + years);
    }

    private void saveData() {
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write(textArea.getText());
            writer.close();
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data.");
        }
    }

    private void clearData() {
        textArea.setText("");
        lblYearsProcessed.setText("Years Processed: ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SalesProductGUI().setVisible(true);
        });
    }
}
