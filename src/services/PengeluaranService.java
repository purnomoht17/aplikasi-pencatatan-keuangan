package services;

public interface PengeluaranService {
    void tampilPengeluaran();
    long tampilTotal();
    void tambahPengeluaran(String keterangan, long jumlah);
    void hapusPengeluaran(Integer number);
    String pengeluaranLaporan();
}
