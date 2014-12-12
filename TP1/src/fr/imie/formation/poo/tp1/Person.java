package fr.imie.formation.poo.tp1;

public class Person
{
	private String name;
	
	/**
	 * Constructeur
	 * @param name
	 */
	public Person(String name)
	{
		this.name = name;
	}
	
	/**
	 * Affiche 'bonjour + le nom de l'objet'
	 */
	public void sayHello()
	{
		System.out.println("Hello, my name is ".concat(this.name));
	}
	
	/**
	 * Obtenir le nom de l'objet
	 * @return name Le nom de l'objet
	 */
	public String getName()
	{
		return this.name;
	}
}
