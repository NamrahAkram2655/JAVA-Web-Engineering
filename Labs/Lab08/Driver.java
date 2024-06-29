import java.io.*;
public class Driver
{
	public static void main(String args[])
	{
		ReadFile r1 = new ReadFile("test.txt");
		ReadFile r2 = new ReadFile("data.txt");
		
		Thread t1 = new Thread(r1, "Thread1");
		Thread t2 = new Thread(r2, "Thread2");
		
		t1.start();
		t2.start();
	}
}