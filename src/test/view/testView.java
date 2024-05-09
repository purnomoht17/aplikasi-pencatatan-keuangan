package test.view;

import entities.Saldo;
import repository.*;
import services.*;
import view.PencatatanKeuanganView;

public class testView {
    public static void main(String[] args) {
    tesMenuUtama();
    }
    public static void tesMenuUtama(){
        Saldo saldo = new Saldo(0);
        PemasukanRepository pemasukanRepository = new PemasukanRepositoryImpl();
        PemasukanServices pemasukanServices = new PemasukanServicesImpl(pemasukanRepository);
        PengeluaranRepository pengeluaranRepository = new PengeluaranRepositoryImpl();
        PengeluaranService pengeluaranService = new PengeluaranServiceImpl(pengeluaranRepository);
        SaldoRepository saldoRepository = new SaldoRepositoryImpl(pemasukanRepository, pengeluaranRepository,saldo);
        SaldoService saldoService = new SaldoServiceImpl(pemasukanRepository, pengeluaranRepository, saldoRepository);
        CetakService cetakService = new CetakService();
        PencatatanKeuanganView pencatatanKeuanganView = new PencatatanKeuanganView(pemasukanServices, pengeluaranService,saldoService, cetakService);

        pencatatanKeuanganView.MenuUtama();
    }
}