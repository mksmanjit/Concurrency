package foo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CountDownRunnable runnable = new CountDownRunnable();
        runnable.setLatch(countDownLatch);
        Thread t1 = new Thread(runnable);
        /*Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();*/
        t1.start();
        countDownLatch.await();
    }

}

class CountDownRunnable implements Runnable {
    private CountDownLatch latch;
    public void run() {
        System.out.println("Hello");
        getLatch().countDown();
        System.out.println("1");
        getLatch().countDown();
        System.out.println("2");
        getLatch().countDown();
        System.out.println("3");
    }
    /**
     * @return the latch
     */
    public CountDownLatch getLatch() {
        return latch;
    }
    /**
     * @param latch the latch to set
     */
    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}
