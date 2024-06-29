import java.util.*;
import javax.swing.*;

class Health
{
	String name;
    double weight;
    double height;
    double BMI;

    Health(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.BMI = weight / (height * height);
    }
	
}

class NegativeArraySizeException extends Exception {
    NegativeArraySizeException() {
        super();
    }

    NegativeArraySizeException(String Message) {
        super(Message);
    }

    public String toString() {
        return "NegativeArraySizeException error has occurred ";
    }

    public String getMessage() {
        return "Index can't be negative";
    }
}

class indexException extends Exception
{
	indexException()
    {
		super();
    }    
     indexException(String Message)
    {
		super(Message);
    }    
     public String toString()
    {
		return "NegativeArraySizeException error has occured ";
    } 
     public String getMessage()
    {
		return "Index can't be negetive";
    }

}
class indexOcuupiedException extends Exception
{
	indexOcuupiedException()
    {
		super();
    }    
     indexOcuupiedException(String Message)
    {
		super(Message);
    }    
     public String toString()
    {
		return "NegativeArraySizeException error has occured ";
    } 
     public String getMessage()
    {
		return "Index can't be negetive";
    }

}
public class Driver
{	
	Health [] people;
	Driver(int N){
		people = new Health[N];
	}
	
	public void save(){
		
		Scanner obj = new Scanner(System.in);
		int index;
		String name;
		double weight;
		double height;
		
		System.out.println("Enter name: ");
		name = obj.nextLine();
		System.out.println("Enter weight: ");
		weight = obj.nextDouble();
		System.out.println("Enter height: ");
		height = obj.nextDouble();
		System.out.println("Enter index on which you want to store data : ");
		index = obj.nextInt();
		obj.nextLine();
		
		try{
			if(people[index]!= null)
			{
				throw new indexOcuupiedException();
			}
			else if(index < 0 )
			{
				throw new NegativeArraySizeException();
			}
			else if(index > people.length)
			{
				throw new indexException();
			}
			else{
				people[index] = new Health(name,weight,height);
			}
		}catch(indexOcuupiedException | NegativeArraySizeException | indexException ex)
		{
			System.out.println("Exception occured " + ex.toString());
		}
		
	}
	
	public void retreive(int index)
	{
		try{
			if(index > people.length)
			{
				throw new indexException();
			}
			else if(index < 0)
			{
				throw new NegativeArraySizeException();
			}
			else{
				System.out.println("Name : " + people[index].name+ " Weight : "+  people[index].weight + " Height" +  people[index].height + " BMI :"+  people[index].BMI);
			}
		}catch(indexException | NegativeArraySizeException ex)
		{
			System.out.println("Exception occured " + ex.toString());
		}
	}
	
	public static void main(String args[])
	{
		int N;
		System.out.println("Enter size of array : ");
		Scanner obj = new Scanner(System.in);
		N = obj.nextInt();
		obj.nextLine();
		
		Driver d = new Driver(N);
		
		try{
			if(N<0)
			{
				throw new NegativeArraySizeException();
			}
		}catch(NegativeArraySizeException ex)
		{
			System.out.println(ex.toString());
		}
		
		while(true)
		{
			int choice;
			Scanner in = new Scanner(System.in);
			System.out.println("Enter 1 to add value in the array ");
			System.out.println("Enter 2 to retrieve data from array ");
			System.out.println("Enter 3 for exiting ");
			choice = in.nextInt();
			in.nextLine();
			
			switch(choice)
			{
				case 1:
					d.save();
					System.out.println("Added SuccessFully");
					break;
				case 2:
					int val;
					val = in.nextInt();
					in.nextLine();
					d.retreive(val);
					System.out.println("Retrived SuccessFully");
					break;
				case 3:
					System.exit(0);
					break;
				default:
					
			}
		}
		
	}
}

