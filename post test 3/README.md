# PostTest3

## Dokumentasi Perubahan Program
1. Model
   * Di kode awal, Driver adalah satu-satunya class di package Model.
   * Di versi baru, Driver dijadikan superclass.
   * Ditambahkan 2 subclass: DriverMotor dan DriverMobil.

     Dengan begini, DriverMotor dan DriverMobil mewarisi atribut dan method dari Driver, lalu menambahkan ciri khas masing-masing melalui implementasi toString() untuk membedakan jenis kendaraan.

2. Di kode awal, logika CRUD (tambah, lihat, update, cari, hapus) masih sederhana dan langsung dibuat tanpa pemisahan khusus.
   Di versi baru, dibuat class DriverService yang berisi method-method CRUD seperti:
   * tambahDriver() → untuk menambahkan driver baru (baik motor maupun mobil).
   * tampilDriver() → untuk menampilkan daftar driver.
   * updateDriver() → untuk memperbarui data driver berdasarkan nomor urut.
   * hapusDriver() → untuk menghapus data driver.
   * cariDriver() → untuk melakukan pencarian berdasarkan nama dan plat nomor.
     Perubahan ini diperlukan supaya manajemen driver lebih rapi dan modular. Selain itu, DriverService menangani pilihan user untuk menentukan apakah driver yang ditambahkan itu motor (1) atau mobil (2).

3. Main
   Di kode awal, menu utama langsung menampilkan pilihan CRUD tanpa sub-pilihan.
   Di versi baru, pada menu Tambah Driver (nomor 1) ditambahkan sub-menu:
   * 1 → Tambah Driver Motor
   * 2 → Tambah Driver Mobil

     Dengan cara ini, menu utama tetap ringkas (1–6), tapi konsep inheritance lebih terlihat ketika user memilih jenis kendaraan driver.
