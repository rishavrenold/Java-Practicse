package SystemDesign.Factory;

public class ShapeFactory {
    
    Shape getShape(String s)
    {   
        if(s.equalsIgnoreCase("Circle"))
        {
            return new Circle();
        }else if(s.equalsIgnoreCase("Rectangle"))
        {
            return new Rectangle();
        }
        return null;
    }
}
