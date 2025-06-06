/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab4;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author waka I
 */
   public class Pendonor {
    // Atribut privat dengan enkapsulasi ketat
    private String nama;
    private int tanggalLahir;
    private String golonganDarah;
    private long tanggalDonorTerakhir;
    
    // Constructor
    public Pendonor() {
        this.tanggalDonorTerakhir = 0; // Inisialisasi default
    }
    
    // Method untuk mengecek kelayakan donor
    public boolean cekKelayakanDonor() {
        // Cek umur minimal 17 tahun
        LocalDate sekarang = LocalDate.now();
        int tahun = this.tanggalLahir / 10000;
        int bulan = (this.tanggalLahir % 10000) / 100;
        int hari = this.tanggalLahir % 100;
        LocalDate tglLahir = LocalDate.of(tahun, bulan, hari);
        
        int umur = Period.between(tglLahir, sekarang).getYears();
        if (umur < 17) {
            return false;
        }
        
        // Cek jarak donor terakhir
        long selisihWaktu = System.currentTimeMillis() - this.tanggalDonorTerakhir;
        return selisihWaktu > 90L * 24 * 60 * 60 * 1000;
    }
    
    // Method spesifik Pendonor dengan validasi
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama.trim();
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public void setGolonganDarah(String golonganDarah) {
        // Validasi golongan darah
        if (golonganDarah == null || !golonganDarah.matches("^(A|B|AB|O)[+-]$")) {
            throw new IllegalArgumentException("Golongan darah tidak valid");
        }
        this.golonganDarah = golonganDarah;
    }
    
    public String getGolonganDarah() {
        return this.golonganDarah;
    }
    
    public void setTanggalLahir(int tanggalLahir) {
    // Validasi format tanggal (8 digit)
    if (tanggalLahir <= 0 || String.valueOf(tanggalLahir).length() != 8) {
        throw new IllegalArgumentException("Format tanggal lahir harus YYYYMMDD");
    }

    // Coba parsing tanggal biar tetap aman
    int tahun = tanggalLahir / 10000;
    int bulan = (tanggalLahir % 10000) / 100;
    int hari = tanggalLahir % 100;

    this.tanggalLahir = tanggalLahir;
}


       public void setTanggalDonorTerakhir(int tanggalDonor) {
           // Validasi format tanggal (8 digit)
           if (tanggalDonor <= 0 || String.valueOf(tanggalDonor).length() != 8) {
               throw new IllegalArgumentException("Format tanggal donor harus YYYYMMDD");
           }

           // Konversi ke timestamp
           int tahun = tanggalDonor / 10000;
           int bulan = (tanggalDonor % 10000) / 100;
           int hari = tanggalDonor % 100;

           LocalDate date = LocalDate.of(tahun, bulan, hari);
           ZonedDateTime zdt = date.atStartOfDay(ZoneId.systemDefault());
           this.tanggalDonorTerakhir = zdt.toInstant().toEpochMilli();
       }
    
    public long getTanggalDonorTerakhir() {
        return this.tanggalDonorTerakhir;
    }
    
    public int getTanggalLahir() {
        return this.tanggalLahir;
    }
    
    // Method tambahan untuk kompatibilitas dengan kode GUI
    public void nama(String nama) {
        setNama(nama);
    }
    
    public String cetaknama() {
        return getNama();
    }
    
    public void GolonganDarah(String golonganDarah) {
        setGolonganDarah(golonganDarah);
    }
    
    public String cetakGolonganDarah() {
        return getGolonganDarah();
    }
    
    public void TanggalLahir(int tanggalLahir) {
        setTanggalLahir(tanggalLahir);
    }
    
    public int cetakTanggalLahir() {
        return getTanggalLahir();
    }
    
    // Method untuk mencatat donor terakhir
    public void catatDonorTerakhir() {
        this.tanggalDonorTerakhir = System.currentTimeMillis();
    }
}