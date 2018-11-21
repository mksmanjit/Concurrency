package foo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        CyclicBarrierRunnable runnable = new CyclicBarrierRunnable();
        runnable.setBarrier(barrier);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable); 
        t1.start();
        t2.start();
        barrier.reset();
        t1 = new Thread(runnable);
        t2 = new Thread(runnable); 
        t1.start();
        t2.start();
    }

}

class CyclicBarrierRunnable implements Runnable {
    private CyclicBarrier barrier;
    public void run() {
        try {
            System.out.println("Hello");
            getBarrier().await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * @return the barrier
     */
    public CyclicBarrier getBarrier() {
        return barrier;
    }
    /**
     * @param barrier the barrier to set
     */
    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    
    
}
