import java.util.Scanner;

class Square implements TwoDimensionalShape
{
    private double a;
    
    public Square()
   {
	a = 0.0;
   }
   public Square(double a)
   {
	this.a = a;
   }
    public double getarea()
    {
	return (a*a);
    }
     public void setval()
   {
	this.a = a;
   }
   public double getval()
   {
	return a;
   }
     public void getInput()
    {
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter value to get square  : ");
        a = obj.nextDouble();
    }
    public String toString()
    {
	return "This is a Square Shape";
    }
}