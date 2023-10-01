package machine.packages.enums;

import machine.packages.data.CoffeeIngredients;

import java.util.Objects;

public enum CoffeeTypes {
    ESPRESSO("espresso", "1", new CoffeeIngredients(250, 0, 16, 1 , 4)),
    LATTE("latte", "2", new CoffeeIngredients(350, 75, 20, 1 , 7)),
    CAPPUCCINO("cappuccino", "3", new CoffeeIngredients(200, 100, 12, 1 , 6));

    public final String type;

    public String number;
    public final CoffeeIngredients ingredients;

    CoffeeTypes(String type, String number, CoffeeIngredients ingredients) {
        this.type = type;
        this.number = number;
        this.ingredients = ingredients;
    }

    public static CoffeeTypes stringToCoffeeType(String type) {
        if(Objects.equals(type, ESPRESSO.type)) {
            return ESPRESSO;
        }
        if(Objects.equals(type, LATTE.type)) {
            return LATTE;
        }

        return LATTE;

    }
}



