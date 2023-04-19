package qlda.nhanvien;

import java.text.ParseException;
import java.util.Date;
import qlda.config.Config;

public class NhanVienQuanLy extends NhanVien {
    private Date ngayNhamChuc;

    
    //================== METHODS =====================

    public NhanVienQuanLy(String hoTen, String ngaySinh, String gioiTinh, String email, LoaiNhanVien loaiNV, String ngayNhamChuc) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, loaiNV);
        this.ngayNhamChuc = Config.f.parse(ngayNhamChuc);
    }

    @Override
    public double layHeSo() {
        return 1.5;
    }

    @Override
    public double layPhuCap() {
        return 0;
    }
    
}
