package PerpustakaanOOP;


import java.util.Scanner;

public class MainApp {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Library lib = new Library();

        System.out.println("Selamat Datang di Perpustakaan Universitas Klabat! 📚🎓");
        System.out.print("Siapa nama anda? ");
        String nama = sc.nextLine();
        System.out.print("Jurusan anda apa? ");
        String jurusan = sc.nextLine();
        System.out.print("Sudah Semester Berapa anda? ");
        String semester = sc.nextLine();

        while (true) {
            System.out.println("\n==== Perpustakaan Universitas Klabat ====");
            System.out.println("1. Masuk Ke dalam perpustakaan 📖");
            System.out.println("2. Profil User 👤");
            System.out.println("3. Keluar 🚪");
            System.out.println("========================================");
            System.out.print("Masukkan Pilihan anda = ");
            int pilih = safeIntInput();

            if (pilih == 1) {
                mainMenu(lib);
            } else if (pilih == 2) {
                profilUser(nama, jurusan, semester);
            } else if (pilih == 3) {
                System.out.println("Terima kasih! Sampai Jumpa Lagi! 👋");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void profilUser(String nama, String jurusan, String semester) {
        System.out.println("\n📋 Profil User");
        System.out.println("Nama User : " + nama);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Semester : " + semester);
        System.out.println("Status Mahasiswa : Aktif 🎓✨");
    }

    private static void mainMenu(Library lib) {
        while (true) {
            System.out.println("\n============= Menu =================");
            System.out.println("1. Kelola Buku 📚");
            System.out.println("2. Peminjaman Buku 📖");
            System.out.println("3. Cari Buku 🔍");
            System.out.println("4. Keluar 🚪");
            System.out.println("====================================");
            System.out.print("Masukkan Pilihan anda : ");
            int pilih = safeIntInput();

            if (pilih == 1) {
                menuKelola(lib);
            } else if (pilih == 2) {
                menuPinjam(lib);
            } else if (pilih == 3) {
                menuCari(lib);
            } else if (pilih == 4) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void menuKelola(Library lib) {
        while (true) {
            System.out.println("\n====== Sub Menu Kelola Buku ========");
            System.out.println("1. Tambahkan Buku ➕");
            System.out.println("2. Hapus Buku ❌");
            System.out.println("3. Urutkan Buku 🔢 (Descending)");
            System.out.println("4. Perbaharui Informasi Buku 🔄");
            System.out.println("5. Keluar 🚪");
            System.out.println("====================================");
            System.out.print("Masukkan Pilihan anda: ");
            int pilih = safeIntInput();

            if (pilih == 1) {
                System.out.print("Masukkan judul: ");
                String judul = sc.nextLine();
                System.out.print("Masukkan pengarang: ");
                String pengarang = sc.nextLine();

                System.out.print("Tipe (1=PrintedBook, 2=EBook): ");
                int tipe = safeIntInput();
                if (tipe == 2) {
                    System.out.print("Format EBook (PDF/EPUB/etc): ");
                    String format = sc.nextLine();
                    lib.tambahItem(new EBook(judul, pengarang, format));
                } else {
                    lib.tambahItem(new PrintedBook(judul, pengarang));
                }

            } else if (pilih == 2) {
                lib.tampilkanRakBernomor();
                System.out.print("Masukkan nomor item yang ingin dihapus: ");
                int idx = safeIntInput();
                lib.hapusItemByIndex(idx);

            } else if (pilih == 3) {
                lib.sortJudulDescending();

            } else if (pilih == 4) {
                System.out.print("Masukkan judul yang ingin diperbarui: ");
                String judul = sc.nextLine();
                System.out.print("Masukkan pengarang baru: ");
                String pengarangBaru = sc.nextLine();
                lib.updatePengarang(judul, pengarangBaru);

            } else if (pilih == 5) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void menuPinjam(Library lib) {
        while (true) {
            System.out.println("\n======= Sub Menu Peminjaman Buku =======");
            System.out.println("1. Pinjam Buku 📖");
            System.out.println("2. Kembalikan Buku 🔄");
            System.out.println("3. Tampilkan Buku Yang Sedang Dipinjam 📋");
            System.out.println("4. Tampilkan Data Yang Meminjam Buku 👤");
            System.out.println("5. Keluar 🚪");
            System.out.println("========================================");
            System.out.print("Masukkan Pilihan anda : ");
            int pilih = safeIntInput();

            if (pilih == 1) {
                System.out.print("Nama peminjam: ");
                String nama = sc.nextLine();
                System.out.print("Nomor telepon: ");
                String phone = sc.nextLine();
                System.out.print("Jaminan: ");
                String jaminan = sc.nextLine();
                System.out.print("Judul item yang dipinjam: ");
                String judul = sc.nextLine();
                System.out.print("Tanggal pengembalian (YYYY-MM-DD): ");
                String tgl = sc.nextLine();

                if (!DateUtil.isValid(tgl)) {
                    System.out.println("Format tanggal tidak valid.");
                } else {
                    Borrower b = new Borrower(nama, phone, jaminan);
                    lib.pinjamItem(judul, b, DateUtil.parse(tgl));
                }

            } else if (pilih == 2) {
                System.out.print("Judul item yang ingin dikembalikan: ");
                String judul = sc.nextLine();
                lib.kembalikanItem(judul);

            } else if (pilih == 3) {
                lib.tampilkanPinjaman();

            } else if (pilih == 4) {
                lib.tampilkanDataPeminjam();

            } else if (pilih == 5) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void menuCari(Library lib) {
        while (true) {
            System.out.println("\n====== Sub Menu Cari Buku ==========");
            System.out.println("1. Cari Buku 📝");
            System.out.println("2. Tampilkan Semua Buku 📚");
            System.out.println("3. Keluar 🚪");
            System.out.println("====================================");
            System.out.print("Masukkan Pilihan anda: ");
            int pilih = safeIntInput();

            if (pilih == 1) {
                System.out.print("Masukkan keyword judul: ");
                String keyword = sc.nextLine();
                lib.cariItem(keyword);

            } else if (pilih == 2) {
                lib.tampilkanSemuaItem();

            } else if (pilih == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static int safeIntInput() {
        while (true) {
            try {
                String s = sc.nextLine();
                return Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }
}
