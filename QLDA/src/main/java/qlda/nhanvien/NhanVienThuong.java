package qlda.nhanvien;

import java.text.ParseException;

public class NhanVienThuong extends NhanVien{

    // ================================ METHOD ===================================
    public NhanVienThuong(String ngaySinh, String hoTen, String email, String gioiTinh, LoaiNhanVien loaiNV) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email);
    }
    
    @Override
    public double getHeSo() {
        return 1;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo();
    }
}
