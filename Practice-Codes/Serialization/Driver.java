import java.util.*;
import java.io.*;
import javax.swing.*;

class Student implements Serializable {
	String name;
	final int age = 18;
	char grade;

	public Student() {
		name = null;
		// age = 0;
		grade = '\0';
	}

	public Student(String name, char grade) {
		this.name = name;
		/* this.age = age; */
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public void setAge(int age) {
	 * this.age = age;
	 * }
	 */

	public void setGrade(char grade) {
		this.grade = grade;
	}
}

public class Driver {
	static ArrayList<Student> a1 = new ArrayList<>();

	public static void main(String args[]) {
		System.out.println("How many students : ");
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		in.nextLine();

		String name;
		int age;
		char grade;
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < total; i++) {
				System.out.println("Enter name : ");
				name = in.nextLine();
				System.out.println("Enter age : ");
				age = in.nextInt();
				in.nextLine();
				System.out.println("Enter grade : ");
				grade = in.nextLine().charAt(0);

				Student obj = new Student(name, grade);
				oos.writeObject(obj);

				a1.add(obj);

				/*
				 * oos.writeUTF(name);
				 * oos.writeInt(age);
				 * oos.writeChar(grade);
				 */
			}
			fos.close();
			oos.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		// Deseialize
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student s1;
			while ((s1 = (Student) ois.readObject()) != null) {

				System.out.println(s1.name + " " + s1.age + " " + s1.grade);
			}
			fis.close();
			ois.close();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());

		}

	}

}
