import java.util.LinkedList;

class SharedBuffer {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACITY = 2;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == CAPACITY) {
                    wait();
                }
                System.out.println("Producer produced: " + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                int val = list.removeFirst();
                System.out.println("Consumer consumed: " + val);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producerThread = new Thread(() -> {
            try { buffer.produce(); } catch (InterruptedException e) {}
        });

        Thread consumerThread = new Thread(() -> {
            try { buffer.consume(); } catch (InterruptedException e) {}
        });

        producerThread.start();
        consumerThread.start();
    }
}
