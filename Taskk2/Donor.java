/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab2;

/**
 *
 * @author waka I
 */

    public class Donor {
    private String nama;
    private int umur;
    private String golonganDarah;
    private String alamat;

    // Constructor default
    public Donor() {
        this.nama = "Tidak Diketahui";
        this.umur = 0;
        this.golonganDarah = "Tidak Diketahui";
        this.alamat = "Tidak Diketahui";
    }

    // Constructor dengan parameter lengkap
    public Donor(String nama, int umur, String golonganDarah, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.golonganDarah = golonganDarah;
        this.alamat = alamat;
    }

    // Constructor dengan parameter nama dan umur
    public Donor(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        this.golonganDarah = "Tidak Diketahui";
        this.alamat = "Tidak Diketahui";
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "nama='" + nama + '\'' +
                ", umur=" + umur +
                ", golonganDarah='" + golonganDarah + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}

