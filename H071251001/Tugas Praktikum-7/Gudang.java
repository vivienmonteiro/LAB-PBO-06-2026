public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang (int kapasitas){
        this.kapasitasMaksimal = kapasitas;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException{
        while (stok + jumlah >kapasitasMaksimal){
            wait();
        }
        stok += jumlah;
        System.out.println("Pemasok menambah:" + jumlah + "| Stok:" + stok);
        notifyAll(); //tunggu jika penuh
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException{
        while (stok < jumlah){
            wait(); //tunggu jika kosong
        }
        stok -= jumlah;
        System.out.println("kurir mengambil: " + jumlah + " | Stok: " + stok);
        notifyAll();
    }

    public synchronized int getStok(){
        return stok;
    }
    public int getKapasitas(){
        return kapasitasMaksimal;
    }
}
