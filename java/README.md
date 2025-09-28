# PostTest4 "Sistem Pendataan Driver (Grab)" 
**Nama : Rabiatul Hikmah**

**Nim : 2409116049**


## Penjelasan PostTest3 
<img width="259" height="229" alt="image" src="https://github.com/user-attachments/assets/4ac25b19-d775-48a3-b2ae-17e1a9d73ba0" />

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

### Kesimpulan
Di kode awal, tidak ada inheritance dan semua data & logika bercampur di satu file Main.java. Di versi baru, inheritance diterapkan dengan cara:

* Driver sebagai superclass.
* DriverMotor & DriverMobil sebagai subclass.
* Keyword extends dipakai untuk mewarisi atribut & method dari Driver.
* Keyword super(...) dipakai di constructor subclass bila diperlukan untuk memanggil constructor superclass.
* Method toString() atau tampilkanInfo() dioverride di subclass agar output menandai jenis kendaraan.


## Penjelasan dan Perubahan yang ada di PostTest 4

<img width="299" height="253" alt="image" src="https://github.com/user-attachments/assets/af0e7e8f-1633-47c8-b30f-2a1813cd9b2f" />

1. Interface IDriver
   
   <img width="379" height="140" alt="image" src="https://github.com/user-attachments/assets/47b39a12-f6ba-4952-9e5b-ddb953bb2e48" />

   Interface IDriver berfungsi sebagai kontrak perilaku yang wajib dimiliki setiap class driver. Dengan adanya interface ini, kita memastikan bahwa semua jenis driver, baik mobil maupun motor, harus memiliki metode tampilkanInfo(). Hal ini membuat program lebih konsisten, karena setiap objek driver pasti bisa menampilkan informasi dirinya sendiri.

2. Abstract Class Driver
   <img width="553" height="151" alt="image" src="https://github.com/user-attachments/assets/3f0a3d19-4e10-4049-9440-1445e8ecc529" />
    Abstract class Driver bertindak sebagai pondasi utama. Di dalamnya disimpan atribut dasar yang dimiliki oleh semua driver, seperti nama, plat nomor, status, riwayat order, dan usia. Dengan begitu, kita tidak perlu menuliskan ulang atribut-atribut ini di setiap subclass. Selain itu, class ini juga menyediakan implementasi awal untuk tampilkanInfo(), sehingga subclass dapat langsung menggunakannya atau menimpanya (override) jika ingin menambahkan detail khusus.

3. Implementasi Overloading
   Pada program ini, terdapat dua method cariDriver yang menerapkan konsep Method Overloading.
   
   * cariDriver(String keyword)
     
   <img width="803" height="374" alt="image" src="https://github.com/user-attachments/assets/124d8441-cd55-442b-9d37-49b186f651af" />
     Method ini digunakan untuk melakukan pencarian driver berdasarkan nama atau plat nomor kendaraan. Pencarian bersifat case-insensitive dan partial, sehingga user tidak perlu mengetik nama atau plat secara lengkap untuk menemukan driver. Fitur ini memudahkan ketika data driver banyak, karena hasil pencarian akan langsung menampilkan driver yang sesuai dengan keyword yang dimasukkan.
     
     * cariDriver(int jenis)
       
   <img width="845" height="551" alt="image" src="https://github.com/user-attachments/assets/8e6533c8-e19e-4113-899d-3656562842e8" />
   Method ini ditambahkan sebagai bentuk Overloading dari cariDriver. Pada versi ini, user dapat memilih jenis kendaraan dengan memasukkan angka:
       
       1) untuk mencari driver Motor
       2) untuk mencari driver Mobil
   
   Validasi input juga ditambahkan, sehingga ketika user memasukkan angka selain 1 atau 2, sistem akan memberikan pesan error. Pencarian ini memanfaatkan instanceof untuk membedakan objek DriverMotor dan DriverMobil. Saat driver ditemukan, method tampilkanInfo() yang sudah di-override di masing-masing subclass dipanggil, sehingga detail driver tampil sesuai tipe kendaraannya.
   
     **OUTPUT**
   
     <img width="407" height="882" alt="image" src="https://github.com/user-attachments/assets/1a689714-6fe3-42e5-b1c2-66cf7e03cd0a" /> <img width="379" height="345" alt="image" src="https://github.com/user-attachments/assets/85f2a639-ef56-4a91-8c11-6af8939c6806" />

   Penambahan method cariDriver(int jenis) bertujuan untuk meningkatkan fleksibilitas pencarian. Jika sebelumnya pencarian hanya dapat dilakukan dengan memasukkan teks (nama/plat), sekarang user juga dapat melakukan pencarian berdasarkan kategori kendaraan

   
4. Implementasi Overriding
   
   * DriverMotor
     <img width="1078" height="368" alt="Screenshot 2025-09-28 185726" src="https://github.com/user-attachments/assets/39aeb110-71d5-496f-9c7d-5e89fb2ab9da" />
     Class DriverMotor juga merupakan turunan dari abstract class Driver, tetapi digunakan untuk driver kendaraan motor. Sama seperti DriverMobil, class ini memakai constructor dari superclass Driver untuk mengisi data umum driver.
Pada method tampilkanInfo(), class ini menimpa implementasi superclass dengan menambahkan label [Motor] sebelum memanggil method bawaan Driver. Hal ini membuat output yang ditampilkan lebih spesifik, sehingga pengguna bisa langsung mengetahui bahwa data yang sedang ditampilkan adalah untuk driver motor.

    * DriverMobil
      <img width="997" height="401" alt="Screenshot 2025-09-28 185737" src="https://github.com/user-attachments/assets/a4d0427f-d5a8-4670-85ea-4221e84bcea0" />
      Class DriverMobil adalah turunan dari abstract class Driver yang merepresentasikan driver khusus untuk kendaraan mobil. Pada constructor-nya, class ini memanggil constructor milik Driver (melalui super) untuk mengisi data umum seperti nama, plat nomor, status, riwayat order, dan usia. Class ini juga melakukan overriding pada method tampilkanInfo() dengan menambahkan label [Mobil] sebelum memanggil method tampilkanInfo() milik superclass. Dengan cara ini, saat informasi driver ditampilkan, akan jelas terlihat bahwa driver tersebut adalah driver mobil.

5. Abstraction: Kombinasi Abstract Class & Interface (Nilai Tambah)
   
   <img width="534" height="153" alt="Screenshot 2025-09-28 223708" src="https://github.com/user-attachments/assets/f7308990-5ad6-46ce-b7aa-627d103f80c9" />

   Pada program ini, kelas Driver didefinisikan sebagai abstract class yang mengimplementasikan interface IDriver.
   
    * Abstract Class (Driver) → digunakan untuk menampung atribut umum (nama, platNomor, status, riwayatOrder, usia) dan memberi dasar bagi kelas turunan (DriverMotor dan DriverMobil).
    * Interface (IDriver) → mendefinisikan kontrak berupa metode yang harus diimplementasikan, seperti tampilkanInfo().

    Dengan kombinasi ini, program mendapatkan manfaat ganda:

    * Abstract class → menyediakan implementasi dasar dan pewarisan atribut.
    * Interface → memastikan semua kelas turunan memiliki perilaku (method) yang konsisten sesuai kontrak.
   
   

      

   
   
