package SystemDesign.StrategyDesignPattern;

public class Tata extends VechileStrategy{
    Tata()
    {
        super(new SuperVechile());
    }
}
