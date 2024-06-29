import java.util.Scanner;

class Book extends PrintMedia
{
   private String name, ISBN;

   public Book()
   {
	name = ISBN = "";
   } 
   public Book(String title, String name, String ISBN)
   {
	this.title = title;
	this.name = name;
 	this.ISBN = ISBN;
   }
   public void setName(String name)
   {
	this.name = name;
   }
    public void setISBN(String ISBN)
   {
	this.ISBN = ISBN;
   }
    public void setTitle(String title)
   {
	this.title = title;
   }
    public String getName()
   {
	return name;
   }
    public String getISBN()
   {
	return ISBN;
   }
    public String getTitle()
   {
	return title;
   }

   public void display()
   {
	System.out.println("The title of book is "+title+" The name of book is " + name + 
	" and it's ISBN is "+ ISBN );
   }
   // public void getINdisplay()
   // {
	// System.out.println("The title of book is "+title+" The name of book is " + name + 
	// " and it's ISBN is "+ ISBN );
   // }
}