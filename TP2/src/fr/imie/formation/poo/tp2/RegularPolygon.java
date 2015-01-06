package fr.imie.formation.poo.tp2;

public class RegularPolygon extends Shape
{
	private Float n;
	private Float s;
	private Float r;
	
	public RegularPolygon(Float nParam, Float sParam, Float rParam)
	{
		super();

		if ( nParam < 3 || sParam < 0 || rParam < 0 )
			throw new IllegalArgumentException();

		this.n = nParam;
		this.s = sParam;
		this.r = rParam;

	}
	
	public RegularPolygon(Float nParam, Float rParam)
	{
		super();
		
		if ( nParam < 3 || rParam < 0 )
			throw new IllegalArgumentException();
		
		this.n = nParam;
		this.r = rParam;
		this.s = (float) (2.0f * r * Math.sin(Math.PI / n));

	}
	
	public float area()
	{
		return  n * new Triangle(r, r, s).area();
	}
	
	public float perimeter()
	{
		return  n * s;
	}
}
