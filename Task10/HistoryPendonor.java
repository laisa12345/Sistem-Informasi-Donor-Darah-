/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab10;

/**
 *
 * @author waka I
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class HistoryPendonor extends DonorDarah {
    private List<Date> riwayatDonor = new ArrayList<>();
    private int totalDonor = 0;
    private String catatanKesehatan = "Tidak ada catatan";

    @Override
    public boolean bolehDonor() {
        if (riwayatDonor.isEmpty()) return true;
        Date terakhir = riwayatDonor.get(riwayatDonor.size() - 1);
        long hari = (new Date().getTime() - terakhir.getTime()) / (1000 * 60 * 60 * 24);
        return hari >= 90;
    }

    public void tambahDonor(Date tanggal, String catatan) {
        if (tanggal == null) throw new IllegalArgumentException("Tanggal donor tidak boleh null");
        if (tanggal.after(new Date())) throw new IllegalArgumentException("Tanggal donor di masa depan");

        if (!riwayatDonor.isEmpty()) {
            Date terakhir = riwayatDonor.get(riwayatDonor.size() - 1);
            long hari = (tanggal.getTime() - terakhir.getTime()) / (1000 * 60 * 60 * 24);
            if (hari < 90) throw new IllegalArgumentException("Minimal jarak 90 hari");
        }

        riwayatDonor.add(tanggal);
        totalDonor++;
        if (catatan != null && !catatan.trim().isEmpty()) {
            this.catatanKesehatan = catatan.trim();
        }
    }

    public void tambahDonor(Date tanggal) {
        tambahDonor(tanggal, "");
    }

    public String getRiwayatFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder("Total Donor: " + totalDonor + "\n");

        if (riwayatDonor.isEmpty()) {
            sb.append("Belum ada riwayat donor\n");
        } else {
            sb.append("Daftar Donor:\n");
            for (Date tgl : riwayatDonor) {
                sb.append("- ").append(sdf.format(tgl)).append("\n");
            }
        }

        sb.append("Catatan: ").append(catatanKesehatan);
        return sb.toString();
    }
    
    public String getNextDonorInfo(int tanggalDonor) {
    int tahun = tanggalDonor / 10000;
    int bulan = (tanggalDonor % 10000) / 100;
    int hari = tanggalDonor % 100;

    Calendar cal = Calendar.getInstance();
    cal.set(tahun, bulan - 1, hari); // bulan dimulai dari 0
    cal.add(Calendar.DAY_OF_YEAR, 90);

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    return "Donor berikutnya bisa dilakukan setelah: " + sdf.format(cal.getTime());
}
}
