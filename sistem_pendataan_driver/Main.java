package com.mycompany.sistem_pendataan_driver;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    // Kelas Driver
    static class Driver {
        String nama;
        String kendaraan;
        String platNomor;
        String status;
        int riwayatOrder;
        int usia;

        Driver(String nama, String kendaraan, String platNomor, String status, int riwayatOrder, int usia) {
            this.nama = nama;
            this.kendaraan = kendaraan;
            this.platNomor = platNomor;
            this.status = status;
            this.riwayatOrder = riwayatOrder;
            this.usia = usia;
        }
    }

    static ArrayList<Driver> daftarDriver = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();

        while (true) {
            System.out.println("\n=== Sistem Pendataan Driver Grab ===");
            System.out.println("1. Tambah Driver");
            System.out.println("2. Lihat Driver");
            System.out.println("3. Update Driver");
            System.out.println("4. Hapus Driver");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1: tambahDriver(); break;
                case 2: lihatDriver(); break;
                case 3: updateDriver(); break;
                case 4: hapusDriver(); break;
                case 5: return;
                default: System.out.println("Pilihan tidak ada!");
            }
        }
    }

    // Data awal (10 orang)
    static void seedData() {
        daftarDriver.add(new Driver("Budi", "Motor", "KT1234AA", "Aktif", 120, 25));
        daftarDriver.add(new Driver("Andi", "Mobil", "KT5678BB", "Aktif", 200, 32));
        daftarDriver.add(new Driver("Siti", "Motor", "KT9012CC", "Nonaktif", 340, 28));
        daftarDriver.add(new Driver("Dewi", "Mobil", "KT3456DD", "Aktif", 90, 22));
        daftarDriver.add(new Driver("Rudi", "Motor", "KT7890EE", "Aktif", 150, 45));
        daftarDriver.add(new Driver("Agus", "Mobil", "KT1122FF", "Nonaktif", 210, 27));
        daftarDriver.add(new Driver("Nina", "Motor", "KT3344GG", "Aktif", 175, 30));
        daftarDriver.add(new Driver("Eka", "Mobil", "KT5566HH", "Aktif", 130, 40));
        daftarDriver.add(new Driver("Yudi", "Motor", "KT7788II", "Aktif", 320, 19));
        daftarDriver.add(new Driver("Lina", "Mobil", "KT9900JJ", "Nonaktif", 250, 35));
    }

    // CREATE
    static void tambahDriver() {
        System.out.println("\n=== Tambah Driver Baru ===");
        System.out.print("Nama        : ");
        String nama = scanner.nextLine();
        System.out.print("Kendaraan   : ");
        String kendaraan = scanner.nextLine();
        System.out.print("Plat Nomor  : ");
        String platNomor = scanner.nextLine();
        System.out.println("Pilih Status (1. Aktif / 2. Nonaktif): ");
        int pilihStatus = scanner.nextInt();
        scanner.nextLine();
        String status = (pilihStatus == 1) ? "Aktif" : "Nonaktif";
        System.out.print("Riwayat Order: ");
        int riwayatOrder = scanner.nextInt();
        System.out.print("Usia        : ");
        int usia = scanner.nextInt();
        scanner.nextLine();

        daftarDriver.add(new Driver(nama, kendaraan, platNomor, status, riwayatOrder, usia));
        System.out.println("Driver berhasil ditambahkan!");
    }

    // READ
    static void lihatDriver() {
        System.out.println("\n=== Daftar Driver ===");
        int i = 1;
        for (Driver d : daftarDriver) {
            System.out.println(i++ + ". " + d.nama + " | " + d.kendaraan +
                    " | " + d.platNomor +
                    " | Status: " + d.status +
                    " | Order: " + d.riwayatOrder +
                    " | Usia: " + d.usia);
        }
    }

    // UPDATE
    static void updateDriver() {
        lihatDriver();
        System.out.print("\nPilih nomor driver yang ingin diupdate: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        Driver d = daftarDriver.get(index - 1);

        System.out.print("Nama baru: ");
        d.nama = scanner.nextLine();
        System.out.print("Kendaraan baru: ");
        d.kendaraan = scanner.nextLine();
        System.out.print("Plat Nomor baru: ");
        d.platNomor = scanner.nextLine();
        System.out.println("Pilih Status baru (0 = tidak diubah): ");
        System.out.println("1. Aktif");
        System.out.println("2. Nonaktif");
        int pilihStatus = scanner.nextInt();
        scanner.nextLine();
        if (pilihStatus == 1) d.status = "Aktif";
        else if (pilihStatus == 2) d.status = "Nonaktif";
        System.out.print("Riwayat Order baru: ");
        d.riwayatOrder = scanner.nextInt();
        System.out.print("Usia baru: ");
        d.usia = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Driver berhasil diupdate!");
    }

    // DELETE
    static void hapusDriver() {
        lihatDriver();
        System.out.print("\nPilih nomor driver yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        Driver d = daftarDriver.get(index - 1);

        System.out.print("Masukkan alasan penghapusan: ");
        String alasan = scanner.nextLine();

        daftarDriver.remove(index - 1);
        System.out.println("Driver " + d.nama + " berhasil dihapus. Alasan: " + alasan);
    }
}
