
package qlda.nhanvien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class QuanLyNhanVien {
    private List<NhanVien> dsNV = new ArrayList<>();
    
    public void themNhanVien(NhanVien... a) {
        this.dsNV.addAll(Arrays.asList(a));
    }

    public void xoaNhanVien(NhanVien... a) {
        this.dsNV.removeAll(Arrays.asList(a));
    }

    public void hienThi() {
        this.dsNV.stream().forEach(nv -> System.out.println(nv));
    }

    public void BangLuongNV() {
        this.dsNV.stream().forEach(n -> {
            System.out.printf("+ %-20s - Luong: %,.1f USD\n", n.getHoTen().toUpperCase(), n.tinhLuong());
        });
    }
    public List<NhanVien> timKiem(String kw) {
        return this.dsNV.stream().filter(n -> n.getHoTen().contains(kw) || n.getMaNV().contains(kw))
                .collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(Date ngay) {
        return this.dsNV.stream().filter(n -> n.getNgaySinh().equals(ngay)).collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(int dau, int cuoi) {
        return this.dsNV.stream().filter(n -> n.tinhTuoi()>= dau && n.tinhTuoi()<= cuoi).
                collect(Collectors.toList());
    }
    
    
    // =================================== getter setter ===================================
    public List<NhanVien> getDsNV() {
        return dsNV;
    }

    public void setDsNV(List<NhanVien> danhSachNhanVien) {
        this.dsNV = danhSachNhanVien;
    }
}


