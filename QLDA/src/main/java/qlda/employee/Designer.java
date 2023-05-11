package qlda.employee;

import java.text.ParseException;
import qlda.phongban.PhongBan;



public class Designer extends Employee{
    private double bonus;

    public Designer(String hoTen, String ngaySinh, String gioiTinh, String email, PhongBan pb, EmployeeType loaiNV, double bonus) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, pb, loaiNV);
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
