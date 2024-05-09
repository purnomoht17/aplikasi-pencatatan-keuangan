package repository;

import entities.Saldo;

public class SaldoRepositoryImpl implements SaldoRepository{
    private PemasukanRepository pemasukanRepository;
    private PengeluaranRepository pengeluaranRepository;
    private Saldo saldo;
    private long saldoAktual;

    public SaldoRepositoryImpl(PemasukanRepository pemasukanRepository, PengeluaranRepository pengeluaranRepository, Saldo saldo) {
        this.pemasukanRepository = pemasukanRepository;
        this.pengeluaranRepository = pengeluaranRepository;
        this.saldo = saldo;
        this.saldoAktual = saldo.getSaldo();
    }

    @Override
    public void isiSaldo(long nominal) {
        saldoAktual = nominal ;
    }

    @Override
    public void updateSaldo() {
        long saldoBaru = saldoAktual + pemasukanRepository.jumlahPemasukan() - pengeluaranRepository.jumlahPengeluaran();
        saldo.setSaldo(saldoBaru);
    }

    @Override
    public long tampilSaldo() {
        updateSaldo();
        return saldo.getSaldo();
    }
}
