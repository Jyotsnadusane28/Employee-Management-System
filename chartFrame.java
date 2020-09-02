import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class chartFrame extends JFrame{
chartFrame(){

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;

try{
	session = sfact.openSession();
	System.out.println("connected ");
	
	String q = "from Employee";
	Query query = session.createQuery(q);
	Iterator it=query.iterate();
	DefaultCategoryDataset d1 = new DefaultCategoryDataset();
	while(it.hasNext())
	{
	Employee s = (Employee)it.next();
	int id = s.getid();
	String name = s.getname();
	double salary = s.getsalary();
	
	d1.addValue(salary,name,"sal");
	}	

JFreeChart chart = ChartFactory.createBarChart("Employee Salary","sal","salary",d1,PlotOrientation.VERTICAL,true,false,false);

ChartPanel panel = new ChartPanel(chart);
setContentPane(panel);


setTitle("Salary");
setSize(800,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
catch(Exception e){
System.out.println("issue "+e);
}


}
}