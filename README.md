# Kopi dan Nyemil ☕

**UTS Pengembangan Aplikasi Mobile**

| Identitas | Keterangan |
|---|---|
| Nama | Naila Aghna Auliya Prayitno |
| NIM | 1247050051 |
| Kelas | C |

## Tentang Aplikasi

**Kopi dan Nyemil** adalah aplikasi pemesanan kopi dan camilan berbasis Android yang dibuat menggunakan **Kotlin** dan **Jetpack Compose**. Aplikasi ini dikembangkan berdasarkan wireframe tugas Ujian Tengah Semester mata kuliah Pengembangan Aplikasi Mobile.

Pengguna dapat membuat akun, mencari dan memilih menu, mengatur jumlah pesanan, melihat keranjang, mengisi alamat pengiriman, hingga memperoleh konfirmasi pesanan. Aplikasi menggunakan data produk statis (*dummy data*) dan belum terhubung ke database atau layanan pembayaran.

## Fitur Utama

- **Welcome, Sign Up, Login, dan Register:** halaman pembuka, pilihan masuk, serta simulasi pendaftaran dan login.
- **Home:** menampilkan 16 menu lengkap dengan foto, deskripsi, dan harga.
- **Pencarian dan Filter:** mencari menu berdasarkan nama atau deskripsi, serta menyaring kategori Kopi, Non Kopi, dan Camilan.
- **Keranjang:** menambah atau mengurangi jumlah produk dan menghitung total pesanan secara otomatis.
- **Alamat Pengiriman:** mengisi data penerima dan alamat sebelum konfirmasi pesanan.
- **Konfirmasi Pesanan:** menampilkan ringkasan pesanan yang berhasil dikonfirmasi.
- **Profile:** melihat informasi akun, mengubah nama dan foto profil, serta logout.

## Daftar Menu

Aplikasi menyediakan **16 produk** dalam tiga kategori.

### Kopi (6 Menu)

| Menu | Harga |
|---|---:|
| Kopi Susu Gula Aren | Rp23.000 |
| Cappuccino | Rp25.000 |
| Iced Americano | Rp22.000 |
| Orange Americano | Rp28.000 |
| Caramel Frappuccino | Rp32.000 |
| Avocado Coffee | Rp30.000 |

### Non Kopi (4 Menu)

| Menu | Harga |
|---|---:|
| Matcha Latte | Rp27.000 |
| Mocktails | Rp29.000 |
| Hot Choco | Rp25.000 |
| Cookies n Cream Frappe | Rp30.000 |

### Camilan (6 Menu)

| Menu | Harga |
|---|---:|
| Donat Cokelat | Rp16.000 |
| Butter Croissant | Rp22.000 |
| Choco Cookies | Rp15.000 |
| Blueberry Cheesecake | Rp35.000 |
| Dimsum | Rp20.000 |
| Cireng | Rp15.000 |

## Teknologi yang Digunakan

- **Bahasa Pemrograman:** Kotlin
- **UI:** Jetpack Compose dan Material Design 3
- **IDE:** Android Studio
- **Build System:** Gradle
- **Minimum Android SDK:** API 35
- **Version Control:** Git dan GitHub

## Dokumentasi Tampilan

### 1. Welcome, Sign Up, Login, dan Register

Halaman awal aplikasi dan proses masuk atau membuat akun baru.

<table>
  <tr>
    <th align="center">Welcome</th>
    <th align="center">Sign Up</th>
    <th align="center">Login</th>
    <th align="center">Register</th>
  </tr>
  <tr>
    <td align="center"><img src="screenshots/01-welcome.png" width="175" alt="Welcome"></td>
    <td align="center"><img src="screenshots/02-signup.png" width="175" alt="Sign Up"></td>
    <td align="center"><img src="screenshots/03-login.png" width="175" alt="Login"></td>
    <td align="center"><img src="screenshots/04-register.png" width="175" alt="Register"></td>
  </tr>
</table>

### 2. Home dan Daftar Menu

Halaman Home menampilkan daftar produk dengan pilihan kategori dan tombol untuk mengatur jumlah pesanan.

