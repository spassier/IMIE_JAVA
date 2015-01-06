package fr.imie.formation.poo.tp2;

public class Circle extends Shape
{
	private Float radius;
	
	public Circle(Float radiusParam)
	{
		super();
		
		if (radiusParam < 0.0f  )
			throw new IllegalArgumentException();
		
		this.radius = radiusParam;
	}
	
	public float area()
	{
		return (float)(Math.PI * radius * radius);
	}
	
	public float perimeter()
	{
		return  (float)(2 * Math.PI * radius);
	}
}
