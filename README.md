# Kopi dan Nyemil

## Ujian Tengah Semester (UTS)
### Mata Kuliah Pengembangan Aplikasi Mobile

**Identitas Mahasiswa**

| Keterangan | Data |
|---|---|
| Nama | Naila Aghna Auliya Prayitno |
| NIM | 1247050051 |
| Kelas | C |

---

## 1. Deskripsi Aplikasi

**Kopi dan Nyemil** adalah aplikasi pemesanan kopi dan camilan berbasis Android yang dikembangkan menggunakan Kotlin dan Jetpack Compose melalui Android Studio.

Aplikasi ini dibuat untuk memenuhi tugas Ujian Tengah Semester (UTS) mata kuliah Pengembangan Aplikasi Mobile berdasarkan wireframe yang telah diberikan.

Melalui aplikasi ini, pengguna dapat melakukan registrasi dan login, melihat daftar menu, mencari produk, memilih makanan atau minuman, mengatur jumlah pesanan, serta melakukan pemesanan melalui halaman Keranjang dan Alamat Pengiriman. Aplikasi juga menyediakan halaman Konfirmasi Pesanan dan Profile untuk mengelola informasi pengguna.

Halaman Home menampilkan **12 produk makanan dan minuman** yang dikelompokkan ke dalam kategori Kopi, Non Kopi, dan Camilan. Seluruh data produk menggunakan data statis (*dummy data*) tanpa database.

## 2. Fitur Aplikasi

| No. | Fitur | Keterangan |
|---|---|---|
| 1 | Welcome | Menampilkan halaman pembuka aplikasi. |
| 2 | Sign Up | Menyediakan pilihan untuk Login atau Register. |
| 3 | Register | Membuat akun pengguna baru. |
| 4 | Login | Masuk menggunakan akun yang telah didaftarkan. |
| 5 | Home | Menampilkan 12 produk beserta foto, nama, deskripsi, dan harga. |
| 6 | Pencarian Menu | Mencari produk berdasarkan nama atau deskripsi. |
| 7 | Filter Kategori | Menampilkan produk berdasarkan kategori Kopi, Non Kopi, dan Camilan. |
| 8 | Pemilihan Produk | Menambah dan mengurangi jumlah pesanan melalui tombol (+) dan (-). |
| 9 | Keranjang | Menampilkan produk terpilih, mengatur jumlah produk, dan menghitung total harga. |
| 10 | Alamat Pengiriman | Mengisi nama penerima, nomor handphone, alamat lengkap, dan catatan tambahan. |
| 11 | Konfirmasi Pesanan | Menampilkan informasi pesanan yang telah dikonfirmasi. |
| 12 | Profile | Menampilkan informasi akun, mengubah nama dan foto profil, serta menyediakan fitur logout. |

## 3. Daftar Menu

Aplikasi menyediakan **12 produk** yang dikelompokkan ke dalam tiga kategori, yaitu Kopi, Non Kopi, dan Camilan.

| No. | Nama Produk | Kategori | Harga |
|---|---|---|---|
| 1 | Kopi Susu Gula Aren | Kopi | Rp23.000 |
| 2 | Cappuccino | Kopi | Rp25.000 |
| 3 | Iced Americano | Kopi | Rp22.000 |
| 4 | Orange Americano | Kopi | Rp28.000 |
| 5 | Matcha Latte | Non Kopi | Rp27.000 |
| 6 | Mocktails | Non Kopi | Rp29.000 |
| 7 | Donat Cokelat | Camilan | Rp16.000 |
| 8 | Butter Croissant | Camilan | Rp22.000 |
| 9 | Choco Cookies | Camilan | Rp15.000 |
| 10 | Blueberry Cheesecake | Camilan | Rp35.000 |
| 11 | Dimsum | Camilan | Rp20.000 |
| 12 | Cireng | Camilan | Rp15.000 |

Setiap produk memiliki foto, nama, deskripsi singkat, dan harga. Pengguna dapat mencari produk, memilih kategori, serta menambahkan produk ke keranjang untuk melakukan pemesanan.

## 4. Teknologi yang Digunakan

