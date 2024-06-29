import javax.swing.*;
public class Driver
{
   public static void main(String args[])
   {
	Square sq = new Square();
 	sq.getinput();
        System.out.println(sq.toString());

	Sphere obj1 =  new Sphere(5);
	System.out.println(obj1.SphereVolume());

	//downcasting by explicit mentioned (Square)

	Shape p1 = new Square();
	Square s1 = new Square();
	System.out.println(s1.toString()); 
	System.out.println(p1.toString());
	s1 = (Square) p1;	
	System.out.println(s1.toString()); 
	System.out.println(p1.toString());
	
	//Upcasting 

	Shape p2 = new Square();
	Square s2 = new Square();
	System.out.println(s2.toString()); 
	System.out.println(p2.toString());
	p2 = s2;
	System.out.println(s2.toString()); 
	System.out.println(p2.toString());
	
	
	Shape p3 = new Sphere();
	Square s3 = new Square();
	System.out.println(p3.toString());	
	System.out.println(s3.toString()); 
	p3 = s3;
	System.out.println(p3.toString());	
	System.out.println(s3.toString()); 
	
	
	
   }
}