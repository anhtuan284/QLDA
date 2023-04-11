package qlda.nhanvien;

import java.text.ParseException;


public class KiemThuVien extends NhanVien{
    private double nError;

    public KiemThuVien(String hoTen, String ngaySinh, String gioiTinh, String email, LoaiNhanVien loaiNV, double nError) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, loaiNV);
        this.nError = nError;
    }

    @Override
    public double getHeSo() {
        return 1.4;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + this.loaiNV.tinhLuongPhu(nError * 200);
    }
    
    
}
