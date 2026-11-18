package com.mycompany.productapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carol
 */
public class ProductApp {

    public static void main(String[] args) {

    private static class customernameList {

        private static String[] get(int row) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public customernameList() {
        }
    }

    private static class productList {

        private static String[] get(int row) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public productList() {
        }
    }

    private static class lblCount {

        private static void setText(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public lblCount() {
        }
    }
  

/**
 *
 * @author Carol
 */




public class ProductSalesApp extends JFrame {
    String name,phone;
    private final JLabel lblName = new JLabel(" Customer Name");
    private final JLabel lblproduct = new JLabel("Select Product");
    private final JLabel lblprice = new JLabel("Enter Price: ");
    private final JTextField txtName = new JTextField(15);
    private final JTextField txtproduct = new JTextField(15);
    private final JButton btnSave = new JButton("PROCESS");
    private final JButton btnExit = new JButton("EXIT");
    
    
    
    ArrayList<String[]> contactList= new ArrayList<>();
    private final Path filePath = Paths.get("data.txt");
    private final JTextArea txtDisplay =  new JTextArea(10,60);
    
    private final DefaultTableModel tblModel = null;
        private final JTable tblContacts = new JTable(tblModel);
        private final JScrollPane scrollPane = new JScrollPane(tblContacts);
        
     
    
    
    public ProductApp(){{
            this.tblModel = new DefaultTableModelImpl(new String [] {"Name" , "Product"} ,0);
        setTitle("Product App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
         setLayout(new BorderLayout());
        add(buildInputPanel(),BorderLayout.NORTH);
        add(BuildDisplayPanel(),BorderLayout.CENTER);
        
        tblContacts.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            selectProduct();
        }

                private void selectProduct() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
        });
       loadFromFile();
       displayProduct();
        setVisible(true);
    }
    private JPanel buildInputPanel(){
        JPanel panel =new JPanel(new GridLayout(2, 2, 8, 8));
        panel.setBackground(new Color(230,240,245));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("VAT"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        
        txtName.setToolTipText("Enter the customer name");
        txtPhone.setToolTipText("Enter the product name");
        
        panel.add(lblName);
        panel.add(txtName);
        PopupMenu lblProduct = null;
        panel.add(lblProduct);
        PopupMenu txtProduct = null;
        panel.add(txtProduct);
        return panel;
    }
     private JPanel BuildDisplayPanel(){
        JPanel dPanel = new JPanel (new BorderLayout());
        dPanel.setBackground(new Color(230, 240, 245));
       dPanel.setBorder(BorderFactory.createCompoundBorder(
               BorderFactory.createTitledBorder("Customer Details"),
               BorderFactory.createEmptyBorder(5,5,5,5)));
       

  
   
   dPanel.add(scrollPane ,BorderLayout.CENTER);
   return dPanel;
    }
     
     private void selectProduct() {
         int row = tblContacts.getSelectedRow();
         if ( row != -1) {
         txtName.setText(customernameList.get(row) [0]);
         txtproduct.setText(productList.get(row)[1]);
     }
     }
    private JPanel buildButtonPanel(){
        
     JPanel panel = new JPanel(new BorderLayout(10, 5));
    panel.setBackground(new Color(230, 240, 245));
    panel.setBorder(
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    );

    // Left side: contact count
    lblCount.setText("Customer Name: " + CustomerList.size());
    panel.add(lblCount, BorderLayout.WEST);

    // Right side: buttons
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.setBackground(new Color(230, 240, 245));
    

    buttonPanel.add(btnSave);
    buttonPanel.add(btnProcess);
    buttonPanel.add(btnClear);
    buttonPanel.add(btnExit);

    panel.add(buttonPanel, BorderLayout.EAST);

    btnSave.setToolTipText("Add this contact to your list");

    btnSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            name = txtName.getText().trim();
            phone = txtPhone.getText().trim();
            if (!name.isEmpty() && !phone.isEmpty()) {
                contactList.add(new String[]{name,phone});
                saveToFile();
               displayContacts();


                    }
                    txtName.setText("");
                    txtPhone.setText("");

                    JOptionPane.showMessageDialog(
                        ProductApp.this, "Customer Saved!"
                    );

        }
    });

    return panel;
    }
private void saveToFile(){
    try(BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)){
        for(String[] customer : customerList){
            writer.write(customer[0] +"\t" + customer[1]);
            writer.newLine();
        }
    }catch(IOException e)
    {
        JOptionPane.showMessageDialog(
                       this, "Error saving contacts: "+e.getMessage()
                    );
    }
}
private void loadFromFile(){
    if(!Files.exists(filePath))
    {
        return;
    }
    try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)){
        String line;
        while((line = reader.readLine())!= null){
            String[] data = line.split("\t", -1);
            if(data.length == 2){
                List.add(new String[]{data[0],data[1]});
            }
        }
    }catch (IOException e ){
         JOptionPane.showMessageDialog(
                       this, "Error reading customer name: "+e.getMessage()
                    );
    }       
}
private void displayContacts(){
    tblModel.setRowCount (0) ;
    for(String[] Customer : CustomerList){
        tblModel.addRow(new Object [] {customer [0] , customer[1]});
        
        
    }
    lblCount.setText("Customer Name: " + CustomerList.size());
}

   public static void main(String[] args) 
   { 
             new ProductsApp();
   }
}

    
    

   
        
    
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

        private void loadFromFile() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void displayProduct() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private class DefaultTableModelImpl extends DefaultTableModel {

            public DefaultTableModelImpl(Object[] columnNames, int rowCount) {
                super(columnNames, rowCount);
            }

            public boolean isProductEditable(int row, int column) {
                return false;
            }
        }
    }
