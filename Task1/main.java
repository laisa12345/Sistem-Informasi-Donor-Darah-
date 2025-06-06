/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab1;

/**
 *
 * @author waka I
 */
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Donor> daftarDonor = new ArrayList<>();

        while (true) {
            System.out.println("=== Sistem Informasi Donor Darah ===");
            System.out.println("1. Tambah Donor");
            System.out.println("2. Tampilkan Daftar Donor");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            if (pilihan == 1) {
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan Umur: ");
                int umur = scanner.nextInt();
                scanner.nextLine(); // membersihkan newline
                System.out.print("Masukkan Golongan Darah: ");
                String golonganDarah = scanner.nextLine();
                System.out.print("Masukkan Alamat: ");
                String alamat = scanner.nextLine();

                Donor donor = new Donor(nama, umur, golonganDarah, alamat);
                daftarDonor.add(donor);
                System.out.println("Donor berhasil ditambahkan!\n");
            } else if (pilihan == 2) {
                System.out.println("=== Daftar Donor ===");
                for (Donor donor : daftarDonor) {
                    System.out.println(donor);
                }
                System.out.println();
            } else if (pilihan == 3) {
                System.out.println("Terima kasih! Program selesai.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
            }
        }

        scanner.close();
    }
}
