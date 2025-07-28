package SystemDesign.Factory;

public class MainClass {
    public static void main(String[] args) {
        ShapeFactory ob=new ShapeFactory();
        ob.getShape("Circle").draw();
    }
}
