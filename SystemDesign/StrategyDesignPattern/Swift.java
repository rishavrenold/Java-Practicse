package SystemDesign.StrategyDesignPattern;

public class Swift extends VechileStrategy{

    Swift() {
        super(new NormalaVechile());
    }
    
}
