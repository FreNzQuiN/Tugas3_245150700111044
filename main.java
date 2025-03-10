import java.text.NumberFormat;
import java.util.Locale;

class PengirimanBarang {
    private String namaPengirim;
    private String alamatTujuan;
    private double berat;
    private double biayaDasar;
    private static int jumlahPengirim = 0;
    
    // --- CONSTRUCTOR OVERLOAD --- \\
    public PengirimanBarang() {
        this.namaPengirim = "";
        this.alamatTujuan = "";
        this.berat = 0.0;
        this.biayaDasar = 0.0;
        jumlahPengirim++;
    }
    public PengirimanBarang(String namaPengirim, String alamatTujuan, double berat, double biayaDasar) {
        this.namaPengirim = namaPengirim;
        this.alamatTujuan = alamatTujuan;
        this.berat = berat;
        this.biayaDasar = biayaDasar;
        jumlahPengirim++;
    }

    // --- OVERLOADING METHOD --- \\
    public double hitungOngkir(double diskonPersen) {
        return biayaDasar * (1 - diskonPersen / 100);
    }
    public double hitungOngkir(double diskonPersen, double biayaTambahan) {
        return biayaDasar * (1 - diskonPersen / 100) + biayaTambahan;
    }
    public double hitungOngkir(int jarak) {
        if (jarak > 50) {
            return biayaDasar * 1.1; 
        } else {
            return biayaDasar * 0.95;
        }
    }

    // --- STATIC METHOD --- \\
    public static void displayInfoLogistik() {
        System.out.println("Informasi Perusahaan Logistik:");
        System.out.println("------------------------------");
        System.out.println("Nama: PT. Logistik Jaya");
        System.out.println("Alamat: Jl. Merdeka No. 123");
        System.out.println("------------------------------");
    }
    public static void displayJumlahPengirim() {
        System.out.println("Jumlah Pengirim: " + jumlahPengirim);
    } 
    
    // --- SETTER GETTER --- \\
    public String getNamaPengirim() { 
        return namaPengirim;
    }
    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }
    public String getAlamatTujuan() {
        return alamatTujuan;
    }
    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }
    public double getBerat() {
        return berat;
    }
    public void setBerat(double berat) {
        this.berat = berat;
    }
    public double getBiayaDasar() {
        return biayaDasar;
    }
    public void setBiayaDasar(double biayaDasar) {
        this.biayaDasar = biayaDasar;
    }
    public int getJumlahPengirim(){
        return jumlahPengirim;
    }

    // --- DISPLAY PENGIRIM --- \\
    public void displayPengirim() {
        System.out.println("Nama Pengirim: " + namaPengirim);
        System.out.println("Alamat Tujuan: " + alamatTujuan);
        System.out.println("Berat Barang: " + berat + " kg");
        System.out.println("Biaya Dasar: " + biayaDasar);
        System.out.println();
    }
}

public class main {
    public static void main(String[] args) {
        System.out.println("++== Tugas 3: Pengiriman Barang ++==\n");

        // --- DOUBLE INSTANCES --- \\
        PengirimanBarang pengiriman1 = new PengirimanBarang();
        PengirimanBarang pengiriman2 = new PengirimanBarang("Andi", "Surabaya", 10.0, 200000.0);
        pengiriman1.setNamaPengirim("Budi");
        pengiriman1.setAlamatTujuan("Jakarta");
        pengiriman1.setBerat(5.0);
        pengiriman1.setBiayaDasar(100000.0);

        // --- EXECUTE hitungOngkir()'s OVERLOADING METHODS --- \\
        PengirimanBarang.displayJumlahPengirim();
        pengiriman1.displayPengirim();
        pengiriman2.displayPengirim();
        System.out.println();

        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        // -- PENGIRIMAN SATU -- \\
        System.out.println("Ongkos kirim (diskon 10%): " + rupiah.format(pengiriman1.hitungOngkir(10.0)));
        System.out.println("Ongkos kirim (jarak 60 km): " + rupiah.format(pengiriman1.hitungOngkir(60)));
        // -- PENGIRIMAN DUA -- \\
        System.out.println("Ongkos kirim (diskon 5%, biaya tambahan 50000): " + rupiah.format(pengiriman2.hitungOngkir(5.0, 50000.0)));
        System.out.println("Ongkos kirim (jarak 30 km): " + rupiah.format(pengiriman2.hitungOngkir(30)));
        System.out.println();
        

        // --- DISPLAY STATIC METHOD --- \\
        PengirimanBarang.displayInfoLogistik(); 
    }
}
