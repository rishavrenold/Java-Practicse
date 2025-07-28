package CreationalDesignPattern.BuilderPattern;

// The number of requirements could increase overtime 
// at 1st its is only bun patty, later could change to sides, topppings, cheese 
//  to solve this builder pattern was followed to subdue the increasing requirement overtime 
// or to only use what is required.

import java.util.*;
class BurgerMeal{
    private final String bun;
    private final String patty;
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;

    private BurgerMeal(BurgerBuilder builder)
    {
        this.bun=builder.bunType;
        this.patty=builder.patty;
        this.hasCheese=builder.hasCheese;
        this.toppings=builder.toppings;
        this.side=builder.side;
        this.drink=builder.drink;
    }

    public static class BurgerBuilder{
        private  String bunType;
        private  String patty;
        private  boolean hasCheese;
        private  List<String> toppings;
        private  String side;
        private  String drink;

        public BurgerBuilder (String bunType,String patty)
        {
            this.bunType=bunType;
            this.patty=patty;
        }
        public BurgerBuilder withCheese(boolean hasCheese)
        {
            this.hasCheese=hasCheese;
            return this;
        }
        public BurgerBuilder withToppings(List<String> toppings)
        {
            this.toppings=toppings;
            return this;
        }
         public BurgerBuilder withSide(String side)
        {
            this.side=side;
            return this;
        }
         public BurgerBuilder withDrink(String drink)
        {
            this.drink=drink;
            return this;
        }
        public BurgerMeal build()
        {
            return new BurgerMeal(this);
        }
    }

    @Override
    public String toString() {
        return "BurgerMeal [bun=" + bun + ", patty=" + patty + ", hasCheese=" + hasCheese + ", toppings=" + toppings
                + ", side=" + side + ", drink=" + drink + "]";
    }
    
    
}
public class BuilderPattern {
    public static void main(String[] args) {
        // Creating burger with only required fields
        BurgerMeal plainBurger = new BurgerMeal.BurgerBuilder("wheat", "veg")
                                    .build();

        // Burger with cheese only
        BurgerMeal burgerWithCheese = new BurgerMeal.BurgerBuilder("wheat", "veg")
                                        .withCheese(true)
                                        .build();

        // Fully loaded burger
        List<String> toppings = Arrays.asList("lettuce", "onion", "jalapeno");
        BurgerMeal loadedBurger = new BurgerMeal.BurgerBuilder("multigrain", "chicken")
                                        .withCheese(true)
                                        .withToppings(toppings)
                                        .withSide("fries")
                                        .withDrink("coke")
                                        .build();
        System.out.println(plainBurger.toString());
        System.out.println(burgerWithCheese.toString());
        System.out.println(loadedBurger.toString());
        
    }
}
