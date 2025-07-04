package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MetroTiming extends JFrame implements ActionListener {

    JLabel labelUsername;
    JButton back;
    JTextArea timingsTextArea;
    String username;
    JScrollPane scrollPane;
    // Use a Map to store station details.  This replaces the database.
    private Map<String, List<String>> metroTimings = new HashMap<>();

    MetroTiming(String username) {
        this.username = username;
        setTitle("Next Metro Timings");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 222, 255));

        //Creating label for the username
        JLabel lblUsername = new JLabel("Metro Timings");
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
        timingsTextArea = new JTextArea();
        timingsTextArea.setBounds(0, 0, 700, 500);
        timingsTextArea.setBackground(new Color(240, 240, 240));
        timingsTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        timingsTextArea.setForeground(new Color(68, 114, 196));
        timingsTextArea.setEditable(false);
        timingsTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the JTextArea to a JScrollPane
        scrollPane = new JScrollPane(timingsTextArea);
        scrollPane.setBounds(20, 60, 700, 500);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
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
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/metroTiming.jpg"));
        Image i5 = i4.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(750, 150, 700, 500);
        add(icon1);

        // Initialize station details in the HashMap
        initializeMetroTimings();
        displayMetroTimings();

        setVisible(true);
    }

    private void initializeMetroTimings() {
        // Store metro timings for each station
        metroTimings.put("PCMC", List.of("08:00 AM", "08:30 AM", "09:00 AM", "09:30 AM", "10:00 AM"));
        metroTimings.put("Sant Tukaram Nagar", List.of("08:05 AM", "08:35 AM", "09:05 AM", "09:35 AM", "10:05 AM"));
        metroTimings.put("Bhosari", List.of("08:10 AM", "08:40 AM", "09:10 AM", "09:40 AM", "10:10 AM"));
        metroTimings.put("Kasarwadi", List.of("08:15 AM", "08:45 AM", "09:15 AM", "09:45 AM", "10:15 AM"));
        metroTimings.put("Phugewadi", List.of("08:20 AM", "08:50 AM", "09:20 AM", "09:50 AM", "10:20 AM"));
        metroTimings.put("Dapodi", List.of("08:25 AM", "08:55 AM", "09:25 AM", "09:55 AM", "10:25 AM"));
        metroTimings.put("Bopodi", List.of("08:30 AM", "09:00 AM", "09:30 AM", "10:00 AM", "10:30 AM"));
        metroTimings.put("Khadaki", List.of("08:35 AM", "09:05 AM", "09:35 AM", "10:05 AM", "10:35 AM"));
        metroTimings.put("Range Hills", List.of("08:40 AM", "09:10 AM", "09:40 AM", "10:10 AM", "10:40 AM"));
        metroTimings.put("Shivaji Nagar", List.of("08:45 AM", "09:15 AM", "09:45 AM", "10:15 AM", "10:45 AM"));
        metroTimings.put("Civil Court", List.of("08:50 AM", "09:20 AM", "09:50 AM", "10:20 AM", "10:50 AM"));
        metroTimings.put("Kasba Peth", List.of("08:55 AM", "09:25 AM", "09:55 AM", "10:25 AM", "10:55 AM"));
        metroTimings.put("Mandai", List.of("09:00 AM", "09:30 AM", "10:00 AM", "10:30 AM", "11:00 AM"));
        metroTimings.put("Swargate", List.of("09:05 AM", "09:35 AM", "10:05 AM", "10:35 AM", "11:05 AM"));
        metroTimings.put("Vanaz", List.of("09:10 AM", "09:40 AM", "10:10 AM", "10:40 AM", "11:10 AM"));
        metroTimings.put("Anand Nagar", List.of("09:15 AM", "09:45 AM", "10:15 AM", "10:45 AM", "11:15 AM"));
        metroTimings.put("Ideal Colony", List.of("09:20 AM", "09:50 AM", "10:20 AM", "10:50 AM", "11:20 AM"));
        metroTimings.put("Nal Stop", List.of("09:25 AM", "09:55 AM", "10:25 AM", "10:55 AM", "11:25 AM"));
        metroTimings.put("Garware College", List.of("09:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM"));
        metroTimings.put("Deccan Gymkhana", List.of("09:35 AM", "10:05 AM", "10:35 AM", "11:05 AM", "11:35 AM"));
        metroTimings.put("Chhatrapati Sambhaji Udyan", List.of("09:40 AM", "10:10 AM", "10:40 AM", "11:10 AM", "11:40 AM"));
        metroTimings.put("PMC", List.of("09:45 AM", "10:15 AM", "10:45 AM", "11:15 AM", "11:45 AM"));
        metroTimings.put("Mangalwar Peth", List.of("09:50 AM", "10:20 AM", "10:50 AM", "11:20 AM", "11:50 AM"));
        metroTimings.put("Pune Railway Station", List.of("09:55 AM", "10:25 AM", "10:55 AM", "11:25 AM", "11:55 AM"));
        metroTimings.put("Ruby Hall Clinic", List.of("10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM"));
        metroTimings.put("Bund Garden", List.of("10:05 AM", "10:35 AM", "11:05 AM", "11:35 AM", "12:05 PM"));
        metroTimings.put("Yerwada", List.of("10:10 AM", "10:40 AM", "11:10 AM", "11:40 AM", "12:10 PM"));
        metroTimings.put("Kalyani Nagar", List.of("10:15 AM", "10:45 AM", "11:15 AM", "11:45 AM", "12:15 PM"));
        metroTimings.put("Ramwadi", List.of("10:20 AM", "10:50 AM", "11:20 AM", "11:50 AM", "12:20 PM"));
    }

    private void displayMetroTimings() {
        // Iterate through the HashMap and append details to the JTextArea
        timingsTextArea.setText(""); // Clear the JTextArea before appending
        for (String stationName : metroTimings.keySet()) {
            timingsTextArea.append(stationName + ":\n");
            List<String> timings = metroTimings.get(stationName);
            for (String time : timings) {
                timingsTextArea.append("  " + time + "\n");
            }
            timingsTextArea.append("\n"); // Add a newline for spacing
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MetroTiming(" ");
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

