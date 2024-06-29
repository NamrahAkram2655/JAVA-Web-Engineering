import java.util.Scanner;

class Student{
	
	private int rollno;
	private String name, email, address;
	
	public Student(){
	   rollno = 0;
	   name = email = address = "";
	}	

	public Student(int rollno, String name,String email,String address)
	{
	   this.rollno = rollno;
	   this.name = name;
	   this.email = email;
	   this.address = address;
	}
	
	public Student( Student ObjStd)
	{
	   this.rollno = ObjStd.rollno;
	   this.name = ObjStd.name;
	   this.email = ObjStd.email;
	   this.address = ObjStd.address;
	}

	//setters
	public void setRollno(int rollno)
	{
	   this.rollno = rollno;
	}
	public void setName(String name)
	{
	   this.name = name;
	}
	public void setEmail(String email)
	{
	   this.email = email;
	}
	public void setAddress(String address)
	{
	   this.address = address;
	}
	
	//getters

	public int getRollno()
	{
	   return rollno;
	}
	public String getName()
	{
	   return name;
	}
	public String getEmail()
	{
	   return email;
	}
	public String getAddress()
	{
	   return address;
	}

	//function for input data
	
	public void inputdata()
	{
	   Scanner obj = new Scanner(System.in);
	   System.out.println("Enter you data ");

	   System.out.print("Rollno : ");
	   rollno = obj.nextInt();
		
	   obj.nextLine();
	   System.out.print("Name : " );
	   name = obj.nextLine();
 	   System.out.print("Email : " );
	   email = obj.nextLine();
 	   System.out.print("Address : ");
	   address = obj.nextLine();
	}
	
	//function for print data

	public void printdata()
	{
	   System.out.println("Data of Student ");
	   System.out.println("Rollno : " + rollno);
	   System.out.println("Name : " + name);
	   System.out.println("Email : " + email);
	   System.out.println("Address : " + address);
	}

}