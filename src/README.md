# **Nama : Rabiatul Hikmah**

# **Nim : 2409116049**

# PostTest4

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
Class ini digunakan untuk membuat koneksi ke MySQL menggunakan konfigurasi dari Database.java. class ini memastikan koneksi hanya dibuat satu kali dan bisa digunakan ulang di class lain seperti DriverService atau DriverORM.

<img width="928" height="459" alt="image" src="https://github.com/user-attachments/assets/a10c22c6-ec12-4d89-a300-dbd92354aded" />


## 2. Penambahan ORM (Object Relational Mapping)
Class baru bernama DriverORM.java dibuat untuk menampilkan data dari tabel database menggunakan Statement, sekaligus menerapkan konsep ORM sederhana.

📄 DriverORM.java

Class ini mengambil data dari tabel driver, lalu mengubah setiap baris hasil query menjadi objek Java (Driver).
Prosesnya:
1. Membuat koneksi ke database.
2. Mengambil data dari tabel menggunakan Statement.
3. Mengubah hasil query (ResultSet) menjadi objek Driver.
4. Menyimpan semua objek ke dalam List<Driver> dan mengembalikannya ke program utama.

<img width="1419" height="786" alt="image" src="https://github.com/user-attachments/assets/d46de61c-c7da-4765-8fa0-00c4bb1cd4ba" />

## 3. Integrasi ke Program Utama
Bagian DriverService diperbarui agar menampilkan data dari ORM, bukan dari input manual lagi.

<img width="748" height="360" alt="image" src="https://github.com/user-attachments/assets/b1b5a547-aa2f-4f68-b1bd-74b427b4e76a" />
