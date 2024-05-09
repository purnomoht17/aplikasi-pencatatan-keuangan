package util;

import java.io.*;

public class laporanUtil implements Serializable {
    private static final long serialVersionUID = 6818489360248218994L;

    private String pemasukanLaporan;
    private String pengeluaranLaporan;
    private String saldoLaporan;

    public laporanUtil(String pemasukanLaporan, String pengeluaranLaporan, String saldoLaporan) {
        this.pemasukanLaporan = pemasukanLaporan;
        this.pengeluaranLaporan = pengeluaranLaporan;
        this.saldoLaporan = saldoLaporan;
    }

    public String getPemasukanLaporan() {
        return pemasukanLaporan;
    }

    public String getPengeluaranLaporan() {
        return pengeluaranLaporan;
    }

    public String getSaldoLaporan() {
        return saldoLaporan;
    }

    public void setPemasukanLaporan(String pemasukanLaporan) {
        this.pemasukanLaporan = pemasukanLaporan;
    }

    public void setPengeluaranLaporan(String pengeluaranLaporan) {
        this.pengeluaranLaporan = pengeluaranLaporan;
    }

    public void setSaldoLaporan(String saldoLaporan) {
        this.saldoLaporan = saldoLaporan;
    }

    public static void simpanLaporan(laporanUtil laporanUtil, String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(laporanUtil);
            System.out.println("Laporan berhasil disimpan ke dalam file: " + filename);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan laporan: " + e.getMessage());
        }
    }

    public static laporanUtil muatLaporan( String filename){
        laporanUtil laporan = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            laporan = (laporanUtil) in.readObject();
            System.out.println("Laporan berhasil dimuat dari file: " + filename);
        } catch (IOException | NullPointerException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat memuat laporan: " + e.getMessage());
        }
        return laporan;
    }


}
