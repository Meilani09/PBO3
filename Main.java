import java.util.*;

class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    String grade;
    boolean lulus;

    // Method untuk menentukan grade
    void hitungGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            lulus = true;
        } else if (nilai >= 70) {
            grade = "B";
            lulus = true;
        } else if (nilai >= 60) {
            grade = "C";
            lulus = true;
        } else if (nilai >= 50) {
            grade = "D";
            lulus = false;
        } else if (nilai >= 0) {
            grade = "E";
            lulus = false;
        } else {
            grade = "Tidak Valid";
        }
    }

    // Method tampil data
    void tampil() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);
        System.out.println("-----------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlah;
        System.out.print("Masukkan jumlah mahasiswa: ");
        jumlah = input.nextInt();
        input.nextLine();

        Mahasiswa[] mhs = new Mahasiswa[jumlah];

        int totalNilai = 0;
        int lulusCount = 0, tidakLulusCount = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0;

        String namaLulus = "", namaTidakLulus = "";

        for (int i = 0; i < jumlah; i++) {
            mhs[i] = new Mahasiswa();

            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            mhs[i].nim = input.nextLine();
            System.out.print("Nama  : ");
            mhs[i].nama = input.nextLine();
            System.out.print("Nilai : ");
            mhs[i].nilai = input.nextInt();
            input.nextLine();

            // Validasi nilai
            if (mhs[i].nilai < 0 || mhs[i].nilai > 100) {
                System.out.println("Input nilai anda salah!");
                i--; // ulang input
                continue;
            }

            mhs[i].hitungGrade();
            totalNilai += mhs[i].nilai;

            // Hitung lulus / tidak
            if (mhs[i].lulus) {
                lulusCount++;
                namaLulus += mhs[i].nama + ", ";
            } else {
                tidakLulusCount++;
                namaTidakLulus += mhs[i].nama + ", ";
            }

            // Hitung grade
            switch (mhs[i].grade) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
                case "E": countE++; break;
            }
        }

        System.out.println("\n=== DATA MAHASISWA ===");
        for (Mahasiswa m : mhs) {
            m.tampil();
        }

        double rata = (double) totalNilai / jumlah;

        System.out.println("Jumlah Mahasiswa : " + jumlah);
        System.out.println("Jumlah Lulus : " + lulusCount + " yaitu " + namaLulus);
        System.out.println("Jumlah Tidak Lulus : " + tidakLulusCount + " yaitu " + namaTidakLulus);
        System.out.println("Jumlah Nilai A : " + countA);
        System.out.println("Jumlah Nilai B : " + countB);
        System.out.println("Jumlah Nilai C : " + countC);
        System.out.println("Jumlah Nilai D : " + countD);
        System.out.println("Jumlah Nilai E : " + countE);
        System.out.println("Rata-rata Nilai : " + rata);
    }
}