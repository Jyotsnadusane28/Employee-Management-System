import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

class updateFrame extends JFrame{
Container c;
JLabel lblid,lblname,lblage,lblgender,lbldob,lbladdress,lbldepartment,lbldesignation,lblsalary;
JTextField txtid,txtname,txtage,txtgender,txtdob,txtaddress,txtdepartment,txtdesignation,txtsalary;
JButton btnSave,btnBack;

updateFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblid = new JLabel("      enter id:         ");
lblid.setHorizontalAlignment(JLabel.CENTER);
txtid = new JTextField(15);

lblname = new JLabel("     enter name:       ");
lblname.setHorizontalAlignment(JLabel.CENTER);
txtname = new JTextField(15);
		  
lblage = new JLabel("enter age: ");
lblage.setHorizontalAlignment(JLabel.CENTER);
txtage = new JTextField(15);

lblgender = new JLabel("enter gender: ");
lblgender.setHorizontalAlignment(JLabel.CENTER);
txtgender = new JTextField(15);

lbldob = new JLabel("enter dob(dd/mm/yyyy): ");
lbldob.setHorizontalAlignment(JLabel.CENTER);
txtdob = new JTextField(15);

lbladdress = new JLabel("enter address: ");
lbladdress.setHorizontalAlignment(JLabel.CENTER);
txtaddress = new JTextField(15);

lbldepartment = new JLabel("enter department: ");
lbldepartment.setHorizontalAlignment(JLabel.CENTER);
txtdepartment = new JTextField(15);

lbldesignation = new JLabel("enter designation: ");
lbldesignation.setHorizontalAlignment(JLabel.CENTER);
txtdesignation = new JTextField(15);

lblsalary = new JLabel("enter salary: ");
lblsalary.setHorizontalAlignment(JLabel.CENTER);
txtsalary = new JTextField(15);

btnSave = new JButton("Save");
btnBack = new JButton("Back");

c.add(lblid);
c.add(txtid);
c.add(lblname);
c.add(txtname);
c.add(lblage);
c.add(txtage);
c.add(lblgender);
c.add(txtgender);
c.add(lbldob);
c.add(txtdob);
c.add(lbladdress);
c.add(txtaddress);
c.add(lbldepartment);
c.add(txtdepartment);
c.add(lbldesignation);
c.add(txtdesignation);
c.add(lblsalary);
c.add(txtsalary);
c.add(btnSave);
c.add(btnBack);

ActionListener a1 = (ae) -> {
MainFrame af = new MainFrame();
dispose();

};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
try{
int id = Integer.parseInt(txtid.getText());
String name = txtname.getText();
int age = Integer.parseInt(txtage.getText());
String gender = txtgender.getText();
String dob = txtdob.getText();
String address = txtaddress.getText();
String department = txtdepartment.getText();
String designation = txtdesignation.getText();
double salary = Double.parseDouble(txtsalary.getText());

if(id<0){
JOptionPane.showMessageDialog(c,"id Must be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtid.requestFocus();
}

else if(name.length()==0 || name.length()<2){
JOptionPane.showMessageDialog(c,"name should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtname.requestFocus();
}

else if(name.matches(".*\\d.*")){
JOptionPane.showMessageDialog(c,"name should be string only","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtname.requestFocus();
}

else if(age<0){
JOptionPane.showMessageDialog(c,"age should be valid","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtage.requestFocus();
}

else if(gender.length()==0){
JOptionPane.showMessageDialog(c,"gender should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtgender.requestFocus();
}

else if(gender.matches(".*\\d.*")){
JOptionPane.showMessageDialog(c,"gender should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtgender.requestFocus();
}

else if(address.length()==0){
JOptionPane.showMessageDialog(c,"address should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtaddress.setText("");
txtaddress.requestFocus();
}

else if(department.length()==0){
JOptionPane.showMessageDialog(c,"department should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtaddress.setText("");
txtdepartment.setText("");
txtdepartment.requestFocus();
}

else if(designation.length()==0){
JOptionPane.showMessageDialog(c,"dob should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtaddress.setText("");
txtdesignation.setText("");
txtdesignation.requestFocus();
}

else if(designation.matches(".*\\d.*")){
JOptionPane.showMessageDialog(c,"designation should be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtaddress.setText("");
txtdesignation.setText("");
txtdesignation.requestFocus();
}
else if(salary<0){
JOptionPane.showMessageDialog(c,"salary Must be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtname.setText("");
txtage.setText("");
txtgender.setText("");
txtaddress.setText("");
txtdesignation.setText("");
txtsalary.setText("");
txtsalary.requestFocus();
}


else{
DbHandler db = new DbHandler();
db.updateEmployee(id,name,age,gender,dob,address,department,designation,salary);
}}
catch(NumberFormatException nfe){
JOptionPane.showMessageDialog(c,"Enter correct info ","issue",JOptionPane.ERROR_MESSAGE);
txtid.requestFocus();
}
};
btnSave.addActionListener(a2);

setTitle("Update Frame");
setSize(200,550);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}}