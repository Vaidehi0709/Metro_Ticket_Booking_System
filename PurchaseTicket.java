package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseTicket extends JFrame implements ActionListener {


    JTextArea displayTicket;
    JButton back, pay, purchaseTicket;
    JTextField tfdest, tfdepart;


    PurchaseTicket(){
        setTitle("Purchase Ticket");

        setBounds(400, 150, 900, 650);
        setLayout(null);
        getContentPane().setBackground(new Color(230,222,255));

        //label for the departure station
        JLabel lbldepart = new JLabel("Departure Station");
        lbldepart.setBounds(20, 30, 200, 30);
        lbldepart.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        add(lbldepart);

        //textbox for the departure station
        tfdepart = new JTextField();
        tfdepart.setBounds(240,30,300,30);
        tfdepart.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        tfdepart.setBorder(BorderFactory.createEmptyBorder());
        add(tfdepart);


        //label for the destination station
        JLabel lbldest = new JLabel("Destination Station");
        lbldest.setBounds(20, 100, 200, 30);
        lbldest.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        add(lbldest);

        //textbox for the destination station
        tfdest = new JTextField();
        tfdest.setBounds(240,100,300,30);
        tfdest.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        tfdest.setBorder(BorderFactory.createEmptyBorder());
        add(tfdest);



        // Radio button for single journey
        JRadioButton singleJourney = new JRadioButton("Single Journey");
        singleJourney.setBounds(20, 170, 200, 30);
        singleJourney.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        singleJourney.setBackground(new Color(230, 222, 255));
        add(singleJourney);

        // Radio button for return journey
        JRadioButton returnJourney = new JRadioButton("Return Journey");
        returnJourney.setBounds(240, 170, 200, 30);
        returnJourney.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        returnJourney.setBackground(new Color(230, 222, 255));
        add(returnJourney);

        // Grouping the radio buttons so that only one can be selected at a time
        ButtonGroup journeyGroup = new ButtonGroup();
        journeyGroup.add(singleJourney);
        journeyGroup.add(returnJourney);


        //Adding the purchase ticket button
        purchaseTicket = new JButton("Purchase Ticket");
        purchaseTicket.setBounds(20, 210, 200, 30);
        purchaseTicket.setForeground(new Color(230, 222, 255 ));
        purchaseTicket.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 14));
        purchaseTicket.setBackground(Color.DARK_GRAY);
        purchaseTicket.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(purchaseTicket);

        //Text area to display the ticket
        displayTicket = new JTextArea();
        displayTicket.setBounds(50,250, 500, 250);
        displayTicket.setEditable(false);
        add(displayTicket);


        //Adding the pay button
        pay = new JButton("Pay");
        pay.setBounds(20, 530, 100, 50);
        pay.setForeground(new Color(230, 222, 255 ));
        pay.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 14));
        pay.setBackground(Color.DARK_GRAY);
        pay.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(pay);


        //Adding the back button
        back = new JButton("Back");
        back.setBounds(150, 530, 100, 50);
        back.setForeground(new Color(230, 222, 255  ));
        back.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 14));
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(back);


        setVisible(true);


    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){

            setVisible(false);
            new PaymentPurchaseTicket();

        }
        else if(ae.getSource() == back){

            setVisible(false);
            new Dashboard("");
        }
        else if (ae.getSource() == purchaseTicket) {
            String depart = tfdepart.getText();
            String dest = tfdest.getText();

            displayTicket.setText("Departure Station: "+ depart);
            displayTicket.setText("Destination Station: "+ dest );


        }
    }


    public static void main(String[] args){

        new PurchaseTicket();

    }
}
