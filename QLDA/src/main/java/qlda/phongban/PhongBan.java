package qlda.phongban;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import qlda.employee.Employee;

public class PhongBan {
    private String tenPB;
    
    private Employee nvQL;
    private List<Employee> dsNVTrucThuoc = new ArrayList<>();
    
    public PhongBan(String tenPB) {
        this.tenPB = tenPB;
    }
    
    public boolean isCoNV(Employee nv) {
        return this.dsNVTrucThuoc.contains(nv);
    }
    
    public void themNV(Employee... arrNV) {
        for (Employee nv: arrNV)
            if (!isCoNV(nv))
                dsNVTrucThuoc.add(nv);
    }
    public void xoaNV(Employee... arrNV) {
        for (Employee nv: arrNV)
            if (isCoNV(nv))
                dsNVTrucThuoc.remove(nv);
    }
    
    public void hienThiDSNV() {
        dsNVTrucThuoc.forEach(System.out :: println);
    }

    @Override
    public String toString() {
        return String.format(this.tenPB);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof PhongBan)) return false;
        PhongBan temp = (PhongBan) obj;
        return this.tenPB.equals(temp.tenPB);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.tenPB);
        return hash;
    }
    
    
    
//======================== getter setter =============================
    public String getTenPB() {
        return tenPB;
    }

    public List<Employee> getDsNVTrucThuoc() {
        return dsNVTrucThuoc;
    }

    
    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public Employee getNvQL() {
        return nvQL;
    }

    public void setNvQL(Employee nvQL) {
        this.nvQL = nvQL;
    }
}
