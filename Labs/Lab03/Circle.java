import java.util.Scanner;

class Circle implements TwoDimensionalShape
{
    private double PI = 3.14;
    private double radius;

    Circle()
    {
	this.radius = 0.0;
    }
    Circle(double radius)
    {
	this.radius = radius;
    }

    public void getInput()
    {
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter radius : ");
        radius = obj.nextDouble();
    }
     public void setRadius(double radius)
    {
	this.radius = radius;
    }
    public double getRadius()
    {
	return radius;
    }
    public double getarea()
    {
	/*Scanner obj = new Scanner(System.in);
	System.out.println("Enter radius : ");
        radius = obj.nextDouble();*/

	return PI*(radius*radius);
    }
    
    public String toString()
    {
	return "This is a Cicle Shape";
    }
}