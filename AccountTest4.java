import java.util.Scanner;

class ObligasiTabungan {
    private double nominal;
    private int termin; 
    private double bunga;

    // Constructor
    public ObligasiTabungan(double nominal, int termin) {
        this.nominal = nominal;
        this.termin = termin;
        this.bunga = tentukanBunga(termin);
    }

    private double tentukanBunga(int bulan) {
        if (bulan >= 0 && bulan <= 11) return 0.005;
        else if (bulan <= 23) return 0.01;
        else if (bulan <= 35) return 0.015;
        else if (bulan <= 47) return 0.02;
        else if (bulan <= 60) return 0.025;
        else return 0;
    }

    public double hitungTotal() {
        double total = nominal;
        for (int i = 0; i < termin; i++) {
            total += total * bunga;
        }
        return total;
    }

    public void tampilkanInfo() {
        System.out.println("=== Informasi Obligasi Tabungan ===");
        System.out.println("Nominal Awal : Rp " + nominal);
        System.out.println("Termin       : " + termin + " bulan");
        System.out.println("Suku Bunga   : " + (bunga * 100) + " % per bulan");
        System.out.println("Total Akhir  : Rp " + hitungTotal());
    }
}

public class AccountTest4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nominal investasi (Rp): ");
        double nominal = input.nextDouble();

        System.out.print("Masukkan termin (1-60 bulan): ");
        int termin = input.nextInt();

        if (termin < 1 || termin > 60) {
            System.out.println("Termin tidak valid. Harus antara 1 - 60 bulan.");
            return;
        }

        ObligasiTabungan obligasi = new ObligasiTabungan(nominal, termin);
        obligasi.tampilkanInfo();
    }
}
