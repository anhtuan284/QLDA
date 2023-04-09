package qlda.nhanvien;

import java.text.ParseException;


public class LapTrinhVien extends NhanVien{
    private double luongOT;

    // ========================================== METHODS =============================================
    
    public LapTrinhVien(String ngaySinh, String hoTen, String email, String gioiTinh, LoaiNhanVien loaiNV, double luongOT) throws ParseException {
        super(ngaySinh, hoTen, email, gioiTinh, loaiNV);
        this.luongOT = luongOT;
    }

    @Override
    public double getHeSo() {
        return 1.8;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + getLoaiNV().tinhLuongPhu(luongOT);
    }
}
