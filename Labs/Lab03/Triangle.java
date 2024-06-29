import java.util.Scanner;

class Triangle implements TwoDimensionalShape
{ 
    private double base;
    private double height;

    public Triangle()
   {
	base = height = 0.0;
   }
   public Triangle(double base, double height)
   {
	this.base = base;
	this.height = height;
   }
   public void setBase(double base)
   {
     	this.base = base;
   }

   public void setHeight(double height)
   {
	this.height = height;
   }
    public double getarea()
    {
	double area = 0.5*(base*height);
	return area;
    }
    public void getInput()
    {
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter base : ");
        base = obj.nextDouble();
 	System.out.println("Enter height : ");
        base = obj.nextDouble();
    }
    public String toString()
    {
	return "This is a Triangle Shape";
    }
}