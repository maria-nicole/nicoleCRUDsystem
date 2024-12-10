/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gopeznicolecrudsystem;

/**
 *
 * @author Administrator
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;


//    06 Handout 1 INHERITANCE
public class GopeznicoleCRUDsystem extends NicoleFace {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, crudPanel, mainPanel, inputPanel, pImgpanel;
    JLabel titleImg, nHead, infoLabel;
    JButton startButton, choice1, choice2, choice3, choice4, choice5, submitButton;
    JTextField idField, nameField, priceField;
    JTextArea displayArea;
   

    ArrayList<GroceryItem> items = new ArrayList<>();
    String position = "";

    //    02 Handout 1 static method
    public static void main(String[] args) {
        new GopeznicoleCRUDsystem();
    }

    public GopeznicoleCRUDsystem() {
        window = new JFrame();
        window.setSize(1000, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(pinkbg);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(55, 5, 880, 555);
        titleNamePanel.setBackground(pinkbg);
        con.add(titleNamePanel);
        
        titleImg = new JLabel();
        titleImg.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\title-1.PNG").getImage().getScaledInstance(765, 580, Image.SCALE_SMOOTH)));
        titleNamePanel.add(titleImg);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(380, 460, 200, 50);
        startButtonPanel.setBackground(eyepinkbg);

        startButton = new JButton("START");
        startButton.setBackground(eyepinkbg);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(e -> createCRUDscreen());
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);
    }

    //    01 Handout 1 method declaration
    public void createCRUDscreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        crudPanel = new JPanel();
        crudPanel.setBounds(55, 15, 880, 150);
        crudPanel.setBackground(pinkbg);
        crudPanel.setLayout(new GridLayout(1, 5));
        con.add(crudPanel);
        
       
        choice1 = new JButton();
        choice1.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\create.PNG").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        
        choice2 = new JButton();
        choice2.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\read.PNG").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        
        choice3 = new JButton();
        choice3.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\update.PNG").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        
        choice4 = new JButton();
        choice4.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\delete.PNG").getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
        
        choice5 = new JButton();
        nicoleR = new Random();
        choice5.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\n-happy.PNG").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        
        
        choice1.setBackground(pinkbg);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.setActionCommand("create");
        choice1.addActionListener(new ChoiceHandler());
        crudPanel.add(choice1);
        
        choice2.setBackground(pinkbg);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.setActionCommand("read");
        choice2.addActionListener(new ChoiceHandler());
        crudPanel.add(choice2);
        
        choice3.setBackground(pinkbg);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.setActionCommand("update");
        choice3.addActionListener(new ChoiceHandler());
        crudPanel.add(choice3);
        
        choice4.setBackground(pinkbg);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.setActionCommand("delete");
        choice4.addActionListener(new ChoiceHandler());
        crudPanel.add(choice4);
        
        choice5.setBackground(pinkbg);
        choice5.setForeground(Color.white);
        choice5.setFont(normalFont);
        choice5.setFocusPainted(false);
        choice5.setActionCommand("back");
        choice5.addActionListener(new ChoiceHandler());
        crudPanel.add(choice5);

        mainPanel = new JPanel();
        mainPanel.setBounds(55, 180, 880, 400);
        mainPanel.setBackground(darkpinkbg);
        mainPanel.setLayout(null);
        con.add(mainPanel);

        displayArea = new JTextArea();
        displayArea.setBounds(20, 40, 840, 330);
        displayArea.setFont(infoFont);
        displayArea.setBackground(darkpinkbg);
        displayArea.setForeground(Color.white);
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        mainPanel.add(displayArea);
    }
    
    private void showInputForm(String operation) {
        mainPanel.removeAll();
        crudPanel.setBounds(55, 15, 880, 150);
        mainPanel.setBounds(55, 180, 880, 400);
        mainPanel.repaint();
        mainPanel.revalidate();

        inputPanel = new JPanel();
        inputPanel.setBounds(20, 15, 840, 360);
        inputPanel.setBackground(darkpinkbg);
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10)); 
        mainPanel.add(inputPanel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(normalFont);
        idLabel.setForeground(Color.WHITE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(normalFont);
        nameLabel.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(normalFont);
        priceLabel.setForeground(Color.WHITE);

        idField = new JTextField();
        idField.setFont(normalFont);
        idField.setBackground(Color.LIGHT_GRAY);
        idField.setForeground(Color.BLACK);

        nameField = new JTextField();
        nameField.setFont(normalFont);
        nameField.setBackground(Color.LIGHT_GRAY);
        nameField.setForeground(Color.BLACK);

        priceField = new JTextField();
        priceField.setFont(normalFont);
        priceField.setBackground(Color.LIGHT_GRAY);
        priceField.setForeground(Color.BLACK);

        JComboBox<String> itemSelector = new JComboBox<>();
        itemSelector.setFont(normalFont); 
        itemSelector.setBackground(Color.LIGHT_GRAY); 
        itemSelector.setForeground(Color.BLACK);

        if (!operation.equals("create")) {
            for (GroceryItem item : items) {
                itemSelector.addItem(item.getId() + ": " + item.getName());
            }

            itemSelector.addActionListener(e -> {
                int selectedIndex = itemSelector.getSelectedIndex();
                if (selectedIndex >= 0) {
                    GroceryItem selectedItem = items.get(selectedIndex);
                    idField.setText(String.valueOf(selectedItem.getId()));
                    nameField.setText(selectedItem.getName());
                    priceField.setText(String.valueOf(selectedItem.getPrice()));
                }
            });
        }

        submitButton = new JButton();
        submitButton.setFont(normalFont);
        submitButton.setBackground(eyepinkbg);
        submitButton.setForeground(Color.WHITE);
        submitButton.setActionCommand(operation);
        submitButton.addActionListener(new FormSubmitHandler());

        switch (operation) {
            case "create":
                submitButton.setText("Add Item");
                break;
            case "update":
                submitButton.setText("Save Changes");
                break;
            case "delete":
                submitButton.setText("Delete Item");
                break;
        }

        if (!operation.equals("create")) {
            inputPanel.add(new JLabel("Select Item:"));
            inputPanel.add(itemSelector);
        }
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        inputPanel.add(new JLabel()); // Empty cell
        inputPanel.add(submitButton);
    }


    private void displayItems() {
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        StringBuilder displayText = new StringBuilder("Items in Inventory:\n");
        if (items.isEmpty()) {
            displayText.append("No items found.");
        } else {
            for (GroceryItem item : items) {
                displayText.append(item.toString()).append("\n");
            }
        }
        displayArea.setText(displayText.toString());
        mainPanel.add(displayArea);
    }

    //    08 Handout 1  INTERFACES (ActionListener is a listener interface part of java.awt package)
    private class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            position = command;

            switch (command) {
                case "create":
                case "update":
                    showInputForm(command);
                    break;
                case "read":
                    displayItems();
                    break;
                case "delete":
                    showInputForm(command);
                    break;
                case "back":
                    int rand_int = nicoleR.nextInt(2);
                    if (rand_int==1) {
                        choice5.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\n-happy.PNG").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    } else {
                        choice5.setIcon(new ImageIcon(new ImageIcon("D:\\schootsti-BT303\\OOP\\CRUD GROCERY NICOLE\\nicoleCRUDsystem\\src\\main\\java\\images\\n-pout.PNG").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    }

                    break;
            }
        }
    }

    private class FormSubmitHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String operation = e.getActionCommand();
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());

            switch (operation) {
                case "create":
                    items.add(new GroceryItem(id, name, price));
                    JOptionPane.showMessageDialog(window, "Item added successfully!");
                    break;
                case "update":
                    for (GroceryItem item : items) {
                        if (item.getId() == id) {
                            item.setName(name);
                            item.setPrice(price);
                            JOptionPane.showMessageDialog(window, "Item updated successfully!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(window, "Item not found!");
                    break;
                case "delete":
                    items.removeIf(item -> item.getId() == id);
                    JOptionPane.showMessageDialog(window, "Item deleted successfully!");
                    break;
            }
        }
    }
}
