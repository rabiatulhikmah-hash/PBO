package model;

public class DriverMotor extends Driver {
    public DriverMotor(String nama, String platNomor, String status, int riwayatOrder, int usia) {
        super(nama, platNomor, status, riwayatOrder, usia);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Motor]");
        super.tampilkanInfo();
    }
}
