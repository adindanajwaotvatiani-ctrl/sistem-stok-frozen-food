public class BarangRusak extends Barang {
    private String alasan;

    public BarangRusak(int id, String nama, int stok, double harga, String alasan) {
        super(id, nama, stok, harga);
        this.alasan = alasan;
    }

    public String getAlasan() {
        return alasan;
    }
}
