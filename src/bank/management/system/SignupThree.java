package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.util.*;
import javax.swing.JOptionPane;

public class SignupThree extends JFrame implements ActionListener{

        JRadioButton r1,r2,r3,r4;
        JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JButton submit, cancel;
        String formno;

       SignupThree(String formno) {
       this.formno = formno;
        setLayout(null);
 
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22)); 
        l1.setBounds(300, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22)); 
        type.setBounds(100,140, 200, 40);
        add(type);

r1 = new JRadioButton("Saving Account");
r1.setFont(new Font("Raleway", Font.BOLD, 16));
r1.setBackground(Color.white);
r1.setBounds(100, 180, 250, 40);
add(r1);

r2 = new JRadioButton("Fixed Deposit Account");
r2.setFont(new Font("Raleway", Font.BOLD, 16));
r2.setBackground(Color.white);
r2.setBounds(350, 180, 250, 40);
add(r2);

r3 = new JRadioButton("Current Account");
r3.setFont(new Font("Raleway", Font.BOLD, 16));
r3.setBackground(Color.white);
r3.setBounds(100, 220, 250, 40);
add(r3);

r4 = new JRadioButton("Recurring Deposit Account");
r4.setFont(new Font("Raleway", Font.BOLD, 16));
r4.setBackground(Color.WHITE);
r4.setBounds(350, 220, 250, 40);
add(r4);



        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22)); 
        card.setBounds(100,300, 200, 40);
        add(card);

        JLabel number = new JLabel("xxxx-xxxx-xxxx-1234 ");
        number.setFont(new Font("Raleway", Font.BOLD, 22)); 
        number.setBounds(330,300, 250, 40);
        add(number);

        JLabel carddetail = new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 16)); 
        carddetail.setBounds(100,320, 200, 40);
        add(carddetail);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22)); 
        pin.setBounds(100, 360, 200, 40);
        add(pin);

        JLabel pindetail = new JLabel("Your 16 digit password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 16)); 
        pindetail.setBounds(100, 380, 200, 40);
        add(pindetail);


        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 26)); 
        pnumber.setBounds(330,360, 200, 40);
        add(pnumber);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22)); 
        services.setBounds(100, 440, 200, 40);
        add(services);


c1 = new JCheckBox("ATM CARD");
c1.setBackground(Color.white);
c1.setFont(new Font("Raleway", Font.BOLD, 16));
c1.setBounds(100, 500, 200, 40);
add(c1);

c2 = new JCheckBox("INTERNATING BANKING");
c2.setBackground(Color.white);
c2.setFont(new Font("Raleway", Font.BOLD, 16));
c2.setBounds(350, 500, 200, 40);
add(c2);

c3 = new JCheckBox("MOBILE BANKING");
c3.setBackground(Color.white);
c3.setFont(new Font("Raleway", Font.BOLD, 16));
c3.setBounds(100, 550, 200, 40);
add(c3);

c4 = new JCheckBox("EMAIL & ALERT");
c4.setBackground(Color.white);
c4.setFont(new Font("Raleway", Font.BOLD, 16));
c4.setBounds(350, 550, 200, 40);
add(c4);

c5 = new JCheckBox("CHECK BOOK");
c5.setBackground(Color.white);
c5.setFont(new Font("Raleway", Font.BOLD, 16));
c5.setBounds(100, 600, 200, 40);
add(c5);

c6 = new JCheckBox("E-STATEMENT");
c6.setBackground(Color.white);
c6.setFont(new Font("Raleway", Font.BOLD, 16));
c6.setBounds(350, 600, 200, 40);
add(c6);

c7 = new JCheckBox("I hereby declare that the above details are correct to the rest of my knowledge");
c7.setBackground(Color.white);
c7.setFont(new Font("Raleway", Font.BOLD, 16));
c7.setBounds(100, 700, 700, 40);
add(c7);

submit = new JButton("Submit");
submit.setBackground(Color.black);
submit.setForeground(Color.white);
submit.setFont(new Font("Raleway", Font.BOLD, 14));
submit.setBounds(300, 780, 100, 40);
submit.addActionListener(this);
add(submit);

cancel = new JButton("Cancel");
cancel.setBackground(Color.black);
cancel.setForeground(Color.white);
cancel.setFont(new Font("Raleway", Font.BOLD, 14));
cancel.setBounds(460, 780, 100, 40);
cancel.addActionListener(this);
add(cancel);

getContentPane().setBackground(Color.white);

        setSize(850,900);
        setLocation(350, 0);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae){
if (ae.getSource() == submit){
String accountType = null;
if(r1.isSelected()){
accountType = "Saving Account";
}
else if(r2.isSelected()){
accountType = "Fixed Deposit Account";
}
else if(r3.isSelected()){
accountType = "Current Account"; 
}
else if(r2.isSelected()){
accountType = "Recurring Deposit Account";
}

Random r = new Random();
String cardnumber = "" +Math.abs((r.nextLong() % 90000000) + 5040936000000000L);
String pinnumber = "" + Math.abs((r.nextLong() % 9000L) + 1000L);

String facility = "";
if(c1.isSelected()){
facility = facility + "ATM Card";
}
else if(c2.isSelected()){
facility = facility + "Internat Banking";
}
else if(c3.isSelected()){
facility = facility + "Mobile Banking";
}
else if(c4.isSelected()){
facility = facility + "Email & sms Alert";
}
else if(c5.isSelected()){
facility = facility + "Cheque Book ";
}
else if(c6.isSelected()){
facility = facility + "E-statement ";
}

try{
if(accountType.equals("")){
    JOptionPane.showMessageDialog(null, "Account type is required");
}
else{
Conn c = new Conn();
String query1 = "insert into signupthree Values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
String query2 = "insert into login Values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
c.s.execute(query1);
c.s.execute(query2);

JOptionPane.showMessageDialog(null, "card number: " + cardnumber +"\n pin: " +pinnumber);

    setVisible(false);
new Deposit(pinnumber).setVisible(true);

}
}
catch(Exception e){
System.out.println(e);
}

}
else if(ae.getSource() == cancel){
    setVisible(false);
new Login().setVisible(true);
}

}

    public static void main(String[] args) {
        new SignupThree("");
    }
}
