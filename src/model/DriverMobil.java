package model;

public class DriverMobil extends Driver {
    public DriverMobil(String nama, String platNomor, String status, int riwayatOrder, int usia) {
        super(nama, platNomor, status, riwayatOrder, usia);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Mobil]");
        super.tampilkanInfo();
    }
}
