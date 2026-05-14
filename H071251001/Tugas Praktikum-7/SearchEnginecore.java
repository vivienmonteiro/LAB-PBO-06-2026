import java.util.*;
import java.util.concurrent.*;

public class SearchEnginecore {
    public static void main(String[] args) throws InterruptedException {
        
        List<String> dokumen = Arrays.asList(
            "Doc1.txt","Doc2.txt","Doc3.txt","Doc4.txt","Doc5.txt",
            "Doc6.txt","Doc7.txt","Doc8.txt","Doc9.txt","Doc10.txt"
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);
        ConcurrentHashMap<String, Integer> hasil = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(dokumen.size());

        DataProcessor processor = new DataProcessor();

        long start = System.currentTimeMillis();

        for (String doc : dokumen) {
            executor.execute(() -> {
                long t1 = System.currentTimeMillis();

                int kata = processor.process(doc);

                long t2 = System.currentTimeMillis();

                hasil.put(doc, kata);

                System.out.println(Thread.currentThread().getName() +
                        " selesai memproses " + doc + " (" + kata + " kata)");

                latch.countDown();
            });
        }

        latch.await();

        long end = System.currentTimeMillis();

        executor.shutdown();

        // OUTPUT AKHIR
        System.out.println("\n=== HASIL AKHIR ===");

        int total = 0;

        for (String doc : hasil.keySet()) {
            int kata = hasil.get(doc);
            total += kata;
            System.out.println(doc + " = " + kata + " kata");
        }

        System.out.println("Total kata: " + total);
        System.out.println("Durasi total: " + (end - start) + " ms");
        System.out.println("Rata-rata waktu: " + ((end - start) / dokumen.size()) + " ms");
    }
}