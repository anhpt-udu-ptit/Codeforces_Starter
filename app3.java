import java.util.*;

class MonHoc {
    private String maMon;
    private String tenMon;

    public MonHoc(String maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }
}

class GiangVien {
    private String maGV;
    private String tenGV;
    private double tongGioChuan;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGioChuan = 0.0;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void addGioChuan(double gio) {
        this.tongGioChuan += gio;
    }

    @Override
    public String toString() {
        return tenGV + " " + String.format(Locale.US, "%.2f", tongGioChuan);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        // 1. Nhập danh sách môn học
        int n = Integer.parseInt(sc.nextLine().trim());
        List<MonHoc> dsMonHoc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+", 2);
            dsMonHoc.add(new MonHoc(parts[0], parts[1]));
        }

        // 2. Nhập danh sách giảng viên
        int m = Integer.parseInt(sc.nextLine().trim());
        List<GiangVien> dsGiangVien = new ArrayList<>();
        Map<String, GiangVien> mapGiangVien = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+", 2);
            GiangVien gv = new GiangVien(parts[0], parts[1]);
            dsGiangVien.add(gv);
            mapGiangVien.put(parts[0], gv);
        }

        // 3. Nhập danh sách lớp học phần và tính tổng giờ chuẩn
        int k = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < k; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String maGV = parts[0];
            double gio = Double.parseDouble(parts[2]);

            if (mapGiangVien.containsKey(maGV)) {
                mapGiangVien.get(maGV).addGioChuan(gio);
            }
        }

        // 4. In kết quả theo thứ tự nhập giảng viên ban đầu
        for (GiangVien gv : dsGiangVien) {
            System.out.println(gv);
        }

        sc.close();
    }
}
