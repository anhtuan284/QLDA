package qlda.nhanvien;

import java.text.ParseException;
import java.util.Date;
import qlda.config.Config;

public class NhanVienQuanLy extends NhanVien {
    private Date ngayNhamChuc;

    
    //================== METHODS =====================

    public NhanVienQuanLy(Date ngayNhamChuc, String ngaySinh, String hoTen, String email, String gioiTinh, LoaiNhanVien loaiNV) throws ParseException {
        super(ngaySinh, hoTen, email, gioiTinh, loaiNV);
        this.ngayNhamChuc = ngayNhamChuc;
    } 

    public double luongPhu() {
        return getLoaiNV().tinhLuongPhu(0);
    } 

    @Override
    public double getHeSo() {
        return 1.5;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + luongPhu();
    }
    
}
