class Employee{
private int id;
private String name;
private int age;
private String gender;
private String dob;
private String address;
private String department;
private String designation;
private double salary;


Employee(){}
public Employee(int id, String name, int age,String gender,String dob,String address,String department,String designation,double salary){
this.id = id;
this.name = name;
this.age = age;
this.gender = gender;
this.dob = dob;
this.address = address;
this.department = department;
this.designation = designation;
this.salary = salary;
}

public void setid(int id){
this.id = id;
}

public int getid(){
return id;
}

public void setname(String name){
this.name = name;
}

public String getname(){
return name;
}

public void setage(int age){
this.age = age;
}

public int getage(){
return age;
}

public void setgender(String gender){
this.gender = gender;
}

public String getgender(){
return gender;
}

public void setdob(String dob){
this.dob = dob;
}

public String getdob(){
return dob;
}

public void setaddress(String address){
this.address = address;
}

public String getaddress(){
return address;
}

public void setdepartment(String department){
this.department = department;
}

public String getdepartment(){
return department;
}

public void setdesignation(String designation){
this.designation = designation;
}

public String getdesignation(){
return designation;
}

public void setsalary(double salary){
this.salary = salary;
}

public double getsalary(){
return salary;
}

}
