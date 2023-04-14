package qlda.phongban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qlda.config.Config;

public class QuanLyPhongBan {
    List<PhongBan> dsPhongBan = new ArrayList<>();

    public QuanLyPhongBan() {}
    
    public PhongBan nhapPhongBan() {
        System.out.print("Ten phong ban: ");
        String tenPB =Config.sc.nextLine();
        return new PhongBan(tenPB);
    }

    public void hienThi() {
        this.dsPhongBan.stream().forEach(pb -> System.out.println(pb.getTenPB()));
    }

    public void themPhongBan(PhongBan... pb) {
        this.dsPhongBan.addAll(Arrays.asList(pb));
    }

    public void xoaPhongBan(PhongBan... pb) {
        this.dsPhongBan.removeAll(Arrays.asList(pb));
    }

    public List<PhongBan> timKiem(String tuKhoa) {
        return this.dsPhongBan.stream().filter(pb -> pb.getTenPB().contains(tuKhoa)).collect(Collectors.toList());
    }

    public List<PhongBan> getDanhSachPhongBan() {
        return dsPhongBan;
    }

    public void setDanhSachPhongBan(List<PhongBan> danhSachPhongBan) {
        this.dsPhongBan = danhSachPhongBan;
    }
}
