public class Barang {
    protected int id;
    protected String nama;
    protected int stok;
    protected double harga;

    public Barang(int id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }
}
