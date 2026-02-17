package PerpustakaanOOP;


import java.time.LocalDate;

class Loan {
    private Borrower peminjam;
    private LibraryItem item;
    private LocalDate returnDate;

    public Loan() {
    }

    public Loan(Borrower peminjam, LibraryItem item, LocalDate returnDate) {
        this.peminjam = peminjam;
        this.item = item;
        this.returnDate = returnDate;
    }

    public Borrower getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Borrower peminjam) {
        this.peminjam = peminjam;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void setItem(LibraryItem item) {
        this.item = item;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getInfo() {
        return item.getInfo() + " - Dipinjam oleh " + peminjam.getNama() +
                " | Kembali: " + DateUtil.formatDate(returnDate);
    }
}
