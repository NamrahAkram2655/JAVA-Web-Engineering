import java.util.Scanner;

public class Employee
{
   public static void main(String args[])
   {
	double payAmount = 2000.00;
	double payPeriod = 12;
	double annualPay;
	
	annualPay = payAmount * payPeriod;

	System.out.println("Annual pay of employee : " + annualPay);
   }
}