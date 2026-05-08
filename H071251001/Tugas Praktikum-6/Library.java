import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getitemId() == itemId) {
                return item;
            }
        }

        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        throw new NoSuchElementException("Member tidak ditemukan");
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append("+------+----------------------+------------+\n");
        sb.append("| ID   | Judul               | Status     |\n");
        sb.append("+------+----------------------+------------+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";

            sb.append(String.format("| %-4d | %-20s | %-10s |\n",
                    item.getitemId(),
                    item.getTitle(),
                    status));
        }

        sb.append("+------+----------------------+------------+");
        return sb.toString();
}
public String getAllogs(){
    return logger.getLogs();
}

public LibraryLogger getLogger(){
    return logger;
}
}