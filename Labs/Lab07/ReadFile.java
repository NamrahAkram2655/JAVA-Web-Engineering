import java.io.*;

class ReadFile implements Runnable{
	
	String filename;
	public ReadFile(String name)
	{
		this.filename = name;
	}
	public void setName(String name)
	{
		this.filename = name;
	}
	public String getName()
	{
		return filename;
	}
	public void run()
	{
		try
		{
			FileReader outf = new FileReader(filename);
			BufferedReader br = new BufferedReader(outf);
			String line;
			
			while((line = br.readLine()) != null)
			{
				System.out.println("The exixtsing thread is " + Thread.currentThread().getName() + "  " + line );
			}
			
			outf.close();
			br.close();
		}catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
