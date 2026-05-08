import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu : ");

            int pilihan = input.nextInt();
            input.nextLine();

            try {

                switch (pilihan) {

                    case 1:

                        System.out.println("1. Book");
                        System.out.println("2. DVD");
                        System.out.print("Pilih jenis item : ");

                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan judul : ");
                        String title = input.nextLine();

                        System.out.print("Masukkan ID Item : ");
                        int itemId = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {

                            System.out.print("Masukkan author : ");
                            String author = input.nextLine();

                            Book book = new Book(title, itemId, author);

                            System.out.println(library.addItem(book));

                        } else if (jenis == 2) {

                            System.out.print("Masukkan durasi DVD : ");
                            int duration = input.nextInt();
                            input.nextLine();

                            DVD dvd = new DVD(title, itemId, duration);

                            System.out.println(library.addItem(dvd));

                        } else {

                            System.out.println("Jenis item tidak valid");
                        }

                        break;

                    case 2:

                        System.out.print("Masukkan nama anggota : ");
                        String name = input.nextLine();

                        System.out.print("Masukkan ID anggota : ");
                        int memberId = input.nextInt();
                        input.nextLine();

                        Member member = new Member(name, memberId);

                        library.addMember(member);

                        System.out.println("Anggota berhasil ditambahkan");

                        break;

                    case 3:

                        System.out.print("Masukkan ID anggota : ");
                        int anggotaId = input.nextInt();

                        System.out.print("Masukkan ID item : ");
                        int pinjamItemId = input.nextInt();

                        System.out.print("Masukkan lama pinjam : ");
                        int days = input.nextInt();
                        input.nextLine();

                        Member anggota = library.findMemberById(anggotaId);
                        LibraryItem item = library.findItemById(pinjamItemId);

                        System.out.println(anggota.borrowItem(item, days));

                        break;

                    case 4:

                        System.out.print("Masukkan ID anggota : ");
                        int anggotaReturnId = input.nextInt();

                        System.out.print("Masukkan ID item : ");
                        int returnItemId = input.nextInt();

                        System.out.print("Masukkan jumlah hari terlambat : ");
                        int daysLate = input.nextInt();
                        input.nextLine();

                        Member memberReturn =
                                library.findMemberById(anggotaReturnId);

                        LibraryItem itemReturn =
                                library.findItemById(returnItemId);

                        System.out.println(
                                memberReturn.returnItem(itemReturn, daysLate)
                        );

                        break;

                    case 5:

                        System.out.println(
                                library.getLibraryStatus()
                        );

                        break;

                    case 6:

                        System.out.println("Program selesai");
                        input.close();

                        return;

                    default:

                        System.out.println("Menu tidak tersedia");
                }

            } catch (Exception e) {

                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}