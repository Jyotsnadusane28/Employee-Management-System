import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;

class DbHandler{
//addemployee
public static void addEmployee(int id,String name,int age,String gender,String dob,String address,String department,String designation,double salary){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;

try{
	session = sfact.openSession();
	System.out.println("connected ");
	
	t = session.beginTransaction();
	Console c = System.console();
	
	Employee s = new Employee(id,name,age,gender,dob,address,department,designation,salary);
	session.save(s);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"Success","record inserted",JOptionPane.INFORMATION_MESSAGE);
}

catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
t.rollback();
}
finally{
	if(session!=null){
	session.close();
	System.out.println("disconnected ");
	}
}
}

//viewEmployee

public static String viewEmployee(){
String data = "";
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;

try{
	session = sfact.openSession();
	System.out.println("connected ");
	
	List<Employee> employeelist = new ArrayList<>();
	employeelist = session.createQuery("from Employee").list();
	for (Employee s:employeelist)
		data += "id-> " + s.getid() + "   " + "Name-> " + s.getname() + "   " + "Age-> " + s.getage() + "   " + "Gender-> "+ s.getgender() + "   "+"DOB-> " + s.getdob() +"Address-> " + s.getaddress() + "Department-> " + s.getdepartment() +"Designation-> " + s.getdesignation() +"Salary-> " + s.getsalary() +"\n";
		
}
catch(Exception e){
System.out.println("issue "+e);

}

finally{
	if(session!=null){
	session.close();
	System.out.println("disconnected ");
	}
return data;
}
}

//update student

public static void updateEmployee(int id,String name,int age,String gender,String dob,String address,String department,String designation,double salary){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;

try{
	session = sfact.openSession();
	System.out.println("connected ");
	
	t = session.beginTransaction();
	Console c = System.console();
	
	Employee s = (Employee)session.get(Employee.class,id);
	if(s == null){
	JOptionPane.showMessageDialog(new JDialog(),id + " not found ");
	}
	else{
	s.setname(name);
	s.setage(age);
	s.setgender(gender);
	s.setdob(dob);
	s.setaddress(address);
	s.setdepartment(department);
	s.setdesignation(designation);
	s.setsalary(salary);
	session.save(s);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"record updated");
	}}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
t.rollback();
}
finally{
	if(session!=null){
	session.close();
	System.out.println("disconnected ");
	}
}
}

//delete student

public static void deleteEmployee(int id){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;

try{
	session = sfact.openSession();
	System.out.println("connected ");
	
	t = session.beginTransaction();
	Console c = System.console();
	
	Employee s = (Employee)session.get(Employee.class,id);
	if(s == null){
	JOptionPane.showMessageDialog(new JDialog(),id + " not found ");
	}
	else{
	session.delete(s);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"record deleted");
	}}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue "+e);
t.rollback();
}
finally{
	if(session!=null){
	session.close();
	System.out.println("disconnected ");
	}
}
}




}
