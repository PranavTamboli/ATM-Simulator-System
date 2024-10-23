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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
JButton change, back;
String pinnumber;
    public PinChange(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

JLabel text = new JLabel("CHANGE YOUR PIN");
text.setForeground(Color.white);
text.setFont(new Font("System", Font.BOLD, 16));
text.setBounds(250, 300, 500, 35);
image.add(text);

JLabel pintext = new JLabel("New Pin");
pintext.setForeground(Color.white);
pintext.setFont(new Font("System", Font.BOLD, 16));
pintext.setBounds(165, 350, 180, 35);
image.add(pintext);

pin = new JPasswordField();
pin.setFont(new Font("Raleway", Font.BOLD, 16));
pin.setBounds(330, 350, 180, 25);
image.add(pin);

JLabel repintext = new JLabel("Re-Enter New Pin");
repintext.setForeground(Color.white);
repintext.setFont(new Font("System", Font.BOLD, 16));
repintext.setBounds(165, 390, 180, 35);
image.add(repintext);

repin = new JPasswordField();
repin.setFont(new Font("Raleway", Font.BOLD, 16));
repin.setBounds(330, 390, 180, 25);
image.add(repin);

change = new JButton("Change");
change.setBounds(355, 460, 150, 35);
change.addActionListener(this);
image.add(change);

back = new JButton("Back");
back.setBounds(355, 500, 150, 35);
back.addActionListener(this);
image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == change) {
        try {
            String npin = pin.getText();
            String rpin = repin.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Enter pin doesn't match");
                return;
            }
            if(npin.equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter Pin");
            return;
            }

            if(rpin.equals("")){
            JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
            return;
            }   
             Conn c = new Conn();
             String query1 = " Update bank set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
             String query2 = " Update login set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
             String query3= " Update signupthree set pin = '"+rpin+"' where pin= '"+pinnumber+"'";

c.s.executeUpdate(query1);
c.s.executeUpdate(query2); 
c.s.executeUpdate(query3);

JOptionPane.showMessageDialog(null, "Pin Change Successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);

            
            
            } catch (Exception e) {
            System.out.println(e);
            }
            } 
             else{
        setVisible(false);
         new Transactions(pinnumber).setVisible(true);
}
}

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
