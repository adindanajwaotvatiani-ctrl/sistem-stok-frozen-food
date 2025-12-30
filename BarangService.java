import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BarangService implements CRUD {

    private Connection conn;
    private Scanner input = new Scanner(System.in);
    private ArrayList<Barang> listBarang = new ArrayList<>();

    public BarangService() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_frozen",
                    "root",
                    ""
            );
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal!");
        }
    }

    // CREATE
    @Override
    public void create() {
        try {
            System.out.print("ID Barang: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Nama Barang: ");
            String nama = input.nextLine().toUpperCase(); // manipulasi String

            System.out.print("Stok: ");
            int stok = Integer.parseInt(input.nextLine());

            System.out.print("Harga: ");
            double harga = Double.parseDouble(input.nextLine());

            String sql = "INSERT INTO barang VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nama);
            ps.setInt(3, stok);
            ps.setDouble(4, harga);
            ps.executeUpdate();

            listBarang.add(new Barang(id, nama, stok, harga));

            System.out.println("Data berhasil ditambahkan!");

        } catch (Exception e) {
            System.out.println("Input tidak valid!");
        }
    }

    // READ
    @Override
    public void read() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM barang");

            System.out.println("\n=== DATA BARANG ===");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nama") + " | " +
                        rs.getInt("stok") + " | " +
                        rs.getDouble("harga")
                );
            }
        } catch (SQLException e) {
            System.out.println("Gagal membaca data!");
        }
    }

    // UPDATE
    @Override
    public void update() {
        try {
            System.out.print("ID Barang: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Stok Baru: ");
            int stok = Integer.parseInt(input.nextLine());

            String sql = "UPDATE barang SET stok=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stok);
            ps.setInt(2, id);
            ps.executeUpdate();

            if (stok < 10) { // percabangan
                System.out.println("Peringatan: Stok menipis!");
            }

            System.out.println("Data berhasil diupdate!");

        } catch (Exception e) {
            System.out.println("Update gagal!");
        }
    }

    // DELETE
    @Override
    public void delete() {
        try {
            System.out.print("ID Barang: ");
            int id = Integer.parseInt(input.nextLine());

            String sql = "DELETE FROM barang WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Data berhasil dihapus!");

        } catch (Exception e) {
            System.out.println("Hapus data gagal!");
        }
    }
}
