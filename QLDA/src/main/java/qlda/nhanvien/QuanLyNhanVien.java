package qlda.nhanvien;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import qlda.config.Config;
import qlda.phongban.QuanLyPhongBan;


public class QuanLyNhanVien {
    private List<NhanVien> dsNV = new ArrayList<>();

    public QuanLyNhanVien() {}
    
    public boolean isTonTaiNV(NhanVien nv) {
        return this.dsNV.contains(nv);
    }
    
    public NhanVien nhapNhanVien() throws ParseException {
        System.out.print("\nHo ten: ");
        String hoTen = Config.sc.nextLine();
        System.out.print("Ngay sinh (dd/MM/yyyy): ");
        String ngaySinh = Config.sc.nextLine();
        System.out.print("Gioi tinh: ");
        String gioiTinh = Config.sc.nextLine();
        System.out.print("Email: ");
        String email = Config.sc.nextLine();
        System.out.print("Kieu Nhan Vien: \n[1]: Nhan Vien Thuong\n[2]: Nhan Vien Quan Ly\n[3]: Lap Trinh Vien\n[4]: Thiet Ke Vien\n[5]: Kiem Thu Vien\n~> Kieu nhan vien: ");
        switch(Integer.parseInt(Config.sc.nextLine())) {
            case 1:
                return new NhanVienThuong(hoTen, ngaySinh, gioiTinh, email, LoaiNhanVien.NHAN_VIEN_THUONG);
            case 2:
                System.out.print("Nhap ngay nham chuc: ");
                String ngayNC = Config.sc.nextLine();
                return new NhanVienQuanLy(hoTen, ngaySinh, gioiTinh, email,LoaiNhanVien.NHAN_VIEN_QUAN_LY, ngayNC);
            case 3:
                System.out.print("Luong OT: ");
                double luongOT = Double.parseDouble(Config.sc.nextLine());
                return new LapTrinhVien(hoTen, ngaySinh, gioiTinh, email, LoaiNhanVien.LAP_TRINH_VIEN, luongOT);
            case 4:
                System.out.print("Bonus: ");
                double bonus = Double.parseDouble(Config.sc.nextLine());
                return new ThietKeVien(hoTen, ngaySinh, gioiTinh, email, LoaiNhanVien.THIET_KE_VIEN, bonus);
            case 5:
                System.out.print("So loi phat hien: ");
                int nError = Integer.parseInt(Config.sc.nextLine());
                return new KiemThuVien(hoTen, ngaySinh, gioiTinh, email, LoaiNhanVien.KIEM_THU_VIEN, nError);
        }
        return null;
    }
    public void themNhanVien(NhanVien... nvs) {
        for (NhanVien nv: nvs)
            if (!isTonTaiNV(nv))
                dsNV.add(nv);
    }

    public void xoaNhanVien(NhanVien... nvs) {
        for (NhanVien nv: nvs)
            if (isTonTaiNV(nv))
                dsNV.remove(nv);
    }

    public void hienThi() {
        System.out.printf("%-7s%-20s%-12s%-5s%-20s%s\n", "Ma NV", "Ho Ten", "Ngay Sinh", "GT", "LoaiNV", "Email");
        this.dsNV.stream().forEach(System.out :: println);
    }

    public void BangLuongNV() {
        this.dsNV.stream().forEach(n -> {
            System.out.printf("+ %-20s - Luong: %,.1f USD\n", n.getHoTen().toUpperCase(), n.tinhLuong());
        });
    }
    
    public List<NhanVien> timKiem(String kw) {
        return this.dsNV.stream()
                .filter(n -> n.getHoTen().trim().equalsIgnoreCase(kw) || n.getMaNV().equalsIgnoreCase(kw))
                .collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(Date ngay) {
        return this.dsNV.stream()
                .filter(n -> n.getNgaySinh().equals(ngay))
                .collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(int dau, int cuoi) {
        return this.dsNV.stream()
                .filter(n -> n.tinhTuoi()>= dau && n.tinhTuoi()<= cuoi)
                .collect(Collectors.toList());
    }
    public List<NhanVien> timKiem(QuanLyPhongBan qlpb, String maPB) {
        return qlpb.timKiem(maPB).get(0).getDsNVTrucThuoc();
    }
    
    public void hienThiDSTN(String kw) {
        this.timKiem(kw).get(0).hienThiTatCaThanNhan();
    }
    
    public void hienThiDSDA(String kw) {
        this.timKiem(kw).get(0).hienThiDuAnThamGia();
    }
    
    // =================================== getter setter ===================================
    public List<NhanVien> getDsNV() {
        return dsNV;
    }

    public void setDsNV(List<NhanVien> danhSachNhanVien) {
        this.dsNV = danhSachNhanVien;
    }
}


