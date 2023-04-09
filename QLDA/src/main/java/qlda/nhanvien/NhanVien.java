package qlda.nhanvien;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import qlda.config.Config;

public abstract class NhanVien {
    private String maNV;
    private Date ngaySinh;
    private String hoTen;
    private String email;
    private String gioiTinh;
    private LoaiNhanVien loaiNV;
    
    protected static final double LUONG_CO_BAN = 1000;
    private static int nNV = 0;
    {
        this.setMaNV(String.format("NV%03d", ++nNV));
    }
    
    // ==================== METHOD =======================
    
    
    public NhanVien(String ngaySinh, String hoTen, String email, String gioiTinh, LoaiNhanVien loaiNV) throws ParseException {
        this.ngaySinh = Config.f.parse(ngaySinh);
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.loaiNV = loaiNV;
    }

    @Override
    public String toString() {
        return String.format("\n+Ma Nhan Vien: %s\n+Ngay Sinh: %s\n+Ngay Sinh: %s\n+Email: %s\n+Gioi tinh: %s", this.getMaNV(), Config.f.format(this.getNgaySinh()), this.getHoTen(), this.getEmail(), this.getGioiTinh());
    }
    
    public abstract double getHeSo();
    public abstract double tinhLuong();

    public int tinhTuoi() {
        LocalDate crrDate = LocalDate.now();
        String []key = Config.f.format(getNgaySinh()).split("/");
        LocalDate dOB = LocalDate.parse(key[2] + "-" + key[1] + "-" + key[0]);
        return Period.between(dOB, crrDate).getYears();
    }

    
    
    
    
    /**
     * 
     * 
     * @return the maNV
     */
    public String getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the loaiNV
     */
    public LoaiNhanVien getLoaiNV() {
        return loaiNV;
    }

    /**
     * @param loaiNV the loaiNV to set
     */
    public void setLoaiNV(LoaiNhanVien loaiNV) {
        this.loaiNV = loaiNV;
    }

    /**
     * @return the nNV
     */
    public static int getnNV() {
        return nNV;
    }

    /**
     * @param anNV the nNV to set
     */
    public static void setnNV(int anNV) {
        nNV = anNV;
    }
    
}
