import java.util.*;

class KhachHang {
    private String maKH;
    private String tenKH;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;

    public KhachHang(int id, String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = String.format("KH%03d", id);
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }
}

class MatHang {
    private String maMH;
    private String tenMH;
    private String donViTinh;
    private long giaMua;
    private long giaBan;

    public MatHang(int id, String tenMH, String donViTinh, long giaMua, long giaBan) {
        this.maMH = String.format("MH%03d", id);
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }
}

class HoaDon {
    private String maHD;
    private KhachHang khachHang;
    private MatHang matHang;
    private long soLuong;

    public HoaDon(int id, KhachHang khachHang, MatHang matHang, long soLuong) {
        this.maHD = String.format("HD%03d", id);
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
    }

    public long getThanhTien() {
        return matHang.getGiaBan() * soLuong;
    }

    @Override
    public String toString() {
        return maHD + " " +
               khachHang.getTenKH() + " " +
               khachHang.getDiaChi() + " " +
               matHang.getTenMH() + " " +
               matHang.getDonViTinh() + " " +
               matHang.getGiaMua() + " " +
               matHang.getGiaBan() + " " +
               soLuong + " " +
               getThanhTien();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        // 1. Nhập danh sách khách hàng
        int n = Integer.parseInt(sc.nextLine().trim());
        Map<String, KhachHang> mapKH = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine().trim();
            String gioiTinh = sc.nextLine().trim();
            String ngaySinh = sc.nextLine().trim();
            String diaChi = sc.nextLine().trim();
            KhachHang kh = new KhachHang(i, ten, gioiTinh, ngaySinh, diaChi);
            mapKH.put(kh.getMaKH(), kh);
        }

        // 2. Nhập danh sách mặt hàng
        int m = Integer.parseInt(sc.nextLine().trim());
        Map<String, MatHang> mapMH = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String tenMH = sc.nextLine().trim();
            String donViTinh = sc.nextLine().trim();
            long giaMua = Long.parseLong(sc.nextLine().trim());
            long giaBan = Long.parseLong(sc.nextLine().trim());
            MatHang mh = new MatHang(i, tenMH, donViTinh, giaMua, giaBan);
            mapMH.put(mh.getMaMH(), mh);
        }

        // 3. Nhập danh sách hóa đơn
        int k = Integer.parseInt(sc.nextLine().trim());
        List<HoaDon> dsHoaDon = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String maKH = parts[0];
            String maMH = parts[1];
            long soLuong = Long.parseLong(parts[2]);

            KhachHang kh = mapKH.get(maKH);
            MatHang mh = mapMH.get(maMH);
            dsHoaDon.add(new HoaDon(i, kh, mh, soLuong));
        }

        // 4. In danh sách hóa đơn theo thứ tự nhập
        for (HoaDon hd : dsHoaDon) {
            System.out.println(hd);
        }

        sc.close();
    }
}
