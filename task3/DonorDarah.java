/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab3;

/**
 *
 * @author waka I
 */
public class DonorDarah {
 String Nama , GolonganDarah , Alamat;
 int Umur;
 
 void Nama(String Nama){
    this.Nama = Nama;
 }
 void GolonganDarah(String GolonganDarah){
    this.GolonganDarah = GolonganDarah;
 } 
 void Alamat(String Alamat){
    this.Alamat = Alamat;
 }
 void Umur(int Umur){
    this.Umur = Umur;
 } 
 String cetakNama(){
 return Nama;
 }
 String cetakGolonganDarah(){
    return GolonganDarah;
 }
 String cetakAlamat(){
    return Alamat;
 }
 int cetakUmur(){
    return Umur;
 }
}
