import java.util.*;

class Person
{
	public void show(){
		System.out.println("It is Person class");
	}
}
class Teacher
{
	public void show(){
		System.out.println("It is Teacher class");
	}
}

class Driver
{
	HashMap<Integer, Object> hp;
	Driver()
	{
		hp = new HashMap<>();
	}
	public void putData()
	{
		Person p1 = new Person();
		Teacher t1 = new Teacher();
		Person p2 = new Person();
		Teacher t2 = new Teacher();
		
		hp.put(0, p1);
		hp.put(1, t1);
		hp.put(2, t2);
		hp.put(3, p2);
	}
	
	public void display()
	{
		for(int i=0; i<hp.size(); i++)
		{
			System.out.println(hp.get(i));
			Object obj = hp.get(i);
			if(obj instanceof Person)
			{
				Person p = (Person) obj;
				p.show();
			}
			if(obj instanceof Teacher)
			{
				Teacher t = (Teacher) obj;
				t.show();
			}
		}
	}
	
	public static void main(String args[])
	{
		Driver d  =  new Driver();
		d.putData();
		d.display();
	}
	
}