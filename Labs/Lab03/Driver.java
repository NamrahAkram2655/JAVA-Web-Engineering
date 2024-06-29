import java.util.Scanner;

public class Driver
{
   public static void main(String args[])
   {
	TwoDimensionalShape[] obj = new TwoDimensionalShape[5];

	obj[0] = new Circle(5.0);
	
	obj[1] = new Square(7.1);

	obj[2] = new Triangle(2.5,1.0);	

	obj[3] = new Circle(2.5);
   
	obj[4] = new Square(7.0);

	for(int i=0; i<obj.length; i++)
        {
	   System.out.println(obj[i].toString());
	   System.out.println(obj[i].getarea());
	}

	System.out.println("Using of toString class method");
	System.out.println(obj[1]);
   }
  
}