package qlda.duan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import qlda.config.Config;
import qlda.nhanvien.NhanVien;


public class DuAn {
    private String maDA;
    private String tenDA;
    private Date thoiDiemBatDau;
    private Date thoiDiemKetThuc;
    private double tongKinhPhi;
    
    private NhanVien chuNhiem;
    private List<NhanVien> listNV = new ArrayList<>();
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
    
    public void hienThi() {
        System.out.println("=== DANH SACH NHAN VIEN THAM GIA DU AN ===");
        System.out.println("==\nChu nhiem du an:");
        if (this.chuNhiem == null)
            System.out.println("CHUA CO NGUOI CHU NHIEM DU AN");
        else
            System.out.println(this.chuNhiem);
        System.out.println("==\nDanh sach nhan vien:");
        if (this.listNV.size() == 0)
            System.out.println("CHUA CO NHAN VIEN THAM GIA");
        else
            this.listNV.stream().forEach(n -> System.out.println(n));
    }
    
    public void themNhanVien(NhanVien... n) {
        for (NhanVien nv: n) {
            nv.getDsDA().add(this);
        }
        this.listNV.addAll(Arrays.asList(n));
    }
    
     public void xoaNhanVien(NhanVien... n) {
        for (NhanVien nv: n) {
            nv.getDsDA().remove(this);
        }
        this.listNV.removeAll(Arrays.asList(n));
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
