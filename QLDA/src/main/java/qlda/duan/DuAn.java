package qlda.duan;

import java.text.ParseException;
import java.util.Date;
import qlda.config.Config;
import qlda.nhanvien.NhanVien;


public class DuAn {
    private String maDA;
    private String tenDA;
    private Date thoiDiemBatDau;
    private Date thoiDiemKetThuc;
    private double tongKinhPhi;
    
    private NhanVien chuNhiem;
    private static int nDA = 0;
    {
        this.maDA = String.format("DA%03d", ++nDA);
    }

    public DuAn() {}
    public DuAn(String tenDA, String thoiDiemBatDau, String thoiDiemKetThuc, double tongKinhPhi, NhanVien chuNhiem) throws ParseException {
        this.tenDA = tenDA;
        this.thoiDiemBatDau = Config.f.parse(thoiDiemBatDau);
        this.thoiDiemKetThuc = Config.f.parse(thoiDiemKetThuc);
        this.tongKinhPhi = tongKinhPhi;
        this.chuNhiem = chuNhiem;
    }
    
    // ============================== METHODS ===========================

    @Override
    public String toString() {
        return String.format("%-7s%-20s%-12s%-12s%-8.1f%s", this.maDA, this.tenDA, Config.f.format(this.thoiDiemBatDau),Config.f.format(this.thoiDiemKetThuc), this.tongKinhPhi, this.chuNhiem.getMaNV());
    }
    
    // ============================== Getter setter ===========================

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
    }

    public String getTenDA() {
        return tenDA;
    }

    public void setTenDA(String tenDA) {
        this.tenDA = tenDA;
    }

    public Date getThoiDiemBatDau() {
        return thoiDiemBatDau;
    }

    public void setThoiDiemBatDau(Date thoiDiemBatDau) {
        this.thoiDiemBatDau = thoiDiemBatDau;
    }

    public Date getThoiDiemKetThuc() {
        return thoiDiemKetThuc;
    }

    public void setThoiDiemKetThuc(Date thoiDiemKetThuc) {
        this.thoiDiemKetThuc = thoiDiemKetThuc;
    }

    public double getTongKinhPhi() {
        return tongKinhPhi;
    }

    public void setTongKinhPhi(double tongKinhPhi) {
        this.tongKinhPhi = tongKinhPhi;
    }

    public NhanVien getChuNhiem() {
        return chuNhiem;
    }

    public void setChuNhiem(NhanVien chuNhiem) {
        this.chuNhiem = chuNhiem;
    }
    
}
