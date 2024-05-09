package services;

import entities.Pemasukan;
import entities.Pengeluaran;
import repository.PengeluaranRepository;

public class PengeluaranServiceImpl implements PengeluaranService{
    private PengeluaranRepository pengeluaranRepository;

    public PengeluaranServiceImpl(PengeluaranRepository pengeluaranRepository) {
        this.pengeluaranRepository = pengeluaranRepository;
    }

    @Override
    public void tampilPengeluaran() {
        Pengeluaran[] dataPengeluaran = pengeluaranRepository.getAll();
        var kosong = true;
        for(int i = 0; i < dataPengeluaran.length; i++){
            if(dataPengeluaran[i] != null){
                kosong = false;
                break;
            }
        }
        if(kosong){
            System.out.println("Tidak Ada Pengeluaran");
        }else{
            System.out.println("Daftar Pengeluaran");
        }

        for(int i = 0; i < dataPengeluaran.length; i++){
            var listPengeluaran = dataPengeluaran[i];
            var nomorList = i + 1;

            if(listPengeluaran != null){
                System.out.println(nomorList + ". " + listPengeluaran.getDeskripsi() + " " + listPengeluaran.getJumlah());
            }
        }
        tampilTotal();
    }

    @Override
    public long tampilTotal() {
        System.out.println("TOTAL PENGELUARAN : " + pengeluaranRepository.jumlahPengeluaran());
        return 0;
    }

    @Override
    public void tambahPengeluaran(String keterangan, long jumlah) {
    pengeluaranRepository.tambahPengeluaran(keterangan, jumlah);
        System.out.println("Sukses Menambahkan Pengeluaran " + keterangan + " " + jumlah);
    }

    @Override
    public void hapusPengeluaran(Integer number) {
        boolean sukses = pengeluaranRepository.hapus(number);
        if (sukses) {
            System.out.println("Sukses menghapus Pengeluaran ke- " + number);
        }else {
            System.out.println("Gagal Menghapus Pengeluaran ke- " + number);
        }
    }

    @Override
    public String pengeluaranLaporan() {
        StringBuilder sb = new StringBuilder();
        Pengeluaran[] pengeluaran = pengeluaranRepository.getAll();

        if(pengeluaran != null){
            sb.append("Daftar Pengeluaran:\n");
            for (int i = 0; i < pengeluaran.length; i++) {
                if (pengeluaran[i] != null) {
                    sb.append((i + 1) + ". ");
                    sb.append(pengeluaran[i].getDeskripsi() + " ");
                    sb.append(pengeluaran[i].getJumlah() + "\n");
                }
            }
            sb.append("TOTAL PENGELUARAN: ").append(pengeluaranRepository.jumlahPengeluaran()).append("\n");
            sb.append("_________________________");
        }
        return sb.toString();
    }
}
