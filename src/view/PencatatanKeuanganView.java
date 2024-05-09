package view;
import entities.Pemasukan;
import entities.Saldo;
import repository.PemasukanRepository;
import repository.PemasukanRepositoryImpl;
import services.CetakService;
import services.PemasukanServices;
import services.PengeluaranService;
import services.SaldoService;
import util.*;
import static util.inputUtil.input;
import static util.laporanUtil.simpanLaporan;
import static util.laporanUtil.muatLaporan;

public class PencatatanKeuanganView {
    private PemasukanServices pemasukanServices;
    private PengeluaranService pengeluaranService;
    private SaldoService saldoService;
    private CetakService cetakService;


    public PencatatanKeuanganView(PemasukanServices pemasukanServices, PengeluaranService pengeluaranService, SaldoService saldoService, CetakService cetakService) {
        this.pemasukanServices = pemasukanServices;
        this.pengeluaranService = pengeluaranService;
        this.saldoService = saldoService;
        this.cetakService = cetakService;
    }

    public void MenuUtama(){
        while (true){
            laporanMuat();

            pemasukanServices.tampilPemasukan();
            pengeluaranService.tampilPengeluaran();
            saldoService.tampilSaldo();


            System.out.println("Pilih Menu");
            System.out.println("1. Atur Saldo");
            System.out.println("2. Pemasukan");
            System.out.println("3. Pengeluaran");
            System.out.println("4. Cetak");
            System.out.println("x. keluar");

            var input = input("Pilih");

            if(input.equals("1")){
                aturSaldoView();
            } else if (input.equals("2")) {
                pemasukanView();
            } else if (input.equals("3")) {
               pengeluaranView();
            } else if (input.equals("4")) {
                cetakView();
                break;
            } else if(input.equals("x")){
                laporanSimpan();
                break;
            } else {
                System.out.println("PILIH MENU YANG BENAR!");
            }
        }
    }

    public void aturSaldoView(){
        System.out.println("Atur SALDO");
        System.out.println("Masukkan Nominal");
        var saldoUser = input("ketik x untuk batal");

        if(saldoUser.equals("x")){
            //
        }else {
            saldoService.sesuaikanSaldo(Long.parseLong(saldoUser));
        }
    }

    public void pemasukanView(){
        System.out.println("PEMASUKAN");
        System.out.println("1. Tambah Pemasukan");
        System.out.println("2. Hapus Pemasukan");
        System.out.println("x. batal");
        
        var input = input("Pilih Opsi Pemasukan");
        
        if(input.equals("x")){
            //batal
        } else if (input.equals("1")) {
            tambahPemasukan();
        } else if (input.equals("2")) {
            hapusPemasukan();
        } else {
            System.out.println("PILIH MENU YANG BENAR!");
        }
    }

    public void tambahPemasukan(){
        System.out.println("ketik x untuk membatalkan");
        var keteranganPemasukan = input("Keterangan Pemasukan");
        if(keteranganPemasukan.equals("x")){
            //batal
        } else {
            var jumlahPemasukan = input("Jumlah Pemasukan");
            pemasukanServices.tambahPemasukan(keteranganPemasukan, Long.parseLong(jumlahPemasukan));
        }
    }

    public void hapusPemasukan(){
        System.out.println("Hapus Pemasukan");
        System.out.println("Ketik Nomor Pemasukan ingin dihapus");
        var nomorList = input("ketik x untuk membatalkan");

        if(nomorList.equals("x")){
            //
        } else {
            pemasukanServices.hapusPemasukan(Integer.valueOf(nomorList));
        }
    }

    public void pengeluaranView(){
        System.out.println("PENGELUARAN");
        System.out.println("1. Tambah Pengeluaran");
        System.out.println("2. Hapus Pengeluaran");
        System.out.println("x. batal");

        var input = input("Pilih Menu");

        if(input.equals("1")){
            tambahPengeluaran();
        } else if (input.equals("2")) {
            hapusPengeluaran();
        } else if (input.equals("x")) {
            //batal
        } else {
            System.out.println("PILIH MENU YANG BENAR");
        }
    }