| Teknologi | Keterangan |
|---|---|
| Kotlin | Bahasa pemrograman yang digunakan untuk mengembangkan aplikasi. |
| Jetpack Compose | Framework untuk membangun antarmuka aplikasi Android. |
| Material Design 3 | Komponen antarmuka yang digunakan pada aplikasi. |
| Android Studio | IDE untuk menulis, menjalankan, dan menguji aplikasi. |
| Gradle | Build system untuk mengelola dan membangun project Android. |
| Android SDK | Minimum API 35. |
| Git dan GitHub | Digunakan untuk version control dan penyimpanan source code. |

## 5. Dokumentasi Tampilan Aplikasi

Berikut merupakan hasil implementasi tampilan dan fitur aplikasi Kopi dan Nyemil berdasarkan wireframe yang diberikan.

### 5.1 Welcome, Sign Up, Login, dan Register

Halaman Welcome merupakan tampilan awal aplikasi. Selanjutnya, pengguna diarahkan ke halaman Sign Up untuk memilih Login atau Register. Pengguna yang belum memiliki akun dapat melakukan pendaftaran terlebih dahulu melalui halaman Register.

<table>
  <tr>
    <th align="center">Welcome</th>
    <th align="center">Sign Up</th>
    <th align="center">Login</th>
    <th align="center">Register</th>
  </tr>
  <tr>
    <td><img src="screenshots/01-welcome.png" width="175"></td>
    <td><img src="screenshots/02-signup.png" width="175"></td>
    <td><img src="screenshots/03-login.png" width="175"></td>
    <td><img src="screenshots/04-register.png" width="175"></td>
  </tr>
</table>

### 5.2 Home

Setelah berhasil login, pengguna masuk ke halaman Home yang menampilkan **12 produk makanan dan minuman**, terdiri dari 4 produk Kopi, 2 produk Non Kopi, dan 6 produk Camilan.

Daftar menu ditampilkan secara vertikal dengan foto produk di sebelah kiri serta nama, deskripsi, harga, dan tombol pemilihan jumlah di sebelah kanan. Pengguna dapat menggulir halaman untuk melihat seluruh menu yang tersedia.

<table>
  <tr>
    <th align="center">Home - Tampilan 1</th>
    <th align="center">Home - Tampilan 2</th>
    <th align="center">Home - Tampilan 3</th>
    <th align="center">Home - Tampilan 4</th>
  </tr>
  <tr>
    <td><img src="screenshots/05-home01.png" width="180"></td>
    <td><img src="screenshots/05-home04.png" width="180"></td>
    <td><img src="screenshots/05-home02.png" width="180"></td>
    <td><img src="screenshots/05-home03.png" width="180"></td>
  </tr>
</table>

### 5.3 Pencarian dan Pemilihan Menu

Fitur pencarian memungkinkan pengguna menemukan produk berdasarkan nama atau deskripsi. Selain itu, tersedia filter kategori untuk menampilkan produk tertentu sesuai jenisnya.

Pengguna dapat memilih produk melalui tombol tambah (+) dan mengurangi jumlahnya melalui tombol kurang (-). Jumlah produk dan total harga akan diperbarui secara otomatis sesuai pilihan pengguna.

<table>
  <tr>
    <th align="center">Pencarian Menu</th>
    <th align="center">Pemilihan Produk</th>
  </tr>
  <tr>
    <td><img src="screenshots/06-carimenu.png" width="230"></td>
    <td><img src="screenshots/07-pilihmenu.png" width="230"></td>
  </tr>
</table>

### 5.4 Keranjang Pesanan

Halaman Keranjang digunakan untuk memeriksa produk yang telah dipilih sebelum melanjutkan pemesanan.

Pada halaman ini, pengguna dapat melihat nama produk, harga, jumlah pesanan, dan total harga keseluruhan. Jumlah produk juga dapat ditambah atau dikurangi sesuai kebutuhan.

Apabila pengguna belum memilih produk, aplikasi akan menampilkan halaman keranjang kosong beserta tombol untuk kembali melihat menu.

<table>
  <tr>
    <th align="center">Keranjang Kosong</th>
    <th align="center">Keranjang Berisi Produk</th>
  </tr>
  <tr>
    <td><img src="screenshots/08-keranjangkosong.png" width="230"></td>
    <td><img src="screenshots/09-keranjang.png" width="230"></td>
  </tr>
