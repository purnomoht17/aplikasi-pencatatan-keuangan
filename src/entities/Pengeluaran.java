package entities;

public class Pengeluaran {
    private String deskripsi;
    private long jumlah;

    public Pengeluaran(String deskripsi, long jumlah) {
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public long getJumlah() {
        return jumlah;
    }

    public void setJumlah(long jumlah) {
        this.jumlah = jumlah;
    }
}
