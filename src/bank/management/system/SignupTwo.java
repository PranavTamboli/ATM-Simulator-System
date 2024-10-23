package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

JTextField pan, aadhar;
JButton next;
JRadioButton syes,sno, eyes,eno;
JComboBox religion, category, occupation, education, income;
String formno;

SignupTwo(String formno) {
this.formno = formno;
    setLayout(null);

    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

JLabel additionaldetails = new JLabel("Page 2 : Additionl Details");
additionaldetails.setFont(new Font("Raleway", Font.BOLD,28));
additionaldetails.setBounds(220, 80, 380, 40);
add(additionaldetails);

JLabel Name = new JLabel("Religion: ");
Name.setFont(new Font("Raleway", Font.BOLD,24));
Name.setBounds(100, 140, 160, 30);
add(Name);

String valReligion[] = {"Hindu", "Muslim", "Sikh", "other"};
religion = new JComboBox(valReligion);
religion.setBounds(300, 140, 400, 35);
religion.setBackground(Color.white);
add(religion);

JLabel fname = new JLabel("Category: ");
fname.setFont(new Font("Raleway", Font.BOLD,24));
fname.setBounds(100, 200, 200, 30);
add(fname);

String valCategory[] = {"General", "OBC", "Sc", "ST"};
category = new JComboBox(valCategory);
category.setBounds(300, 200, 400, 35);
category.setBackground(Color.white);
add(category);

JLabel dob = new JLabel("Income: ");
dob.setFont(new Font("Raleway", Font.BOLD,24));
dob.setBounds(100, 260, 200, 30);
add(dob);

String incomeCategory[] = {"Null", "<200000", "<400000", "upto 1000000"};
income = new JComboBox(incomeCategory);
income.setBounds(300, 260, 400, 35);
income.setBackground(Color.white);
add(income);

JLabel gender = new JLabel("Educational: ");
gender.setFont(new Font("Raleway", Font.BOLD,24));
gender.setBounds(100, 320, 200, 35);
add(gender);

JLabel email = new JLabel("Qualification: ");
email.setFont(new Font("Raleway", Font.BOLD,24));
email.setBounds(100, 350, 200, 30);
add(email);

String educationValues[] = {"Non graduate", "Graduate", "Post Graduate", "Doctrate"};
education = new JComboBox(educationValues);
education.setBounds(300, 320, 400, 35);
education.setBackground(Color.white);
add(education);


JLabel marital = new JLabel("Occupation: ");
marital.setFont(new Font("Raleway", Font.BOLD,24));
marital.setBounds(100, 440, 250, 30);
add(marital);

String occupatioonValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
occupation = new JComboBox(occupatioonValues);
occupation.setBounds(300, 440, 400, 35);
occupation.setBackground(Color.white);
add(occupation);

JLabel add = new JLabel("Pan Number: ");
add.setFont(new Font("Raleway", Font.BOLD,24));
add.setBounds(100, 500, 200, 30);
add(add);

pan = new JTextField();
pan.setFont(new Font("Raleway", Font.BOLD, 38));
pan.setBounds(300, 500, 400, 35);
add(pan);

JLabel city = new JLabel("Aadhar Number: ");
city.setFont(new Font("Raleway", Font.BOLD,24));
city.setBounds(100, 560, 200, 30);
add(city);

aadhar = new JTextField();
aadhar.setFont(new Font("Raleway", Font.BOLD, 38));
aadhar.setBounds(300, 560, 400, 35);
add(aadhar);

JLabel state = new JLabel("Senior cetizen: ");
state.setFont(new Font("Raleway", Font.BOLD,24));
state.setBounds(100, 620, 200, 30);
add(state);

syes = new JRadioButton("Yes");
syes.setBounds(300, 620, 100, 35);
syes.setBackground(Color.WHITE);
add(syes);

sno = new JRadioButton("No");
sno.setBounds(450, 620, 100, 35);
sno.setBackground(Color.WHITE);
add(sno);

ButtonGroup marriedgroup = new ButtonGroup();
marriedgroup.add(syes);
marriedgroup.add(sno);

JLabel pincode = new JLabel("Existing Account: ");
pincode.setFont(new Font("Raleway", Font.BOLD,22));
pincode.setBounds(100, 680, 220, 34);
add(pincode);

eyes = new JRadioButton("Yes");
eyes.setBounds(300, 680, 100, 35);
eyes.setBackground(Color.WHITE);
add(eyes);

eno = new JRadioButton("No");
eno.setBounds(450, 680, 100, 35);
eno.setBackground(Color.WHITE);
add(eno);

ButtonGroup emarriedgroup = new ButtonGroup();
emarriedgroup.add(eyes);
emarriedgroup.add(eno);

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
//String formno = "" +random; //long
String sreligion = (String) religion.getSelectedItem();
String scategory = (String) category.getSelectedItem();
String sincome = (String) income.getSelectedItem();
String seducation = (String) education.getSelectedItem();
String soccupation = (String) occupation.getSelectedItem();


String seniorcitizen = null;
    if(syes.isSelected()){
        seniorcitizen = "yes";
}
else if(sno.isSelected()){
        seniorcitizen = "No";
}

String existingaccount = null;
if(eyes.isSelected()){
existingaccount = "yes";
}
else if(eno.isSelected()){
existingaccount = "UnMarried";
}

String span = pan.getText();
String saadhar = aadhar.getText();


    try { 
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+ formno +"', '"+ sreligion+ "', '"+ scategory +"', '" +sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

//      Signup3 class object

        setVisible(false);
        new SignupThree(formno).setVisible(true);

    } catch (Exception e) {
        System.out.println(e);
    }

}
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
