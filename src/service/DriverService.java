package service;

import model.Driver;
import model.DriverMobil;
import model.DriverMotor;

import java.util.List;
import java.util.Scanner;

public class DriverService {
    private Scanner scanner = new Scanner(System.in);

    // READ (pakai ORM)
    public void tampilkanDriver() {
        System.out.println("\n=== Daftar Driver (Dari Database) ===");
        List<Driver> daftar = DriverORM.getAll();
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data driver.");
            return;
        }
        int i = 1;
        for (Driver d : daftar) {
            System.out.println(i++ + ".");
            d.tampilkanInfo();
            System.out.println("------------------------");
        }
    }

    // CREATE (pakai ORM)
    public void tambahDriver() {
        System.out.println("\n=== Tambah Driver Baru ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.println("Pilih kendaraan:");
        System.out.println("1. Motor");
        System.out.println("2. Mobil");
        System.out.print("Pilihan (1/2): ");
        int pilihKendaraan = scanner.nextInt();
        scanner.nextLine();

        if (pilihKendaraan != 1 && pilihKendaraan != 2) {
            System.out.println("Pilihan kendaraan tidak valid. Batal menambah driver.");
            return;
        }

        System.out.print("Plat Nomor: ");
        String plat = scanner.nextLine();

        System.out.println("Pilih status:");
        System.out.println("1. Aktif");
        System.out.println("2. Nonaktif");
        System.out.print("Pilihan (1/2): ");
        int pilihStatus = scanner.nextInt();
        scanner.nextLine();
        if (pilihStatus != 1 && pilihStatus != 2) {
            System.out.println("Pilihan status tidak valid. Batal menambah driver.");
            return;
        }
        String status = (pilihStatus == 1) ? "Aktif" : "Nonaktif";

        System.out.print("Riwayat Order (angka): ");
        int riwayat = scanner.nextInt();

        System.out.print("Usia (angka): ");
        int usia = scanner.nextInt();
        scanner.nextLine();

        Driver d;
        if (pilihKendaraan == 1) {
            d = new DriverMotor(nama, plat, status, riwayat, usia);
        } else {
            d = new DriverMobil(nama, plat, status, riwayat, usia);
        }

        DriverORM.insert(d);
    }

    // UPDATE (pakai ORM)
    public void updateDriver() {
        tampilkanDriver();
        System.out.print("Masukkan ID driver yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Pilih status baru:");
        System.out.println("1. Aktif");
        System.out.println("2. Nonaktif");
        System.out.print("Pilihan (1/2): ");
        int pilihStatus = scanner.nextInt();
        scanner.nextLine();

        String statusBaru = (pilihStatus == 1) ? "Aktif" : "Nonaktif";
        DriverORM.update(id, statusBaru);
    }

    // DELETE (pakai ORM)
    public void hapusDriver() {
        tampilkanDriver();
        System.out.print("Masukkan ID driver yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan alasan penghapusan: ");
        String alasan = scanner.nextLine();

        DriverORM.delete(id);
        System.out.println("Driver dengan ID " + id + " dihapus. Alasan: " + alasan);
    }

    // SEARCH sederhana (tidak wajib ORM)
    public void cariDriver() {
        System.out.println("\n=== MENU PENCARIAN ===");
        System.out.println("1. Berdasarkan Nama");
        System.out.println("2. Berdasarkan Jenis Kendaraan");
        System.out.print("Pilih (1/2): ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        List<Driver> daftar = DriverORM.getAll();
        boolean found = false;

        if (pilih == 1) {
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine().toLowerCase();

            for (Driver d : daftar) {
                if (d.getNama().toLowerCase().contains(nama)) {
                    d.tampilkanInfo();
                    System.out.println("------------------------");
                    found = true;
                }
            }
        } else if (pilih == 2) {
            System.out.print("Masukkan jenis (Motor/Mobil): ");
            String jenis = scanner.nextLine().toLowerCase();

            for (Driver d : daftar) {
                String tipe = (d instanceof DriverMotor) ? "motor" : "mobil";
                if (tipe.equals(jenis)) {
                    d.tampilkanInfo();
                    System.out.println("------------------------");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Data tidak ditemukan!");
        }
    }
}
