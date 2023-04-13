
package qlda.nhanvien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class QuanLyNhanVien {
    private List<NhanVien> dsNhanVien = new ArrayList<>();
    
    public void themNhanVien(NhanVien... a) {
        this.dsNhanVien.addAll(Arrays.asList(a));
    }

    public void xoaNhanVien(NhanVien... a) {
        this.dsNhanVien.removeAll(Arrays.asList(a));
    }

    public void hienThi() {
        this.dsNhanVien.stream().forEach(nv -> System.out.println(nv));
    }

    public void BangLuongNV() {
        this.dsNhanVien.stream().forEach(n -> {
            System.out.printf("\nNhan vien %s - Luong tong: %,.1f Trieu VNĐ", n.getHoTen().toUpperCase(), n.tinhLuong());
        });
    }
    public List<NhanVien> timKiem(String tuKhoa) {
        return this.dsNhanVien.stream().filter(n -> n.getHoTen().contains(tuKhoa) || n.getMaNV().contains(tuKhoa))
                .collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(Date ngay) {
        return this.dsNhanVien.stream().filter(n -> n.getNgaySinh().equals(ngay)).collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(int dau, int cuoi) {
        return this.dsNhanVien.stream().filter(n -> n.tinhTuoi()>= dau && n.tinhTuoi()<= cuoi).
                collect(Collectors.toList());
    }
    
    
    // =================================== getter setter ===================================
    public List<NhanVien> getDanhSachNhanVien() {
        return dsNhanVien;
    }

    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.dsNhanVien = danhSachNhanVien;
    }
}


