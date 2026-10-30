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

**Kopi dan Nyemil** merupakan aplikasi pemesanan kopi dan camilan berbasis Android yang dikembangkan menggunakan Kotlin dan Jetpack Compose melalui Android Studio.

Aplikasi ini dibuat untuk memenuhi tugas Ujian Tengah Semester (UTS) mata kuliah Pengembangan Aplikasi Mobile berdasarkan wireframe yang telah diberikan.

Aplikasi menyediakan fitur registrasi dan login, daftar menu makanan dan minuman, pencarian produk, filter kategori, pemilihan produk, keranjang pesanan, pengisian alamat pengiriman, konfirmasi pesanan, serta pengelolaan profil pengguna.

Halaman Home menampilkan **16 produk makanan dan minuman** yang terbagi ke dalam tiga kategori, yaitu Kopi, Non Kopi, dan Camilan. Seluruh data produk menggunakan data statis (*dummy data*) tanpa database.

## 2. Fitur Aplikasi

| No. | Fitur | Keterangan |
|---|---|---|
| 1 | Welcome | Menampilkan halaman pembuka aplikasi. |
| 2 | Sign Up | Menyediakan pilihan Login atau Register. |
| 3 | Register | Form untuk membuat akun pengguna baru. |
| 4 | Login | Masuk menggunakan akun yang telah didaftarkan. |
| 5 | Home | Menampilkan 16 produk beserta foto, nama, deskripsi, dan harga. |
| 6 | Pencarian Menu | Mencari produk berdasarkan nama atau deskripsi. |
| 7 | Filter Kategori | Menampilkan produk sesuai kategori Kopi, Non Kopi, dan Camilan. |
| 8 | Pemilihan Produk | Menambah dan mengurangi jumlah pesanan melalui tombol (+) dan (-). |
| 9 | Keranjang | Menampilkan produk yang dipilih, mengatur jumlah, dan menghitung total harga. |
| 10 | Alamat Pengiriman | Mengisi nama penerima, nomor handphone, alamat lengkap, dan catatan tambahan. |
| 11 | Konfirmasi Pesanan | Menampilkan ringkasan pesanan yang telah dikonfirmasi. |
| 12 | Profile | Menampilkan informasi akun, mengubah nama dan foto profil, serta menyediakan fitur logout. |

## 3. Daftar Menu

Aplikasi menyediakan **16 produk** yang terdiri dari 6 menu Kopi, 4 menu Non Kopi, dan 6 menu Camilan.

### 3.1 Kopi

| No. | Nama Produk | Harga |
|---|---|---|
| 1 | Kopi Susu Gula Aren | Rp23.000 |
| 2 | Cappuccino | Rp25.000 |
| 3 | Iced Americano | Rp22.000 |
| 4 | Orange Americano | Rp28.000 |
| 5 | Caramel Frappuccino | Rp32.000 |
| 6 | Avocado Coffee | Rp30.000 |

### 3.2 Non Kopi

| No. | Nama Produk | Harga |
|---|---|---|
| 1 | Matcha Latte | Rp27.000 |
| 2 | Mocktails | Rp29.000 |
| 3 | Hot Choco | Rp25.000 |
| 4 | Cookies n Cream Frappe | Rp30.000 |

### 3.3 Camilan

| No. | Nama Produk | Harga |
|---|---|---|
| 1 | Donat Cokelat | Rp16.000 |
| 2 | Butter Croissant | Rp22.000 |
| 3 | Choco Cookies | Rp15.000 |
| 4 | Blueberry Cheesecake | Rp35.000 |
| 5 | Dimsum | Rp20.000 |
| 6 | Cireng | Rp15.000 |

Seluruh produk ditampilkan pada halaman Home secara berurutan berdasarkan kategori. Setiap produk dilengkapi dengan foto, nama, deskripsi singkat, harga, dan tombol untuk mengatur jumlah pesanan.

## 4. Teknologi yang Digunakan

| Teknologi | Keterangan |
|---|---|
| Kotlin | Bahasa pemrograman aplikasi. |
| Jetpack Compose | Framework untuk membangun antarmuka Android. |
| Material Design 3 | Komponen antarmuka aplikasi. |
| Android Studio | IDE untuk mengembangkan dan menjalankan aplikasi. |
| Gradle | Build system project Android. |
| Android SDK | Minimum API 35. |
| Git dan GitHub | Version control dan penyimpanan source code. |

## 5. Dokumentasi Tampilan Aplikasi

Bagian berikut menampilkan hasil implementasi halaman dan fitur aplikasi Kopi dan Nyemil.

### 5.1 Welcome, Sign Up, Login, dan Register

Halaman Welcome merupakan tampilan awal aplikasi. Selanjutnya, pengguna diarahkan ke halaman Sign Up untuk memilih Login atau Register. Pengguna yang belum memiliki akun dapat melakukan pendaftaran terlebih dahulu.

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

Setelah berhasil login, pengguna masuk ke halaman Home yang menampilkan **16 produk makanan dan minuman**, terdiri dari 6 produk Kopi, 4 produk Non Kopi, dan 6 produk Camilan.

