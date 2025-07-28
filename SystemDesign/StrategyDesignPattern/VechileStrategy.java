package SystemDesign.StrategyDesignPattern;

public class VechileStrategy {
    
    Vechile ob;

    VechileStrategy(Vechile obj)
    {
        this.ob=obj;
    }
    public void display()
    {
        ob.display();
    }
}
