/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bab9Revisi;

/**
 *
 * @author waka I
 */
import java.time.LocalDate;
import java.time.Period;

public class Pendonor extends DonorDarah implements PendonorInterface {
    private String nama;
    private int tanggalLahir;
    private String alamat;

    public Pendonor() {}

    public Pendonor(String nama, int tanggalLahir) {
        setNama(nama);
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama.trim();
    }

    @Override
    public String getNama() {
        return this.nama;
    }

    @Override
    public void setUmur(int umur) {
        throw new UnsupportedOperationException("Umur dihitung dari tanggal lahir.");
    }

    @Override
    public int getUmur() {
        LocalDate sekarang = LocalDate.now();
        int tahun = tanggalLahir / 10000;
        int bulan = (tanggalLahir % 10000) / 100;
        int hari = tanggalLahir % 100;
        return Period.between(LocalDate.of(tahun, bulan, hari), sekarang).getYears();
    }

    @Override
    public void setGolonganDarah(String golongan) {
        super.setGolonganDarah(golongan);
    }

    @Override
    public String getGolonganDarah() {
        return super.getGolonganDarah();
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String getAlamat() {
        return alamat;
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