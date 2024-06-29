import javax.swing.*;

public class GuiTask
{
	public static void main(String args[])
	{
		String a1,a2;

		a1 = JOptionPane.showInputDialog("Enter number 1 : ");

		a2 = JOptionPane.showInputDialog("Enter number 2 : ");
		
		double num1  = Double.parseDouble(a1);
		double num2  = Double.parseDouble(a2);
		
		double sum = num1+num2;

		JOptionPane.showMessageDialog(null,"Sum of both number is : "+ sum);

 	}
}