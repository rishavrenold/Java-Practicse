package SystemDesign.BuilderPattern;

public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder)
    {
        this.studentBuilder=studentBuilder;
    }

    public Student createStudent()
    {
        if(studentBuilder instanceof EngineerStudent){
            return createEngineer();
        }
        return null;
    }

    public Student createEngineer()
    {
        return studentBuilder.setrollno(1).setname("Rishav").setSubject().build();
    }
}
