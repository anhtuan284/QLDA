package qlda.nhanvien;

import java.text.ParseException;

public class NhanVienThuong extends NhanVien{

    // ================================ METHOD ===================================
    public NhanVienThuong(String hoTen, String ngaySinh, String gioiTinh, String email) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email);
    }

    @Override
    public double layHeSo() {
        return 1;
    }

    @Override
    public double layPhuCap() {
        return 0;
    }
}