    public void tambahPengeluaran(){
        System.out.println("Ketik x untuk membatalkan");
        var keteranganPengeluaran = input("Keterangan Pengeluaran");
        if(keteranganPengeluaran.equals("x")){
            //
        } else {
            var jumlahPengeluaran = input("Jumlah Pengeluaran");
                pengeluaranService.tambahPengeluaran(keteranganPengeluaran, Long.parseLong(jumlahPengeluaran));
        }
    }

    public void hapusPengeluaran(){
        System.out.println("Hapus Pengeluaran");
        System.out.println("Ketik Nomor Pengeluaran ingin dihapus");
        var nomorList = input("ketik x untuk membatalkan");

        if(nomorList.equals("x")){
            //
        }else {
            pengeluaranService.hapusPengeluaran(Integer.valueOf(nomorList));
        }
    }

    public void cetakView(){
        String pemasukanLaporan = pemasukanServices.pemasukanLaporan();
        String pengeluaranLaporan =  pengeluaranService.pengeluaranLaporan();
        String saldoLaporan = saldoService.saldoLaporan();

        System.out.println("CETAK");
        System.out.println("Masukkan nama File");
        var input = input("ketik x untuk membatalkan");

        String content = pemasukanLaporan + "\n" + pengeluaranLaporan + "\n" + saldoLaporan;
        String filename = input + ".txt";

        if (input.equals("x")){
            MenuUtama();
        }else {
            cetakService.cetak(filename, content);
        }
    }


    public void laporanSimpan(){
        String pemasukanLaporan = pemasukanServices.pemasukanLaporan();
        String pengeluaranLaporan = pengeluaranService.pengeluaranLaporan();
        String saldoLaporan = saldoService.saldoLaporan();

        // Membuat objek laporan
        laporanUtil laporan = new laporanUtil(pemasukanLaporan, pengeluaranLaporan, saldoLaporan);

        // Menyimpan objek laporan ke dalam file
        String filename = "laporan.ser";
        simpanLaporan(laporan, filename);

        // Memuat objek laporan dari file
        //laporanUtil laporanDariFile = muatLaporan(filename);

        // Menampilkan isi laporan yang telah dimuat
        //System.out.println("Pemasukan:\n" + laporanDariFile.getPemasukanLaporan());
        //System.out.println("Pengeluaran:\n" + laporanDariFile.getPengeluaranLaporan());
        //System.out.println("Saldo:\n" + laporanDariFile.getSaldoLaporan());
    }

    public void laporanMuat(){
        // Membuat objek laporan baru dengan data terkini
        String pemasukanLaporan = pemasukanServices.pemasukanLaporan();
        String pengeluaranLaporan = pengeluaranService.pengeluaranLaporan();
        String saldoLaporan = saldoService.saldoLaporan();
        laporanUtil laporanBaru = new laporanUtil(pemasukanLaporan, pengeluaranLaporan, saldoLaporan);

        // Menyimpan objek laporan ke dalam file
        String filename = "laporan.ser";
        simpanLaporan(laporanBaru, filename); // Pastikan baris ini tidak dikomentari untuk menyimpan laporan

        // Memuat objek laporan dari file
        laporanUtil laporanDariFile = muatLaporan(filename);

        // Cek apakah laporanDariFile tidak null sebelum mengaksesnya
        if (laporanDariFile != null) {
            // Tidak perlu setter jika hanya menampilkan data
            System.out.println("Pemasukan:\n" + laporanDariFile.getPemasukanLaporan());
            System.out.println("Pengeluaran:\n" + laporanDariFile.getPengeluaranLaporan());
            System.out.println("Saldo:\n" + laporanDariFile.getSaldoLaporan());
        } else {
            System.out.println("Tidak dapat memuat laporan dari file.");
        }
    }

}
