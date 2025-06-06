/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab5.jey;

import Bab4.*;

/**
 *
 * @author waka I
 */
    public abstract class DonorDarah {
    // Atribut dasar yang dimiliki semua donor darah
    private String golonganDarah;
    private int tanggalDonorTerakhir;
    
    // Constructor
    public DonorDarah() {
        this.golonganDarah = "Unknown";
        this.tanggalDonorTerakhir = 0;
    }
    
    // Method umum untuk semua donor darah
    public abstract boolean bolehDonor();
    
    // Getter dan setter
    public String getGolonganDarah() {
        return golonganDarah;
    }
    
    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }
    
    public int getTanggalDonorTerakhir() {
        return tanggalDonorTerakhir;
    }
    
    public void setTanggalDonorTerakhir(int tanggalDonorTerakhir) {
        this.tanggalDonorTerakhir = tanggalDonorTerakhir;
    }
}
