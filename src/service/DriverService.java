package service;

import model.Driver;
import model.DriverMobil;
import model.DriverMotor;
import model.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    private List<Driver> drivers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Tambahkan data default biar gak kosong saat awal program
    public DriverService() {
        seedData();
    }

    private void seedData() {
        drivers.add(new DriverMotor("Rizky", "KT1234AA", "Aktif", 20, 25));
        drivers.add(new DriverMobil("Andi", "KT5678BB", "Nonaktif", 12, 30));
        drivers.add(new DriverMotor("Sinta", "KT9101CC", "Aktif", 40, 28));
    }

    // READ (Tampilkan semua data dari database)
    public void tampilkanDriver() {
        System.out.println("\n=== Daftar Driver ===");
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM driver")) {

            if (!rs.isBeforeFirst()) {
                System.out.println("Belum ada data driver.");
                return;
            }

            while (rs.next()) {
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Plat Nomor: " + rs.getString("plat_nomor"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Riwayat Order: " + rs.getInt("riwayat_order"));
                System.out.println("Usia: " + rs.getInt("usia"));
                System.out.println("Jenis Kendaraan: " + rs.getString("jenis_driver"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
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

        String jenis = (pilihKendaraan == 1) ? "Motor" : "Mobil";

        System.out.print("Plat Nomor: ");
        String plat = scanner.nextLine();

        System.out.println("Pilih status:");
        System.out.println("1. Aktif");
        System.out.println("2. Nonaktif");
        System.out.print("Pilihan (1/2): ");
        int pilihStatus = scanner.nextInt();
        scanner.nextLine();

        String status = (pilihStatus == 1) ? "Aktif" : "Nonaktif";

        System.out.print("Riwayat Order (angka): ");
        int riwayat = scanner.nextInt();

        System.out.print("Usia (angka): ");
        int usia = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO driver (nama, plat_nomor, status, riwayat_order, usia, jenis_driver) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, nama);
            ps.setString(2, plat);
            ps.setString(3, status);
            ps.setInt(4, riwayat);
            ps.setInt(5, usia);
            ps.setString(6, jenis);

            ps.executeUpdate();
            System.out.println("Driver berhasil ditambahkan ke database!");

        } catch (SQLException e) {
            System.out.println("Gagal menambah driver: " + e.getMessage());
        }
    }

    // UPDATE (edit data di database)
    public void updateDriver() {
        tampilkanDriver();

        System.out.print("Masukkan ID Driver yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama baru (kosong = tidak diubah): ");
        String namaBaru = scanner.nextLine();
        System.out.print("Plat baru (kosong = tidak diubah): ");
        String platBaru = scanner.nextLine();
        System.out.print("Status baru (kosong = tidak diubah): ");
        String statusBaru = scanner.nextLine();

        try (Connection conn = Database.connect()) {
            String sql = "UPDATE driver SET "
                    + "nama = IF(? = '', nama, ?), "
                    + "plat_nomor = IF(? = '', plat_nomor, ?), "
                    + "status = IF(? = '', status, ?) "
                    + "WHERE id_driver = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, namaBaru);
            ps.setString(2, namaBaru);
            ps.setString(3, platBaru);
            ps.setString(4, platBaru);
            ps.setString(5, statusBaru);
            ps.setString(6, statusBaru);
            ps.setInt(7, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Data driver berhasil diperbarui!");
            } else {
                System.out.println("Driver dengan ID tersebut tidak ditemukan!");
            }

        } catch (SQLException e) {
            System.out.println("Gagal update: " + e.getMessage());
        }
    }

    // DELETE
    public void hapusDriver() {
        tampilkanDriver();
        System.out.print("Masukkan ID driver yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM driver WHERE id_driver = ?")) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Driver berhasil dihapus!");
            } else {
                System.out.println("Driver tidak ditemukan!");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus driver: " + e.getMessage());
        }
    }

    // SEARCH
    public void cariDriver() {
        System.out.println("\n=== MENU PENCARIAN ===");
        System.out.println("1. Berdasarkan Nama");
        System.out.println("2. Berdasarkan Jenis Kendaraan");
        System.out.print("Pilih (1/2): ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        try (Connection conn = Database.connect()) {
            PreparedStatement ps;
            if (pilih == 1) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                ps = conn.prepareStatement("SELECT * FROM driver WHERE nama LIKE ?");
                ps.setString(1, "%" + nama + "%");
            } else {
                System.out.print("Masukkan jenis kendaraan (Motor/Mobil): ");
                String jenis = scanner.nextLine();
                ps = conn.prepareStatement("SELECT * FROM driver WHERE jenis_driver = ?");
                ps.setString(1, jenis);
            }

            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("Data tidak ditemukan!");
                return;
            }

            while (rs.next()) {
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Plat Nomor: " + rs.getString("plat_nomor"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Riwayat Order: " + rs.getInt("riwayat_order"));
                System.out.println("Usia: " + rs.getInt("usia"));
                System.out.println("Jenis Kendaraan: " + rs.getString("jenis_driver"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Gagal mencari driver: " + e.getMessage());
        }
    }
}
