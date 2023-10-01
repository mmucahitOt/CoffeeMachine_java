package machine.packages;

import machine.packages.enums.CoffeeTypes;
import machine.packages.enums.Mode;
import machine.packages.manager.CoffeeResourceManager;

import java.util.Objects;
import java.util.Scanner;

public class Machine {

    private int requestedCupsOfCoffee;
    CoffeeResourceManager coffeeResourceManager;
    public Machine() {
        this.coffeeResourceManager = new CoffeeResourceManager();
    }

    public void startCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String mode = scanner.next();
            if (Objects.equals(mode, Mode.FILL.mode)) {
                System.out.println();
                this.fill();
            } else if (Objects.equals(mode, Mode.BUY.mode)) {
                System.out.println();
                this.buy();
            } else if (Objects.equals(mode, Mode.TAKE.mode)) {
                System.out.println();
                this.take();
            }
            else if (Objects.equals(mode, Mode.REMAINING.mode)) {
                System.out.println();
                coffeeResourceManager.printResources();
            }
            if (Objects.equals(mode, Mode.EXIT.mode)) {
                return;

            }
        }

    };

    void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int amountOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int amountOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int amountOfBean  = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int amountOfCups  = scanner.nextInt();
        coffeeResourceManager.fillResources(amountOfWater, amountOfMilk, amountOfBean, amountOfCups);
    }

    void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.next();

        CoffeeTypes type = CoffeeTypes.stringToCoffeeType(coffeeType);
        boolean valid = coffeeResourceManager.validateRemaining(type);
        if (valid) {
            System.out.println("I have enough resources, making you a coffee!");
            if (Objects.equals(coffeeType, CoffeeTypes.ESPRESSO.number)) {
                coffeeResourceManager.sellACup(CoffeeTypes.ESPRESSO);
            } else if (Objects.equals(coffeeType, CoffeeTypes.LATTE.number)) {
                coffeeResourceManager.sellACup(CoffeeTypes.LATTE);
            } else if (Objects.equals(coffeeType, CoffeeTypes.CAPPUCCINO.number)) {
                coffeeResourceManager.sellACup(CoffeeTypes.CAPPUCCINO);
            } else if (Objects.equals(coffeeType, "back")) {
                return;
            }
        }
    }

    void take() {
        int total = coffeeResourceManager.takeAllEarnings();
        System.out.printf("I gave you $%d", total);
    }

}
