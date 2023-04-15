package qlda;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
        
        NhanVien nv1 = new LapTrinhVien("Anh Tuan","20/3/2003", "Nam",  "at@",  20);
        NhanVien nv2 = new KiemThuVien("Nguyen haha","20/5/2003", "Nam", "huutu1098@gmail.com", 39);
        NhanVien nv3 = new NhanVienQuanLy("Nguyen Huu Tinh", "20/1/2001", "Nam", "tinh@gmail.com", "20/12/2022");
        NhanVien nv4 = new NhanVienThuong("Nguyen huu Tu","20/3/2003", "Nam", "huutu1098@gmail.com");
        NhanVien nv5 = new ThietKeVien("Nguyen huu Tu","20/3/2003", "Nam", "huutu1098@gmail.com", 50);
        PhongBan pb1 = new PhongBan("Phong Nhan Su");
        PhongBan pb2 = new PhongBan("Phong Cong Nghe Thong Tin");
        PhongBan pb3 = new PhongBan("Phong Ke Toan");
        PhongBan pb4 = new PhongBan("Phong An Ninh");
        PhongBan pb5 = new PhongBan("Phong Ke Kiem");
        DuAn da1 = new DuAn("Pha nha", "2/2/2022", "3/3/2023", 120.1);
        DuAn da2 = new DuAn("Xay Nha", "2/2/2022", "3/3/2023", 1300.1);
        DuAn da3 = new DuAn("Ok", "2/2/2022", "3/3/2023", 1560.1);
        DuAn da4 = new DuAn("Riverside", "2/2/2022", "3/3/2023", 3200.1);
        DuAn da5 = new DuAn("Cong trình thanh nien", "2/2/2022", "3/3/2023", 2200.1);
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
            int option;
            try {
                option = Integer.parseInt(Config.sc.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.println("INPUT INVALID!");
                continue;
            }
            switch (option) {
                case 1 -> {
                    Config.menuQLNV();
                    System.out.print("~> Nhap lua chon: ");
                    switch (Integer.parseInt(Config.sc.nextLine())) {
                        case 1->{ 
                            System.out.println("== > Nhap Thong tin NV:");
                            NhanVien nv = quanLyNhanVien.nhapNhanVien();
                            quanLyNhanVien.themNhanVien(nv);
                            System.out.println("Phong ban can them: \n[1]: Tao phong ban moi\n[2]: Phong ban hien co");
                            PhongBan pb = null;
                            switch (Integer.parseInt(Config.sc.nextLine())) {
                                case 1 -> {
                                    pb = quanLyPhongBan.nhapPhongBan();
                                    quanLyPhongBan.themPB(pb);
                                    pb.themNV(nv);
                                }
                                case 2 -> {
                                    quanLyPhongBan.hienThi();
                                    System.out.print("~> Nhap ten phong ban: ");
                                    List<PhongBan>kq = quanLyPhongBan.timKiem(Config.sc.nextLine());
                                    if (kq.isEmpty())
                                        System.out.println("Khong tim thay phong ban");
                                    else
                                        kq.get(0).themNV(nv);
                                }
                                default -> System.out.println("Nhap Sai lua chon:");
                            }
                            System.out.print("+ Them Than Nhan ?\n [1] Co\n [2] Khong\n~> Lua chon: ");
                            switch (Integer.parseInt(Config.sc.nextLine())) {
                                case 1:
                                    System.out.println("- Nhap thong tin than nhan: ");
                                    do {
                                        System.out.print("Ho ten: ");
                                        String hoTen = Config.sc.nextLine();
                                        System.out.print("Ngay sinh: ");
                                        String ngaySinh = Config.sc.nextLine();
                                        System.out.print("Gioi tinh: ");
                                        String gioiTinh = Config.sc.nextLine();
                                        System.out.print("Moi quan he: ");
                                        String moiQuanHe = Config.sc.nextLine();
                                        nv.themTN(new ThanNhan(hoTen, ngaySinh, gioiTinh, moiQuanHe));
                                        System.out.print("THEM Than Nhan ? \n[1] Co [2]Khong\n ~> Lua chon:");
                                    } while (Integer.parseInt(Config.sc.nextLine())!= 2);
                                case 2: break;
                                default: break;
                            }
                            System.out.println("Nhap NHAN VIEN THANH CONG");
                        }
                        case 2->{
                            quanLyNhanVien.hienThi();
                            System.out.print("Nhap ma nhan vien can xoa:");
                            String maNV = Config.sc.nextLine();
                            quanLyNhanVien.xoaNhanVien(quanLyNhanVien.timKiem(maNV).get(0));
                            System.out.println("Xoa thanh cong");
                        }
                        case 3->{
                            ///hamtinh luong dau anhtuan
                            quanLyNhanVien.BangLuongNV();
                            System.out.println();
                        }
                        case 4->{
                            quanLyNhanVien.hienThi();
                        }
                        case 5->{
                            System.out.print("[1]Tim kiem nhan vien theo ho ten\n[2]Tim kiem nhan vien theo ngay sinh\n[3]Tim kiem nhan vien theo phong ban\n[4]Tim kiem nhan vien theo do tuoi\n~> Nhap lua chon:");
                            switch (Integer.parseInt(Config.sc.nextLine())) {
                                case 1->{
                                    System.out.print("Nhap ten nhan vien can tim:");
                                    String hoTen  = Config.sc.nextLine();
                                    List<NhanVien> kq = quanLyNhanVien.timKiem(hoTen);
                                    if(kq.isEmpty())
                                        System.out.println("Khong tim thay ten nhan vien");
                                    else {
                                        System.out.printf("%-7s%-20s%-12s%-5s%s", "Ma NV", "Ho Ten", "Ngay Sinh", "GT", "Email");
                                        quanLyNhanVien.timKiem(hoTen).stream().forEach(nv -> System.out.println(nv));
                                    }
                                }
                                case 2->{
                                    System.out.print("Nhap ngay sinh nhan vien can tim:");
                                    Date ngaySinh = Config.f.parse(Config.sc.nextLine());
                                    if(quanLyNhanVien.timKiem(ngaySinh).isEmpty())
                                        System.out.println("Khong tim thay ten nhan vien");
                                    else
                                        quanLyNhanVien.timKiem(ngaySinh).stream().forEach(nv -> System.out.println(nv));
                                }
                                case 3->{
                                    System.out.print("Nhap ten phong ban cua nhan vien can tim:");
                                    String phongBan = Config.sc.nextLine();
                                    List<NhanVien> nv = quanLyNhanVien.timKiem(quanLyPhongBan, phongBan);
                                    if(nv.isEmpty())
                                         System.out.println("Khong tim thay ten nhan vien");
                                    else
                                    quanLyNhanVien.timKiem(quanLyPhongBan, phongBan).forEach(System.out :: println); 
                                }
                                case 4 -> {
                                    System.out.print("Nhap khoang do tuoi\n + Min: ");
                                    int min = Integer.parseInt(Config.sc.nextLine());
                                    System.out.print("+ Max: ");
                                    int max = Integer.parseInt(Config.sc.nextLine());
                                    List<NhanVien> kq = quanLyNhanVien.timKiem(min, max);
                                    if(kq.isEmpty())
                                        System.out.println("Khong tim thay nhan vien");
                                    else
                                        kq.forEach(System.out :: println);
                                }
                            }
                        }
                        case 6->{
                            System.out.print("Nhap ma nhan vien can hien thi danh sach than nhan:");
                            String maNV = Config.sc.nextLine();
                            if(quanLyNhanVien.timKiem(maNV) == null)
                                    System.out.println("Khong tim thay ten nhan vien");
                            else
                                    quanLyNhanVien.timKiem(maNV).get(0).hienThiTatCaThanNhan();
                        }
                        case 7->{
                            System.out.print("Nhap Ten nhan vien can hien thi danh sach du an:");
                            String tenNV = Config.sc.nextLine();
                            NhanVien kq = quanLyNhanVien.timKiem(tenNV).get(0);
                            if(kq == null)
                                System.out.println("Khong tim thay ten nhan vien");
                            else {
                               System.out.printf("%-7s%-20s%-16s%-18s%-13s%s\n", "Ma DA", "Ten DA", "Ngay BD", "Ngay KT", "Tong KP", "Chu Nhiem");
                               kq.hienThiDuAnThamGia();
                            }
                        }
                   }   
                }
                
// ============================================ QLDA ===============================================
                case 2 -> {
                    Config.menuQLDA();
                    System.out.print("~> Nhap lua chon: ");
                    switch (Integer.parseInt(Config.sc.nextLine())) {
                        case 1 -> {
                            do {
                                quanLyDuAn.themDA(quanLyDuAn.nhapDA());
                                System.out.println("THEM THANH CONG!");
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 2 -> {
                            do {
                                quanLyDuAn.hienThi();
                                System.out.print("~> MA DU AN CAN XOA: ");
                                String maDA = Config.sc.nextLine();
                                quanLyDuAn.xoaDuAn(quanLyDuAn.timKiem(maDA).get(0));
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 3 -> {
                            do {
                                quanLyDuAn.hienThi();
                                System.out.print("~> MA DU AN CAN SUA: ");
                                String maDA = Config.sc.nextLine();
                                quanLyDuAn.suaDA(quanLyDuAn.timKiem(maDA.toUpperCase()).get(0));
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 4 -> {
                            System.out.print("~> Nhap Ma DA can xem DSNV: ");
                            String maDA = Config.sc.nextLine().toUpperCase();
                            quanLyDuAn.timKiem(maDA).get(0).hienThiDSNV();
                        }
                        case 5 -> {
                            System.out.print("[1] Tim kiem theo Ten DU AN\n[2] Tim kiem theo Ngay Bat Dau\n~> Lua chon:");
                            switch (Integer.parseInt(Config.sc.nextLine())) {
                                case 1 -> {
                                    System.out.print("~> Ten Du An muon tim: ");
                                    String tenDA = Config.sc.nextLine();
                                    if (quanLyDuAn.timKiem(tenDA).isEmpty())
                                        System.out.println("KHONG TIM THAY DU AN NAO");
                                    else {
                                        quanLyDuAn.timKiem(tenDA).stream().forEach(System.out:: println);
                                    }
                                }
                                case 2 -> {
                                    System.out.print("~> Ngay bat dau Du An muon tim:: ");
                                    Date ngayBD = Config.f.parse(Config.sc.nextLine());
                                    System.out.println("\n=== DANH SACH DU AN TIM THAY ===");
                                    if (quanLyDuAn.timKiem(ngayBD).isEmpty())
                                        System.out.println("KHONG TIM THAY DU AN NAO");
                                    else {
                                        quanLyDuAn.timKiem(ngayBD).stream().forEach(System.out :: println);
                                    }
                                }
                            }
                        }
                        case 6 -> {
                            System.out.println("Danh sach sau khi sap xep theo TONG KINH PHI Giam dan");
                            quanLyDuAn.sapXepDuAn();
                            quanLyDuAn.hienThi();
                        }
                        case 7 -> {
                            System.out.print("~> Ma Du An Can Gan: ");
                            String maDA = Config.sc.nextLine();
                            System.out.print("~> Ma Nhan Vien Chu Nhiem: ");
                            String maNV = Config.sc.nextLine();
                            quanLyDuAn.ganChuNhiem(quanLyNhanVien, maDA, maNV);
                        }
                        case 8 -> {
                            System.out.print("~> Ma Du An Can Gan: ");
                            String maDA = Config.sc.nextLine().toUpperCase();
                            System.out.print("~> Ma Nhan Vien: ");
                            String maNV = Config.sc.nextLine().toUpperCase();
                            quanLyDuAn.ganNhanVien(quanLyNhanVien, maDA, maNV);
                        }
                        case 9 -> {
                            quanLyDuAn.hienThi();
                        }
                        default -> System.out.println("NHAP SAI LUA CHON! QUAY VE MENU CHINH");
                    }
                }
                case 0 -> isLoop = false;
                default -> System.out.println("NHAP SAI !! VUI LONG NHAP LAI");
            }
        } while(isLoop);
    }
}
