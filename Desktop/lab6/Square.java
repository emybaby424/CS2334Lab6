
public class Square extends Rectangle{

	
	public Square(String id, double size){
		super(id, size, size);		// calling the rectangle class
		
	}
		
	
	@Override
	public String getShapeType()
	{
		return "Square";			// returning the shape
	}
		

}


