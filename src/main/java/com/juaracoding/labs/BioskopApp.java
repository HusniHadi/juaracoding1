package com.juaracoding.labs;

import java.util.Scanner;

public class BioskopApp {

    static Scanner input = new Scanner(System.in);
    static String[] judulFilm = new String[10];
    static int jumlahFilm = 0;

    public static void main(String[] args) {
        login();

        int pilih;
        do {
            tampilkanMenu();
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine(); 

            switch (pilih) {
                case 1:
                    tampilkanFilm();
                    break;
                case 2:
                    inputFilm();
                    break;
                case 3:
                    cariFilm();
                    break;
                case 4:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 4);
    }

    // ===================== LOGIN =====================
    static void login() {
        while (true) {
            System.out.println("=== Login ===");
            System.out.print("Username: ");
            String user = input.nextLine();
            System.out.print("Password: ");
            String pass = input.nextLine();

            if (user.equals("admin") && pass.equals("12345")) {
                System.out.println("Login berhasil!\n");
                break;
            } else {
                System.out.println("Username atau password salah!\n");
            }
        }
    }

    // ===================== MENU =====================
    static void tampilkanMenu() {
        System.out.println("=== Menu Utama ===");
        System.out.println("1. Tampilkan Daftar Film");
        System.out.println("2. Input Data Film");
        System.out.println("3. Cari Film");
        System.out.println("4. Keluar");
    }

    // ===================== INPUT FILM =====================
    static void inputFilm() {
        System.out.print("Masukkan jumlah film yang ingin ditambah: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            if (jumlahFilm >= 10) {
                System.out.println("Kapasitas film penuh!");
                break;
            }
            System.out.println("Film ke-" + (i + 1));
            System.out.print("Judul: ");
            judulFilm[jumlahFilm] = input.nextLine();
            jumlahFilm++;
        }

        System.out.println("Input film selesai!\n");
    }

    // ===================== TAMPILKAN FILM =====================
    static void tampilkanFilm() {
        System.out.println("=== Daftar Film ===");
        if (jumlahFilm == 0) {
            System.out.println("Belum ada film yang diinput!\n");
            return;
        }

        for (int i = 0; i < jumlahFilm; i++) {
            System.out.println((i + 1) + ". " + judulFilm[i]);
        }
        System.out.println();
    }

    // ===================== CARI FILM =====================
    static void cariFilm() {
        System.out.print("Masukkan judul film yang dicari: ");
        String cari = input.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilm; i++) {
            if (judulFilm[i].equalsIgnoreCase(cari)) {
                System.out.println("Film ditemukan: " + judulFilm[i] + "\n");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Film tidak ditemukan!\n");
        }
    }
}
