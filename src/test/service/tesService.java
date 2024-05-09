package test.service;

import entities.Saldo;
import repository.*;
import services.*;

public class tesService {
    public static void main(String[] args) {
        tesCetak();
    }

    public static void testSaldo(){
        Saldo saldo = new Saldo(0);
        PemasukanRepository pemasukanRepository = new PemasukanRepositoryImpl();
        PengeluaranRepository pengeluaranRepository = new PengeluaranRepositoryImpl();
        SaldoRepository saldoRepository = new SaldoRepositoryImpl(pemasukanRepository, pengeluaranRepository, saldo);
        PemasukanServices pemasukanServices = new PemasukanServicesImpl(pemasukanRepository);
        PengeluaranService pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);
        SaldoService saldoService = new SaldoServiceImpl(pemasukanRepository, pengeluaranRepository,saldoRepository);


        saldoService.sesuaikanSaldo(100000);

        pemasukanServices.tambahPemasukan("sangu", 200000);
        pemasukanServices.tambahPemasukan("nemu", 50000);
        pemasukanServices.tampilPemasukan();

        pengeluaranService.tambahPengeluaran("jajan", 50000);
        pengeluaranService.tampilPengeluaran();

        saldoService.sesuaikanSaldo(100000);

        saldoService.tampilSaldo();
    }
    public static void testTampilPemasukan(){
        PemasukanRepository pemasukanRepository = new PemasukanRepositoryImpl();
        PengeluaranRepository pengeluaranRepository = new PengeluaranRepositoryImpl();
        PemasukanServices pemasukanServices = new PemasukanServicesImpl(pemasukanRepository);
        PengeluaranService pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);

        pemasukanServices.tambahPemasukan("Jualan", 15000);
        pemasukanServices.tambahPemasukan("sangu make", 15000);
        pemasukanServices.tambahPemasukan("gajian", 20000);
        pemasukanServices.tambahPemasukan("saham", 20000);
        pemasukanServices.tambahPemasukan("Nemu", 30000);

        pengeluaranService.tambahPengeluaran("Beli bensin",20000);
        pengeluaranService.tambahPengeluaran("Jajan HI",40000);

        pemasukanServices.tampilPemasukan();
        pengeluaranService.tampilPengeluaran();


    }

    public static void testHapusPemasukan(){
        PemasukanRepository pemasukanRepository = new PemasukanRepositoryImpl();
        PemasukanServices pemasukanServices = new PemasukanServicesImpl(pemasukanRepository);

        pemasukanServices.tambahPemasukan("Jualan", 15000);
        pemasukanServices.tambahPemasukan("sangu make", 15000);
        pemasukanServices.tambahPemasukan("gajian", 20000);
        pemasukanServices.tambahPemasukan("saham", 20000);

        pemasukanServices.tampilPemasukan();


        pemasukanServices.hapusPemasukan(3);

        pemasukanServices.tampilPemasukan();

    }

    public  static void testTambahPengeluaran(){
        PengeluaranRepository pengeluaranRepository = new PengeluaranRepositoryImpl();
        PengeluaranService pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);

        pengeluaranService.tambahPengeluaran("Beli baju", 50000);
        pengeluaranService.tambahPengeluaran("Beli celana", 50000);
        pengeluaranService.tambahPengeluaran("Bayar GYM", 20000);

        pengeluaranService.tampilPengeluaran();
    }

    public static void testHapusPengeluaran(){
        PengeluaranRepository pengeluaranRepository = new PengeluaranRepositoryImpl();
        PengeluaranService pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);


        pengeluaranService.tampilPengeluaran();

        pengeluaranService.hapusPengeluaran(2);

        pengeluaranService.tampilPengeluaran();

    }

    public static void tesCetak(){
        CetakService cetakService = new CetakService();
        Saldo saldo = new Saldo(0);
        PemasukanRepository pemasukanRepository = new PemasukanRepositoryImpl();
        PemasukanServices pemasukanServices = new PemasukanServicesImpl(pemasukanRepository);
        PengeluaranRepository pengeluaranRepository = new PengeluaranRepositoryImpl();
        PengeluaranService pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);
        SaldoRepository saldoRepository = new SaldoRepositoryImpl(pemasukanRepository, pengeluaranRepository,saldo);
        SaldoService saldoService = new SaldoServiceImpl(pemasukanRepository, pengeluaranRepository, saldoRepository);

        pemasukanServices.tambahPemasukan("sangu", 100000);
        pemasukanServices.tambahPemasukan("nemu", 100000);

        pengeluaranService.tambahPengeluaran("jajan" ,50000);
        pengeluaranService.tambahPengeluaran("bensin" ,50000);

        String pemasukanLaporan = pemasukanServices.pemasukanLaporan();
        String pengeluaranLaporan =  pengeluaranService.pengeluaranLaporan();
        String saldoLaporan = saldoService.saldoLaporan();

        String content = pemasukanLaporan + "\n" + pengeluaranLaporan + "\n" + saldoLaporan;

        String filename = "laporan.txt";

        cetakService.cetak(filename, content);
    }
}