</table>

### 5.5 Alamat Pengiriman

Setelah memeriksa keranjang, pengguna dapat melanjutkan ke halaman Alamat Pengiriman.

Pengguna diminta mengisi nama penerima, nomor handphone, alamat lengkap, dan catatan tambahan apabila diperlukan. Aplikasi melakukan validasi pada kolom wajib sebelum pesanan dapat dikonfirmasi.

Pada bagian bawah halaman, terdapat ringkasan jumlah produk dan total harga pesanan.

<p align="center">
  <img src="screenshots/11-alamat.png" width="230">
</p>

### 5.6 Konfirmasi Pesanan

Setelah informasi pengiriman diisi dan pengguna menekan tombol Konfirmasi Pesanan, aplikasi menampilkan halaman konfirmasi sebagai tanda bahwa proses pemesanan telah selesai.

Halaman ini menampilkan nama penerima, jumlah produk, dan total harga pesanan. Pengguna juga dapat kembali ke halaman Home untuk melakukan pemesanan berikutnya.

<p align="center">
  <img src="screenshots/12-konfirmasi.png" width="230">
</p>

### 5.7 Profile

Halaman Profile digunakan untuk melihat dan mengelola informasi akun pengguna.

Pada halaman ini, pengguna dapat melihat nama lengkap dan username, mengubah nama lengkap, serta memilih foto profil dari galeri perangkat. Selain itu, tersedia tombol logout untuk keluar dari akun.

<p align="center">
  <img src="screenshots/10-profile.png" width="230">
</p>

## 6. Alur Penggunaan Aplikasi

1. Pengguna membuka aplikasi melalui halaman Welcome.
2. Pengguna memilih Login atau Register pada halaman Sign Up.
3. Jika belum memiliki akun, pengguna melakukan registrasi terlebih dahulu.
4. Setelah login berhasil, pengguna masuk ke halaman Home.
5. Pengguna dapat melihat 12 produk, melakukan pencarian, atau memilih kategori menu.
6. Pengguna memilih produk dan mengatur jumlah pesanan menggunakan tombol tambah (+) dan kurang (-).
7. Produk yang dipilih akan ditampilkan pada halaman Keranjang.
8. Pengguna memeriksa produk dan total harga sebelum melanjutkan pemesanan.
9. Pengguna mengisi informasi pada halaman Alamat Pengiriman.
10. Setelah informasi lengkap, pengguna melakukan konfirmasi pesanan.
11. Aplikasi menampilkan halaman Konfirmasi Pesanan yang berisi ringkasan pesanan.
12. Pengguna dapat kembali ke halaman Home untuk melakukan pemesanan baru.
13. Melalui menu Profile, pengguna dapat memperbarui informasi akun atau melakukan logout.

## 7. Cara Menjalankan Aplikasi

1. Clone repository melalui terminal:

   ```bash
   git clone https://github.com/nailaauliya/KopiDanNyemil.git
   ```

2. Buka Android Studio.
3. Pilih **Open**, kemudian buka folder `KopiDanNyemil`.
4. Tunggu hingga proses Gradle Sync selesai.
5. Jalankan emulator atau hubungkan perangkat Android dengan API 35 atau lebih tinggi.
6. Pilih konfigurasi `app`, kemudian klik **Run**.
7. Setelah aplikasi terbuka, lakukan registrasi dan login untuk menggunakan fitur yang tersedia.

## 8. Catatan Pengembangan

Aplikasi Kopi dan Nyemil merupakan prototype yang dikembangkan untuk memenuhi tugas Ujian Tengah Semester mata kuliah Pengembangan Aplikasi Mobile.

Data produk menggunakan data statis (*dummy data*), sedangkan informasi akun, foto profil, dan keranjang dikelola sementara menggunakan state aplikasi.

Aplikasi belum terhubung dengan database, backend server, sistem pembayaran, maupun layanan pengiriman sebenarnya. Konfirmasi pesanan yang ditampilkan merupakan simulasi proses pemesanan.

---

**UTS Pengembangan Aplikasi Mobile — Kopi dan Nyemil**
