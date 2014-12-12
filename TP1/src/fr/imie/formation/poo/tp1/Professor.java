package fr.imie.formation.poo.tp1;

public class Professor extends Person
{
	private Integer salary;
	
	public Professor(String name)
	{
		super(name);
		this.salary = 0;
	}
	
	public Professor(String name, int salary)
	{
		super(name);
		this.salary = salary;
	}


	public void sayHello()
	{
		super.sayHello();
		
		if (salary == 0)
			System.out.println("Object of class ".concat(this.getClass().getName()) + " said hello");
		else
			System.out.println("Object of class ".concat(this.getClass().getName()) + " said hello and earn :" + salary.toString());

	}

}
