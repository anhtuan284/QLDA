package qlda.nhanvien;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import qlda.config.Config;
import qlda.phongban.PhongBan;

public class NhanVienQuanLy extends NhanVien {
    private Date ngayNhamChuc;
    
    private List<PhongBan> dsPB = new ArrayList<>();
    private static final int PHONG_BAN_QUAN_LY_TOI_DA = 2;
    //================== METHODS =====================

    public NhanVienQuanLy(String hoTen, String ngaySinh, String gioiTinh, String email, PhongBan pb, LoaiNhanVien loaiNV, String ngayNhamChuc) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, pb, loaiNV);
        this.ngayNhamChuc = Config.f.parse(ngayNhamChuc);
    }
    
    public boolean isCoPB(PhongBan pb) {
        return dsPB.contains(pb);
    }
    
    public void themPBQL(PhongBan pb) {
        if (!isCoPB(pb) && dsPB.size() < PHONG_BAN_QUAN_LY_TOI_DA)
            dsPB.add(pb);
    }
    @Override
    public double layHeSo() {
        return 1.5;
    }

    @Override
    public double layPhuCap() {
        return 0;
    }

    public Date getNgayNhamChuc() {
        return ngayNhamChuc;
    }

    public void setNgayNhamChuc(Date ngayNhamChuc) {
        this.ngayNhamChuc = ngayNhamChuc;
    }

    public List<PhongBan> getDsPB() {
        return dsPB;
    }

    public void setDsPB(List<PhongBan> dsPB) {
        this.dsPB = dsPB;
    }
    
}
