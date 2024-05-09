package repository;

import entities.Pemasukan;

public interface PemasukanRepository {
    Pemasukan[] getAll();
    void tambah(String keterangan, long jumlah);
    long jumlahPemasukan();
    boolean hapus(Integer number);
}

