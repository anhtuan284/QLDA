package qlda.nhanvien;

import java.text.ParseException;



public class ThietKeVien extends NhanVien{
    private double bonus;

    public ThietKeVien(String ngaySinh, String hoTen, String email, String gioiTinh, double bonus) throws ParseException {
        super(ngaySinh, hoTen, email, gioiTinh);
        this.bonus = bonus;
    }

    @Override
    public double getHeSo() {
        return 1.7;
    }

    @Override
    public double tinhLuong() {
        return LUONG_CO_BAN * getHeSo() + this.getBonus();
    }

    // ============================== GETTER SETTER =================================
    
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
