package repository;

import entities.Saldo;

public interface SaldoRepository {
   void isiSaldo(long nominal);
   void updateSaldo();
    long tampilSaldo();
}
