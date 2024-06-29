import java.util.Scanner;

class Square implements Shape
{
   private double length, width, area , perimeter;
   
   public Square()
   {
	length = width = area = perimeter = 0.0;
   }
   public Square(double length, double width)
   {
	this.length = length;
	this.width = width;
   }
   public Square(Square obj)
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
	return "Square , Area : "+ area +" Perimeter : " + perimeter;
   }
}