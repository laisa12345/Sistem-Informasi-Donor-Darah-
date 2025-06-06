/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab10;

/**
 *
 * @author waka I
 */
public class Admin implements User {
    private String nama;
    private String username;
    private String password;

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void tampilkanDataAdmin() {
        System.out.println("\n=== Data Admin ===");
        System.out.println("Nama     : " + getNama());
        System.out.println("Username : " + getUsername());
        System.out.println("Password : " + getPassword());
    }
}