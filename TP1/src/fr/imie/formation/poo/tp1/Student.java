package fr.imie.formation.poo.tp1;

public class Student extends Person
{
	public Student(String name)
	{
		super(name);
	}
	
	public void sayHello()
	{
		System.out.println("Object of class ".concat(this.getClass().getName()) + " said hello");
	}
}
