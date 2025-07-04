package MetroTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPurchaseTicket extends JFrame implements ActionListener {

    JButton back;

    PaymentPurchaseTicket(){
        //cretaiing the frame
        setBounds(500, 200 , 800 ,600);
        setLayout(null);
        getContentPane().setBackground(new Color(230,222,255));


        //Creating a text pane where we will load the complete site
        //It can be done in two ways using text area and text pane but adding the scrollbAr in the text area is difficult
        //So we use pane
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);//so that the pane is not editable

        try{
            //To load a particular page in pane we use the setpage
            pane.setPage("https://paytm.com/rent-payment");

        }
        catch (Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could Not Load, Error 404</html>");
        }

        //Adding the scrollbar
        JScrollPane sp = new JScrollPane(pane);
        sp.setBounds(0, 0, 800, 600);
        getContentPane().add(sp);


        //button for back
        back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.setForeground(new Color(230, 222, 255 ));
        back.setFont(new Font("CENTURY GOTHIC" , Font.BOLD, 14));
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        //create.setBorder(new LineBorder(new Color(170, 51 ,106)));
        pane.add(back);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            //new NewPurchaseTicket(" ");

        }
    }


    public static void main(String [] arg){
        new PaymentPurchaseTicket();
    }
}
