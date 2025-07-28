package SystemDesign.BuilderPattern;

public class Student {
    int rollno;
    String name;
    String subject;

    Student(StudentBuilder sb)
    {
        this.rollno=sb.rollno;
        this.name=sb.name;
        this.subject=sb.subject;
    }

    public String toString(){
        return ""+ " roll number: " + this.rollno +
                " name: " + this.name +
                " subjects: " +this.subject;
    }

}
