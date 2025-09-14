package model;

public class Driver {
    private String nama;
    private String kendaraan;
    private String platNomor;
    private String status;
    private int riwayatOrder;
    private int usia;

    public Driver(String nama, String kendaraan, String platNomor, String status, int riwayatOrder, int usia) {
        this.nama = nama;
        this.kendaraan = kendaraan;
        this.platNomor = platNomor;
        this.status = status;
        this.riwayatOrder = riwayatOrder;
        this.usia = usia;
    }

    // Getter & Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getKendaraan() { return kendaraan; }
    public void setKendaraan(String kendaraan) { this.kendaraan = kendaraan; }

    public String getPlatNomor() { return platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getRiwayatOrder() { return riwayatOrder; }
    public void setRiwayatOrder(int riwayatOrder) { this.riwayatOrder = riwayatOrder; }

    public int getUsia() { return usia; }
    public void setUsia(int usia) { this.usia = usia; }

    @Override
    public String toString() {
        return "Nama: " + nama +
                ", Kendaraan: " + kendaraan +
                ", Plat Nomor: " + platNomor +
                ", Status: " + status +
                ", Riwayat Order: " + riwayatOrder +
                ", Usia: " + usia;
    }
}
