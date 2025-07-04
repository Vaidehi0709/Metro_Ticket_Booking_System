package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RechargeCard extends JFrame implements ActionListener {

    JLabel labelUsername, labelCardNumber, labelBalance;
    JTextField tfRechargeAmount;
    JButton checkBalance, rechargeCard, back;
    String username;
    JTextArea transactionArea;
    int balance = 0;
    // Use a Map to store card number and balance.  Simulates the database.
    private Map<String, Integer> cardBalances = new HashMap<>();
    private String cardNumber; // Store the generated card number

    RechargeCard(String username) {
        this.username = username;
        setTitle("Recharge Card");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        getContentPane().setBackground(new Color(230, 222, 255));

        // Creating label for the username
        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setBounds(20, 50, 200, 30);
        lblUsername.setForeground(new Color(108, 48, 130));
        lblUsername.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        add(lblUsername);

        // creating label that stores the original username
        labelUsername = new JLabel(username);  // Display the username passed to the constructor.
        labelUsername.setBounds(250, 50, 200, 30);
        labelUsername.setForeground(new Color(108, 48, 130));
        labelUsername.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        add(labelUsername);

        // Label for Card Number
        JLabel lblCardNumber = new JLabel("Card Number");
        lblCardNumber.setBounds(20, 100, 200, 30);
        lblCardNumber.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        lblCardNumber.setForeground(new Color(108, 48, 130));
        add(lblCardNumber);

        // Generate and display a random card number
        cardNumber = generateRandomCardNumber();
        labelCardNumber = new JLabel(cardNumber);
        labelCardNumber.setBounds(250, 100, 300, 40);
        labelCardNumber.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(labelCardNumber);

        // Label for Recharge Amount
        JLabel lblRechargeAmount = new JLabel("Recharge Amount");
        lblRechargeAmount.setBounds(20, 150, 200, 30);
        lblRechargeAmount.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        lblRechargeAmount.setForeground(new Color(108, 48, 130));
        add(lblRechargeAmount);

        // TextField for Recharge Amount
        tfRechargeAmount = new JTextField();
        tfRechargeAmount.setBounds(250, 150, 300, 40);
        tfRechargeAmount.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(tfRechargeAmount);

        // Label for Balance
        labelBalance = new JLabel("Current Balance: Rs. 0");
        labelBalance.setBounds(20, 200, 350, 30);
        labelBalance.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        labelBalance.setForeground(new Color(108, 48, 130));
        add(labelBalance);

        // Button to Check Balance
        checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(30, 300, 220, 35);
        checkBalance.setForeground(new Color(230, 230, 250));
        checkBalance.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 18));
        checkBalance.setBackground(Color.DARK_GRAY);
        checkBalance.addActionListener(this);
        add(checkBalance);

        // Button to Recharge Card
        rechargeCard = new JButton("Recharge Card");
        rechargeCard.setBounds(260, 300, 200, 35);
        rechargeCard.setForeground(new Color(230, 230, 250));
        rechargeCard.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 18));
        rechargeCard.setBackground(Color.DARK_GRAY);
        rechargeCard.addActionListener(this);
        add(rechargeCard);

        // text area to display the ticket details
        transactionArea = new JTextArea();
        transactionArea.setBounds(20, 350, 550, 300);
        transactionArea.setBackground(new Color(204, 146, 236));
        transactionArea.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        transactionArea.setForeground(new Color(52, 4, 72));
        add(transactionArea);

        // Button for back
        back = new JButton("Back");
        back.setBounds(30, 680, 220, 40);
        back.setForeground(new Color(230, 230, 250));
        back.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 18));
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        add(back);

        // Adding image on the screen
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/recharge_card1.png"));
        Image i5 = i4.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(600, 200, 500, 500);
        add(icon1);

        // Initialize card balances (for testing)
        cardBalances.put(cardNumber, 0);  // Initialize with 0 balance

        setVisible(true);

    }

    private String generateRandomCardNumber() {
        // Generate a 10-digit random card number
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == checkBalance) {
            if (cardBalances.containsKey(cardNumber)) {
                balance = cardBalances.get(cardNumber);
                labelBalance.setText("Current Balance: Rs. " + balance);
                transactionArea.setText("Current balance for Card Number " + cardNumber + " is Rs. " + balance + "\n");
            } else {
                JOptionPane.showMessageDialog(null, "Card not found. Please enter a valid card number.");
                labelBalance.setText("Current Balance: Rs. 0");
                transactionArea.setText("");
            }
        } else if (ae.getSource() == rechargeCard) {
            try {
                int rechargeAmount = Integer.parseInt(tfRechargeAmount.getText());
                if (rechargeAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "Recharge amount must be greater than zero.");
                    return;
                }
                if (cardBalances.containsKey(cardNumber)) {
                    balance = cardBalances.get(cardNumber);
                    balance += rechargeAmount;
                    cardBalances.put(cardNumber, balance); // Update the balance in the map
                    JOptionPane.showMessageDialog(null, "Card recharged successfully.");
                    labelBalance.setText("Current Balance: Rs. " + balance);
                    transactionArea.append("Card Number " + cardNumber + " recharged with Rs. " + rechargeAmount + "\n");
                    transactionArea.append("New balance: Rs. " + balance + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Card not found. Please enter a valid card number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid recharge amount (numeric value).");
            }
        }
    }

    public static void main(String[] args) {
        new RechargeCard(" ");  // Pass a dummy username
    }
}
