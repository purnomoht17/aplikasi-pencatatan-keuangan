package services;

import java.io.FileOutputStream;
import java.io.IOException;

public class CetakService {

    public void cetak(String filename, String content) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(content.getBytes());
            System.out.println("File berhasil dibuat: " + filename);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menciptakan file: " + e.getMessage());
        }
    }

}
