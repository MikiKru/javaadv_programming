package z38;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Thread.sleep;

@AllArgsConstructor
public class CoffeeMachine {
    private int coffeeCapacity;

    public synchronized void makeCoffee() throws InterruptedException {
        while(true) {
            if (coffeeCapacity == 0) {
                wait();
            }
            System.out.println("Coffee is ready");
            this.coffeeCapacity--;
            sleep(1000);
        }
    }
    public synchronized void fillCoffee(int value){
        this.coffeeCapacity += value;
        if(this.coffeeCapacity >= 0){
            notify();
        }
    }

}
