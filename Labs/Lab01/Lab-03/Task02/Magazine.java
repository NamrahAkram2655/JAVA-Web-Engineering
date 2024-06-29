import java.util.Scanner;

class Magazine extends PrintMedia
{
   private String month;
   private int year;

   public Magazine()
   {
	month = "";
	year = 0;
   } 
   public Magazine(String title,String month, int year)
   {
	this.title = title;
	this.month = month;
 	this.year = year;
   }
   public void setMonth(String month)
   {
	this.month = month;
   }
    public void setyear(int year)
   {
	this.year = year;
   }
    public void setTitle(String title)
   {
	this.title = title;
   }
    public String getMonth()
   {
	return month;
   }
    public int getYear()
   {
	return year;
   }
    public String getTitle()
   {
	return title;
   }

   public void display()
   {
      super.display();
	System.out.println("It's title is "+ title + " Month is "+month+" and year is " + year);
   }
}