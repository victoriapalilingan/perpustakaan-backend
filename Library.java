package PerpustakaanOOP;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

class Library {
    private ArrayList<LibraryItem> rak;
    private ArrayList<Loan> pinjaman;

    public Library() {
        this.rak = new ArrayList<>();
        this.pinjaman = new ArrayList<>();
    }

    public void tambahItem(LibraryItem item) {
        rak.add(item);
        System.out.println("Item ditambahkan: " + item.getInfo());
    }

    public void tampilkanSemuaItem() {
        if (rak.isEmpty()) {
            System.out.println("\nRak perpustakaan kosong.");
            return;
        }
        System.out.println("\nItem tersedia:");
        rak.stream()
                .sorted(Comparator.comparing(LibraryItem::getJudul))
                .forEach(i -> System.out.println("- " + i.getInfo()));
    }

    public void hapusItemByIndex(int index) {
        if (rak.isEmpty()) {
            System.out.println("Rak perpustakaan kosong.");
            return;
        }
        if (index < 1 || index > rak.size()) {
            System.out.println("Nomor item tidak valid.");
            return;
        }
        LibraryItem removed = rak.remove(index - 1);
        System.out.println("Item dihapus: " + removed.getInfo());
    }

    public void sortJudulDescending() {
        if (rak.isEmpty()) {
            System.out.println("Tidak ada item yang perlu diurutkan.");
            return;
        }
        rak.sort((a, b) -> b.getJudul().compareToIgnoreCase(a.getJudul()));
        System.out.println("Item telah diurutkan berdasarkan judul (descending).");
    }

    public void updatePengarang(String judul, String pengarangBaru) {
        for (LibraryItem item : rak) {
            if (item.getJudul().equalsIgnoreCase(judul)) {
                item.setPengarang(pengarangBaru);
                System.out.println("Informasi item diperbarui: " + item.getInfo());
                return;
            }
        }
        System.out.println("Item dengan judul '" + judul + "' tidak ditemukan.");
    }

    public void cariItem(String keyword) {
        ArrayList<LibraryItem> ditemukan = new ArrayList<>();
        for (LibraryItem item : rak) {
            if (item.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                ditemukan.add(item);
            }
        }
        if (ditemukan.isEmpty()) {
            System.out.println("Item dengan judul mengandung '" + keyword + "' tidak ditemukan.");
            return;
        }
        System.out.println("\nHasil pencarian:");
        for (LibraryItem item : ditemukan) {
            System.out.println("- " + item.getInfo());
        }
    }

    public void pinjamItem(String judul, Borrower borrower, LocalDate returnDate) {
        for (int i = 0; i < rak.size(); i++) {
            LibraryItem item = rak.get(i);
            if (item.getJudul().equalsIgnoreCase(judul)) {
                rak.remove(i);
                pinjaman.add(new Loan(borrower, item, returnDate));
                System.out.println("Berhasil pinjam: " + item.getInfo());
                System.out.println("Peminjam: " + borrower.getInfo());
                System.out.println("Kembali: " + DateUtil.formatDate(returnDate));
                return;
            }
        }
        System.out.println("Item '" + judul + "' tidak tersedia untuk dipinjam.");
    }

    public void kembalikanItem(String judul) {
        for (int i = 0; i < pinjaman.size(); i++) {
            Loan loan = pinjaman.get(i);
            if (loan.getItem().getJudul().equalsIgnoreCase(judul)) {
                pinjaman.remove(i);
                rak.add(loan.getItem());
                System.out.println("Item dikembalikan: " + loan.getItem().getInfo());
                return;
            }
        }
        System.out.println("Item '" + judul + "' tidak sedang dipinjam.");
    }

    public void tampilkanPinjaman() {
        if (pinjaman.isEmpty()) {
            System.out.println("\nTidak ada item yang sedang dipinjam.");
            return;
        }
        System.out.println("\nItem yang sedang dipinjam:");
        for (int i = 0; i < pinjaman.size(); i++) {
            System.out.println((i + 1) + ". " + pinjaman.get(i).getInfo());
        }
    }

    public void tampilkanDataPeminjam() {
        if (pinjaman.isEmpty()) {
            System.out.println("\nTidak ada data peminjam.");
            return;
        }
        System.out.println("\nData peminjam:");
        for (int i = 0; i < pinjaman.size(); i++) {
            Loan loan = pinjaman.get(i);
            System.out.println((i + 1) + ". " + loan.getPeminjam().getInfo() +
                    " | Item: " + loan.getItem().getInfo() +
                    " | Kembali: " + DateUtil.formatDate(loan.getReturnDate()));
        }
    }

    public void tampilkanRakBernomor() {
        if (rak.isEmpty()) {
            System.out.println("Rak perpustakaan kosong.");
            return;
        }
        System.out.println("\nDaftar item tersedia:");
        for (int i = 0; i < rak.size(); i++) {
            System.out.println((i + 1) + ". " + rak.get(i).getInfo());
        }
    }
}
