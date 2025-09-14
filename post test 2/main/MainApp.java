package main;

import service.DriverService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        DriverService service = new DriverService();
        service.seedData();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN DRIVER ===");
            System.out.println("1. Tambah Driver");
            System.out.println("2. Lihat Driver");
            System.out.println("3. Update Driver");
            System.out.println("4. Hapus Driver");
            System.out.println("5. Cari Driver");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> service.tambahDriver();
                case 2 -> service.tampilkanDriver();
                case 3 -> service.updateDriver();
                case 4 -> service.hapusDriver();
                case 5 -> service.cariDriver();
                case 6 -> {
                    System.out.println("Keluar dari program...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
