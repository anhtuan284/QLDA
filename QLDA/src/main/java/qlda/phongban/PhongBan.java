package qlda.phongban;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import qlda.nhanvien.NhanVien;

public class PhongBan {
    private String tenPB;

    private List<NhanVien> dsNVTrucThuoc = new ArrayList<>();

    public PhongBan(String tenPB) {
        this.tenPB = tenPB;
    }
    
    public boolean isCoNV(NhanVien nv) {
        return this.dsNVTrucThuoc.contains(nv);
    }
    
    public void themNV(NhanVien... arrNV) {
        for (NhanVien nv: arrNV)
            if (!isCoNV(nv))
                dsNVTrucThuoc.add(nv);
    }
    public void xoaNV(NhanVien... arrNV) {
        for (NhanVien nv: arrNV)
            if (isCoNV(nv))
                dsNVTrucThuoc.remove(nv);
    }
    
    public void hienThiDSNV() {
        dsNVTrucThuoc.forEach(System.out :: println);
    }

    @Override
    public String toString() {
        return String.format("============================= %-27s ============================", this.tenPB);
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

    public List<NhanVien> getDsNVTrucThuoc() {
        return dsNVTrucThuoc;
    }

    
    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }
}
