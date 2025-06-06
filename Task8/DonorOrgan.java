/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab8;

/**
 *
 * @author waka I
 */
public class DonorOrgan extends DonorDarah {
    private String jenisOrgan;
    private boolean donorHidup;

    public DonorOrgan(String jenisOrgan, boolean donorHidup) {
        this.jenisOrgan = jenisOrgan;
        this.donorHidup = donorHidup;
    }

    @Override
    public boolean bolehDonor() {
        return donorHidup; // Hanya donor hidup yang valid dalam contoh ini
    }

    public String getStatusDonor() {
        return donorHidup ? "Donor hidup" : "Donor meninggal";
    }

    public String getInfoDonor() {
        return "Organ: " + jenisOrgan + " - " + getStatusDonor();
    }
}