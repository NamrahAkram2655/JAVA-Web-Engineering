import java.util.*;
import java.io.*;
import java.util.HashMap;

class Words
{
	String Wordname;
	String meaning;
	
	public Words()
	{
		this.Wordname = null;
		this.meaning = null;
	}
	public Words(String Wordname, String meaning)
	{
		this.Wordname = Wordname;
		this.meaning = meaning;
	}
	
	public void setWordName(String Wordname)
	{
		this.Wordname = Wordname;
	}
	public void setMeaning(String meaning)
	{
		this.meaning = meaning;
	}
	
	public String getWordName(){
		return Wordname;
	}
	public String getMeaning()
	{
		return meaning;
	}
}

class Dictionary
{
	HashMap<String, String> dataCollector;
	public Dictionary()
	{
		dataCollector = new HashMap<>();
	}
	
	
	public void insertRecord(String Wordname, String meaning)
	{
		dataCollector.put(Wordname, meaning);
	}
	public void find(String Wordname)
	{
		System.out.println("The meaning of this "+ Wordname + " is : " + dataCollector.get(Wordname));//dataCollector.getValue());
	}
}

public class Driver
{
	public static void main(String args[])
	{

		Dictionary d = new Dictionary();
		
		while(true)
		{
			int option;
		System.out.println("Enter what do you want to do");
		System.out.println("Enter 1 to add new reocord ");
		System.out.println("Enter 2 to see meaning of a word ");
		System.out.println("Enter 3 to exit : ");
		Scanner obj = new Scanner(System.in);
		
		option = obj.nextInt();
		obj.nextLine();
			switch(option)
			{
				case 1: 
	
				     System.out.println("Enter Word : ");
				    String Wn = obj.nextLine();
				    System.out.println("Enter meaning : ");
				    String m = obj.nextLine();
				   
				   d.insertRecord(Wn, m);	 
				
			
				 
				   break;
				case 2: 
				
				   System.out.println("Enter Word whose meaning you want to know : ");
				   String Wordname = obj.nextLine();
			
				   d.find(Wordname);
				 
				
				   break;
				case 3:
				    System.exit(0);
					break;
				default:
				    System.out.println("Invalid choice");
			} 
	
	}
		
	}
}