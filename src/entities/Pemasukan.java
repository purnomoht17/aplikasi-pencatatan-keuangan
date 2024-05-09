package entities;

public class Pemasukan {

    private String keterangan;
    private long jumlah;

    public Pemasukan(String keterangan, long jumlah) {
        this.keterangan = keterangan;
        this.jumlah = jumlah;
    }

    public Pemasukan(String keterangan){
        this.keterangan = keterangan;
    }
    public Pemasukan(long jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public long getJumlah() {
        return jumlah;
    }

    public void setJumlah(long jumlah) {
        this.jumlah = jumlah;
    }
}
