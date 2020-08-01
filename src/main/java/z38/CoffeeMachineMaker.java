package z38;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoffeeMachineMaker implements Runnable {
    private CoffeeMachine coffeeMachine;

    @Override
    public void run() {
        try {
            coffeeMachine.makeCoffee();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
