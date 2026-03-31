import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PrimeChecker {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void printPrimesInRange(String threadName, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(threadName + " found Prime: " + i);
            }
        }
    }
}

// 1. Using Thread Class
class PrimeThread extends Thread {
    private int start, end;
    public PrimeThread(int start, int end) { this.start = start; this.end = end; }
    @Override
    public void run() {
        PrimeChecker.printPrimesInRange("Thread-Class", start, end);
    }
}

// 2. Using Runnable Interface
class PrimeRunnable implements Runnable {
    private int start, end;
    public PrimeRunnable(int start, int end) { this.start = start; this.end = end; }
    @Override
    public void run() {
        PrimeChecker.printPrimesInRange("Runnable-Task", start, end);
    }
}

public class MultithreadedPrime {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("--- Starting Thread Class ---");
        PrimeThread t1 = new PrimeThread(1, 10);
        t1.start();
        t1.join();

        System.out.println("\n--- Starting Runnable Interface ---");
        Thread t2 = new Thread(new PrimeRunnable(11, 20));
        t2.start();
        t2.join();

        System.out.println("\n--- Starting Executor Framework ---");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        executor.execute(() -> PrimeChecker.printPrimesInRange("Executor-1", 21, 30));
        executor.execute(() -> PrimeChecker.printPrimesInRange("Executor-2", 31, 40));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("\nAll tasks completed.");
    }
}
