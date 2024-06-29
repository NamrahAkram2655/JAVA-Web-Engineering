import java.util.Scanner;

class Circle implements Shape
{
    private double radius, area , perimeter;
    private final double PI = 3.14;

    public Circle()
    {
	this.radius = area = perimeter = 0.0;
    }
    public Circle(double radius)
    {
	this.radius = radius;
    }
    public Circle(Circle obj)
    {
	this.radius = obj.radius;
    }
    
    public void setRadius(double radius)
    {
	this.radius = radius;
    }
    public Double getRadius()
    {
	return radius;
    }

    public double CalculateArea()
   {
	area = PI*(radius*radius);
	return area;
   }
   public double CalculatePerimeter()
   {
	perimeter = 2*PI*radius;
	return perimeter;
   }
   public String toString()
   {
	return "Circle , Area : "+ area +" Perimeter : " + perimeter;
   }

}