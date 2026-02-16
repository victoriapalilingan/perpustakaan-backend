package PerpustakaanOOP.src;

abstract class LibraryItem {
    private String judul;
    private String pengarang;

    public LibraryItem() {
    }

    public LibraryItem(String judul, String pengarang) {
        this.judul = judul;
        this.pengarang = pengarang;
    }

    public abstract String getItemType();

    public String getInfo() {
        return "'" + judul + "' karya " + pengarang + " (" + getItemType() + ")";
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
}
