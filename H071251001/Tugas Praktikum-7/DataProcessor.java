import java.util.Random;

class DataProcessor {
    public int process(String fileName) {
        try {
            int waktu = new Random().nextInt(1500) + 500;
            Thread.sleep(waktu);

            int jumlahKata = new Random().nextInt(200) + 50;
            return jumlahKata;

        } catch (InterruptedException e) {
            return 0;
        }
    }
}