package machine.packages.enums;

public enum CoffeeIngredientType {
    WATER("water"),
    MILK("milk"),
    BEAN("bean");

    final String type;

    CoffeeIngredientType(String type) {
        this.type = type;
    };
}
