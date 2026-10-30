# Kopi dan Nyemil

## Ujian Tengah Semester (UTS)
### Mata Kuliah Pengembangan Aplikasi Mobile

**Identitas Mahasiswa**

| Keterangan | Data |
|---|---|
| Nama | Naila Aghna Auliya Prayitno |
| NIM | 1247050051 |
| Kelas | C |
| Mata Kuliah | Pengembangan Aplikasi Mobile |

---

## 1. Deskripsi Aplikasi

**Kopi dan Nyemil** merupakan aplikasi pemesanan kopi dan camilan berbasis Android yang dikembangkan menggunakan bahasa pemrograman Kotlin dan Jetpack Compose melalui Android Studio.

Aplikasi ini dibuat untuk memenuhi tugas Ujian Tengah Semester (UTS) mata kuliah Pengembangan Aplikasi Mobile berdasarkan wireframe yang telah diberikan.

Aplikasi menyediakan fitur registrasi dan login, daftar menu makanan dan minuman, pencarian dan filter kategori produk, pengelolaan keranjang pesanan, pengeditan profil, pengisian alamat pengiriman, serta konfirmasi pesanan.

Data yang digunakan masih berupa data statis (*dummy data*) tanpa database. Aplikasi juga belum terhubung dengan sistem pembayaran atau pengiriman secara langsung.

## 2. Fitur Aplikasi

| No. | Fitur | Keterangan |
|---|---|---|
| 1 | Welcome | Halaman pembuka aplikasi. |
| 2 | Sign Up | Pilihan untuk masuk atau mendaftar akun. |
| 3 | Login | Masuk menggunakan akun yang telah didaftarkan. |
| 4 | Register | Membuat akun pengguna baru. |
| 5 | Home | Menampilkan daftar menu kopi dan camilan beserta informasi produk. |
| 6 | Pencarian Menu | Mencari produk berdasarkan nama atau deskripsi. |
| 7 | Filter Kategori | Memfilter produk berdasarkan kategori Kopi, Non Kopi, dan Camilan. |
| 8 | Pemilihan Produk | Menambah dan mengurangi jumlah produk yang ingin dipesan. |
| 9 | Keranjang | Menampilkan produk terpilih, jumlah, dan total harga pesanan. |
| 10 | Profile | Melihat dan mengubah nama serta foto profil pengguna. |
| 11 | Alamat Pengiriman | Mengisi nama penerima, nomor handphone, alamat, dan catatan tambahan. |
| 12 | Konfirmasi Pesanan | Menampilkan informasi pesanan yang telah dikonfirmasi. |

## 3. Teknologi yang Digunakan

| Teknologi | Keterangan |
|---|---|
| Kotlin | Bahasa pemrograman aplikasi. |
| Jetpack Compose | Framework untuk membangun antarmuka aplikasi Android. |
| Material Design 3 | Komponen antarmuka aplikasi. |
| Android Studio | IDE yang digunakan untuk pengembangan aplikasi. |
| Gradle | Build system untuk mengelola dan menjalankan project. |
| Android SDK | Minimum API 35. |
| Git dan GitHub | Version control dan penyimpanan source code. |

## 4. Dokumentasi Tampilan Aplikasi

Berikut merupakan hasil implementasi tampilan dan fitur aplikasi Kopi dan Nyemil.

### 4.1 Welcome, Sign Up, Login, dan Register

Halaman awal digunakan untuk mengarahkan pengguna ke proses autentikasi. Pengguna dapat membuat akun melalui Register, kemudian masuk ke aplikasi melalui Login.

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

### 4.2 Home

Halaman Home menampilkan daftar makanan dan minuman yang tersedia. Setiap produk dilengkapi dengan foto, nama, deskripsi, harga, serta tombol untuk mengatur jumlah pesanan.

Menu dikelompokkan ke dalam kategori Kopi, Non Kopi, dan Camilan.

