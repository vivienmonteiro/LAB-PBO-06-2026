import java.util.ArrayList;
import java.util.List;

public class Member{
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId){
        this.name = name;
        this. memberId = memberId;
        borrowedItems = new ArrayList<>();
    }

    public String borrowItem(LibraryItem item, int days){
        if (item.isBorrowed()){
            throw new IllegalArgumentException("Item sedang dipinjam ");   
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }
    public String returnItem(LibraryItem item, int dayslate){
        borrowedItems.add(item);
        item.returnItem();

        double fine = item.calculateFine(dayslate);

        return "Item" + item.getTitle()+ "berhasil dikembalikan dengan denda: Rp" + fine;
    }

    public void getBorrowedItems(){
        if(borrowedItems.isEmpty()){
            System.out.println("Tidak ada item yang dipinjam ");
            return;
        }
        System.out.println("+------+----------------------+");
        System.out.println("| ID   | Judul               |");
        System.out.println("+------+----------------------+");

        for (LibraryItem item : borrowedItems){
            System.out.printf("| %-4d | %-20s |", item.getitemId(), item.getTitle());
        }
        System.out.println("+------+----------------------+");
    }

    public String getname(){
        return name;
    }

    public int getMemberId(){
        return memberId;
    }
}