package fr.imie.formation.poo.tp2;

public class Triangle extends Shape
{
	private Float side1;
	private Float side2;
	private Float side3;
	
	public Triangle(Float side1Param, Float side2Param, Float side3Param)
	{
		super();
		
		if ( (side1Param > (side2Param + side3Param)) || (side2Param > (side1Param + side3Param)) || (side3Param > (side2Param + side1Param)) )
			throw new IllegalArgumentException("Erreur de valeurs dans la création d'un objet triangle");
		
		this.side1 = side1Param;
		this.side2 = side2Param;
		this.side3 = side3Param;
		
	}
	
	public float area()
	{
		float perimeter = this.perimeter();
		return (float)(Math.sqrt( (perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3)) / 16));
	}
	
	public float perimeter()
	{
		return  side1 + side2 + side3;
	}
}
