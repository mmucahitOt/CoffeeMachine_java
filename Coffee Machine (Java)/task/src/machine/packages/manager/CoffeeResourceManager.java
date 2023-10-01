package machine.packages.manager;

import machine.packages.data.CoffeeIngredients;
import machine.packages.enums.CoffeeTypes;

public class CoffeeResourceManager {
    private int remainingWater = 400;
    private int remainingMilk = 540;
    private int remainingBean = 120 ;
    private int remainingCups = 9;

    private int earning = 550;
    public void fillResources(int amountOfWater, int amountOfMilk, int amountOfBean, int amountOfCups) {
        this.remainingWater += amountOfWater;
        this.remainingMilk += amountOfMilk;
        this.remainingBean += amountOfBean;
        this.remainingCups += amountOfCups;
    }

    public void sellACup(CoffeeTypes type) {
        switch (type) {
            case ESPRESSO -> {
                this.remainingWater -=  CoffeeTypes.ESPRESSO.ingredients.water();
                this.remainingBean -=  CoffeeTypes.ESPRESSO.ingredients.bean();
                this.remainingCups -=  CoffeeTypes.ESPRESSO.ingredients.disposableCups();
                this.earning += CoffeeTypes.ESPRESSO.ingredients.price();
            }
            case LATTE -> {
                this.remainingWater -=  CoffeeTypes.LATTE.ingredients.water();
                this.remainingMilk -=  CoffeeTypes.LATTE.ingredients.milk();
                this.remainingBean -=  CoffeeTypes.LATTE.ingredients.bean();
                this.remainingCups -=  CoffeeTypes.LATTE.ingredients.disposableCups();
                this.earning += CoffeeTypes.LATTE.ingredients.price();
            }
            case CAPPUCCINO -> {
                this.remainingWater -=  CoffeeTypes.CAPPUCCINO.ingredients.water();
                this.remainingMilk -=  CoffeeTypes.CAPPUCCINO.ingredients.milk();
                this.remainingBean -=  CoffeeTypes.CAPPUCCINO.ingredients.bean();
                this.remainingCups -=  CoffeeTypes.CAPPUCCINO.ingredients.disposableCups();
                this.earning += CoffeeTypes.CAPPUCCINO.ingredients.price();
            }
            default -> this.earning += 0;
        }
    }

    public boolean validateRemaining(CoffeeTypes type) {
        switch (type) {
            case ESPRESSO -> {
                if (this.remainingWater < CoffeeTypes.ESPRESSO.ingredients.water()) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                }
                if (this.remainingMilk < CoffeeTypes.ESPRESSO.ingredients.milk()) {
                    System.out.println("Sorry, not enough milk!");
                    return false;
                }
                if (this.remainingBean < CoffeeTypes.ESPRESSO.ingredients.bean()) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                if (this.remainingCups < CoffeeTypes.ESPRESSO.ingredients.disposableCups()) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return false;
                }
            }
            case LATTE -> {
                if (this.remainingWater < CoffeeTypes.LATTE.ingredients.water()) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                }
                if (this.remainingMilk < CoffeeTypes.LATTE.ingredients.milk()) {
                    System.out.println("Sorry, not enough milk!");
                    return false;
                }
                if (this.remainingBean < CoffeeTypes.LATTE.ingredients.bean()) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                if (this.remainingCups < CoffeeTypes.LATTE.ingredients.disposableCups()) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return false;
                }
            }
            case CAPPUCCINO ->{
                if (this.remainingWater < CoffeeTypes.CAPPUCCINO.ingredients.water()) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                }
                if (this.remainingMilk < CoffeeTypes.CAPPUCCINO.ingredients.milk()) {
                    System.out.println("Sorry, not enough milk!");
                    return false;
                }
                if (this.remainingBean < CoffeeTypes.CAPPUCCINO.ingredients.bean()) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                if (this.remainingCups < CoffeeTypes.CAPPUCCINO.ingredients.disposableCups()) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return false;
                }
            }
            default -> {
                return true;
            }
        }
        return true;
    }

    public CoffeeIngredients getResources() {
        return new CoffeeIngredients(remainingWater, remainingMilk, remainingBean, remainingCups, earning);
    }

    public void printResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.remainingWater);
        System.out.printf("%d ml of milk\n", this.remainingMilk);
        System.out.printf("%d g of coffee beans\n", this.remainingBean);
        System.out.printf("%d disposable cups\n", this.remainingCups);
        System.out.printf("$%d of money\n", this.earning);
    }

    public int takeAllEarnings() {
        int total = this.earning;
        this.earning = 0;

        return total;
    }


}
