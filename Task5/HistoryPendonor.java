/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab5.jey;

/**
 *
 * @author waka I
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class HistoryPendonor extends DonorDarah {
    private List<Date> riwayatDonor;
    private int totalDonor;
    private String catatanKesehatan;

    // Constructor
    public HistoryPendonor() {
        super(); // panggil constructor DonorDarah
        this.riwayatDonor = new ArrayList<>();
        this.totalDonor = 0;
        this.catatanKesehatan = "Tidak ada catatan";
    }

    // Override method bolehDonor() dari abstract class DonorDarah
    @Override
    public boolean bolehDonor() {
        if (riwayatDonor.isEmpty()) {
            return true; // belum pernah donor, boleh donor
        }

        Date terakhir = riwayatDonor.get(riwayatDonor.size() - 1);
        long diff = new Date().getTime() - terakhir.getTime();
        long hari = diff / (1000 * 60 * 60 * 24);

        return hari >= 90; // boleh donor jika sudah 90 hari sejak donor terakhir
    }

    // Overload method tambahDonor - versi dengan catatan
    public void tambahDonor(Date tanggalDonor, String catatan) {
        if (tanggalDonor == null) {
            throw new IllegalArgumentException("Tanggal donor tidak boleh kosong");
        }

        if (tanggalDonor.after(new Date())) {
            throw new IllegalArgumentException("Tanggal donor tidak boleh di masa depan");
        }

        if (!riwayatDonor.isEmpty()) {
            Date terakhir = riwayatDonor.get(riwayatDonor.size() - 1);
            long diff = tanggalDonor.getTime() - terakhir.getTime();
            long hari = diff / (1000 * 60 * 60 * 24);

            if (hari < 90) {
                throw new IllegalArgumentException("Jarak donor minimal 90 hari dari donor terakhir");
            }
        }

        riwayatDonor.add(tanggalDonor);
        totalDonor++;

        if (catatan != null && !catatan.trim().isEmpty()) {
            this.catatanKesehatan = catatan.trim();
        }
    }

    // Overload method tambahDonor - versi tanpa catatan
    public void tambahDonor(Date tanggalDonor) {
        tambahDonor(tanggalDonor, "");
    }

    // Getter dan setter
    public List<Date> getRiwayatDonor() {
        return new ArrayList<>(riwayatDonor); // return copy untuk enkapsulasi
    }

    public int getTotalDonor() {
        return totalDonor;
    }

    public String getCatatanKesehatan() {
        return catatanKesehatan;
    }

    public void setCatatanKesehatan(String catatan) {
        if (catatan != null && !catatan.trim().isEmpty()) {
            this.catatanKesehatan = catatan.trim();
        }
    }

    // Format riwayat donor jadi string mudah baca
    public String getRiwayatFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("Total Donor: ").append(totalDonor).append("\n\n");

        if (riwayatDonor.isEmpty()) {
            sb.append("Belum ada riwayat donor\n");
        } else {
            sb.append("Daftar Donor:\n");
            for (Date tanggal : riwayatDonor) {
                sb.append("- ").append(sdf.format(tanggal)).append("\n");
            }
            sb.append("\nDonor terakhir: ").append(sdf.format(riwayatDonor.get(riwayatDonor.size() - 1))).append("\n");
        }

        sb.append("\nCatatan Kesehatan:\n").append(catatanKesehatan);

        return sb.toString();
    }

    // Info kapan bisa donor lagi
    public String getNextDonorInfo(Date tanggalDonor) {
        if (tanggalDonor == null) {
            return "Tanggal donor tidak valid";
        }

        Date sekarang = new Date();
        long selisih = sekarang.getTime() - tanggalDonor.getTime();
        long hari = selisih / (1000 * 60 * 60 * 24);

        if (hari < 0) {
            return "Tanggal donor tidak boleh di masa depan";
        } else if (hari >= 90) {
            return "Bisa donor sekarang (sudah " + hari + " hari sejak donor)";
        } else {
            return "Belum bisa donor. Tunggu " + (90 - hari) + " hari lagi";
        }
    }
}