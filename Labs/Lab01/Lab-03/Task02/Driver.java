public class Driver
{
   public static void main(String args[])
   {
	Media[] m1 = new Media[10];

	m1[0] = new PrintMedia();
	m1[1] = new SocialMedia();
	m1[2] = new Book("Novels","Aab-e-hayat","Mw123");
	m1[3] = new Magazine("Clothes","January",2023);
	m1[4] = new Facebook("Aab-e-hayat","Jannat k pattay",3412);
	m1[5] = new Book("Novels","Aab-e-hayat","Mw123");
	m1[6] = new Magazine("Clothes","January",2023);
	m1[7] = new Facebook("Aab-e-hayat","Jannat k pattay",3412);
	m1[8] = new Book("Novels","Aab-e-hayat","Mw123");
	m1[9] = new Magazine("Clothes","January",2023);
	

	// m1[2].getINdisplay(); //jo parent ka function overrided h juts wo call ho skta baki sirf parent k 
	// m1[4].getINdisplay();
	for(int i=0; i<m1.length; i++)
	{
	    m1[i].display();
	}
   }
}