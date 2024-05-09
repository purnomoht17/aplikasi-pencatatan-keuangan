package services;

import repository.PemasukanRepository;

public interface PemasukanServices {
    void tampilPemasukan();
    long tampilTotal();
    void tambahPemasukan(String keterangan, long jumlah);
    void hapusPemasukan(Integer number);

    String pemasukanLaporan();
}