<table>
  <tr>
    <th align="center">Home - Tampilan 1</th>
    <th align="center">Home - Tampilan 2</th>
    <th align="center">Home - Tampilan 3</th>
  </tr>
  <tr>
    <td><img src="screenshots/05-home01.png" width="220"></td>
    <td><img src="screenshots/05-home02.png" width="220"></td>
    <td><img src="screenshots/05-home03.png" width="220"></td>
  </tr>
</table>

### 4.3 Pencarian dan Pemilihan Menu

Pengguna dapat mencari makanan atau minuman melalui kolom pencarian. Selain itu, pengguna dapat memilih produk dan mengatur jumlahnya menggunakan tombol tambah (+) dan kurang (-).

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

### 4.4 Keranjang Pesanan

Halaman Keranjang digunakan untuk meninjau produk yang telah dipilih sebelum melanjutkan pemesanan.

Pengguna dapat menambah atau mengurangi jumlah produk dan melihat total harga secara otomatis. Apabila belum ada produk yang dipilih, aplikasi menampilkan informasi keranjang kosong.

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

### 4.5 Profile

Halaman Profile menampilkan nama lengkap dan username pengguna. Pengguna dapat memperbarui nama, mengganti foto profil melalui galeri, dan keluar dari akun.

<p align="center">
  <img src="screenshots/10-profile.png" width="230">
</p>

### 4.6 Alamat Pengiriman

Halaman Alamat Pengiriman digunakan untuk mengisi informasi penerima, nomor handphone, alamat lengkap, dan catatan tambahan jika diperlukan.

Pada halaman ini juga ditampilkan ringkasan jumlah produk dan total harga sebelum pesanan dikonfirmasi.

<p align="center">
  <img src="screenshots/11-alamatmenu.png" width="230">
</p>

### 4.7 Konfirmasi Pesanan

Setelah pengguna melengkapi alamat pengiriman dan melakukan konfirmasi, aplikasi menampilkan halaman pesanan berhasil.

Halaman ini memuat informasi nama penerima, jumlah produk, dan total harga pesanan.

<p align="center">
  <img src="screenshots/12-konfirmasi.png" width="230">
</p>

## 5. Alur Penggunaan Aplikasi

1. Pengguna membuka aplikasi melalui halaman Welcome.
2. Pengguna memilih Login atau Register.
3. Jika belum memiliki akun, pengguna melakukan registrasi terlebih dahulu.
4. Setelah login berhasil, pengguna masuk ke halaman Home.
5. Pengguna dapat melihat produk, mencari menu, atau memilih kategori.
6. Pengguna memilih produk dan mengatur jumlah pesanan.
7. Produk yang dipilih dapat dilihat pada halaman Keranjang.
8. Pengguna dapat meninjau serta mengubah jumlah produk sebelum melanjutkan pemesanan.
9. Pengguna mengisi informasi pada halaman Alamat Pengiriman.
10. Setelah pesanan dikonfirmasi, aplikasi menampilkan halaman Konfirmasi Pesanan.
11. Pengguna dapat kembali ke Home untuk melakukan pemesanan berikutnya.

## 6. Cara Menjalankan Aplikasi

1. Clone repository menggunakan perintah berikut:

   ```bash
   git clone https://github.com/nailaauliya/KopiDanNyemil.git
   ```

2. Buka Android Studio.
3. Pilih **Open**, kemudian pilih folder `KopiDanNyemil`.
4. Tunggu proses Gradle Sync hingga selesai.
5. Jalankan emulator atau hubungkan perangkat Android dengan API 35 atau lebih tinggi.
6. Pilih konfigurasi `app`, lalu klik tombol **Run**.
7. Setelah aplikasi berjalan, lakukan registrasi dan login untuk menggunakan fitur aplikasi.

## 7. Catatan Pengembangan

Aplikasi Kopi dan Nyemil merupakan prototype yang dibuat untuk kebutuhan Ujian Tengah Semester.

Data produk disimpan secara statis, sedangkan informasi akun, profil, dan keranjang dikelola menggunakan state pada aplikasi.

Aplikasi belum menggunakan database, backend server, payment gateway, maupun layanan pengiriman yang terintegrasi.

---

**UTS Pengembangan Aplikasi Mobile — Kopi dan Nyemil**
