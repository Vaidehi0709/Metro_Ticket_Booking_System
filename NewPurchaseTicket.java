package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class NewPurchaseTicket extends JFrame implements ActionListener {


    Choice departStation, destStation;
    JTextField tfpeople;
    JLabel labelUsername, labelPrice;
    JButton checkPrice, bookticket, back, pay, displayTicket;
    String username;
    JRadioButton singleJourney, returnJourney;
    JTextArea ticketArea;

    NewPurchaseTicket(String username){
        this.username = username;
        setTitle("Purchase Ticket");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        getContentPane().setBackground(new Color(230,222,255));


        //Creating the label for the purchase ticket class
        /*JLabel text = new JLabel("PURCHASE TICKET");
        text.setBounds(600, 30, 600, 30);
        text.setForeground(new Color(170, 51 ,106));
        text.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 30));
        add(text);*/


        //Creating label for the username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(20, 50, 100, 30);
        lblUsername.setForeground(new Color(108,48,130));
        lblUsername.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        add(lblUsername);

        //creating label that stores the original username
        labelUsername = new JLabel(username);
        labelUsername.setBounds(150, 50, 100, 30);
        labelUsername.setForeground(new Color(108,48,130));
        labelUsername.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        add(labelUsername);


        //label for the departure station
        JLabel lbldepart = new JLabel("Departure Station");
        lbldepart.setBounds(20, 100, 200, 30);
        lbldepart.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        lbldepart.setForeground(new Color(108,48,130));
        add(lbldepart);

        //Dropdown to select the departure stations available
        departStation = new Choice();
        departStation.setBounds(250, 100, 300, 40);
        departStation.setFont(new Font("Century Gothic", Font.PLAIN, 18));  // Adjust font size
        departStation.add("PCMC");
        departStation.add("Sant Tukaram Nagar");
        departStation.add("Bhosari");
        departStation.add("Kasarwadi");
        departStation.add("Phugewadi");
        departStation.add("Dapodi");
        departStation.add("Bopodi");
        departStation.add("Khadaki");
        departStation.add("Range Hills");
        departStation.add("Shivaji Nagar");
        departStation.add("Civil Court");
        departStation.add("Kasba Peth");
        departStation.add("Mandai");
        departStation.add("Swargate");
        departStation.add("Vanaz");
        departStation.add("Anand Nagar");
        departStation.add("Ideal Colony");
        departStation.add("Nal Stop");
        departStation.add("Garware College");
        departStation.add("Deccan Gymkhana");
        departStation.add("Chhatrapati Sambhaji Udyan");
        departStation.add("PMC");
        departStation.add("Mangalwar Peth");
        departStation.add("Pune Railway Station");
        departStation.add("Ruby Hall Clinic");
        departStation.add("Bund Garden");
        departStation.add("Yerwada");
        departStation.add("Kalyani Nagar");
        departStation.add("Ramwadi");

        add(departStation);

       //Adding image in between the depature staion and the destination station
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/interchangeStation.png"));
        Image i2 = i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(650, 80, 50, 50);
        add(icon);


        //label for the destination station
        JLabel lbldest = new JLabel("Destination Station");
        lbldest.setBounds(800, 100, 200, 30);
        lbldest.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        lbldest.setForeground(new Color(108,48,130));
        add(lbldest);

        //Dropdown to select the destination stations available
        destStation = new Choice();
        destStation.setBounds(1030, 100, 300, 40);
        destStation.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        destStation.add("PCMC");
        destStation.add("Sant Tukaram Nagar");
        destStation.add("Bhosari");
        destStation.add("Kasarwadi");
        destStation.add("Phugewadi");
        destStation.add("Dapodi");
        destStation.add("Bopodi");
        destStation.add("Khadaki");
        destStation.add("Range Hills");
        destStation.add("Shivaji Nagar");
        destStation.add("Civil Court");
        destStation.add("Kasba Peth");
        destStation.add("Mandai");
        destStation.add("Swargate");
        destStation.add("Vanaz");
        destStation.add("Anand Nagar");
        destStation.add("Ideal Colony");
        destStation.add("Nal Stop");
        destStation.add("Garware College");
        destStation.add("Deccan Gymkhana");
        destStation.add("Chhatrapati Sambhaji Udyan");
        destStation.add("PMC");
        destStation.add("Mangalwar Peth");
        destStation.add("Pune Railway Station");
        destStation.add("Ruby Hall Clinic");
        destStation.add("Bund Garden");
        destStation.add("Yerwada");
        destStation.add("Kalyani Nagar");
        destStation.add("Ramwadi");
        add(destStation);




        //Creating label for the Total no of persons
        JLabel lblpeople = new JLabel("Total Passengers");
        lblpeople.setBounds(20, 150, 220, 30);
        lblpeople.setForeground(new Color(108,48,130));
        lblpeople.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        add(lblpeople);

        //Creating a text feld for taking the input of total persons
        tfpeople = new JTextField();
        tfpeople.setBounds(250,150,200,30);
        tfpeople.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(tfpeople);


        // Radio button for single journey
        singleJourney = new JRadioButton("Single Journey");
        singleJourney.setBounds(20, 200, 200, 30);
        singleJourney.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        singleJourney.setBackground(new Color(230, 222, 255));
        singleJourney.setForeground(new Color(108,48,130));
        add(singleJourney);

        // Radio button for return journey
        returnJourney = new JRadioButton("Return Journey");
        returnJourney.setBounds(260, 200, 200, 30);
        returnJourney.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        returnJourney.setBackground(new Color(230, 222, 255));
        returnJourney.setForeground(new Color(108,48,130));
        add(returnJourney);

        // Grouping the radio buttons so that only one can be selected at a time
        ButtonGroup journeyGroup = new ButtonGroup();
        journeyGroup.add(singleJourney);
        journeyGroup.add(returnJourney);


        //Creating label for the price
        JLabel lblPrice = new JLabel("Total Price");
        lblPrice.setBounds(20, 250, 150, 30);
        lblPrice.setForeground(new Color(108,48,130));
        lblPrice.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        add(lblPrice);

        //creating label that stores the original price
        labelPrice = new JLabel();
        labelPrice.setBounds(150, 250, 200, 30);
        labelPrice.setForeground(new Color(108,48,130));
        labelPrice.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 18));
        add(labelPrice);


        //Button for checking the price of package
        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(30, 300, 220, 35);
        checkPrice.setForeground(new Color(230,230,250));
        checkPrice.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 18));
        checkPrice.setBackground(Color.DARK_GRAY);
        checkPrice.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(checkPrice);


        //Button for booking the ticket
        bookticket = new JButton("Book Ticket");
        bookticket.setBounds(260, 300, 200, 35);
        bookticket.setForeground(new Color(230,230,250 ));
        bookticket.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 18));
        bookticket.setBackground(Color.DARK_GRAY);
        bookticket.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(bookticket);


        //text area to display the ticket details
        ticketArea = new JTextArea();
        ticketArea.setBounds(20, 350, 600, 300);
        ticketArea.setBackground(new Color(204, 146, 236));
        ticketArea.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        ticketArea.setForeground(new Color(52, 4, 72));
        add(ticketArea);


        //Button for back
        back = new JButton("Back");
        back.setBounds(30, 680, 220, 40);
        back.setForeground(new Color(230,230,250));
        back.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 18));
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(back);


        //Button for pay
        pay = new JButton("Pay");
        pay.setBounds(260, 680, 200, 40);
        pay.setForeground(new Color(230,230,250 ));
        pay.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 18));
        pay.setBackground(Color.DARK_GRAY);
        pay.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(pay);


        //Adding image on the screen
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/purchaseTicket1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(700, 200, 600, 600);
        add(icon1);



        //taking the data from the database
        /*try{
            Conn c = new Conn();
            String query = "SELECT * FROM account WHERE username = '"+username+"'";
            ResultSet rs =  c.stmt.executeQuery(query);
            if (rs.next()){
                labelUsername.setText(rs.getString("username"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM account WHERE username = ?"; // Use a prepared statement
            PreparedStatement pstmt = c.con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                labelUsername.setText(rs.getString("username")); // Correctly set the username

            }
            pstmt.close(); // Close the prepared statement.
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching user data: " + e.getMessage()); // Show error
        }


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            //new Dashboard();
        }


        else if(ae.getSource() == checkPrice){
            try{
                String query = "SELECT * FROM stations where departure = '"+departStation.getSelectedItem()+"' AND destination = '"+destStation.getSelectedItem()+"'";
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery(query);

                /*Conn c = new Conn();
                String query = "SELECT singleJourney, returnJourney FROM stations WHERE departure = ? AND destination = ?";
                PreparedStatement pstmt = c.con.prepareStatement(query);
                pstmt.setString(1, departStation.getSelectedItem());
                pstmt.setString(2, destStation.getSelectedItem());
                ResultSet rs = pstmt.executeQuery();*/

                if (rs.next()){
                    int passenger = 0;
                    try{
                        if(Integer.parseInt(tfpeople.getText()) <= 10){
                            passenger = Integer.parseInt(tfpeople.getText());
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Error! Maximum passenger count is 10.");
                        }
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Please enter a valid number of passengers.");
                        return;
                    }

                    int singlePrice = Integer.parseInt(rs.getString("singleJourney"));
                    int returnPrice = Integer.parseInt(rs.getString("returnJourney"));

                    int price = 0;
                    if(singleJourney.isSelected()){
                        price = passenger * singlePrice;
                    }
                    else if(returnJourney.isSelected()){
                        price = passenger * returnPrice;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please select a journey type.");
                        return;
                    }
                    labelPrice.setText("Rs. "+ price);
                }
                else {
                    labelPrice.setText("Rs. 0");
                    JOptionPane.showMessageDialog(null, "No route found between selected stations.");
                }


            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == bookticket){
            try {
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                String depart = departStation.getSelectedItem();
                String dest = destStation.getSelectedItem();
                String journeyType = singleJourney.isSelected() ? "Single Journey" : "Return Journey";
                String passenger = tfpeople.getText();
                String price = labelPrice.getText();

                ticketArea.setText(" " );
                ticketArea.setText("Welcome to Pune Metro");
                ticketArea.append("\n\nDeparture Station: "+ depart);
                ticketArea.append("\nDestination Station: "+ dest);
                ticketArea.append("\nType of Journey: "+ journeyType);
                ticketArea.append("\nNumber of Passengers: "+passenger);
                ticketArea.append("\nTotal ticket price: "+ price);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource() == pay){

            //setVisible(false);
            new PaymentPurchaseTicket();

        }


    }


    public static void main(String[] args){

        new NewPurchaseTicket(" ");
    }
}


