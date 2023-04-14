package qlda.duan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import qlda.config.Config;
import qlda.nhanvien.NhanVien;


public class DuAn {
    private String maDA;
    private String tenDA;
    private Date thoiDiemBatDau;
    private Date thoiDiemKetThuc;
    private double tongKinhPhi;
    
    private NhanVien chuNhiem;
    private List<NhanVien> dsNVThamGia = new ArrayList<>();
    private static int nDA = 0;
    {
        this.maDA = String.format("DA%03d", ++nDA);
    }

    public DuAn() {}
    public DuAn(String tenDA, String thoiDiemBatDau, String thoiDiemKetThuc, double tongKinhPhi) throws ParseException {
        this.tenDA = tenDA;
        this.thoiDiemBatDau = Config.f.parse(thoiDiemBatDau);
        this.thoiDiemKetThuc = Config.f.parse(thoiDiemKetThuc);
        this.tongKinhPhi = tongKinhPhi;
    }
    
    // ============================== METHODS ===========================

    @Override
    public String toString() {
        return String.format("%-7s%-20s%-12s%-12s%-8.1f%s", this.maDA, this.tenDA, Config.f.format(this.thoiDiemBatDau),Config.f.format(this.thoiDiemKetThuc), this.tongKinhPhi, this.chuNhiem.getMaNV());
    }

    public void hienThi() {
        System.out.printf("===================== DU AN : %s ==============================\n", this.tenDA);
        System.out.printf("+ Chu nhiem du an:\n%s\n", isCoCN() ? this.chuNhiem : "Chua co chu nhiem");
        System.out.println("- Danh sach nhan vien:");
        if (this.dsNVThamGia.isEmpty()) 
            System.out.println("Chua co nhan vien tham gia");
        else 
            this.dsNVThamGia.stream().forEach(n -> System.out.println(n));
        System.out.printf("=====================================================================\n", this.tenDA);
    }
    
    public boolean isCoNV(NhanVien nv) {
        return this.dsNVThamGia.contains(nv);
    }
    
    public void themNV(NhanVien... n) {
        for (NhanVien nv: n) {
            nv.getDsDA().add(this);
        }
        this.dsNVThamGia.addAll(Arrays.asList(n));
    }
    
    public void xoaNV(NhanVien... n) {
        for (NhanVien nv: n)
            if (isCoNV(nv))
                this.dsNVThamGia.remove(nv);  
    }

    public boolean isCoCN() {
        return this.chuNhiem != null;
    }
    public boolean themCN(NhanVien nv) {
        if (isCoCN())
            return false;
        this.chuNhiem = nv;
        return true;
    }

    public void xoaCN() {
        this.chuNhiem = null;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof DuAn)) return false;
        DuAn temp = (DuAn) obj;
        return maDA.equals(temp.maDA);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.maDA);
        return hash;
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

    public List<NhanVien> getDsNVThamGia() {
        return dsNVThamGia;
    }
}
