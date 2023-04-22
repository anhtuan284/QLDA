package qlda.duan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import qlda.config.Config;
import qlda.nhanvien.NhanVien;
import qlda.nhanvien.QuanLyNhanVien;


public class DuAn {
    private String maDA;
    private String tenDA;
    private Date thoiDiemBatDau;
    private Date thoiDiemKetThuc;
    private double tongKinhPhi;
    
    private static final int NHAN_VIEN_TOI_DA = 10;
    private static final int NHAN_VIEN_TOI_THIEU = 5;
    private NhanVien chuNhiem;
    private List<NhanVien> dsNV = new ArrayList<>();
    private static int nDA = 0;
    {
        this.maDA = String.format("DA%03d", ++nDA);
    }

    public DuAn() {}
    public DuAn(String tenDA, String thoiDiemBatDau, String thoiDiemKetThuc, double tongKinhPhi, QuanLyNhanVien qlnv) throws ParseException {
        this.tenDA = tenDA;
        this.thoiDiemBatDau = Config.f.parse(thoiDiemBatDau);
        this.thoiDiemKetThuc = Config.f.parse(thoiDiemKetThuc);
        this.tongKinhPhi = tongKinhPhi;
        do { themCN(qlnv); } while (!isCoCN());
        do { System.out.printf("DU AN CHUA DU NHAN VIEN !!! Thieu %d Nhan Vien\n", NHAN_VIEN_TOI_THIEU - this.dsNV.size());themNV(qlnv); } while (!isDuNV());
    }
    
    public DuAn(String tenDA, String thoiDiemBatDau, String thoiDiemKetThuc, double tongKinhPhi, NhanVien chuNhiem, NhanVien... arrNV) throws ParseException {
        this.tenDA = tenDA;
        this.thoiDiemBatDau = Config.f.parse(thoiDiemBatDau);
        this.thoiDiemKetThuc = Config.f.parse(thoiDiemKetThuc);
        this.tongKinhPhi = tongKinhPhi;
        this.chuNhiem = chuNhiem;
        themNV(arrNV);
        
    }
    
    
    // ============================== METHODS ===========================

    @Override
    public String toString() {
        return String.format("%-7s%-20s%-16s%-18s%-13.1f%s", this.maDA, this.tenDA, Config.f.format(this.thoiDiemBatDau),Config.f.format(this.thoiDiemKetThuc), this.tongKinhPhi, this.chuNhiem != null ? this.chuNhiem.getMaNV(): "null");
    }

    public void hienThiDSNV() {
        System.out.printf("===================== DU AN : %s ============================\n", this.tenDA);
        System.out.printf("+ Chu nhiem du an:\n%s\n", isCoCN() ? this.chuNhiem : "Chua co chu nhiem");
        System.out.println("- Danh sach nhan vien:");
        if (this.dsNV.isEmpty()) 
            System.out.println("Chua co nhan vien tham gia");
        else 
            this.dsNV.forEach(System.out :: println);
        System.out.printf("=====================================================================\n", this.tenDA);
    }
    
    public boolean isCoNV(NhanVien nv) {
        return this.dsNV.contains(nv);
    }
    
    public final boolean isDuNV() {
        return dsNV.size() >= NHAN_VIEN_TOI_THIEU && dsNV.size() <= NHAN_VIEN_TOI_DA; 
    }
    
    public void themNV(NhanVien... n) {
        for (NhanVien nv: n) 
            if (!isCoNV(nv) && dsNV.size() < NHAN_VIEN_TOI_DA) {
                dsNV.add(nv);
                nv.themDA(this);
            }
    }
    
    public void themNV(QuanLyNhanVien qlnv) {
        System.out.print("Ma Nhan Vien Can Them: ");
        List<NhanVien> nv = qlnv.timKiem(Config.sc.nextLine());
        if (nv.isEmpty())
            System.out.println("Khong Tim Thay Nhan Vien !! ");
        else {
            if(!nv.get(0).isFullDA())
                themNV(nv.get(0));
            else
                System.out.println("Nhan Vien nay da tham gia du DU AN!");
        }
    }
    
    public void xoaNV(NhanVien... n) {
        for (NhanVien nv: n)
            if (isCoNV(nv) && dsNV.size() > NHAN_VIEN_TOI_THIEU) {
                System.out.println("XOA THANH CONG");
                this.dsNV.remove(nv);  
            }
            else 
                System.out.println(isCoNV(nv) ? "TOI THIEU 5 NHAN VIEN !!" : "NHAN VIEN NAY CHUA THAM GIA !!");
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
    public void themCN(QuanLyNhanVien qlnv) {
        System.out.print("Ma Nhan Vien Chu Nhiem: ");
        List<NhanVien> nv = qlnv.timKiem(Config.sc.nextLine());
        if (nv.isEmpty())
            System.out.println("KHONG TIM THAY NV !! ");
        else
            themCN(nv.get(0));
    }
    
    public void xoaCN() {
        this.chuNhiem = null;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof DuAn)) return false;
        DuAn temp = (DuAn) obj;
        return maDA.equals(temp.maDA) || tenDA.equalsIgnoreCase(temp.tenDA);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.maDA);
        hash = 71 * hash + Objects.hashCode(this.tenDA);
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
        return dsNV;
    }
}
