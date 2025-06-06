/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6;

/**
 *
 * @author waka I
 */
import java.time.LocalDate;
import java.time.Period;

public class Pendonor extends DonorDarah {
    private String nama;
    private int tanggalLahir;

    public Pendonor() {}

    public Pendonor(String nama, int tanggalLahir) {
        setNama(nama);
        this.tanggalLahir = tanggalLahir;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama.trim();
    }

    public String getNama() {
        return this.nama;
    }

    public void setTanggalLahir(int tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public int getTanggalLahir() {
        return tanggalLahir;
    }

    @Override
    public boolean bolehDonor() {
        LocalDate sekarang = LocalDate.now();
        int tahun = tanggalLahir / 10000;
        int bulan = (tanggalLahir % 10000) / 100;
        int hari = tanggalLahir % 100;
        LocalDate lahir = LocalDate.of(tahun, bulan, hari);
        int umur = Period.between(lahir, sekarang).getYears();

        if (umur < 17) return false;

        long jarak = System.currentTimeMillis() - getTanggalDonorTerakhir();
        return jarak > 90L * 24 * 60 * 60 * 1000;
    }

    public boolean cekKelayakanDonor() {
        return bolehDonor();
    }
}