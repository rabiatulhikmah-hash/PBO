package service;

import model.Driver;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverService {
    private ArrayList<Driver> daftarDriver = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Seed data awal (10 orang)
    public void seedData() {
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

    public void tampilkanDriver() {
        System.out.println("\n=== Data Driver ===");
        for (int i = 0; i < daftarDriver.size(); i++) {
            Driver d = daftarDriver.get(i);
            System.out.println((i + 1) + ". " + d.getNama() + " | " + d.getKendaraan() + " | "
                    + d.getPlatNomor() + " | " + d.getStatus() + " | "
                    + d.getRiwayatOrder() + " order | Usia: " + d.getUsia());
        }
    }

    public void tambahDriver() {
        System.out.print("\nMasukkan nama driver: ");
        String nama = input.nextLine();

        System.out.println("Pilih jenis kendaraan:\n1. Motor\n2. Mobil");
        int pilihKendaraan = input.nextInt();
        input.nextLine();
        String kendaraan = (pilihKendaraan == 1) ? "Motor" : "Mobil";

        System.out.print("Masukkan plat nomor: ");
        String plat = input.nextLine();

        System.out.println("Pilih status driver:\n1. Aktif\n2. Nonaktif");
        int pilihStatus = input.nextInt();
        input.nextLine();
        String status = (pilihStatus == 1) ? "Aktif" : "Nonaktif";

        System.out.print("Masukkan jumlah riwayat order: ");
        int riwayat = input.nextInt();

        System.out.print("Masukkan usia driver: ");
        int usia = input.nextInt();
        input.nextLine();

        daftarDriver.add(new Driver(nama, kendaraan, plat, status, riwayat, usia));
        System.out.println("Driver berhasil ditambahkan!");
    }

    public void updateDriver() {
        tampilkanDriver();
        System.out.print("\nPilih nomor driver yang ingin diupdate: ");
        int index = input.nextInt();
        input.nextLine();

        if (index < 1 || index > daftarDriver.size()) {
            System.out.println("Nomor driver tidak valid!");
            return;
        }

        Driver d = daftarDriver.get(index - 1);

        System.out.print("Nama baru (" + d.getNama() + "): ");
        String namaBaru = input.nextLine();
        if (!namaBaru.isEmpty()) d.setNama(namaBaru);

        System.out.println("Pilih jenis kendaraan:\n1. Motor\n2. Mobil");
        int pilihKendaraan = input.nextInt();
        input.nextLine();
        d.setKendaraan((pilihKendaraan == 1) ? "Motor" : "Mobil");

        System.out.print("Plat nomor baru (" + d.getPlatNomor() + "): ");
        String plat = input.nextLine();
        if (!plat.isEmpty()) d.setPlatNomor(plat);

        System.out.println("Pilih status driver:\n1. Aktif\n2. Nonaktif");
        int pilihStatus = input.nextInt();
        input.nextLine();
        d.setStatus((pilihStatus == 1) ? "Aktif" : "Nonaktif");

        System.out.print("Riwayat order baru (" + d.getRiwayatOrder() + "): ");
        String riwayatInput = input.nextLine();
        if (!riwayatInput.isEmpty()) d.setRiwayatOrder(Integer.parseInt(riwayatInput));

        System.out.print("Usia baru (" + d.getUsia() + "): ");
        String usiaInput = input.nextLine();
        if (!usiaInput.isEmpty()) d.setUsia(Integer.parseInt(usiaInput));

        System.out.println("Data driver berhasil diperbarui!");
    }

    public void hapusDriver() {
        tampilkanDriver();
        System.out.print("\nPilih nomor driver yang ingin dihapus: ");
        int index = input.nextInt();
        input.nextLine();

        if (index < 1 || index > daftarDriver.size()) {
            System.out.println("Nomor driver tidak valid!");
            return;
        }

        Driver d = daftarDriver.get(index - 1);
        daftarDriver.remove(index - 1);
        System.out.println("Driver " + d.getNama() + " berhasil dihapus!");
    }

    public void cariDriver() {
        System.out.print("\nMasukkan nama atau plat nomor driver yang dicari: ");
        String keyword = input.nextLine().toLowerCase();

        System.out.println("\n=== HASIL PENCARIAN ===");
        boolean found = false;
        for (Driver d : daftarDriver) {
            if (d.getNama().toLowerCase().contains(keyword) || d.getPlatNomor().toLowerCase().contains(keyword)) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Driver tidak ditemukan!");
        }
    }
}
