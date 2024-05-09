package repository;

import entities.Pengeluaran;

public interface PengeluaranRepository {
    Pengeluaran[] getAll();
    void tambahPengeluaran(String keterangan, long jumlah);
    long jumlahPengeluaran();
    boolean hapus(Integer number);
}
