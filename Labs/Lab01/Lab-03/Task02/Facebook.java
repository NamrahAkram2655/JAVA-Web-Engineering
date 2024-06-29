import java.util.Scanner;

class Facebook extends SocialMedia
{
   private String name;
   private int likes;

   public Facebook()
   {
	name = "";
	likes = 0;
   } 
   public Facebook(String title, String name, int likes)
   {
	this.title = title;
	this.name = name;
 	this.likes = likes;
   }
   public void setName(String name)
   {
	this.name = name;
   }
    public void setLikes(int likes)
   {
	this.likes = likes;
   }
    public void setTitle(String title)
   {
	this.title = title;
   }
     public String getName()
   {
	return name;
   }
    public int getLikes()
   {
	return likes;
   }
    public String getTitle()
   {
	return title;
   }

   public void display()
   {
      super.display();
	System.out.println("It's title is " + title + " Name is "+name+" and Likes are " + likes);
   }
   // public void getINdisplay()
   // {
   //    super.display();
	// System.out.println("It's title is " + title + " Name is "+name+" and Likes are " + likes);
   // }
}