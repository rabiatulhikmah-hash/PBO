package model;

public abstract class Driver implements IDriver {
    protected String nama;
    protected String platNomor;
    protected String status;
    protected int riwayatOrder;
    protected int usia;

    public Driver(String nama, String platNomor, String status, int riwayatOrder, int usia) {
        this.nama = nama;
        this.platNomor = platNomor;
        this.status = status;
        this.riwayatOrder = riwayatOrder;
        this.usia = usia;
    }

    // Getter Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getPlatNomor() { return platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getRiwayatOrder() { return riwayatOrder; }
    public void setRiwayatOrder(int riwayatOrder) { this.riwayatOrder = riwayatOrder; }

    public int getUsia() { return usia; }
    public void setUsia(int usia) { this.usia = usia; }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Plat Nomor: " + platNomor);
        System.out.println("Status: " + status);
        System.out.println("Riwayat Order: " + riwayatOrder);
        System.out.println("Usia: " + usia);
    }
}
