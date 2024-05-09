package services;

import entities.Pemasukan;
import repository.PemasukanRepository;

public class PemasukanServicesImpl implements PemasukanServices {
    private PemasukanRepository pemasukanRepository;

    public PemasukanServicesImpl(PemasukanRepository pemasukanRepository) {
        this.pemasukanRepository = pemasukanRepository;
    }

    @Override
    public void tampilPemasukan() {
        Pemasukan[] dataPemasukan = pemasukanRepository.getAll();
        //cek apakah data kosong
        var kosong = true;
        for (int i = 0; i < dataPemasukan.length; i++) {
            if (dataPemasukan[i] != null) {
                kosong = false;
                break;
            }
        }

        if (kosong) {
            System.out.println("Tidak Ada Pemasukan");
        } else {
            System.out.println("Daftar Pemasukan");
        }

        for (int i = 0; i < dataPemasukan.length; i++) {
            var listPemasukan = dataPemasukan[i];
            var nomorList = i + 1;

            if (listPemasukan != null) {
                System.out.println(nomorList + ". " + listPemasukan.getKeterangan() + " " + listPemasukan.getJumlah());
            }
        }

        tampilTotal();
    }

    @Override
    public long tampilTotal() {
        System.out.println("TOTAL PEMASUKAN : " + pemasukanRepository.jumlahPemasukan());
        return 0;
    }


    @Override
    public void tambahPemasukan(String keterangan, long jumlah) {
        pemasukanRepository.tambah(keterangan, jumlah);
        System.out.println("Sukses Menambahkan Pemasukan " + keterangan + " " + jumlah);
    }

    @Override
    public void hapusPemasukan(Integer number) {
        boolean sukses = pemasukanRepository.hapus(number);
        if (sukses) {
            System.out.println("Sukses menghapus Pemasukan ke- " + number);
        }else {
            System.out.println("Gagal Menghapus Pemasukan ke_ " + number);
        }
    }

    @Override
    public String pemasukanLaporan() {
        StringBuilder sb = new StringBuilder();
        Pemasukan[] pemasukan = pemasukanRepository.getAll();

        if(pemasukan != null){
            sb.append("Daftar Pemasukan:\n");
            for (int i = 0; i < pemasukan.length; i++) {
                if (pemasukan[i] != null) {
                    sb.append((i + 1) + ". ");
                    sb.append(pemasukan[i].getKeterangan() + " ");
                    sb.append(pemasukan[i].getJumlah() + "\n");
                }
            }
            sb.append("TOTAL PEMASUKAN: ").append(pemasukanRepository.jumlahPemasukan()).append("\n");
            sb.append("_________________________");
        }
        return sb.toString();
    }
}


