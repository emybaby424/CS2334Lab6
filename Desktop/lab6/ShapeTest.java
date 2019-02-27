import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
		Shape rec = new Rectangle("A", 5.0, 4.0);
		Assert.assertEquals("Rectangle area incorrect.", 20.0, rec.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 18.0, rec.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "A", rec.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
		Shape tri = new EquilateralTriangle("dorito", 7.0);
		Assert.assertEquals("Triangle area incorrect.", 21.2176, tri.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 21.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "dorito", tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		Shape trape = new Trapezoid("block", 1.0, 2.0, 2.0, 4.0);
		Assert.assertEquals("Trapezoid area incorrect.", 2.9047, trape.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 9.0, trape.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trape.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "block", trape.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
		Shape ball = new Circle("o", 10.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*10.0*10.0, ball.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect", Math.PI*10.0*2.0, ball.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", ball.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "o", ball.getId());
	
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape s1 = new Square("A", 4.0);
		Shape s2 = new Rectangle("B", 4.0, 1.0);
		Shape s3 = new Trapezoid("C", 2.0, 3.0, 4.0, 1.0);
		Shape s4 = new Circle("D", 1.0);
		Shape s5 = new EquilateralTriangle("E", 1.0);
		
		Assert.assertEquals("Square:	 ID = A	 area = 16.000	 perimeter = 16.000", s1.toString());
		Assert.assertEquals("Rectangle:	 ID = B	 area = 4.000	 perimeter = 10.000", s2.toString());
		Assert.assertEquals("Trapezoid:	 ID = C	 area = 4.714	 perimeter = 10.000", s3.toString());
		Assert.assertEquals("Circle:	 ID = D	 area = 3.142	 perimeter = 6.283", s4.toString());
		Assert.assertEquals("EquilateralTriangle:	 ID = E	 area = 0.433	 perimeter = 3.000", s5.toString());
		
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
		Shape a = new Rectangle("R1", 4.0, 2.0);
		Shape b = new Rectangle("S1", 2.0, 4.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(a, b));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(a, b));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 4.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(sqr2, a));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(a, sqr2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, a));
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// TODO: complete this...
		Shape a = new Circle("A", 4.0);
		Shape b = new Circle("B", 4.0);
		
		Assert.assertEquals("CompareTest should find shapes equal", 0, a.compareTo(b));
		
		//Test equal perimeter, different area
		Shape c = new Rectangle("C", 1.0, 9.0);
		Shape d = new Square("D", 5.0);
		Assert.assertEquals("CompareTest found shapes incorrectly inequal", -1, c.compareTo(d));
		Assert.assertEquals("CompareTest found shapes incorrectly inequal", 1, d.compareTo(c));

		//Test unequal perimeter but equal area
		Shape e = new Rectangle("E", 12.0, 3.0);
		Shape f = new Square("F", 6.0);
		Assert.assertEquals("CompareTest found shapes incorrectly inequal", 1, e.compareTo(f));
		Assert.assertEquals("CompareTest found shapes incorrectly inequal", -1, f.compareTo(e));
		
    }
}
