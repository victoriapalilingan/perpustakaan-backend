package PerpustakaanOOP.src;

class Borrower {
    private String nama;
    private String phone;
    private String jaminan;

    public Borrower() {
    }

    public Borrower(String nama, String phone, String jaminan) {
        this.nama = nama;
        this.phone = phone;
        this.jaminan = jaminan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJaminan() {
        return jaminan;
    }

    public void setJaminan(String jaminan) {
        this.jaminan = jaminan;
    }

    public String getInfo() {
        return "Nama: " + nama + ", Telp: " + phone + ", Jaminan: " + jaminan;
    }
}
