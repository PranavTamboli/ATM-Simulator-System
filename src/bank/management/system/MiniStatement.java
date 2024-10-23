package bank.management.system;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame{
//    String pinnumber;
    MiniStatement(String pinnumber){
//      this.pinnumber = pinnumber;
        setTitle("Mini Statement");

        setLayout(null);
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Raleway", Font.BOLD, 20));
        bank.setBounds(130, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(40, 80, 400, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                 card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4) + "xxxxxxxx" +rs.getString("cardnumber").substring(12));

            }

        } catch (Exception e) {
          System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
            mini.setText(mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                     bal = bal + Integer.parseInt(rs.getString("amount"));
            }else {
                     bal = bal - Integer.parseInt(rs.getString("amount"));
            }
            }
              balance.setText("Your current account balance is Rs " +bal);
        } catch (Exception e) {
           System.out.println(e);      
         }

       


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");

    }
}
