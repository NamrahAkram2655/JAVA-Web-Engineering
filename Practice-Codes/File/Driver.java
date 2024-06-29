import java.util.*;
import java.io.*;
import java.text.*;

class Driver
{
	File f = new File("D:\\JAVA LABS\\Mid\\File\\file\\test.txt");
	
	public void display(){
		System.out.println("It exist " + f.exists());
		if(f.exists())
		{
			System.out.println("Last modified " + formatDate(f.lastModified()));
			System.out.println("Can Read " + f.canRead());
			System.out.println("Can Write " + f.canWrite());
			System.out.println("Creation Time  " +  formatDate(f.lastModified()));
		}
	}
	public static String formatDate(long milliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date resultDate = new Date(milliseconds);
        return sdf.format(resultDate);
    }
	public static void main(String args[])
	{
		Driver d = new Driver();
		d.display();
		
	}
	
	
}