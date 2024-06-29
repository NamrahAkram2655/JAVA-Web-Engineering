import javax.swing.*;

class Square extends Shape
{
   private double height, length, width;
   
   public Square()
   {
	super();
	height = length = width = 0.0;
   }
   public Square(double area, double volume, double height, double length, double width)
   {
	super(area,volume);
	this.height = height;
	this.length = length;
	this.width = width;
   }
   public Square(Square obj)
   {
	super(obj);
	this.height = height;
	this.length = length;
	this.width = width;
   }
   
   public void getinput()
   {
	String h =  JOptionPane.showInputDialog("Enter height : ");
	height =  Double.parseDouble(h);

	String L = JOptionPane.showInputDialog("Enter length : ");
	length = Double.parseDouble(L);

	String W = JOptionPane.showInputDialog("Enter width : ");
	width = Double.parseDouble(W);
   }

   public String toString()
   {
	return "Height is "+ height + "and length is " + length+ "Width is "+width;
   }

   public void CalculateArea()
   {
       area =  length*width;
   }
   public void CalculateVolume()
   {
	volume = length*width*height;
   }
}
