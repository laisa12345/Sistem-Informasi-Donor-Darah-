/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6;

/**
 *
 * @author waka I
 */
public abstract class DonorDarah {
    private String golonganDarah;
    private long tanggalDonorTerakhir;

    public DonorDarah() {
        this.golonganDarah = "Unknown";
        this.tanggalDonorTerakhir = 0;
    }

    // Getter & Setter
    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public long getTanggalDonorTerakhir() {
        return tanggalDonorTerakhir;
    }

    public void setTanggalDonorTerakhir(long tanggalDonorTerakhir) {
        this.tanggalDonorTerakhir = tanggalDonorTerakhir;
    }

    // Method abstrak
    public abstract boolean bolehDonor();
}