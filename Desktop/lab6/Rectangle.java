
public class Rectangle extends Polygon {
	
	private double width, height;
	
	/**
	 * constructor for Rectangle
	 */
	
	public Rectangle(String id, double width, double height) {
		super(id);
		this.width = width;
		this.height = height;
		
		sideLengths.add(width);
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(height);

	}
	
	
	@Override
	public double getArea() {
		
		return width * height;		// calculating the area of a rectangle
		
	}
	
	@Override
	public String getShapeType()
	{
		return "Rectangle";			// returning the shape
	}
		

}
