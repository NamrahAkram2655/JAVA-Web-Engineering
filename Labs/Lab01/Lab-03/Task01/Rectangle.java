import java.util.Scanner;

class Rectangle implements Shape
{
   private double length, width, area , perimeter;
   
   public Rectangle()
   {
	length = width = area = perimeter = 0.0;
   }
   public Rectangle(double length, double width)
   {
	this.length = length;
	this.width = width;
   }
   public Rectangle(Rectangle obj)
   {
	this.length = obj.length;
	this.width = obj.width;
   }

   public void setLength()
   {
	this.length = length;
   }
   public void setWidth()
   {
	this.width = width;
   }
   public double getLength()
   {
	return length;
   }
   public double getWidth()
   {
	return width;
   }

   public double CalculateArea()
   {
	area = length*width;
	return area;
   }
   public double CalculatePerimeter()
   {
	perimeter = 2*(length + width);
	return perimeter;
   }
   public String toString()
   {
	return "Rectangle , Area : "+ area +" Perimeter : " + perimeter;
   }
}