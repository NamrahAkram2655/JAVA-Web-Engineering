import java.util.*;

class duplicateCustomerException extends Exception
{
	public duplicateCustomerException()
	{
		super();
	}
	public duplicateCustomerException(String message)
	{
		super(message);
	}
	public String toString()
	{
		return "this is duplicate Customer Exception";
	}
	
}
class invalidAgeException extends Exception
{
	public invalidAgeException()
	{
		super();
	}
	public invalidAgeException(String message)
	{
		super(message);
	}
	public String toString()
	{
		return "this is invalid Age Exception";
	}
}
class lowBalanceException extends Exception
{
	public lowBalanceException()
	{
		super();
	}
	public lowBalanceException(String message)
	{
		super(message);
	}
	public String toString()
	{
		return "this is low Balance Exception";
	}
}
class invalidCustomerIDException extends Exception
{
	public invalidCustomerIDException()
	{
		super();
	}
	public invalidCustomerIDException(String message)
	{
		super(message);
	}
	public String toString()
	{
		return "this is invalid Customer ID Exception";
	}
}
class Customer
{
	String name;
	int id;
	int age;
	double balance;
	
	public Customer()
	{
		name="";
		id = age = 0;
		balance = 0.0;
	}
	public Customer(String name, int id, int age, double balance)
	{
		this.name = name;
		this.id = id;
		this.age = age;
		this.balance = balance;
	}
	public int getId()
	{
		return id;
	}
}

public class Bank
{	
	ArrayList <Customer> people = new ArrayList<Customer>();
	
	public void addCustomer(String name, int id, int age, double balance){
		try
		{
			for(int i=0; i<people.size(); i++)
			{
				//if(people[i].id == id) whenever arrauy list use method below
				if(people.get(i).getId() == id)
				{
					throw new duplicateCustomerException();
				}
			}
			if(age<18 || age>65)
			{
				throw new invalidAgeException();
			}
			if(balance<0)
			{
				throw new lowBalanceException();
			}
		}catch(duplicateCustomerException | invalidAgeException | lowBalanceException d)
		{
			System.out.println("error" + d.toString());
		}
		
		Customer obj = new Customer(name,id,age,balance);
		people.add(obj);
	}
	
	public void searchCustomer(int searchID){
		
		boolean found = false;
		try{
			for(int i=0; i<people.size(); i++)
			{
				if(people.get(i).getId()==searchID)
				{
					System.out.println("Customer exist");
					System.out.println(people.get(i).name + "  " + people.get(i).id + "  "+ people.get(i).age + "  "+ people.get(i).balance);
					found = true;
				}
			}
			
			if(found==false)
			{
				throw new invalidCustomerIDException();
			}
		}
		catch(invalidCustomerIDException ex)
		{
			System.out.println("error" + ex.toString());
		}
	}
	
	public static void main(String args[])
	{

		Bank b = new Bank();
		
		while(true)
		{
			int choice;
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter your choice 1 for cutomer add and 2 for getting data and 3 for exiting ");
			choice = obj.nextInt();
			obj.nextLine();
			
			switch(choice)
			{
				case 1: 
					String name; int id; int age; double balance;
					System.out.println("Enter name ");
					name = obj.nextLine();
					System.out.println("Enter id ");
					id = obj.nextInt();
					obj.nextLine();
					System.out.println("Enter age ");
					age = obj.nextInt();
					obj.nextLine();
					System.out.println("Enter balance ");
					balance = obj.nextDouble();
					obj.nextLine();
					
					b.addCustomer(name,id,age,balance);
					System.out.println("Added SccessFully");
					break;
				
				case 2:
					int index;
					System.out.println("Enter id of customer you want to search");
					index = obj.nextInt();
					obj.nextLine();
					
					b.searchCustomer(index);
					System.out.println("Searched SccessFully");
					break;
				case 3:
					System.exit(0);
					break;
				default: 
					System.out.println("Invalid choice");
					break;
			}
		}
		
	}
	
}