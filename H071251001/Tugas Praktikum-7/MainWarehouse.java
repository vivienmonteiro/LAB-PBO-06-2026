import java.lang.runtime.ExactConversionsSupport;
import java.util.concurrent.*;

public class MainWarehouse{
    public static void main(String[]args) throws InterruptedException{
        Gudang gudang = new Gudang(50);

        ExecutorService executor = Executors.newFixedThreadPool(6);

        // 2 pemasok
        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));

        // 3 kurir
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        //monitoring
        Thread monitor = new Thread (new Monitoring(gudang));
        monitor.start();

        Thread.sleep(15000);
        executor.shutdownNow();
        monitor.interrupt();

        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Sistem Selesai");


    }
}
