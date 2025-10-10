# Penjelasan Struktur Program
Program ini merupakan sistem manajemen data driver yang terhubung dengan database MySQL.
Fungsinya adalah untuk melakukan CRUD (Create, Read, Update, Delete) dan menampilkan data menggunakan ORM sederhana dengan pendekatan Object-Oriented Programming (OOP).

<img width="382" height="429" alt="image" src="https://github.com/user-attachments/assets/e97c2fbc-0a67-4a08-873e-8d3a816683b1" />


## 1. Package main
* Berisi class MainApp.java yang menjadi entry point (titik awal) dari program.
* Di sinilah menu utama ditampilkan dan interaksi pengguna dikendalikan.
* Setiap pilihan menu akan memanggil fungsi yang ada di class DriverService.

## 2. Package model
Menampung seluruh class yang merepresentasikan data dan struktur objek.
* Driver.java → Abstract class yang menjadi dasar bagi semua jenis driver.
* DriverMotor.java & DriverMobil.java → Subclass yang menurunkan class Driver dengan detail khusus untuk kendaraan motor dan mobil.
* IDriver.java → Interface yang berisi kontrak perilaku yang wajib dimiliki setiap driver (seperti tampilkanInfo()).
* Database.java → Class yang berfungsi untuk mengatur nama database dan tabel yang digunakan di dalam program agar mudah diakses dari berbagai bagian kode.

## 3. Package service
Menyimpan seluruh logika program dan proses yang berhubungan langsung dengan database.

* DatabaseConnection.java → Mengatur koneksi ke database menggunakan JDBC (Java Database Connectivity). Class ini membuat dan mengembalikan objek Connection agar bisa digunakan di seluruh sistem.
* DriverService.java → Berisi operasi CRUD (Create, Read, Update, Delete) serta fitur pencarian driver. Semua query SQL ditulis dan dijalankan melalui class ini.

## 4. Libraries

* mysql-connector-j-9.4.0.jar → Library yang memungkinkan Java untuk berkomunikasi dengan database MySQL/MariaDB.
* JDK 24 (Default) → Versi Java Development Kit yang digunakan untuk menjalankan program ini.

# Penjelasan Bagian Baru: Koneksi Database & ORM

## 1. Koneksi ke Database
Agar program bisa berkomunikasi dengan database MySQL, kamu menambahkan dua class utama, yaitu:

### 📄 Database.java

Class ini berfungsi untuk menyimpan konfigurasi dasar koneksi database, supaya mudah digunakan di seluruh bagian program.
Fungsinya seperti “pusat konfigurasi” — jadi kalau nanti nama database atau password berubah, cukup ubah di sini aja.

<img width="1163" height="629" alt="Screenshot 2025-10-10 224943" src="https://github.com/user-attachments/assets/b63e2441-a65a-48c0-9449-96053f34657a" />

### 📄 DatabaseConnection.java
Class ini digunakan untuk membuat koneksi ke MySQL menggunakan konfigurasi dari Database.java.

