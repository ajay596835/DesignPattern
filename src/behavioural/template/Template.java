package behavioural.template;




abstract class CoffeeMaker {
    // Template method
    public final void prepareCoffee() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addCondiments();
    }

    // Abstract methods to be overridden by subclasses
    protected abstract void brewCoffeeGrinds();
    protected abstract void addCondiments();

    // Common methods
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class BlackCoffeeMaker extends CoffeeMaker {
    @Override
    protected void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

class LatteCoffeeMaker extends CoffeeMaker {
    @Override
    protected void brewCoffeeGrinds() {
        System.out.println("Steeping the coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding milk foam");
    }
}

public class Template {
    public static void main(String[] args) {
        CoffeeMaker blackCoffee = new BlackCoffeeMaker();
        blackCoffee.prepareCoffee();

        CoffeeMaker latteCoffee = new LatteCoffeeMaker();
        latteCoffee.prepareCoffee();
    }
}
