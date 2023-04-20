package qlda.nhanvien;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import qlda.config.Config;
import qlda.duan.DuAn;
import qlda.phongban.PhongBan;
import qlda.phongban.QuanLyPhongBan;
import qlda.thannhan.ThanNhan;

public abstract class NhanVien {
    private String maNV;
    private String hoTen;
    private Date ngaySinh;
    private String email;
    private String gioiTinh;
    private LoaiNhanVien loaiNV;
    
    private List<DuAn> dsDA = new ArrayList<>();
    private List<ThanNhan> dsTN = new ArrayList<>();
    private PhongBan phongBan;
    private static final double LUONG_CO_BAN = 1000;
    private static final int DU_AN_TOI_DA = 3;
    private static int nNV = 0;
    {
        this.setMaNV(String.format("NV%03d", ++nNV));
    }
    
    
    public NhanVien(String hoTen, String ngaySinh, String gioiTinh, String email, PhongBan pb, LoaiNhanVien loai) throws ParseException {
        this.hoTen = hoTen;
        this.ngaySinh = Config.f.parse(ngaySinh);
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.loaiNV = loai;
        this.phongBan = pb;
        this.dsDA = new ArrayList<>();
        themNVVaoPhongBan(pb);
    }

    public NhanVien(String hoTen, Date ngaySinh, String email, String gioiTinh, PhongBan phongBan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.phongBan = phongBan;
    }
    
    // ====================================== METHOD =======================================

    @Override
    public String toString() {
        return String.format("%-7s%-20s%-12s%-5s%-20s%s", this.getMaNV(), this.getHoTen(), Config.f.format(this.getNgaySinh()), this.getGioiTinh(), loaiNV.getTypeName(), this.getEmail());
    }
    
    public abstract double layHeSo();
    public abstract double layPhuCap();

    public double tinhLuong() {
        return LUONG_CO_BAN * layHeSo() + layPhuCap();
    }
    public int tinhTuoi() {
        LocalDate crrDate = LocalDate.now();
        String []key = Config.f.format(getNgaySinh()).split("/"); 
        LocalDate dOB = LocalDate.parse(key[2] + "-" + key[1] + "-" + key[0]); // YYYY-MM-dd
        return Period.between(dOB, crrDate).getYears();
    }
    
    public boolean isCoDuAn(DuAn da) {
        return this.dsDA.contains(da); // contains su dung equal & hashCode kiem tra 
    }
    
    // tham số đầu vào của addAll chỉ chấp nhận kiểu Collection nên phải dùng Array.asList()
    public void themDA(DuAn... da) {
        for (DuAn duAn: da) 
            if (!isCoDuAn(duAn) && dsDA.size() < DU_AN_TOI_DA) {
                dsDA.add(duAn);
                duAn.themNV(this);
            }
    }
    
    public void xoaDA(DuAn da) {
        if(isCoDuAn(da))
            dsDA.remove(da);
    }
    
    public void hienThiDuAnThamGia() {
        if (dsDA.size() == 0)
            System.out.println("Chua tham gia du an nao!");
        else
            dsDA.forEach(System.out :: println);
    }
    
    public boolean isCoTN(ThanNhan thanNhan) {
        return this.dsTN.contains(thanNhan);
    }
    
    public void themTN(ThanNhan... tn) {
        for (ThanNhan thanNhan: tn) 
            if (!isCoTN(thanNhan))
                dsTN.add(thanNhan);
    }
    
    public void xoaTN(ThanNhan tn) {
        dsTN.remove(tn);
    }
    
    public void hienThiTatCaThanNhan() {
        dsTN.forEach(System.out :: println);
    }

    public final void themNVVaoPhongBan(PhongBan pb) {
        pb.themNV(this);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof NhanVien)) return false;
        NhanVien temp = (NhanVien) obj;
        return maNV.equals(temp.maNV) || ( hoTen.equals(temp.hoTen) && ngaySinh.equals(temp.ngaySinh));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.maNV);
        hash = 89 * hash + Objects.hashCode(this.hoTen);
        hash = 89 * hash + Objects.hashCode(this.ngaySinh);
        return hash;
    }


    
    // ================================= GETTER SETTER ====================================
 
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public static int getnNV() {
        return nNV;
    }

    public static void setnNV(int anNV) {
        nNV = anNV;
    }

    public List<DuAn> getDsDA() {
        return dsDA;
    }

    public void setDsDA(List<DuAn> dsDA) {
        this.dsDA = dsDA;
    }

    public List<ThanNhan> getDsTN() {
        return dsTN;
    }

    public void setDsTN(List<ThanNhan> dsTN) {
        this.dsTN = dsTN;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public LoaiNhanVien getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(LoaiNhanVien loaiNV) {
        this.loaiNV = loaiNV;
    }
}
