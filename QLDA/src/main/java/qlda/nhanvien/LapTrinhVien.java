package qlda.nhanvien;

import java.text.ParseException;


public class LapTrinhVien extends NhanVien{
    private double luongOT;

    // ========================================== METHODS =============================================
   
    public LapTrinhVien(String hoTen, String ngaySinh, String gioiTinh, String email, double luongOT) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email);
        this.luongOT = luongOT;
    }
    
    @Override
    public double getHeSo() {
        return 1.5;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + this.luongOT;
    }

    // ========================================== METHODS =============================================

    public double getLuongOT() {
        return luongOT;
    }

    public void setLuongOT(double luongOT) {
        this.luongOT = luongOT;
    }
}
