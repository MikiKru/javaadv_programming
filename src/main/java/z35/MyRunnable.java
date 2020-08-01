package z35;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Jestem w wątku: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Jestem w wątku: " + Thread.currentThread().getName());
        Thread thread = new Thread(new MyRunnable(), "wątek 1");
        thread.start();
        // za pomocą lambda expr

        Thread threadLambda = new Thread(
                () -> System.out.println("Jestem w wątku: " + Thread.currentThread().getName())
                , "wątek lambda");
        threadLambda.start();

        Thread threadAnonymousClass = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jestem w wątku: " + Thread.currentThread().getName());
            }
        }, "wątek z klasy anonimowej implementującej Runnable");
        threadAnonymousClass.start();
    }
}
