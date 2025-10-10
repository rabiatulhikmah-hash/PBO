package service;

import model.Driver;
import model.DriverMobil;
import model.DriverMotor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverORM {

    // CREATE
    public static void insert(Driver d) {
        String sql = "INSERT INTO driver (nama, plat_nomor, status, riwayat_order, usia, jenis_driver) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getNama());
            stmt.setString(2, d.getPlatNomor());
            stmt.setString(3, d.getStatus());
            stmt.setInt(4, d.getRiwayatOrder());
            stmt.setInt(5, d.getUsia());
            stmt.setString(6, (d instanceof DriverMotor) ? "Motor" : "Mobil");

            stmt.executeUpdate();
            System.out.println("✅ Data berhasil disimpan ke database!");
        } catch (SQLException e) {
            System.out.println("❌ Gagal menyimpan data: " + e.getMessage());
        }
    }

    // READ
    public static List<Driver> getAll() {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM driver";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String jenis = rs.getString("jenis_driver");
                Driver d;
                if ("Motor".equalsIgnoreCase(jenis)) {
                    d = new DriverMotor(
                            rs.getString("nama"),
                            rs.getString("plat_nomor"),
                            rs.getString("status"),
                            rs.getInt("riwayat_order"),
                            rs.getInt("usia")
                    );
                } else {
                    d = new DriverMobil(
                            rs.getString("nama"),
                            rs.getString("plat_nomor"),
                            rs.getString("status"),
                            rs.getInt("riwayat_order"),
                            rs.getInt("usia")
                    );
                }
                list.add(d);
            }

        } catch (SQLException e) {
            System.out.println("❌ Gagal membaca data: " + e.getMessage());
        }
        return list;
    }

    // UPDATE
    public static void update(int id, String statusBaru) {
        String sql = "UPDATE driver SET status = ? WHERE id_driver = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, statusBaru);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("✅ Data berhasil diperbarui!");
        } catch (SQLException e) {
            System.out.println("❌ Gagal update: " + e.getMessage());
        }
    }

    // DELETE
    public static void delete(int id) {
        String sql = "DELETE FROM driver WHERE id_driver = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Data berhasil dihapus!");
        } catch (SQLException e) {
            System.out.println("❌ Gagal hapus data: " + e.getMessage());
        }
    }
}
