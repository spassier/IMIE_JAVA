package fr.imie.formation.poo.tp1;

public class TP1
{
	public static void main(String[] args)
	{
		Person person = new Person("Toto");
		person.sayHello();

		Student aStudent = new Student("Tata");
		aStudent.sayHello();
		
		System.out.println(aStudent.getName());
		
		Professor aProfessor = new Professor("Titi");
		aProfessor.sayHello();
		
		Professor aProfessor2 = new Professor("Tutu", 21021);
		aProfessor2.sayHello();
		
	}
}
