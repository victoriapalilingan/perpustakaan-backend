package PerpustakaanOOP;


class EBook extends LibraryItem {
    private String format;

    public EBook() {
        super();
    }

    public EBook(String judul, String pengarang) {
        this(judul, pengarang, "PDF");
    }

    public EBook(String judul, String pengarang, String format) {
        super(judul, pengarang);
        this.format = format;
    }

    @Override
    public String getItemType() {
        return "E-Book " + format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

