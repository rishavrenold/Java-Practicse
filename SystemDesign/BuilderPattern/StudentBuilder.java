package SystemDesign.BuilderPattern;

public abstract class StudentBuilder {
    int rollno;
    String name;
    String subject;

    public StudentBuilder setrollno(int rollno)
    {
        this.rollno=rollno;
        return this;
    }
    public StudentBuilder setname(String name)
    {
        this.name=name;
        return this;
    }
    public abstract StudentBuilder setSubject();

    public Student build() {
        return new Student(this);
    }

}
