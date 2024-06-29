import java.util.*;
import java.io.*;

class redirect
{
	public static void main(String args[]) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("test.txt",true);
		PrintStream ps = new PrintStream(fos);
		
		System.setOut(ps);
		
		System.out.println("Heloo world");
		fos.close();
		ps.close();
	}
}
//i cal also do trye catch 