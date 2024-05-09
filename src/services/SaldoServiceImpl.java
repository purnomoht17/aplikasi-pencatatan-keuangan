package services;

import entities.Saldo;
import repository.*;

public class SaldoServiceImpl implements SaldoService{
    private PemasukanRepository pemasukanRepository;
    private PengeluaranRepository pengeluaranRepository;
    private SaldoRepository saldoRepository;

    public SaldoServiceImpl(PemasukanRepository pemasukanRepository, PengeluaranRepository pengeluaranRepository, SaldoRepository saldoRepository) {
        this.pemasukanRepository = pemasukanRepository;
        this.pengeluaranRepository = pengeluaranRepository;
        this.saldoRepository = saldoRepository;
    }

    @Override
    public void sesuaikanSaldo(long nominal) {
        saldoRepository.isiSaldo(nominal);
        System.out.println("SUKSES MENYESUAIKAN SALDO : " + nominal);
    }

    @Override
    public void tampilSaldo() {

        System.out.println("SALDO : " + saldoRepository.tampilSaldo());
    }

    @Override
    public String saldoLaporan() {
        StringBuilder sb = new StringBuilder();

        sb.append("SALDO : " + saldoRepository.tampilSaldo());

        return sb.toString();
    }
}