Menu ditampilkan dalam bentuk daftar vertikal dengan foto produk di sebelah kiri serta nama, deskripsi, harga, dan tombol pemilihan jumlah di sebelah kanan.

Pengguna dapat menggulir daftar menu untuk melihat seluruh produk yang tersedia.

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

Fitur pencarian digunakan untuk menemukan produk berdasarkan nama atau deskripsi. Pengguna juga dapat menggunakan filter kategori Kopi, Non Kopi, dan Camilan untuk mempersempit daftar produk.

Pemilihan produk dilakukan menggunakan tombol tambah (+) dan kurang (-). Jumlah produk dan total harga akan diperbarui secara otomatis sesuai pilihan pengguna.

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

Halaman Keranjang digunakan untuk melihat dan memeriksa produk yang telah dipilih sebelum melanjutkan pemesanan.

Pada halaman ini, pengguna dapat melihat nama produk, harga, jumlah pesanan, dan total harga keseluruhan. Pengguna juga dapat menambah atau mengurangi jumlah produk.

Jika belum ada produk yang dipilih, aplikasi menampilkan informasi bahwa keranjang masih kosong.

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

Pengguna diminta mengisi nama penerima, nomor handphone, alamat lengkap, dan catatan tambahan apabila diperlukan. Aplikasi melakukan validasi terhadap kolom wajib sebelum pesanan dapat dikonfirmasi.

Halaman ini juga menampilkan ringkasan jumlah produk dan total harga pesanan.

<p align="center">
  <img src="screenshots/11-alamat.png" width="230">
</p>

### 5.6 Konfirmasi Pesanan

Setelah informasi pengiriman dilengkapi, pengguna dapat menekan tombol Konfirmasi Pesanan untuk menyelesaikan proses pemesanan.

Aplikasi kemudian menampilkan halaman konfirmasi yang berisi nama penerima, jumlah produk, dan total harga pesanan. Pengguna dapat kembali ke Home untuk melakukan pemesanan berikutnya.

<p align="center">
  <img src="screenshots/12-konfirmasi.png" width="230">
</p>

### 5.7 Profile

Halaman Profile digunakan untuk melihat dan mengelola informasi akun pengguna.

Pengguna dapat melihat nama lengkap dan username, mengubah nama lengkap, memilih foto profil dari galeri perangkat, serta keluar dari akun melalui tombol logout.

<p align="center">
  <img src="screenshots/10-profile.png" width="230">
</p>

## 6. Alur Penggunaan Aplikasi

1. Pengguna membuka aplikasi melalui halaman Welcome.
2. Pengguna memilih Login atau Register pada halaman Sign Up.
3. Pengguna yang belum memiliki akun melakukan registrasi terlebih dahulu.
4. Setelah login berhasil, pengguna masuk ke halaman Home.
5. Pengguna dapat melihat 16 produk, melakukan pencarian, atau memilih kategori menu.
6. Pengguna memilih produk dan mengatur jumlah pesanan menggunakan tombol tambah (+) dan kurang (-).
7. Produk yang dipilih ditampilkan pada halaman Keranjang.
8. Pengguna memeriksa produk dan total harga sebelum melanjutkan pemesanan.
9. Pengguna mengisi informasi pada halaman Alamat Pengiriman.
10. Setelah informasi lengkap, pengguna melakukan konfirmasi pesanan.
11. Aplikasi menampilkan halaman Konfirmasi Pesanan sebagai simulasi pemesanan berhasil.
12. Pengguna dapat kembali ke Home untuk melakukan pemesanan baru.
13. Melalui menu Profile, pengguna dapat memperbarui informasi akun atau melakukan logout.

## 7. Cara Menjalankan Aplikasi

1. Clone repository melalui terminal:

   ```bash
   git clone https://github.com/nailaauliya/KopiDanNyemil.git
   ```

2. Buka Android Studio.
3. Pilih **Open**, kemudian buka folder `KopiDanNyemil`.
4. Tunggu proses Gradle Sync hingga selesai.
5. Jalankan emulator atau hubungkan perangkat Android dengan API 35 atau lebih tinggi.
6. Pilih konfigurasi `app`, kemudian klik **Run**.
7. Setelah aplikasi terbuka, lakukan registrasi dan login untuk menggunakan fitur yang tersedia.

## 8. Catatan Pengembangan

Kopi dan Nyemil merupakan prototype yang dikembangkan untuk memenuhi tugas Ujian Tengah Semester mata kuliah Pengembangan Aplikasi Mobile.

Data produk menggunakan data statis (*dummy data*), sedangkan informasi akun, foto profil, dan keranjang dikelola sementara melalui state aplikasi.

Aplikasi belum terhubung dengan database, backend server, sistem pembayaran, maupun layanan pengiriman sebenarnya. Konfirmasi pesanan merupakan simulasi proses pemesanan.

---

**UTS Pengembangan Aplikasi Mobile — Kopi dan Nyemil**
