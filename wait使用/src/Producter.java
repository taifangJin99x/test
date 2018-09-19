import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Producter implements Runnable{
    Integer maxSize;
    Queue<String> buffer = new ArrayBlockingQueue(10);
    public Producter(int maxSize, Queue buffer) {
        this.maxSize = maxSize;
        this.buffer = buffer;
    }

    @Override
    public void run() {
       while (true){
           synchronized (buffer){
               while (buffer.size() ==10){
                   System.out.println("已满");
                   try {
                       buffer.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               buffer.add("a");
//               System.out.println("add"+buffer.size());
               buffer.notifyAll();


           }
       }
    }
}
