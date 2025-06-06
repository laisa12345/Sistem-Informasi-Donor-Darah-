/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bab9Revisi;

/**
 *
 * @author waka I
 */
public abstract class DonorDarah {
    private String golonganDarah;
    private long tanggalDonorTerakhir;

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

    // INI YANG PALING PENTING:
    public abstract boolean bolehDonor();
}