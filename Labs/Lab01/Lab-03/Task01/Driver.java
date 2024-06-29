import java.util.Scanner;

public class Driver
{
    public static void main(String args[])
    {
	Shape[] s1 = new Shape[3];
     	
	s1[0] = new Square(2,3);
	s1[0].CalculateArea();
	s1[0].CalculatePerimeter();

	s1[1] = new Rectangle(5,6);
	s1[1].CalculateArea();
	s1[1].CalculatePerimeter();
	
	s1[2] = new Circle(5);
	s1[2].CalculateArea();
	s1[2].CalculatePerimeter();


	for(int i=0; i<s1.length; i++)
	{
	    System.out.println(s1[i].toString());
	}
    }
}