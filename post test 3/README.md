# PostTest3
1. Model
   * Di kode awal, Driver adalah satu-satunya class di package Model.
* Di versi baru, Driver dijadikan superclass.
Ditambahkan 2 subclass: DriverMotor dan DriverMobil.
Dengan begini, DriverMotor dan DriverMobil mewarisi atribut dan method dari Driver, lalu menambahkan ciri khas masing-masing melalui implementasi toString() untuk membedakan jenis kendaraan.
