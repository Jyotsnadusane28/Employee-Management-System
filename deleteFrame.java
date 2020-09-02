import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class deleteFrame extends JFrame{
Container c;
JLabel lblid;
JTextField txtid;
JButton btnSave,btnBack;

deleteFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblid = new JLabel("enter id: ");
txtid = new JTextField(20);

btnSave = new JButton("Save");
btnBack = new JButton("Back");

c.add(lblid);
c.add(txtid);
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
if(id<0){
JOptionPane.showMessageDialog(c,"id Must be valid ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtid.requestFocus();
}
else{
DbHandler db = new DbHandler();
db.deleteEmployee(id);
txtid.setText("");
txtid.requestFocus();
}

}
catch(NumberFormatException nfe){
JOptionPane.showMessageDialog(c,"Number Expected ","issue",JOptionPane.ERROR_MESSAGE);
txtid.setText("");
txtid.requestFocus();
}

};
btnSave.addActionListener(a2);

setTitle("Delete Frame");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}}