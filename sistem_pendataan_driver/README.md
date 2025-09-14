
## Post Test 1  "Sistem Pendataan Driver (Grab)"
Sebuah aplikasi sederhana berbasis console untuk mengelola data driver. Sistem ini memanfaatkan konsep CRUD (Create, Read, Update, Delete) di Java, dengan penyimpanan data menggunakan ArrayList. Data yang disimpan mencakup nama driver, jenis kendaraan, plat nomor, status (Aktif/Nonaktif), jumlah riwayat order, dan usia. Dengan adanya sistem ini, proses pencatatan driver jadi lebih rapi, mudah dilihat, serta bisa ditambah, diubah, atau dihapus sesuai kebutuhan.

### Menu Utama
<img width="330" height="164" alt="image" src="https://github.com/user-attachments/assets/ec3a760c-c509-4980-b1db-ec7c40c4a363" />

Saat dijalankan, program menampilkan menu utama berisi lima pilihaan, yaitu : tambah driver, lihat driver, update driver, hapus driver, dan keluar.


### 1. Tambah Driver 
<img width="324" height="223" alt="image" src="https://github.com/user-attachments/assets/52f7ae99-7e48-4dd7-9864-1e6154f54e53" />

Di fitur tambah driver, pengguna bisa memasukkan data baru dengan mengisi nama, kendaraan, plat nomor, status, riwayat order, dan usia. Untuk status, sistem memberi pilihan sederhana: 1 untuk Aktif dan 2 untuk Nonaktif. Setelah semua terisi, data langsung masuk ke daftar dan sistem menampilkan konfirmasi bahwa driver berhasil ditambahkan.


### 2. Lihat Driver 
<img width="618" height="288" alt="image" src="https://github.com/user-attachments/assets/7745a794-7cec-43b8-a350-07032901b6ee" />
Setiap driver ditampilkan lengkap dengan informasi nama, usia, kendaraan, plat nomor, status, dan riwayat order. Daftar juga diberi nomor agar mudah dipilih saat ingin mengupdate atau menghapus data.


### 3. Update Driver 

Fitur update memungkinkan pengguna mengubah data yang sudah ada. Pertama, daftar driver ditampilkan, lalu pengguna memilih driver berdasarkan nomornya. Setelah itu, data lama bisa diganti satu per satu, seperti nama, kendaraan, plat nomor, status, riwayat order, dan usia. Jika sudah terisi semua, sistem akan langsung menyimpan perubahan dan memberi konfirmasi bahwa data berhasil diperbarui.

<img width="584" height="521" alt="image" src="https://github.com/user-attachments/assets/b712541c-988c-491e-902d-1664fb2e3385" />

Output :

<img width="587" height="267" alt="image" src="https://github.com/user-attachments/assets/66e125bd-8279-4fa2-b32d-93d3a5b362d1" />

### 4. Hapus Driver 
<img width="585" height="327" alt="image" src="https://github.com/user-attachments/assets/859738d4-9b94-4898-a0bd-b6eeb2dcf6ca" />

Pertama, pengguna harus memilih nomor driver yang ingin dihapus. kemudian pengguna harus memberikan alasan penghapusan. Ini agar penghapusan lebih jelas, misalnya karena driver sudah berhenti atau data ganda. Setelah alasan dimasukkan, data akan terhapus dan sistem menampilkan pesan konfirmasi lengkap dengan nama driver yang dihapus. 

### 5. Keluar
<img width="600" height="272" alt="image" src="https://github.com/user-attachments/assets/8de423e8-4f7c-4ae5-81b3-b4d7fc04f1a1" />
Dengan memilih menu ini penggunak akan langsung keluar dari program.

