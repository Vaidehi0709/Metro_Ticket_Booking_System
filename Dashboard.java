package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton purchaseTicket, rechargecard, checkBalance, stationInfo, metroTiming;
    String username ;

    Dashboard(String username){
        this.username = username;

        //Creating the frame
        setTitle("Metro ticket Booing System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        //Creating a panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(236,230,255));
        p1.setBounds(0, 0 , 1600, 60);
        add(p1);

        //Adding image at dashboard
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,50,50);
        p1.add(icon);

        //Creating a label for heading
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.DARK_GRAY);
        heading.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 30));
        p1.add(heading);

        //Creating panel for the menu
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(224,214,250));
        p2.setBounds(0, 65 , 1600, 50);
        add(p2);

        //Adding button to purcahse ticket
        purchaseTicket = new JButton("Purchase Ticket");
        purchaseTicket.setBounds(10, 10, 200, 30);
        purchaseTicket.setBackground(new Color(227,218,255));
        purchaseTicket.setForeground(new Color(85, 20, 90));
        purchaseTicket.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 20));
        //purchaseTicket.setMargin(new Insets(0, 0, 0 , 60));
        purchaseTicket.addActionListener(this);
        p2.add(purchaseTicket);


        //Adding button to recharge card
        rechargecard = new JButton("Recharge Card");
        rechargecard.setBounds(220, 10, 200, 30);
        rechargecard.setBackground(new Color(227,218,255));
        rechargecard.setForeground(new Color(85, 20, 90));
        rechargecard.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 20));
        //rechargecard.setMargin(new Insets(0, 0, 0 , 60));
        rechargecard.addActionListener(this);
        p2.add(rechargecard);

        

        //Adding button to station info
        stationInfo = new JButton("Station Info");
        stationInfo.setBounds(440, 10, 200, 30);
        stationInfo.setBackground(new Color(227,218,255));
        stationInfo.setForeground(new Color(85, 20, 90));
        stationInfo.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 20));
        //stationInfo.setMargin(new Insets(0, 0, 0 , 60));
        stationInfo.addActionListener(this);
        p2.add(stationInfo);



        //Adding button to metro timing
        metroTiming = new JButton("Metro Timing");
        metroTiming.setBounds(660, 10, 200, 30);
        metroTiming.setBackground(new Color(227,218,255));
        metroTiming.setForeground(new Color(85, 20, 90));
        metroTiming.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 20));
        //metroTiming.setMargin(new Insets(0, 0, 0 , 60));
        metroTiming.addActionListener(this);
        p2.add(metroTiming);


        //Image for trhe dashboard
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 700, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds( 0 , 100, 1650, 700);
        add(image);






        setVisible(true);


    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == purchaseTicket){
            new NewPurchaseTicket(username);
        }
        else if(ae.getSource() == rechargecard){
            new RechargeCard(username );
        }
        /*else if(ae.getSource() == checkBalance){
            new CheckBalance();
        }*/
        else if(ae.getSource() == stationInfo){
            new StationInfo(username);
        }
        else if(ae.getSource() == metroTiming){
            new MetroTiming(username);
        }
    }



    public static void main(String[] args){

        new Dashboard("");
    }
}
