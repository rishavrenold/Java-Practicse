package SystemDesign.BuilderPattern;

public class Main {

    public static void main(String[] args) {
        Director director=new Director(new EngineerStudent());
        Student student=director.createStudent();
        System.out.println(student.toString());  
    }
    
}
