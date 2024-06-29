import java.util.Scanner;
import javax.swing.*;

public class Calculator
{
	private String num1, num2,operator;
	
	//constructor
	
	Calculator()
	{
		num1 = num2 = operator = null;
	}
	Calculator(String num1, String num2, String operator)
	{
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	//getters
	public double getnum1()
	{
		double value1 = Double.parseDouble(num1);
		return value1;
	}

	public double getnum2()
	{
		double value2 = Double.parseDouble(num2);
		return value2;
	}
	
	public String getoperator()
	{
		return operator;
	}

	//setters
	public void setnum1(String num1)
	{
		this.num1 = num1;
	}

	public void setnum2(String num2)
	{
		this.num2 = num2;
	}

	public void setoperator(String operator)
	{
		this.operator = operator;
	}
	
	public static void main(String args[])
	{
		
		Calculator  obj = new Calculator();

		obj.num1 = JOptionPane.showInputDialog("Enter number1 : ");
		double number1 =  Double.parseDouble(obj.num1);
		
		while(number1 < 0)
		{
			obj.num1 = JOptionPane.showInputDialog("Enter non-negetive number1 : ");
			number1 =  Double.parseDouble(obj.num1);	
		}
		
		obj.num2 = JOptionPane.showInputDialog("Enter number2 : ");
		double number2 =  Double.parseDouble(obj.num2);	
		
		while(number2 < 0)
		{
			obj.num2 = JOptionPane.showInputDialog("Enter non-negetive number2 : ");
			number2 =  Double.parseDouble(obj.num2);	
		}
		
		obj.operator = JOptionPane.showInputDialog("Enter operator +-/* : ");

		obj.result(number1,number2,obj.operator);

		Calculator obj2 = new Calculator("12.5","8","+");
		
		double val1 = obj2.getnum1();
		double val2 = obj2.getnum2();

		obj2.result(val1, val2, obj2.getoperator());		
		
		
		
	}	
	public static void result(double a, double b, String op)
	{
		switch(op){
			
			case "+": 
				double sum = addition(a,b);
				JOptionPane.showMessageDialog(null,"Sum of two numbers is : " + sum);
				break;	
			case "-": 
				double subtract = subtraction(a,b);
				JOptionPane.showMessageDialog(null,"Difference of two numbers is : " + subtract);	
				break;	
			case "*": 
				double multiply = multiplication(a,b);
				JOptionPane.showMessageDialog(null,"Multipication of two numbers is : " + multiply);	
				break;	
			case "/": 
				double divide = division(a,b);
				JOptionPane.showMessageDialog(null,"division of two numbers is : " + divide);	
				break;	
			default: 
				JOptionPane.showMessageDialog(null,"Operator doesn't match ");	
				break;	
		}
	}
	public static double subtraction(double a, double b)
	{
		return a-b;
	}
	public static double addition(double a, double b)
	{
		return a+b;
	}
	public static double multiplication(double a, double b)
	{
		return a*b;
	}
	public static double division(double a, double b)
	{
		return a/b;
	}
}