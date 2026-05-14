import java.util.Random;

public class Pemasok implements Runnable{
    private Gudang gudang;
    private Random rand = new Random();

    public Pemasok(Gudang gudang){
        this.gudang = gudang;
    }

    @Override
    public void run(){
        try{
            while (true){
                int jumlah = rand.nextInt(5) + 1;
                gudang.tambahStok(jumlah);
                Thread.sleep((rand.nextInt(2)+ 1)* 1000);
            }
            
        }catch (InterruptedException e ){
            System.out.println("Pemasok berhenti");
        }
    }
}
