package qlda.thannhan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import qlda.config.Config;
import qlda.nhanvien.NhanVien;


public class ThanNhan {
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String moiQuanHe;
    
    private List<NhanVien> dsNV = new ArrayList<>(); // 1 than nhan co the co nhieu NV

    public ThanNhan(String hoTen, String ngaySinh, String gioiTinh, String moiQuanHe) throws ParseException {
        this.hoTen = hoTen;
        this.ngaySinh = Config.f.parse(ngaySinh);
        this.gioiTinh = gioiTinh;
        this.moiQuanHe = moiQuanHe;
    }
    
    // ========================= METHODS ===============================
    @Override
    public String toString() {
        return String.format("%-20s%-12s%-6s%-8s",this.hoTen, Config.f.format(this.ngaySinh), this.gioiTinh, this.moiQuanHe);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof ThanNhan)) return false;
        ThanNhan tn = (ThanNhan) obj;
        return tn.getHoTen().equals(this.hoTen) && tn.getMoiQuanHe().equals(this.moiQuanHe);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.hoTen);
        hash = 23 * hash + Objects.hashCode(this.moiQuanHe);
        return hash;
    }
    
    
    // ======================== getter setter ===========================

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMoiQuanHe() {
        return moiQuanHe;
    }

    public void setMoiQuanHe(String moiQuanHe) {
        this.moiQuanHe = moiQuanHe;
    }
}
