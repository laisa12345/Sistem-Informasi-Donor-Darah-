/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bab9Revisi;

import Bab8.*;
import Bab7.*;
import Bab6.*;



/**
 *
 * @author waka I
 */
public class AdminDonorDarah {

    // Atribut privat dengan enkapsulasi ketat
    private String idAdmin;
    private String hakAkses;
    private int jumlahDonorDisetujui;

    // Constructor default dengan inisialisasi nilai default
    public AdminDonorDarah() {
        this.hakAkses = "basic";
        this.jumlahDonorDisetujui = 0;
    }

    // Constructor dengan parameter yang divalidasi
    public AdminDonorDarah(String idAdmin, String hakAkses) {
        setIdAdmin(idAdmin);
        setHakAkses(hakAkses);
        this.jumlahDonorDisetujui = 0;
    }

    // Method untuk mengecek apakah admin boleh donor (tanpa override)
    public boolean adminBolehDonor() {
        // Admin tidak boleh menjadi donor
        return false;
    }

    // Method khusus admin dengan validasi
    public void approveDonor(Bab8.Pendonor pendonor) {
        if (pendonor == null) {
            throw new IllegalArgumentException("Pendonor tidak boleh null");
        }

        // Ganti pendonor.bolehDonor() dengan pendonor.cekKelayakanDonor()
        if (pendonor.cekKelayakanDonor()) {
            this.jumlahDonorDisetujui++;
            pendonor.setTanggalDonorTerakhir((int) System.currentTimeMillis());
            System.out.println("Donor disetujui untuk: " + pendonor.getNama());
        } else {
            System.out.println("Donor tidak memenuhi syarat");
        }
    }

    public void updateGolonganDarah(Bab8.Pendonor pendonor, String golonganBaru) {
        if (pendonor == null || golonganBaru == null || golonganBaru.isEmpty()) {
            throw new IllegalArgumentException("Parameter tidak valid");
        }

        if (hakAkses.equals("admin") || hakAkses.equals("superadmin")) {
            pendonor.setGolonganDarah(golonganBaru);
            System.out.println("Golongan darah diperbarui");
        } else {
            System.out.println("Akses ditolak");
        }
    }

    public void generateLaporan() {
        System.out.println("=== Laporan Admin ===");
        System.out.println("ID Admin: " + this.idAdmin);
        System.out.println("Jumlah donor disetujui: " + this.jumlahDonorDisetujui);
        System.out.println("Hak akses: " + this.hakAkses);
    }

    // Getter dan Setter dengan validasi
    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        if (idAdmin == null || idAdmin.isEmpty()) {
            throw new IllegalArgumentException("ID Admin tidak boleh kosong");
        }
        this.idAdmin = idAdmin;
    }

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        if (hakAkses == null || !(hakAkses.equals("basic") || hakAkses.equals("admin") || hakAkses.equals("superadmin"))) {
            throw new IllegalArgumentException("Hak akses tidak valid");
        }
        this.hakAkses = hakAkses;
    }

    // Getter saja untuk jumlahDonorDisetujui karena tidak boleh diubah sembarangan
    public int getJumlahDonorDisetujui() {
        return jumlahDonorDisetujui;
    }

    // Method untuk reset jumlah donor disetujui (hanya untuk superadmin)
    protected void resetJumlahDonorDisetujui() {
        if (this.hakAkses.equals("superadmin")) {
            this.jumlahDonorDisetujui = 0;
        } else {
            System.out.println("Akses ditolak: Hanya superadmin yang dapat mereset");
        }
    }
}