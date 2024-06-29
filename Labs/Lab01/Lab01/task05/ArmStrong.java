import java.util.Scanner;

public class ArmStrong 
{
   public static void main(String args[])
   {
	int start,end;
	
	Scanner obj = new Scanner(System.in);

	System.out.println("Enter Starting range : ");
	start = obj.nextInt();
	System.out.println("Enter ending range : ");
	end = obj.nextInt();	

	for(int i=start; i<end; i++)
	{
	    if(checkNumber(i))
	    {
		System.out.println("   "+ i);
	    }
	}
	
	obj.close();
   }

   public static boolean checkNumber(int num)
   {
	int sum=0;

	int snum=num; 

	while(snum>0)
	{
	   int val = snum % 10;
	   sum = sum + (val*val*val);
	   snum = snum/10;
	}

	if(sum==num)
	{
	   return true;
	}
	else
	{	
	  return false;
	}
   }
}