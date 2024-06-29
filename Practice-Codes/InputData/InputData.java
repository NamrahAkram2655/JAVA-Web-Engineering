import java.util.Scanner;

public class InputData
{
	public static void main(String args[])
	{
		String deg,batch;
		int id;
		double cgpa;
		
		Scanner obj = new Scanner(System.in);

		System.out.println("What's your degree : ");
		deg = obj.nextLine();

		System.out.println("What's your batch : ");
		batch = obj.nextLine();

		System.out.println("What's your ID : ");
		id = obj.nextInt();

		System.out.println("What's your Cgpa : ");
		cgpa = obj.nextDouble();

		System.out.println("Total values are : " + deg+batch+cgpa+id);

		obj.close();
		
	}
}