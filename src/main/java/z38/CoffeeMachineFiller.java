package z38;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class CoffeeMachineFiller implements Runnable {
    private CoffeeMachine coffeeMachine;

    @Override
    public void run() {
        coffeeMachine.fillCoffee(new Random().nextInt(5) + 1);
    }
}
