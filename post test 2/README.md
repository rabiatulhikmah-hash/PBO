# Post Test 2 

## "Sistem Pendataan Driver (Grab)" 
Program Sistem Pendataan Driver (Grab) adalah aplikasi berbasis Java yang dibuat untuk mengelola data driver Grab. Program ini menerapkan konsep CRUD (Create, Read, Update, Delete) sehingga pengguna dapat menambahkan, melihat, memperbarui, dan menghapus data driver dengan mudah. pada project ini juga ditambahkan menu baru yaitu cari driver, sehingga memudahkan user mencari driver.

Struktur program juga diperbarui menjadi menggunakan 3 packages untuk memisahkan bagian sesuai fungsinya:

* model → menyimpan struktur data Driver (atribut + constructor).
* service → berisi logika CRUD (DriverService).
* main → menampilkan menu interaktif untuk user.

<img width="281" height="191" alt="Screenshot 2025-09-14 235838" src="https://github.com/user-attachments/assets/af400cb4-d4b6-4b06-baa4-4ae4ff8c100f" />


### Menu Utama
<img width="274" height="168" alt="image" src="https://github.com/user-attachments/assets/5f8c13dc-7e9b-4aaf-b3af-a3611d7d116f" />

Saat dijalankan, program menampilkan menu utama yang awalnya berisi lima pilihaan, menjadi enam pilihan. Yaitu : tambah driver, lihat driver, update driver, hapus driver, cari driver dan keluar.


### 1. Tambah Driver 

<img width="322" height="267" alt="image" src="https://github.com/user-attachments/assets/de0926cd-e35c-496d-baf9-5db8bb8a327d" />

Di fitur tambah driver, pengguna harus memasukkan data baru dengan mengisi nama, kendaraan, plat nomor, status, riwayat order, dan usia. Untuk kendaraan dan status, sistem memberi pilihan sederhana: 1 & 2 sesuai keterangan yang diberikan. Setelah semua terisi, data langsung masuk ke daftar dan sistem menampilkan konfirmasi bahwa driver berhasil ditambahkan.


### 2. Lihat Driver 
<img width="514" height="246" alt="image" src="https://github.com/user-attachments/assets/3a321d6b-2074-4a72-8ef7-05f2c56ffde0" />

Setiap driver ditampilkan lengkap dengan informasi nama, usia, kendaraan, plat nomor, status, dan riwayat order. Daftar juga diberi nomor agar mudah dipilih saat ingin mengupdate atau menghapus data.


### 3. Update Driver 

<img width="421" height="285" alt="image" src="https://github.com/user-attachments/assets/b6f6ac05-0fa3-46d3-84b6-e4d7da1a1167" />

Fitur update memungkinkan pengguna mengubah data yang sudah ada. Pertama, daftar driver ditampilkan, lalu pengguna memilih driver berdasarkan nomornya. Setelah itu, data lama bisa diganti satu per satu, seperti nama, kendaraan, plat nomor, status, riwayat order, dan usia. Jika sudah terisi semua, sistem akan langsung menyimpan perubahan dan memberi konfirmasi bahwa data berhasil diperbarui. Disini juga saya munculkan data sebelumnya, sehingga memudahkan user untuk mengingat atau mengetahui data sebelumnya dari driver tersebut dan dapat mengganti sesuai keinginannya. user juga bisa meng enter jika tidak mau mengganti data, seperti yang saya lakukan oada nomor plat.

Output :

<img width="513" height="247" alt="image" src="https://github.com/user-attachments/assets/b135dd89-3106-40df-9689-884a6835665b" />

### 4. Hapus Driver 
<img width="518" height="344" alt="image" src="https://github.com/user-attachments/assets/9cd37c0d-cfa9-4a26-bc63-9ef0feb9dc7e" />

Pertama, user harus memilih nomor driver yang ingin dihapus. Setelah user memasukan nomor, data akan terhapus dan sistem menampilkan pesan konfirmasi lengkap dengan nama driver yang dihapus. 

### 5. Cari Driver (fitur baru)
<img width="788" height="95" alt="image" src="https://github.com/user-attachments/assets/0d9516fc-8cfe-4695-8c30-d2e7dfee2b11" />

jadi pada fitur ini user akan diminta untuk menginput nama atau plat nomor driver. kemudian, setelah pengguna menginput dan program menemukan data yang sama, maka akan keluar output data lengkap dari driver yang dicari tersebut.

### 6. Keluar
<img width="631" height="306" alt="image" src="https://github.com/user-attachments/assets/1cdcc202-5ca8-4d0d-9786-abbf21524cb9" />

Dengan memilih menu ini penggunak akan langsung keluar dari program.

