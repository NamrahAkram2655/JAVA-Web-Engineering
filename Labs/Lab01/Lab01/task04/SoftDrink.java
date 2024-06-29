import java.util.Scanner;

public class SoftDrink
{
    public static void main(String args[])
    {
	int customerSurveyed;
	int perOfgoodCustomers;
	int perOfCitrusLover;
	
	System.out.print("Enter Number of customers surveyed : ");
	Scanner obj = new Scanner(System.in);
	customerSurveyed = obj.nextInt();
	System.out.print("Enter %age of customers who purchase more than one drink : ");
	perOfgoodCustomers = obj.nextInt();
	System.out.print("Enter %age of customers who love citrus flavour : ");
	perOfCitrusLover = obj.nextInt();
	
	System.out.println("Number of customes who purchase more than one drink : " +
	(customerSurveyed*perOfgoodCustomers)/100);
	
	System.out.println("Number of customes  who love citrus flavour : " + 
	(perOfCitrusLover*customerSurveyed)/100);
    }
}