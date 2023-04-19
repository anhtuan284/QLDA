package qlda.nhanvien;

import java.text.ParseException;


public class LapTrinhVien extends NhanVien{
    private double luongOT;

    // ========================================== METHODS =============================================
   
    public LapTrinhVien(String hoTen, String ngaySinh, String gioiTinh, String email, LoaiNhanVien loaiNV, double luongOT) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, loaiNV);
        this.luongOT = luongOT;
    }
    
    @Override
    public double layHeSo() {
        return 1.5;
    }

    @Override
    public double layPhuCap() {
        return this.luongOT;
    }

    // ========================================== METHODS =============================================

    public double getLuongOT() {
        return luongOT;
    }

    public void setLuongOT(double luongOT) {
        this.luongOT = luongOT;
    }
}
