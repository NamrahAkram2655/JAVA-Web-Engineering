import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Employee
{
	int id;
	String name;
	static double salary;
	String rank;
	
	public Employee(int id, String name, double salary, String rank)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rank = rank;
	}
	public Employee()
	{
		this.id = 0;
		this.name = null;
		this.salary = 0.0;
		this.rank = null;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	public void setID(String name)
	{
		this.name = name;
	}
	public void setRank(String rank)
	{
		this.rank = rank;
	}
	
}

public class Driver
{
	ArrayList<Employee> empData = new ArrayList<Employee>();
	
	public static void main(String args[])
	{
		Driver obj1 = new Driver();
		obj1.addList();
		obj1.WriteData();
	}
	public void addList()
	{	
		int id;
		String name;
		double salary;
		String rank;
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the id of person : ");
		id  = obj.nextInt();
		obj.nextLine();
		System.out.println("Enter name : ");
		name = obj.nextLine();
		System.out.println("Enter Salary : ");
		salary = obj.nextDouble();
		obj.nextLine();
		System.out.println("Enter rank : ");
		rank = obj.nextLine();
		
		Employee emp = new Employee(id,name,salary,rank);
		empData.add(emp);
	}
	public void RemoveData(int id)
	{
		for(int i=0; i<empData.size(); i++)
		{
			if(id==empData.get(i).id)
			{
				empData.remove(empData.get(i));
			}
		}
		System.out.println("Doesn't find the data ");
	}
	public void WriteData()
	{
		try
		{
			FileWriter outf = new FileWriter("test.txt");
			PrintWriter pout = new PrintWriter(outf);
			
			for(int i=0; i<empData.size(); i++)
			{
				pout.println(empData.get(i).id + " " + empData.get(i).name + " " + empData.get(i).salary + " " + empData.get(i).rank);
			}
			
			outf.close();
			pout.close();
		}
		catch(IOException ex)
		{
			 ex.printStackTrace();
		}
	}
	public void loadData(String fileName)
	{
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader bf = new BufferedReader(fr);
			
			String line;
			while((line = bf.readLine()) != null)
			{
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				String name = parts[1];
				double salary = Double.parseDouble(parts[2]);
				String rank = parts[3];
				
				Employee val = new Employee(id,name,salary,rank);
				empData.add(val);
			}
			
			fr.close();
			bf.close();
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
}








