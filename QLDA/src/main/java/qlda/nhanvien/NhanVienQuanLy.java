package qlda.nhanvien;

import java.text.ParseException;
import java.util.Date;
import qlda.config.Config;

public class NhanVienQuanLy extends NhanVien {
    private Date ngayNhamChuc;

    
    //================== METHODS =====================

    public NhanVienQuanLy(String hoTen, String ngaySinh, String gioiTinh, String email, LoaiNhanVien loaiNV, Date ngayNhamChuc) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, loaiNV);
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
