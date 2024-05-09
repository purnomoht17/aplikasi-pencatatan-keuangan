package repository;

import entities.Pemasukan;
import entities.Pengeluaran;

public class PengeluaranRepositoryImpl implements PengeluaranRepository{

    Pengeluaran[] dataPengeluaran = new Pengeluaran[10];
    @Override
    public Pengeluaran[] getAll() {
        return dataPengeluaran;
    }

    public boolean cekPenuh(){
        var penuh = true;
        for(int i = 0 ; i < dataPengeluaran.length; i++){
            if(dataPengeluaran[i] == null){
                penuh = false;
                break;
            }
        }
        return penuh;
    }

    public void resize(){
        if(cekPenuh()){
            var dataPengeluaranSebelumnya = dataPengeluaran;
            dataPengeluaran = new Pengeluaran[dataPengeluaran.length * 2];

            for(int i = 0; i < dataPengeluaranSebelumnya.length; i++){
                dataPengeluaran[i] = dataPengeluaranSebelumnya[i];
            }
        }
    }
    @Override
    public void tambahPengeluaran(String keterangan, long jumlah) {
        resize();

        for (int i = 0; i < dataPengeluaran.length; i++) {
            if (dataPengeluaran[i] == null) {
                dataPengeluaran[i] = new Pengeluaran(keterangan, jumlah);
                break;
            }
        }
    }

    @Override
    public long jumlahPengeluaran() {
        long totalPengeluaran = 0;
        for (Pengeluaran pengeluaran : dataPengeluaran) {
            if (pengeluaran != null) {
                totalPengeluaran += pengeluaran.getJumlah();
            }
        }
        return totalPengeluaran;
    }

    @Override
    public boolean hapus(Integer number) {
        if((number - 1) >= dataPengeluaran.length){
            return false;
        } else if ((dataPengeluaran[number - 1] == null)) {
            return false;
        } else {
            for(int i = (number - 1); i < dataPengeluaran.length; i++){
                if(i == (dataPengeluaran.length) - 1){
                    dataPengeluaran[i] = null;
                } else{
                    dataPengeluaran[i] = dataPengeluaran[i + 1];
                }
            }
            return true;
        }
    }
}

