import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class viewFrame extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

viewFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

taData = new TextArea(10,30);
btnBack = new JButton("Back");

c.add(taData);
c.add(btnBack);

String data = new DbHandler().viewEmployee();
taData.setText(data);

ActionListener a1 = (ae) -> {
MainFrame af = new MainFrame();
dispose();

};
btnBack.addActionListener(a1);

setTitle("Add Frame");
setSize(350,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}}