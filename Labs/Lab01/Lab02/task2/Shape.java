import javax.swing.*;

class Shape
{
   protected double area, volume;

   public Shape()
   {
	area = volume = 0.0;
   }
   public Shape(double area, double volume)
   {
	this.area = area;
	this.volume = volume;
   }
   public Shape(Shape obj)
   {
	this.area = obj.area;
	this.volume = obj.volume;
   }

   public void setArea(Double area)
   {
	this.area = area;
   }
   public Double getArea()
   {
	return area;
   }
   public void setVol(Double volume)
   {
	this.volume = volume;
   }
   public Double getVol()
   {
	return volume;
   }
   public void getinput()
   {
	String val =  JOptionPane.showInputDialog("Enter area : ");
	area =  Double.parseDouble(val);

	String val2= JOptionPane.showInputDialog("Enter volume : ");
	volume = Double.parseDouble(val2);
   }

   public String toString()
   {
	return "Area is "+ area + "and Volume is "+volume;
   }
}