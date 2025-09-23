package service;

import model.Driver;
import model.DriverMobil;
import model.DriverMotor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    private List<Driver> drivers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // seedData() dipanggil dari MainApp (sesuai kode kamu)
    public void seedData() {
        drivers.add(new DriverMotor("Budi", "KT1234AA", "Aktif", 120, 25));
        drivers.add(new DriverMobil("Andi", "KT5678BB", "Aktif", 200, 32));
        drivers.add(new DriverMotor("Siti", "KT9012CC", "Nonaktif", 340, 28));
        drivers.add(new DriverMobil("Dewi", "KT3456DD", "Aktif", 90, 22));
        drivers.add(new DriverMotor("Rudi", "KT7890EE", "Aktif", 150, 45));
        drivers.add(new DriverMobil("Agus", "KT1122FF", "Nonaktif", 210, 27));
        drivers.add(new DriverMotor("Nina", "KT3344GG", "Aktif", 175, 30));
        drivers.add(new DriverMobil("Eka", "KT5566HH", "Aktif", 130, 40));
        drivers.add(new DriverMotor("Yudi", "KT7788II", "Aktif", 320, 19));
        drivers.add(new DriverMobil("Lina", "KT9900JJ", "Nonaktif", 250, 35));
    }

    // READ - tampilkan semua (pakai override tampilkanInfo)
    public void tampilkanDriver() {
            System.out.println("\n=== Daftar Driver ===");
            if (drivers.isEmpty()) {
                System.out.println("Belum ada data driver.");
                return;
            }
            for (int i = 0; i < drivers.size(); i++) {
                System.out.println((i + 1) + ".");
                drivers.get(i).tampilkanInfo();
                System.out.println("------------------------------");
            }
        }
    // CREATE
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

        if (pilihKendaraan == 1) {
            drivers.add(new DriverMotor(nama, plat, status, riwayat, usia));
        } else {
            drivers.add(new DriverMobil(nama, plat, status, riwayat, usia));
        }

        System.out.println("Driver berhasil ditambahkan!");
    }
    
    // UPDATE (pilih nomor driver)
    public void updateDriver() {
        tampilkanDriver();
        if (drivers.isEmpty()) return;

        System.out.print("Pilih nomor driver yang ingin diupdate: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > drivers.size()) {
            System.out.println("Nomor driver tidak valid!");
            return;
        }

        Driver old = drivers.get(index - 1);

        System.out.print("Nama baru (kosong = tidak diubah): ");
        String namaBaru = scanner.nextLine();
        if (!namaBaru.isEmpty()) old.setNama(namaBaru);

        System.out.print("Plat baru (kosong = tidak diubah): ");
        String platBaru = scanner.nextLine();
        if (!platBaru.isEmpty()) old.setPlatNomor(platBaru);

        System.out.println("Pilih status baru (0 = tidak diubah):");
        System.out.println("1. Aktif");
        System.out.println("2. Nonaktif");
        int pilihStatus = scanner.nextInt();
        scanner.nextLine();
        if (pilihStatus == 1) old.setStatus("Aktif");
        else if (pilihStatus == 2) old.setStatus("Nonaktif");

        System.out.print("Riwayat order baru (0 = tidak diubah): ");
        int riwayatBaru = scanner.nextInt();
        System.out.print("Usia baru (0 = tidak diubah): ");
        int usiaBaru = scanner.nextInt();
        scanner.nextLine();

        if (riwayatBaru > 0) old.setRiwayatOrder(riwayatBaru);
        if (usiaBaru > 0) old.setUsia(usiaBaru);

        System.out.println("Data driver berhasil diperbarui!");
    }


    // DELETE dengan alasan
    public void hapusDriver() {
        tampilkanDriver();
        if (drivers.isEmpty()) return;

        System.out.print("Pilih nomor driver yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > drivers.size()) {
            System.out.println("Nomor driver tidak valid!");
            return;
        }

        Driver d = drivers.get(index - 1);
        System.out.print("Masukkan alasan penghapusan: ");
        String alasan = scanner.nextLine();

        drivers.remove(index - 1);
        System.out.println("Driver " + d.getNama() + " berhasil dihapus. Alasan: " + alasan);
    }

    // SEARCH by nama atau plat (case-insensitive, partial)
    public void cariDriver() {
        System.out.print("Masukkan nama atau plat nomor yang dicari: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("\n=== HASIL PENCARIAN ===");
        for (Driver d : drivers) {
            if (d.getNama().toLowerCase().contains(keyword) ||
                d.getPlatNomor().toLowerCase().contains(keyword)) {
                d.tampilkanInfo();
                System.out.println("------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Driver tidak ditemukan!");
        }
    }
}