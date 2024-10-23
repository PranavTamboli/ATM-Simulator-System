package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{

long random;
JTextField nametextfield, fnametextfield, dobtextfield, emailtextfield, addresstextfield, citytextfield, statetextfield, pintextfield;
JButton next;
JRadioButton male, female, other, married, unmarried;
JDateChooser datechooser;


Signupone() {
    setLayout(null);

Random r = new Random();
random =Math.abs((r.nextLong() % 9000L) + 1000L );

JLabel Formno = new JLabel("Application Form No. " +random);
Formno.setFont(new Font("Raleway", Font.BOLD,38));
Formno.setBounds(140, 20, 600, 40);
add(Formno);

JLabel personaldetails = new JLabel("Page 1 : Personal Details");
personaldetails.setFont(new Font("Raleway", Font.BOLD,28));
personaldetails.setBounds(220, 80, 380, 40);
add(personaldetails);

JLabel Name = new JLabel("Name: ");
Name.setFont(new Font("Raleway", Font.BOLD,28));
Name.setBounds(100, 140, 100, 30);
add(Name);

nametextfield = new JTextField();
nametextfield.setFont(new Font("Raleway", Font.BOLD, 38));
nametextfield.setBounds(300, 140, 400, 35);
add(nametextfield);

JLabel fname = new JLabel("Father Name: ");
fname.setFont(new Font("Raleway", Font.BOLD,28));
fname.setBounds(100, 200, 200, 30);
add(fname);

fnametextfield = new JTextField();
fnametextfield.setFont(new Font("Raleway", Font.BOLD, 38));
fnametextfield.setBounds(300, 200, 400, 35);
add(fnametextfield);

JLabel dob = new JLabel("Date of Birth: ");
dob.setFont(new Font("Raleway", Font.BOLD,28));
dob.setBounds(100, 260, 200, 30);
add(dob);

datechooser = new JDateChooser();
datechooser.setBounds(300, 260, 400, 30);
add(datechooser);

JLabel gender = new JLabel("Gender: ");
gender.setFont(new Font("Raleway", Font.BOLD,28));
gender.setBounds(100, 320, 200, 35);
add(gender);

male = new JRadioButton("male");
male.setBounds(300, 320, 60, 30);
male.setBackground(Color.WHITE);
add(male);

female = new JRadioButton("Female");
female.setBounds(450, 320, 80, 30);
female.setBackground(Color.WHITE);
add(female);

ButtonGroup group = new ButtonGroup();
group.add(male);
group.add(female);


JLabel email = new JLabel("Email: ");
email.setFont(new Font("Raleway", Font.BOLD,28));
email.setBounds(100, 380, 200, 30);
add(email);

emailtextfield = new JTextField();
emailtextfield.setFont(new Font("Raleway", Font.BOLD, 38));
emailtextfield.setBounds(300, 380, 400, 35);
add(emailtextfield);

JLabel marital = new JLabel("Marital Status: ");
marital.setFont(new Font("Raleway", Font.BOLD,28));
marital.setBounds(100, 440, 250, 30);
add(marital);

married = new JRadioButton("married");
married.setBounds(300, 440, 100, 35);
married.setBackground(Color.WHITE);
add(married);

unmarried = new JRadioButton("unmarried");
unmarried.setBounds(450, 440, 100, 35);
unmarried.setBackground(Color.WHITE);
add(unmarried);

other = new JRadioButton("other");
other.setBounds(600, 440, 100, 35);
other.setBackground(Color.WHITE);
add(other);

ButtonGroup marriedgroup = new ButtonGroup();
marriedgroup.add(married);
marriedgroup.add(unmarried);
marriedgroup.add(other);

JLabel add = new JLabel("Address: ");
add.setFont(new Font("Raleway", Font.BOLD,28));
add.setBounds(100, 500, 200, 30);
add(add);

addresstextfield = new JTextField();
addresstextfield.setFont(new Font("Raleway", Font.BOLD, 38));
addresstextfield.setBounds(300, 500, 400, 35);
add(addresstextfield);

JLabel city = new JLabel("City: ");
city.setFont(new Font("Raleway", Font.BOLD,28));
city.setBounds(100, 560, 200, 30);
add(city);

citytextfield = new JTextField();
citytextfield.setFont(new Font("Raleway", Font.BOLD, 38));
citytextfield.setBounds(300, 560, 400, 35);
add(citytextfield);

JLabel state = new JLabel("State: ");
state.setFont(new Font("Raleway", Font.BOLD,28));
state.setBounds(100, 620, 200, 30);
add(state);

statetextfield = new JTextField();
statetextfield.setFont(new Font("Raleway", Font.BOLD, 38));
statetextfield.setBounds(300, 620, 400, 35);
add(statetextfield);


JLabel pincode = new JLabel("Pin Code: ");
pincode.setFont(new Font("Raleway", Font.BOLD,28));
pincode.setBounds(100, 680, 200, 30);
add(pincode);

pintextfield = new JTextField();
pintextfield.setFont(new Font("Raleway", Font.BOLD, 38));
pintextfield.setBounds(300, 680, 400, 35);
add(pintextfield);

next = new JButton("Next");
next.setBackground(Color.black);
next.setForeground(Color.WHITE);
next.setFont(new Font("Raleway", Font.BOLD, 14));
next.setBounds(620, 740, 80, 30);
next.addActionListener(this);
add(next);

getContentPane().setBackground(Color.WHITE);

        setSize(850,900);
        setLocation(600, 100);
        setVisible(true);
      }

public void actionPerformed(ActionEvent ae){
String formno = "" +random; //long
String name = nametextfield.getText();
String fname = fnametextfield.getText();
String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();

String gender = null;
if(male.isSelected()){
gender = "male";
}
else if(female.isSelected()){
gender = "Female";
}

String email = emailtextfield.getText();
String marital = null;
if(married.isSelected()){
marital = "Married";
}
else if(unmarried.isSelected()){
marital = "UnMarried";
}
else if(other.isSelected()){
marital = "other";
}
String address = addresstextfield.getText();
String city = citytextfield.getText();
String state = statetextfield.getText();
String pin = pintextfield.getText();

    try {
        if (name.equals("")) {
            JOptionPane .showMessageDialog(null, "Name is required");
        } 
        else{  
            Conn c = new Conn();
            String query = "insert into signup values('"+ formno +"', '"+ name+ "', '"+ fname +"', '" +dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupTwo(formno).setVisible(true);
}
    } catch (Exception e) {
        System.out.println(e);
    }

}
    public static void main(String[] args) {
        new Signupone();
    }
}
