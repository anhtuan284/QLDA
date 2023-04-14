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
        PhongBan pb4 = new PhongBan("Phong An Ninh");
        PhongBan pb5 = new PhongBan("Phong Ke Kiem");
        DuAn da1 = new DuAn("Pha nha", "2/2/2022", "3/3/2023", 120.1);
        DuAn da2 = new DuAn("Xay Nha", "2/2/2022", "3/3/2023", 1300.1);
        DuAn da3 = new DuAn("Ok", "2/2/2022", "3/3/2023", 1560.1);
        DuAn da4 = new DuAn("Quy Mui", "2/2/2022", "3/3/2023", 3200.1);
        DuAn da5 = new DuAn("Tien Ma", "2/2/2022", "3/3/2023", 2200.1);
        ThanNhan tn1 = new ThanNhan("Thao Van", "9/11/2003", "Nu", "Nguoi yeu cua Huu Tu");
        ThanNhan tn2 = new ThanNhan("Quoc Huy", "3/2/2022", "Nam", "friend");
        ThanNhan tn3 = new ThanNhan("An Tien", "22/2/2022", "Nam", "super");
        quanLyNhanVien.themNhanVien(nv1, nv2, nv3, nv4, nv5);
        quanLyDuAn.themDA(da1, da2, da3, da4, da5);
        quanLyPhongBan.themPB(pb1, pb2, pb3);
        pb1.themNV(nv1, nv2, nv3, nv1, nv3);
        pb2.themNV(nv4);
        pb3.themNV(nv5);
        da1.themNV(nv1, nv2);
        da2.themNV(nv3);
        da3.themNV(nv4, nv5); 
        da1.setChuNhiem(nv1);
        da2.setChuNhiem(nv3);
        da3.setChuNhiem(nv5);
        nv1.themTN(tn2, tn1);
        nv2.themTN(tn1);
        nv1.themDA(da1, da2, da3);
        nv1.themDA(da4, da5);    
        boolean isLoop = true;
        do {
            Config.menu();
            System.out.print("~> Nhap lua chon: ");
            switch (Integer.parseInt(Config.sc.nextLine())) {
                case 1 -> {
                   
                }
                case 2 -> {
                    
                }
                case 0 -> isLoop = false;
                default -> System.out.println("NHAP SAI !! VUI LONG NHAP LAI");
            }
        } while(isLoop);
    }
}
