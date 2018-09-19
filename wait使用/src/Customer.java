import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Customer implements Runnable{
    Integer maxSize;
    Queue<String> queue = new ArrayBlockingQueue(10);

    public Customer(int maxSize, Queue buffer) {
        this.maxSize = maxSize;
        this.queue = buffer;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == 0){
                    System.out.println("已空");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.remove();
//                System.out.println("remove"+queue.size());
                queue.notifyAll();
            }
        }
    }
}
