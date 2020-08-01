package z34;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);    // wywołanie konstruktora klasy Thread(String name)
    }
    @Override
    public void run(){
        System.out.println("Jestem w wątku: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Jestem w wątku: " + Thread.currentThread().getName());
        MyThread myThread = new MyThread("mój wątek");
        myThread.start();
    }
}
