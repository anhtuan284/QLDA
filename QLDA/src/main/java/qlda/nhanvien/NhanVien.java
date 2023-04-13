package qlda.nhanvien;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import qlda.config.Config;
import qlda.duan.DuAn;
import qlda.phongban.PhongBan;
import qlda.thannhan.ThanNhan;

public abstract class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected Date ngaySinh;
    protected String email;
    protected String gioiTinh;
    
    protected List<DuAn> dsDA = new ArrayList<>();
    protected List<ThanNhan> dsTN = new ArrayList<>();
    protected PhongBan phongBan;
    protected static final double LUONG_CO_BAN = 1000;
    private static int nNV = 0;
    {
        this.setMaNV(String.format("NV%03d", ++nNV));
    }
    
    
    
    public NhanVien(String hoTen, String ngaySinh, String gioiTinh, String email) throws ParseException {
        this.hoTen = hoTen;
        this.ngaySinh = Config.f.parse(ngaySinh);
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.dsDA = new ArrayList<>();
    }
    
    // ====================================== METHOD =======================================

    @Override
    public String toString() {
        return String.format("%-7s%-20s%-12s%-5s%s", this.getMaNV(), this.getHoTen(), Config.f.format(this.getNgaySinh()), this.getGioiTinh(), this.getEmail());
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
    
    public boolean isChuaCoDuAn(DuAn da) {
        return this.getDsDA().stream().filter(ds -> ds.getMaDA().contains(da.getMaDA())).collect(Collectors.toList()).isEmpty();
    }
    
    // tham số đầu vào của addAll chỉ chấp nhận kiểu Collection nên phải dùng Array.asList()
    public void themDA(DuAn... da) {
        for (DuAn duAn: da) 
            if (isChuaCoDuAn(duAn))
                dsDA.add(duAn);
//        dsDA.addAll(Arrays.asList(da));
    }
    
    public void xoaDA(DuAn da) {
        dsDA.remove(da);
    }
    
    public void hienThiDuAnThamGia() {
        dsDA.forEach(da -> {
            System.out.println(da);
        });
    }
    
    public boolean isChuaCoThanNhan(ThanNhan thanNhan) {
        for (ThanNhan tn : dsTN) 
            if (tn.equals(thanNhan)) // ghi đè equal trong thân nhân rồi
                return false;
        return true;
    }
    
    public void themTN(ThanNhan... tn) {
        for (ThanNhan thanNhan: tn) 
            if (isChuaCoThanNhan(thanNhan))
                dsTN.add(thanNhan);
    }
    
    public void xoaDA(ThanNhan tn) {
        dsTN.remove(tn);
    }
    
    public void hienThiTatCaThanNhan() {
        dsTN.forEach(tn -> {
            System.out.println(tn);
        });
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof NhanVien)) return false;
        NhanVien temp = (NhanVien) obj;
        return maNV.equals(temp.maNV);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.maNV);
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
}
