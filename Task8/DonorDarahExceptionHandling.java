package Bab8.Revisi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author waka I
 */
import javax.swing.JOptionPane;

public class DonorDarahExceptionHandling {
    public static void main(String[] args) {
        try {
            // Header program
            JOptionPane.showMessageDialog(null, 
                "=== PROGRAM PENDAFTARAN DONOR DARAH ===", 
                "Selamat Datang", 
                JOptionPane.INFORMATION_MESSAGE);

            // Input data donor
            String nama = JOptionPane.showInputDialog("Masukkan nama lengkap:");
            if (nama == null || nama.trim().isEmpty()) {
                throw new IllegalArgumentException("Nama tidak boleh kosong!");
            }

            String usiaStr = JOptionPane.showInputDialog("Masukkan usia:");
            if (usiaStr == null || usiaStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Usia tidak boleh kosong!");
            }
            int usia = Integer.parseInt(usiaStr);
            
            if (usia < 17) {
                throw new IllegalArgumentException("Usia minimal donor darah adalah 17 tahun!");
            }
            if (usia > 65) {
                throw new IllegalArgumentException("Usia maksimal donor darah adalah 65 tahun!");
            }

            String beratStr = JOptionPane.showInputDialog("Masukkan berat badan (kg):");
            if (beratStr == null || beratStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Berat badan tidak boleh kosong!");
            }
            double berat = Double.parseDouble(beratStr);
            
            if (berat < 50) {
                throw new IllegalArgumentException("Berat badan minimal 50 kg untuk donor darah!");
            }

            String tekananDarah = JOptionPane.showInputDialog("Masukkan tekanan darah (contoh: 120/80):");
            if (tekananDarah == null || tekananDarah.trim().isEmpty()) {
                throw new IllegalArgumentException("Tekanan darah tidak boleh kosong!");
            }
            if (!tekananDarah.matches("\\d+/\\d+")) {
                throw new IllegalArgumentException("Format tekanan darah tidak valid! Gunakan format seperti 120/80");
            }

            // Jika semua validasi berhasil
            JOptionPane.showMessageDialog(null, 
                "PENDAFTARAN BERHASIL!\n\n" +
                "Nama: " + nama + 
                "\nUsia: " + usia + " tahun" + 
                "\nBerat: " + berat + " kg" +
                "\nTekanan Darah: " + tekananDarah + 
                "\n\nAnda memenuhi syarat untuk donor darah.", 
                "Pendaftaran Sukses", 
                JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "ERROR: Input angka tidak valid!\n" + 
                "Pastikan usia dan berat badan berupa angka.", 
                "Input Tidak Valid", 
                JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, 
                "ERROR: " + e.getMessage(), 
                "Validasi Gagal", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            JOptionPane.showMessageDialog(null, 
                "Terima kasih telah berminat menjadi pendonor darah.\n" +
                "Darah Anda dapat menyelamatkan nyawa orang lain.", 
                "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}