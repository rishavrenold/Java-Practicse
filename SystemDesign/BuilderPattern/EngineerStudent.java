package SystemDesign.BuilderPattern;

public class EngineerStudent extends StudentBuilder{

    @Override
    public StudentBuilder setSubject() {
        this.subject="DSA";
        return this;
    }
    
}
