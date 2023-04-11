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
    public double getHeSo() {
        return 1.8;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + this.loaiNV.tinhLuongPhu(luongOT);
    }
}
