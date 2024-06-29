
/*Make a copy of an existing file*/

import java.io.*;
import java.util.*;

class CopyFile
{
	public static void main(String args[])
	{
		try
		{
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("test-copy.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line;
			while((line = br.readLine())!= null)
			{
				System.out.println(line);
				bw.write(line);
			}
			
			System.out.println("SuccessFully copied");
			bw.close();
			fw.close();
			fr.close();
			br.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}