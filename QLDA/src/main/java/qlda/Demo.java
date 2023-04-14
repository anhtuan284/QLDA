package qlda;

import java.text.ParseException;
import qlda.config.Config;
import qlda.duan.DuAn;
import qlda.duan.QuanLyDuAn;
import qlda.nhanvien.KiemThuVien;
import qlda.nhanvien.LapTrinhVien;
import qlda.nhanvien.NhanVien;
import qlda.nhanvien.NhanVienQuanLy;
import qlda.nhanvien.NhanVienThuong;
import qlda.nhanvien.QuanLyNhanVien;
import qlda.nhanvien.ThietKeVien;
import qlda.phongban.PhongBan;
import qlda.phongban.QuanLyPhongBan;
import qlda.thannhan.ThanNhan;

public class Demo {
    public static void main(String[] args) throws ParseException {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        QuanLyDuAn quanLyDuAn = new QuanLyDuAn();
        QuanLyPhongBan quanLyPhongBan = new QuanLyPhongBan();
        
        NhanVien nv1 = new LapTrinhVien("Anh Tuan ","20/3/2003", "Nam",  "at@",  20);
        NhanVien nv2 = new KiemThuVien("Nguyen haha ","20/5/2003", "Nam", "huutu1098@gmail.com", 39);
        NhanVien nv3 = new NhanVienQuanLy("Nguyen Huu Tinh", "20/1/2001", "Nam", "tinh@gmail.com", "20/12/2022");
        NhanVien nv4 = new NhanVienThuong("Nguyen huu Tu ","20/3/2003", "Nam", "huutu1098@gmail.com");
        NhanVien nv5 = new ThietKeVien("Nguyen huu Tu ","20/3/2003", "Nam", "huutu1098@gmail.com", 50);
        
        PhongBan pb1 = new PhongBan("Phong Nhan Su");
        PhongBan pb2 = new PhongBan("Phong Cong Nghe Thong Tin");
        PhongBan pb3 = new PhongBan("Phong Ke Toan");
        
        DuAn da1 = new DuAn("Pha nha", "2/2/2022", "3/3/2023", 1200.1);
        DuAn da2 = new DuAn("Xay Nha", "2/2/2022", "3/3/2023", 1200.1);
        DuAn da3 = new DuAn("Ok", "2/2/2022", "3/3/2023", 1200.1);
        
        ThanNhan tn1 = new ThanNhan("Thao Van", "9/11/2003", "Nu", "Nguoi yeu cua Huu Tu");
        ThanNhan tn2 = new ThanNhan("Quoc Huy", "3/2/2022", "Nam", "friend");
        ThanNhan tn3 = new ThanNhan("An Tien", "22/2/2022", "Nam", "super");
        
        quanLyNhanVien.themNhanVien(nv1, nv2, nv3, nv4, nv5);
        quanLyDuAn.themDuAn(da1, da2, da3);
        quanLyPhongBan.themPhongBan(pb1, pb2, pb3);
        
        pb1.themNV(nv1, nv2, nv3);
        pb2.themNV(nv4);
        pb3.themNV(nv5);
        
        da1.themNV(nv1, nv2);
        da2.themNV(nv3);
        da3.themNV(nv4, nv5);
        
        da1.setChuNhiem(nv1);
        da2.setChuNhiem(nv3);
        da3.setChuNhiem(nv5);
        
        nv1.themTN(tn2);
        nv2.themTN(tn1);
        da1.hienThi();
        System.out.println("============ BANG LUONG NHAN VIEN ==========");
        quanLyNhanVien.BangLuongNV();
        //System.out.println(da1.isChuaCoNV(nv2));
        
//        nv1.themDA(da2);
//        nv1.themDA(da2, da1, da3);
//        System.out.println("Các du an NV1 tham gia: ");
//        nv1.hienThiDuAnThamGia();
        
//        ThanNhan tn1 = new ThanNhan("Thao Van", "2/2/2022", "Nu", "Nguoi yeu");
//        ThanNhan tn2 = new ThanNhan("Quoc Huy", "3/2/2022", "Nam", "Nguoi yeu");
//        ThanNhan tn3 = new ThanNhan("An Tien", "22/2/2022", "Nam", "Nguoi yeu");
//        
//        nv1.themTN(tn1);
//        nv1.themTN(tn1, tn1, tn2, tn2, tn3);
//        System.out.println("\nNguoi than cua NV1:");
//        nv1.hienThiTatCaThanNhan();
        
    }
}
