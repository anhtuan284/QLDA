package qlda.employee;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import qlda.config.Config;
import qlda.project.DuAn;
import qlda.phongban.PhongBan;
import qlda.thannhan.ThanNhan;

public abstract class Employee {
    private String emID;
    private String emName;
    private Date emDOB;
    private String emEmail;
    private String emGender;
    private LoaiNhanVien emType;
    
    private List<DuAn> dsDA = new ArrayList<>();
    private List<ThanNhan> dsTN = new ArrayList<>();
    private PhongBan phongBan;
    private static final double LUONG_CO_BAN = 1000;
    private static final int DU_AN_TOI_DA = 3;
    private static int nNV = 0;
    {
        this.setEmID(String.format("NV%03d", ++nNV));
    }
    
    
    public Employee(String name, String dob, String gender, String email, PhongBan department, LoaiNhanVien type) throws ParseException {
        this.emName = name;
        this.emDOB = Config.f.parse(dob);
        this.emGender = gender;
        this.emEmail = email;
        this.emType = type;
        this.phongBan = department;
        this.dsDA = new ArrayList<>();
        themNVVaoPhongBan(department);
    }

    // ====================================== METHOD =======================================

    @Override
    public String toString() {
        return String.format("%-7s%-20s%-12s%-5s%-20s%s", this.getEmID(), this.getEmName(), Config.f.format(this.getEmDOB()), this.getEmGender(), this.emType, this.getEmEmail());
    }
    
    public abstract double layHeSo();
    public abstract double layPhuCap();

    public double tinhLuong() {
        return LUONG_CO_BAN * layHeSo() + layPhuCap();
    }
    public int tinhTuoi() {
        LocalDate crrDate = LocalDate.now();
        String []key = Config.f.format(getEmDOB()).split("/"); 
        LocalDate dOB = LocalDate.parse(key[2] + "-" + key[1] + "-" + key[0]); // YYYY-MM-dd
        return Period.between(dOB, crrDate).getYears();
    }
    
    public boolean isHasProject(DuAn da) {
        return this.dsDA.contains(da);
    }
    public boolean isFullProject() {
        return dsDA.size() >= DU_AN_TOI_DA;
    }
    
    public boolean addProject(DuAn... da) {
        for (DuAn duAn: da) 
            if (!isHasProject(duAn) && dsDA.size() < DU_AN_TOI_DA) {
                dsDA.add(duAn);
                duAn.themNV(this);
                return true;
            }
        return false;
    }
    
    public void rmProject(DuAn da) {
        if(isHasProject(da))
            dsDA.remove(da);
    }
    
    public void hienThiDuAnThamGia() {
        if (dsDA.isEmpty())
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
        if (!(obj instanceof Employee)) return false;
        Employee temp = (Employee) obj;
        return emID.equals(temp.emID) || ( emName.equals(temp.emName) && emDOB.equals(temp.emDOB));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.emID);
        hash = 89 * hash + Objects.hashCode(this.emName);
        hash = 89 * hash + Objects.hashCode(this.emDOB);
        return hash;
    }


    
    // ================================= GETTER SETTER ====================================
 
    public String getEmID() {
        return emID;
    }

    public void setEmID(String maNV) {
        this.emID = maNV;
    }

    public Date getEmDOB() {
        return emDOB;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.emDOB = ngaySinh;
    }

    public String getEmName() {
        return emName;
    }

    public void setHoTen(String hoTen) {
        this.emName = hoTen;
    }

    public String getEmEmail() {
        return emEmail;
    }

    public void setEmail(String email) {
        this.emEmail = email;
    }

    public String getEmGender() {
        return emGender;
    }

    public void setGioiTinh(String gioiTinh) {
        this.emGender = gioiTinh;
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
        return emType;
    }

    public void setLoaiNV(LoaiNhanVien loaiNV) {
        this.emType = loaiNV;
    }
}
