import javax.swing.*;

class Sphere extends Shape 
{
   private double radius;
   private final double PI=3.14;

   public Sphere()
   {	
	super();
	this.radius = radius;
   }   
   public Sphere(double radius)
   {
	super();
	this.radius=radius;
   }
   public void getInput()
   {
	String r = JOptionPane.showInputDialog("Enter Radius : ");
	radius = Double.parseDouble(r);
   }

   public String toString()
   {
	return "Radius is "+ radius;
   }

   public double SphereVolume()
   {
	volume = (4/3)*PI*radius*radius*radius;
	return volume;
   }
}