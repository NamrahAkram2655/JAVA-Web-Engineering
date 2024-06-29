import java.io.*;
import java.util.*;

class Employee {
	private int id;
	private String name;
	private static double salary;
	private String rank;

	public Employee(int id, String name, double salary, String rank) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static double getSalary() {
		return salary;
	}

	public String getRank() {
		return rank;
	}
}

public class EmployeeManagement {
	private static ArrayList<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {
		loadDataFromCSV("employees.csv");
		Scanner person = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nEmployee Management System");
			System.out.println("1. Add new employee");
			System.out.println("2. Remove employee");
			System.out.println("3. Save employee records to file");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = person.nextInt();
			person.nextLine(); // consume newline

			switch (choice) {
				case 1:
					addEmployee(person);
					break;
				case 2:
					removeEmployee(person);
					break;
				case 3:
					saveRecordsToFile("employee_records.txt");
					break;
				case 4:
					System.out.println("Exiting program...");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number from 1 to 4.");
			}
		} while (choice != 4);
	}

	private static void loadDataFromCSV(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				double salary = Double.parseDouble(data[2]);
				String rank = data[3];
				employees.add(new Employee(id, name, salary, rank));
			}
			br.close();
			System.out.println("Data loaded successfully from CSV.");
		} catch (IOException e) {
			System.out.println("Error reading from CSV file: " + e.getMessage());
		}
	}

	private static void addEmployee(Scanner scanner) {
		
		System.out.print("Enter employee ID: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // consume newline
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();
		System.out.print("Enter employee salary: ");
		double salary = scanner.nextDouble();
		scanner.nextLine(); // consume newline
		System.out.print("Enter employee rank: ");
		String rank = scanner.nextLine();
		employees.add(new Employee(id, name, salary, rank));
		System.out.println("Employee added successfully.");
	}

	private static void removeEmployee(Scanner scanner) {
		System.out.print("Enter employee ID to remove: ");
		int idToRemove = scanner.nextInt();
		boolean removed = false;
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getId() == idToRemove) {
				iterator.remove();
				removed = true;
				System.out.println("Employee with ID " + idToRemove + " removed successfully.");
				break;
			}
		}
		if (!removed)
			System.out.println("Employee with ID " + idToRemove + " not found.");
	}

	private static void saveRecordsToFile(String filename) {
		try {
			PrintWriter writer = new PrintWriter(filename);
			for (Employee employee : employees) {
				writer.println(employee.getId() + "," + employee.getName() + "," + employee.getSalary() + ","
						+ employee.getRank());
			}
			writer.close();
			System.out.println("Employee records saved to " + filename + " successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("Error saving records to file: " + e.getMessage());
		}
	}
}
