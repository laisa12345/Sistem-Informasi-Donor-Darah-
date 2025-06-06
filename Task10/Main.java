/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab10;

/**
 *
 * @author waka I
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        System.out.println("Pilih jenis donor:");
        System.out.println("1. Donor Darah");
        System.out.println("2. Donor Organ");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Nama: ");
        String nama = sc.nextLine();

        System.out.print("Jenis Kelamin: ");
        String jenisKelamin = sc.nextLine();

        System.out.print("Tanggal Lahir (YYYYMMDD): ");
        int tanggalLahir = sc.nextInt();
        sc.nextLine();

        System.out.print("Golongan Darah: ");
        String golDarah = sc.nextLine();

        System.out.print("No Telpon: ");
        String noTelp = sc.nextLine();

        System.out.print("Alamat: ");
        String alamat = sc.nextLine();

        output.append("Nama: ").append(nama).append("\n");
        output.append("Jenis Kelamin: ").append(jenisKelamin).append("\n");
        output.append("Tanggal Lahir: ").append(tanggalLahir).append("\n");
        output.append("Golongan Darah: ").append(golDarah).append("\n");
        output.append("No Telpon: ").append(noTelp).append("\n");
        output.append("Alamat: ").append(alamat).append("\n");

        if (pilihan == 1) {
            // Donor Darah
            Pendonor pendonor = new Pendonor(nama, tanggalLahir);
            pendonor.setGolonganDarah(golDarah);
            pendonor.setTanggalDonorTerakhir(System.currentTimeMillis() - 100L * 24 * 60 * 60 * 1000);

            output.append("Jenis Donor: Darah\n");
            output.append("Boleh Donor: ").append(pendonor.bolehDonor() ? "Ya" : "Tidak").append("\n");

        } else if (pilihan == 2) {
            // Donor Organ
            System.out.print("Organ yang Didonorkan: ");
            String organ = sc.nextLine();

            System.out.print("Pernah Donor Sebelumnya? (true/false): ");
            boolean pernahDonor = sc.nextBoolean();
            sc.nextLine();

            String organSebelumnya = "";
            if (pernahDonor) {
                System.out.print("Organ yang Pernah Didonorkan: ");
                organSebelumnya = sc.nextLine();
            }

            DonorOrgan donorOrgan = new DonorOrgan(organ, true);
            donorOrgan.setTanggalDonorTerakhir(System.currentTimeMillis());

            output.append("Jenis Donor: Organ\n");
            output.append("Organ yang Didonorkan: ").append(organ).append("\n");
            output.append("Pernah Donor Sebelumnya: ").append(pernahDonor ? "Ya" : "Tidak").append("\n");
            if (pernahDonor) {
                output.append("Organ yang Pernah Didonorkan: ").append(organSebelumnya).append("\n");
            }
            output.append("Boleh Donor: ").append(donorOrgan.bolehDonor() ? "Ya" : "Tidak").append("\n");

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        System.out.println("\n=== Rangkuman Data Pendonor ===");
        System.out.println(output);

        sc.close();
    }
}