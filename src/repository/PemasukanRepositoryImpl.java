package repository;

import entities.Pemasukan;

public class PemasukanRepositoryImpl implements PemasukanRepository{

    Pemasukan[] dataPemasukan = new Pemasukan[1];

    @Override
    public Pemasukan[] getAll() {
        return dataPemasukan;
    }

    //cek apakah penuh atau tidak
    public boolean cekPenuh(){
        var penuh = true;
        for(int i = 0 ; i < dataPemasukan.length; i++){
            if(dataPemasukan[i] == null){
                penuh = false;
                break;
            }
        }
        return penuh;
    }

    //resize jika penuh
    public void resize(){
        if(cekPenuh()){
            var dataPemasukanSebelumnya = dataPemasukan;
            dataPemasukan = new Pemasukan[dataPemasukan.length * 2];

            for(int i = 0; i < dataPemasukanSebelumnya.length; i++){
                dataPemasukan[i] = dataPemasukanSebelumnya[i];
            }
        }
    }

    @Override
    public void tambah(String keterangan, long jumlah) {
        resize();

        for (int i = 0; i < dataPemasukan.length; i++) {
            if (dataPemasukan[i] == null) {
                dataPemasukan[i] = new Pemasukan(keterangan, jumlah);
                break;
            }
        }
    }

    @Override
    public long jumlahPemasukan() {
        long totalPemasukan = 0;
        for (Pemasukan pemasukan : dataPemasukan) {
            if (pemasukan != null) {
                totalPemasukan += pemasukan.getJumlah();
            }
        }
        return totalPemasukan;
    }

    @Override
    public boolean hapus(Integer number) {
        if((number - 1) >= dataPemasukan.length){
            return false;
        } else if ((dataPemasukan[number - 1] == null)) {
            return false;
        } else {
            for(int i = (number - 1); i < dataPemasukan.length; i++){
                if(i == (dataPemasukan.length) - 1){
                    dataPemasukan[i] = null;
                } else{
                    dataPemasukan[i] = dataPemasukan[i + 1];
                }
            }
            return true;
        }
    }
}
