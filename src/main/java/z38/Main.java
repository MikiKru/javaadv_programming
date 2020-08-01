package z38;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(5);
        Thread thread = new Thread(new CoffeeMachineMaker(coffeeMachine));
        thread.start();

        while(true) {
            try {
                thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread1 = new Thread(new CoffeeMachineFiller(coffeeMachine));
            thread1.start();
            System.out.println("===");
        }
    }
}
