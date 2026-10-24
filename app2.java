import java.util.*;

class SanPham {
    private String maLoai;
    private String ten;
    private long gia1;
    private long gia2;

    public SanPham(String maLoai, String ten, long gia1, long gia2) {
        this.maLoai = maLoai;
        this.ten = ten;
        this.gia1 = gia1;
        this.gia2 = gia2;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTen() {
        return ten;
    }

    public long getGia(int loai) {
        return loai == 1 ? gia1 : gia2;
    }
}

class HoaDon {
    private int stt;
    private String maHD;
    private SanPham sanPham;
    private long soLuong;

    public HoaDon(int stt, String maHD, SanPham sanPham, long soLuong) {
        this.stt = stt;
        this.maHD = maHD;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public String getMaFull() {
        return maHD + "-" + String.format("%03d", stt);
    }

    public long getThanhTien() {
        int loai = maHD.charAt(2) - '0';
        return sanPham.getGia(loai) * soLuong;
    }

    public long getGiamGia() {
        long thanhTien = getThanhTien();
        if (soLuong >= 150) {
            return thanhTien * 50 / 100;
        } else if (soLuong >= 100) {
            return thanhTien * 30 / 100;
        } else if (soLuong >= 50) {
            return thanhTien * 15 / 100;
        }
        return 0;
    }

    public long getPhaiTra() {
        return getThanhTien() - getGiamGia();
    }

    @Override
    public String toString() {
        return getMaFull() + " " + sanPham.getTen() + " " + getGiamGia() + " " + getPhaiTra();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        Map<String, SanPham> mapSP = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String maLoai = sc.nextLine().trim();
            String ten = sc.nextLine().trim();
            long gia1 = Long.parseLong(sc.nextLine().trim());
            long gia2 = Long.parseLong(sc.nextLine().trim());
            mapSP.put(maLoai, new SanPham(maLoai, ten, gia1, gia2));
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        List<HoaDon> listHD = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String maHD = parts[0];
            long soLuong = Long.parseLong(parts[1]);

            String maLoai = maHD.substring(0, 2);
            SanPham sp = mapSP.get(maLoai);
            listHD.add(new HoaDon(i, maHD, sp, soLuong));
        }

        for (HoaDon hd : listHD) {
            System.out.println(hd);
        }

        sc.close();
    }
}
