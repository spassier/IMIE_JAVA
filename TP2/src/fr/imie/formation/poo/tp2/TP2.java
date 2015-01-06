package fr.imie.formation.poo.tp2;

public class TP2 
{
	public static void main(String[] args)
	{
		Rectangle rect = new Rectangle(10f, 20f);
		System.out.format("Area : %f\nPerimeter : %f\n", rect.area(), rect.perimeter());

		Circle circ = new Circle(20f);
		printAreaOf(circ);
		printPerimeterOf(rect);
		
		Triangle tri = new Triangle(10f, 15f, 20f);
		printAreaOf(tri);
		printPerimeterOf(tri);
	
		RegularPolygon regPoly = new RegularPolygon(4f, 10f, 10.0f); // n, s, r
		printAreaOf(regPoly);
		printPerimeterOf(regPoly);
		
		RegularPolygon regPoly2 = new RegularPolygon(8f, 10.0f);
		printAreaOf(regPoly2);
		printPerimeterOf(regPoly2);
		
		try
		{
			Triangle tri2 = new Triangle(10f, 45f, 20f);
			printAreaOf(tri2);
			printPerimeterOf(tri2);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.format("%s\n", e.getLocalizedMessage());
		}
		finally
		{
			System.out.println("Block finally exécuté");
		}
		
		RegularPolygon regPoly3 = new RegularPolygon(81f, 10.0f);
		printAreaOf(regPoly3);
		printPerimeterOf(regPoly3);

	}
	
	public static void printAreaOf(Shape aShape)
	{
		System.out.format("Area of the shape :%f\n", aShape.area());
	}
	
	public static void printPerimeterOf(Shape aShape)
	{
		System.out.format("Perimeter of the shape :%f\n", aShape.perimeter());
	}
}
