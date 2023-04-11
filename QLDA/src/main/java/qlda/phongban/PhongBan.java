package qlda.phongban;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import qlda.nhanvien.NhanVien;

public class PhongBan {
    private String tenPB;

    private List<NhanVien> listNV = new ArrayList<>();

    public PhongBan(String tenPB) {
        this.tenPB = tenPB;
    }
    
    public boolean isChuaCoNV(NhanVien nv) {
        return this.listNV.stream().filter(t -> t.getMaNV().contains(nv.getMaNV())).collect(Collectors.toList()).isEmpty();
    }
    
    public void them1NV(NhanVien nv) {
        if (!isChuaCoNV(nv))
            return;
        this.listNV.add(nv);
    }
    
    public void themNV(NhanVien... arrNV) {
        for (NhanVien nv: arrNV) {
            them1NV(nv);
        }
    }
    
    public void xoaNV(NhanVien nv) {
        if (isChuaCoNV(nv))
            return;
        listNV.remove(nv);
    }
    
    public void hienThiDSNV() {
        listNV.forEach(t -> {
            System.out.println(t);
        });
    }

    @Override
    public String toString() {
        return String.format("-Ten Phong Ban: %s", this.tenPB);
    }
    
    
//======== getter setter =========
    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }
}
