import java.util.*;

public class Driver
{
   public static void main(String args[])
   {
	
	Student s1 = new Student();
	s1.inputdata();
	s1.printdata();

	Student s2 = new Student(2,"Nimra","Bitf21m542@pucit.edu.pk","Wapda Town");
	s2.printdata();

	Student s3 = new Student(s2);
	s3.printdata();
	
	Student[] std = new Student[5];

	for(int i=0; i<std.length; i++)
	{
	   std[i] = new Student();
	   std[i].inputdata();
	}
	for(int i=0; i<std.length; i++)
	{
	   std[i].printdata();
	}
	
   }
}