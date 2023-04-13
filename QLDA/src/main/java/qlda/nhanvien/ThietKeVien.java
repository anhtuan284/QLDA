package qlda.nhanvien;

import java.text.ParseException;



public class ThietKeVien extends NhanVien{
    private double bonus;

    public ThietKeVien(String hoTen, String ngaySinh, String gioiTinh, String email, double bonus) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email);
        this.bonus = bonus;
    }

    @Override
    public double layHeSo() {
        return 1.7;
    }

    @Override
    public double layPhuCap() {
        return this.bonus;
    }

    // ============================== GETTER SETTER =================================
    
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
