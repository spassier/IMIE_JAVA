package fr.imie.formation.poo.tp2;

public class Rectangle extends Shape
{
	private Float width;
	private Float height;
	
	public Rectangle(Float widthParam, Float heightParam)
	{
		super();
		
		if (widthParam < 0 || heightParam < 0 )
			throw new IllegalArgumentException();
		
		this.width = widthParam;
		this.height = heightParam;
		
	}
	
	public float area()
	{
		return width * height;
	}
	
	public float perimeter()
	{
		return  2 * (width +  height);
	}
}
