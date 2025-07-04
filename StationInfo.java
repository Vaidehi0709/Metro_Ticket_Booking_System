package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class StationInfo extends JFrame implements ActionListener {

    JLabel labelUsername;
    JButton back;
    JTextArea stationInfoTextArea;
    String username;
    JScrollPane scrollPane;
    // Use a Map to store station details.  This replaces the database.
    private Map<String, String> stationDetails = new HashMap<>();

    StationInfo(String username) {
        this.username = username;
        setTitle("Station Information");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 222, 255));

        //Creating label for the username
        JLabel lblUsername = new JLabel("Station Information");
        lblUsername.setBounds(20, 20, 250, 30);
        lblUsername.setForeground(new Color(108,48,130));
        lblUsername.setFont(new Font("CENTURY GOTHIC", Font.BOLD, 20));
        add(lblUsername);

        //creating label that stores the original username
        labelUsername = new JLabel(username);
        labelUsername.setBounds(150, 50, 100, 30);
        labelUsername.setForeground(new Color(108,48,130));
        labelUsername.setFont(new Font("CENTURY GOTHIC", Font.PLAIN, 20));
        add(labelUsername);

        // Text area to display station information
        stationInfoTextArea = new JTextArea();
        stationInfoTextArea.setBounds(0, 0, 700, 500);
        stationInfoTextArea.setBackground(new Color(240, 240, 240)); // Lighter background
        stationInfoTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 16)); // Slightly smaller font
        stationInfoTextArea.setForeground(new Color(68, 114, 196)); // Darker blue text
        stationInfoTextArea.setEditable(false);
        stationInfoTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding

        // Add the JTextArea to a JScrollPane
        scrollPane = new JScrollPane(stationInfoTextArea);
        scrollPane.setBounds(20, 60, 700, 500); // Shifted down
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153))); // Added border
        add(scrollPane);

        //Button for back
        back = new JButton("Back");
        back.setBounds(20, 580, 200, 40);
        back.setForeground(new Color(230,230,250));
        back.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 18));
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        add(back);

        // Adding image on the screen
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Metro_Station.jpg"));
        Image i5 = i4.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(750, 150, 700, 500);
        add(icon1);

        // Initialize station details in the HashMap
        initializeStationDetails();
        displayAllStationInfo();

        setVisible(true);
    }

    private void initializeStationDetails() {
        // Store station details with names.  Added more formatting for better readability in the text area.
        stationDetails.put("PCMC", "PCMC Station Details:\n  Platforms: 2\n  Facilities: Parking, Restrooms\n\n");
        stationDetails.put("Sant Tukaram Nagar", "Sant Tukaram Nagar Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Bhosari", "Bhosari Station Details:\n  Platforms: 2\n  Facilities: Parking, Food Stalls\n\n");
        stationDetails.put("Kasarwadi", "Kasarwadi Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Phugewadi", "Phugewadi Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Dapodi", "Dapodi Station Details:\n  Platforms: 2\n  Facilities: Parking\n\n");
        stationDetails.put("Bopodi", "Bopodi Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Khadaki", "Khadaki Station Details:\n  Platforms: 2\n  Facilities: Food Stalls\n\n");
        stationDetails.put("Range Hills", "Range Hills Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Shivaji Nagar", "Shivaji Nagar Station Details:\n  Platforms: 4\n  Facilities: Parking, Restrooms, Food Stalls, Shopping\n\n");
        stationDetails.put("Civil Court", "Civil Court Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Kasba Peth", "Kasba Peth Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Mandai", "Mandai Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Swargate", "Swargate Station Details:\n  Platforms: 4\n  Facilities: Parking, Restrooms, Food Stalls\n\n");
        stationDetails.put("Vanaz", "Vanaz Station Details:\n  Platforms: 2\n  Facilities: Parking, Restrooms\n\n");
        stationDetails.put("Anand Nagar", "Anand Nagar Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Ideal Colony", "Ideal Colony Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Nal Stop", "Nal Stop Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Garware College", "Garware College Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Deccan Gymkhana", "Deccan Gymkhana Station Details:\n  Platforms: 2\n  Facilities: Food Stalls\n\n");
        stationDetails.put("Chhatrapati Sambhaji Udyan", "Chhatrapati Sambhaji Udyan Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("PMC", "PMC Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Mangalwar Peth", "Mangalwar Peth Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Pune Railway Station", "Pune Railway Station Details:\n  Platforms: 4\n  Facilities: Parking, Restrooms, Food Stalls, Shopping\n\n");
        stationDetails.put("Ruby Hall Clinic", "Ruby Hall Clinic Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Bund Garden", "Bund Garden Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Yerwada", "Yerwada Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
        stationDetails.put("Kalyani Nagar", "Kalyani Nagar Station Details:\n  Platforms: 2\n  Facilities: Parking\n\n");
        stationDetails.put("Ramwadi", "Ramwadi Station Details:\n  Platforms: 2\n  Facilities: Restrooms\n\n");
    }

    private void displayAllStationInfo() {
        // Iterate through the HashMap and append details to the JTextArea
        stationInfoTextArea.setText(""); // Clear the JTextArea before appending
        for (String stationName : stationDetails.keySet()) {
            String details = stationDetails.get(stationName);
            stationInfoTextArea.append(details);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StationInfo(" ");
    }

    // Custom border class for rounded corners
    private static class RoundBorder extends javax.swing.border.AbstractBorder {
        private int radius;

        RoundBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(c.getForeground()); // Use button's foreground color
            g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius / 2, radius / 2, radius / 2, radius / 2);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = radius / 2;
            return insets;
        }
    }
}
