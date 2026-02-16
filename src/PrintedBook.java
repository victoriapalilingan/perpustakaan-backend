package PerpustakaanOOP.src;

class PrintedBook extends LibraryItem {
    public PrintedBook() {
        super();
    }

    public PrintedBook(String judul, String pengarang) {
        super(judul, pengarang);
    }

    @Override
    public String getItemType() {
        return "Printed Book";
    }
}
