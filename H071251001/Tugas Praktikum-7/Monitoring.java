public class Monitoring implements Runnable {
    private Gudang gudang;

    public Monitoring(Gudang gudang){
        this.gudang = gudang;
    }
    @Override
    public void run(){
        try{
            while(true){
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitas();

                int persen = (stok * 100) / kapasitas;
                String bar = "#".repeat(persen/10) + "-".repeat(10 -(persen/10));

                System.out.println("Status Gudang: ["+ bar +"] "+ persen + "%");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e ){
            System.out.println("Monitoring berhenti");
        }
    }
    
}
