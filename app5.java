import java.util.*;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String sdt;
    private int sttNhom;

    public SinhVien(String maSV, String hoTen, String sdt, int sttNhom) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.sttNhom = sttNhom;
    }

    public int getSttNhom() {
        return sttNhom;
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + sdt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống/xuống dòng sau khi đọc N, M

        List<SinhVien> dsSinhVien = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String maSV = sc.nextLine().trim();
            String hoTen = sc.nextLine().trim();
            String sdt = sc.nextLine().trim();
            int sttNhom = Integer.parseInt(sc.nextLine().trim());
            dsSinhVien.add(new SinhVien(maSV, hoTen, sdt, sttNhom));
        }

        String[] tenBaiTap = new String[m + 1];
        for (int i = 1; i <= m; i++) {
            tenBaiTap[i] = sc.nextLine().trim();
        }

        int q = Integer.parseInt(sc.nextLine().trim());
        while (q-- > 0) {
            int nnhom = Integer.parseInt(sc.nextLine().trim());

            System.out.println("DANH SACH NHOM " + nnhom + ":");
            for (SinhVien sv : dsSinhVien) {
                if (sv.getSttNhom() == nnhom) {
                    System.out.println(sv);
                }
            }
            System.out.println("Bai tap dang ky: " + tenBaiTap[nnhom]);
        }

        sc.close();
    }
}
