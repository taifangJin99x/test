import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Queue buffer = new LinkedList<>();
        int maxSize = 10;
        Thread thread1 = new Thread(new Producter(maxSize,buffer));
        Thread thread2 = new Thread(new Customer(maxSize,buffer));
        thread1.start();
        thread2.start();

    }

}
