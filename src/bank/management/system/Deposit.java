package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JOptionPane;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinnumber;

    public Deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount uou want to deposit");
        text.setForeground(Color.white);
        text.setBackground(Color.RED);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 320, 700, 35);
        image.add(text);    

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 370, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(360, 500, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);
 
        back = new JButton("Back");
        back.setBounds(360, 540, 130, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,1000);
        setLocation(300,0);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == deposit) {
         String number = amount.getText();
         Date date = new Date();
         if(number.equals("")){
             JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
               try {
                 Conn c = new Conn();
                 String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "rs "+number+" Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
             } catch (Exception e) {
                System.out.println(e);
             }
            }   

    } else if(ae.getSource() == back){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
}
}

    public static void main(String[] args) {
        new Deposit("");
    }
}