<table>
  <tr>
    <th align="center">Home 1</th>
    <th align="center">Home 2</th>
    <th align="center">Home 3</th>
    <th align="center">Home 4</th>
  </tr>
  <tr>
    <td align="center"><img src="screenshots/05-home01.png" width="175" alt="Home 1"></td>
    <td align="center"><img src="screenshots/05-home04.png" width="175" alt="Home 2"></td>
    <td align="center"><img src="screenshots/05-home02.png" width="175" alt="Home 3"></td>
    <td align="center"><img src="screenshots/05-home03.png" width="175" alt="Home 4"></td>
  </tr>
</table>

### 3. Pencarian dan Pemilihan Menu

Pengguna dapat mencari produk berdasarkan nama atau deskripsi serta menambahkan menu ke dalam pesanan.

<table>
  <tr>
    <th align="center">Pencarian Menu</th>
    <th align="center">Pemilihan Menu</th>
  </tr>
  <tr>
    <td align="center"><img src="screenshots/06-carimenu.png" width="210" alt="Pencarian Menu"></td>
    <td align="center"><img src="screenshots/07-pilihmenu.png" width="210" alt="Pemilihan Menu"></td>
  </tr>
</table>

### 4. Keranjang Pesanan

Keranjang menampilkan produk yang dipilih, jumlah masing-masing produk, dan total harga. Pengguna dapat menambah atau mengurangi jumlah produk sebelum melanjutkan pemesanan.

<table>
  <tr>
    <th align="center">Keranjang Kosong</th>
    <th align="center">Keranjang Berisi Pesanan</th>
  </tr>
  <tr>
    <td align="center"><img src="screenshots/08-keranjangkosong.png" width="210" alt="Keranjang Kosong"></td>
    <td align="center"><img src="screenshots/09-keranjang.png" width="210" alt="Keranjang Berisi Pesanan"></td>
  </tr>
</table>

### 5. Alamat Pengiriman

Pengguna melengkapi informasi penerima, nomor handphone, alamat lengkap, dan catatan tambahan sebelum mengonfirmasi pesanan.

<p align="center">
  <img src="screenshots/11-alamat.png" width="230" alt="Alamat Pengiriman">
</p>

### 6. Konfirmasi Pesanan

Halaman ini menampilkan ringkasan pesanan yang sudah dikonfirmasi, meliputi nama penerima, jumlah produk, dan total harga.

<p align="center">
  <img src="screenshots/12-konfirmasi.png" width="230" alt="Konfirmasi Pesanan">
</p>

### 7. Profile

Pengguna dapat melihat informasi akun, mengubah nama dan foto profil, serta keluar dari aplikasi melalui fitur logout.

<p align="center">
  <img src="screenshots/10-profile.png" width="230" alt="Profile">
</p>

## Alur Penggunaan Aplikasi

**Welcome → Sign Up → Register/Login → Home → Pilih Menu → Keranjang → Alamat Pengiriman → Konfirmasi Pesanan**

Halaman **Profile** dapat diakses dari Home untuk mengubah informasi akun atau logout.

## Cara Menjalankan Aplikasi

1. Clone repository melalui terminal:

   ```bash
   git clone https://github.com/nailaauliya/KopiDanNyemil.git
   ```

2. Buka folder **KopiDanNyemil** menggunakan Android Studio.
3. Tunggu proses **Gradle Sync** hingga selesai.
4. Pilih emulator atau perangkat Android dengan API 35 atau lebih tinggi.
5. Jalankan konfigurasi **app** dengan menekan tombol **Run**.
6. Lakukan registrasi dan login untuk mencoba fitur aplikasi.

## Catatan Pengembangan

Kopi dan Nyemil merupakan prototype yang dibuat untuk memenuhi tugas Ujian Tengah Semester mata kuliah Pengembangan Aplikasi Mobile.

Data produk menggunakan *dummy data*, sedangkan informasi akun dan keranjang disimpan sementara selama aplikasi berjalan. Proses pemesanan masih berupa simulasi dan belum terhubung dengan sistem pembayaran maupun layanan pengiriman sebenarnya.
