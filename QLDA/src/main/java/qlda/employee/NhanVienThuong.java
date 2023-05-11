package qlda.employee;

import java.text.ParseException;
import qlda.phongban.PhongBan;

public class NhanVienThuong extends Employee{

    // ================================ METHOD ===================================
    public NhanVienThuong(String hoTen, String ngaySinh, String gioiTinh, String email, PhongBan pb, LoaiNhanVien loaiNV) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, pb, loaiNV);
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
