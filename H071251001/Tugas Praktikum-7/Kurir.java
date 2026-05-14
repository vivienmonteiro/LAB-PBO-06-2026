import java.util.Random;

public class Kurir implements Runnable {
    private Gudang gudang;
    private Random rand = new Random();

    public Kurir (Gudang gudang){
        this.gudang = gudang; 
    }

    @Override
public void run(){
    try{
        while(true){
            int jumlah = rand.nextInt(5) + 1;
            gudang.ambilStok(jumlah);
            Thread.sleep((rand.nextInt(2) + 2) * 1000);
        }
    }catch (InterruptedException e) {
        System.out.println("Kurir berhenti");
    }
}
}
