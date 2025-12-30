import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BarangService service = new BarangService();
        LocalDate tanggal = LocalDate.now();

        int menu = -1;

        do {
            System.out.println("\n=== SISTEM STOK FROZEN FOOD ===");
            System.out.println("Tanggal: " + tanggal);
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Update Stok");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Hitung Total Harga");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");

            try {
                menu = Integer.parseInt(input.nextLine());

                switch (menu) {
                    case 1:
                        service.create();
                        break;
                    case 2:
                        service.read();
                        break;
                    case 3:
                        service.update();
                        break;
                    case 4:
                        service.delete();
                        break;
                    case 5:
                        System.out.print("Jumlah: ");
                        int jumlah = Integer.parseInt(input.nextLine());

                        System.out.print("Harga: ");
                        double harga = Double.parseDouble(input.nextLine());

                        double total = jumlah * harga;
                        System.out.println("Total Harga: " + total);
                        break;
                    case 0:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus angka!");
            }

        } while (menu != 0);

        input.close();
    }
}
