# PostTest3 "Sistem Pendataan Driver (Grab)" 

## Penjelasan Perubahan Program
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

##  Dokumentasi Output Program 
### Menu Utama
<img width="299" height="173" alt="image" src="https://github.com/user-attachments/assets/51a382fd-a3af-455d-bbbf-84c96f3d5cbd" />

### 1. Tambah Driver 
<img width="327" height="306" alt="image" src="https://github.com/user-attachments/assets/7712eab9-19f0-4fd9-96ee-654495f84490" />

Di fitur tambah driver, pengguna harus memasukkan data baru dengan mengisi nama, kendaraan, plat nomor, status, riwayat order, dan usia. Untuk kendaraan dan status, sistem memberi pilihan sederhana: 1 & 2 sesuai keterangan yang diberikan. Setelah semua terisi, data langsung masuk ke daftar dan sistem menampilkan konfirmasi bahwa driver berhasil ditambahkan.


### 2. Lihat Driver 
<img width="347" height="738" alt="Screenshot 2025-09-23 222609" src="https://github.com/user-attachments/assets/2a719cd8-fc4a-452d-9f9b-330b4a36ecb2" />
<img width="319" height="686" alt="Screenshot 2025-09-23 222644" src="https://github.com/user-attachments/assets/4481e706-ba92-4f32-be30-3d7c8c52d0b9" />
<img width="328" height="513" alt="Screenshot 2025-09-23 222702" src="https://github.com/user-attachments/assets/3dc5b9e2-84fe-467d-9684-aeb5e360dc30" />

Setiap driver ditampilkan lengkap dengan informasi nama, usia, kendaraan, plat nomor, status, dan riwayat order. Daftar juga diberi nomor agar mudah dipilih saat ingin mengupdate atau menghapus data.


### 3. Update Driver 

<img width="483" height="625" alt="image" src="https://github.com/user-attachments/assets/34574f10-3702-4c32-b2d0-895f6b1a6db3" />

Fitur update memungkinkan pengguna mengubah data yang sudah ada. Pertama, daftar driver ditampilkan, lalu pengguna memilih driver berdasarkan nomornya. Setelah itu, data lama bisa diganti satu per satu, seperti nama, kendaraan, plat nomor, status, riwayat order, dan usia. Jika sudah terisi semua, sistem akan langsung menyimpan perubahan dan memberi konfirmasi bahwa data berhasil diperbarui. Disini juga saya munculkan data sebelumnya, sehingga memudahkan user untuk mengingat atau mengetahui data sebelumnya dari driver tersebut dan dapat mengganti sesuai keinginannya. user juga bisa meng enter jika tidak mau mengganti data, seperti yang saya lakukan oada nomor plat.

Output :

<img width="317" height="183" alt="image" src="https://github.com/user-attachments/assets/32b91fb9-7e79-4575-a18a-4107b14a1b43" />


### 4. Hapus Driver 
<img width="474" height="608" alt="image" src="https://github.com/user-attachments/assets/64de78fa-c4e1-47f5-bbce-3c866ee5130f" />

Pertama, user harus memilih nomor driver yang ingin dihapus. Setelah user memasukan nomor, data akan terhapus dan sistem menampilkan pesan konfirmasi lengkap dengan nama driver yang dihapus. 

### 5. Cari Driver 
<img width="496" height="236" alt="image" src="https://github.com/user-attachments/assets/e6b70a93-3c9e-4258-97f8-17ce2eab022f" />

jadi pada fitur ini user akan diminta untuk menginput nama atau plat nomor driver. kemudian, setelah pengguna menginput dan program menemukan data yang sama, maka akan keluar output data lengkap dari driver yang dicari tersebut.

### 6. Keluar
<img width="761" height="319" alt="image" src="https://github.com/user-attachments/assets/ec632313-237f-4b85-abea-7410d46deb25" />
Dengan memilih menu ini penggunak akan langsung keluar dari program.
