package lab;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutor {

    final static java.util.concurrent.ScheduledThreadPoolExecutor executor = new java.util.concurrent.ScheduledThreadPoolExecutor(4);

    public static void main(String[] args) {
        executor.scheduleAtFixedRate(new MyClass("kakaha"), 300, 300, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new MyClass("rubaha"), 300, 300, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new MyClass("chubaka"), 300, 300, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new MyClass("rubaka"), 300, 300, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new MyClass("vonyaka"), 300, 300, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new MyClass("gavnyaka"), 300, 300, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new MyClass("sabaka"), 300, 300, TimeUnit.MILLISECONDS);
    }

}

class MyClass implements Runnable {

    String name;
    int counter = 0;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("My name is: " + name + ", i in thread: " + thread.getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter++;
        System.out.println(thread.getName() + " slept, i executed: " + counter + " times");
    }

}