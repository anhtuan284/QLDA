package qlda.employee;

import java.text.ParseException;
import qlda.phongban.PhongBan;


public class Developer extends Employee{
    private double luongOT;

    // ========================================== METHODS =============================================
   
    public Developer(String hoTen, String ngaySinh, String gioiTinh, String email, PhongBan pb, EmployeeType loaiNV, double luongOT) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, pb, loaiNV);
        this.luongOT = luongOT;
    }
    
    @Override
    public double layHeSo() {
        return 1.5;
    }

    @Override
    public double layPhuCap() {
        return this.luongOT;
    }

    // ========================================== METHODS =============================================

    public double getLuongOT() {
        return luongOT;
    }

    public void setLuongOT(double luongOT) {
        this.luongOT = luongOT;
    }
}
