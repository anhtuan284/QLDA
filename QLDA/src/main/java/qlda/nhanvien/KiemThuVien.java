package qlda.nhanvien;

import java.text.ParseException;


public class KiemThuVien extends NhanVien{
    private double nError;

    public KiemThuVien(double nError, String ngaySinh, String hoTen, String email, String gioiTinh, LoaiNhanVien loaiNV) throws ParseException {
        super(ngaySinh, hoTen, email, gioiTinh, loaiNV);
        this.nError = nError;
    }
    
    @Override
    public double getHeSo() {
        return 1.4;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + getLoaiNV().tinhLuongPhu(nError * 200);
    }
    
    
}
