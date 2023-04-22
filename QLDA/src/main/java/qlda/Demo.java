package qlda;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import qlda.config.Config;
import qlda.duan.DuAn;
import qlda.duan.QuanLyDuAn;
import qlda.nhanvien.KiemThuVien;
import qlda.nhanvien.LapTrinhVien;
import qlda.nhanvien.LoaiNhanVien;
import qlda.nhanvien.NhanVien;
import qlda.nhanvien.NhanVienQuanLy;
import qlda.nhanvien.NhanVienThuong;
import qlda.nhanvien.QuanLyNhanVien;
import qlda.nhanvien.ThietKeVien;
import qlda.phongban.PhongBan;
import qlda.phongban.QuanLyPhongBan;
import qlda.thannhan.ThanNhan;

public class Demo {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws ParseException {
        QuanLyNhanVien quanLyNhanVien = QuanLyNhanVien.getQlnv();
        QuanLyDuAn quanLyDuAn = QuanLyDuAn.getQlda();
        QuanLyPhongBan quanLyPhongBan = QuanLyPhongBan.getQlpb();
        
        PhongBan pb1 = new PhongBan("Phong Nhan Su");
        PhongBan pb2 = new PhongBan("Phong Cong Nghe Thong Tin");
        PhongBan pb3 = new PhongBan("Phong Ke Toan");
        PhongBan pb4 = new PhongBan("Phong An Ninh");
        PhongBan pb5 = new PhongBan("Phong Ke Kiem");
        
        
        NhanVien nv1 = new LapTrinhVien("Anh Tuan","20/3/2003", "Nam",  "at@", pb1, LoaiNhanVien.NHAN_VIEN_THUONG, 20);
        NhanVien nv2 = new KiemThuVien("Nguyen Mui","20/5/2003", "Nu", "huutu1098@gmail.com", pb2, LoaiNhanVien.KIEM_THU_VIEN, 39);
        NhanVien nv3 = new ThietKeVien("Nguyen Huu Tinh", "20/1/2006", "Nam", "tinh@gmail.com", pb1, LoaiNhanVien.NHAN_VIEN_QUAN_LY, 999);
        NhanVien nv4 = new NhanVienThuong("Nguyen Huu Tu","20/3/2008", "Nam", "huutu1098@gmail.com", pb3, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv5 = new ThietKeVien("Nguyen Huu Tu","20/3/2003", "Nam", "tuj293@gmail.com", pb5, LoaiNhanVien.THIET_KE_VIEN, 50);
        NhanVien nv6 = new NhanVienThuong("Tran Duc An","20/3/2008", "Nam", "an200@gmail.com", pb2, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv7 = new NhanVienThuong("Nguyen Manh","20/3/2008", "Nam", "huutu1098@gmail.com", pb1, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv8 = new NhanVienThuong("An Vy","22/4/2008", "NU", "huutu1098@gmail.com", pb4, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv9 = new NhanVienThuong("Hong Loc","12/3/2004", "Nam", "huutu1098@gmail.com", pb3, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv10 = new NhanVienThuong("Huy Vo","10/3/2001", "Nam", "huyvo@gmail.com", pb2, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv11 = new NhanVienThuong("Huy Dinh","30/3/2001", "Nam", "dinhuy@gmail.com", pb4, LoaiNhanVien.NHAN_VIEN_THUONG);
        NhanVien nv12 = new NhanVienThuong("Tuan Tran","1/3/2001", "Nam", "huu98@gmail.com", pb3, LoaiNhanVien.NHAN_VIEN_THUONG);
        
        
        DuAn da1 = new DuAn("Pha nha", "2/2/2020", "21/3/2023", 12120.44, nv5, nv2, nv3, nv6, nv8, nv1, nv7);
        DuAn da2 = new DuAn("Cai Tao Nha", "12/2/2012", "16/5/2012", 13020.11, nv1, nv8, nv6, nv4, nv5, nv2);
        DuAn da3 = new DuAn("Flow Chart", "2/12/2015", "3/3/2023", 15630.42, nv2, nv1, nv6, nv8, nv9, nv10);
        DuAn da4 = new DuAn("Riverside", "6/5/2012", "3/3/2023", 32100, nv3, nv1, nv7, nv9, nv4, nv12); 
        DuAn da5 = new DuAn("Cong trình TN", "15/2/2020", "2/12/2023", 22002, nv4, nv10, nv11, nv3, nv7, nv5);
        
        
        ThanNhan tn1 = new ThanNhan("Thao Van", "9/11/1979", "Nu", "Me");
        ThanNhan tn2 = new ThanNhan("Quoc Huy", "3/2/1998", "Nam", "Chu");
        ThanNhan tn3 = new ThanNhan("An Tien", "22/2/1989", "Nam", "Bac");
        ThanNhan tn4 = new ThanNhan("Ngoc Thuy", "12/4/1958", "Nu", "Ba noi");
        ThanNhan tn5 = new ThanNhan("Quoc Hung", "12/4/1951", "Nam", "Ong noi");
        
        quanLyNhanVien.themNhanVien(nv1, nv2, nv3, nv4, nv5, nv6, nv7, nv8, nv9, nv10, nv11, nv12);
        quanLyDuAn.themDA(da1, da2, da3, da4, da5);
        quanLyPhongBan.themPB(pb1, pb2, pb3);

        da1.setChuNhiem(nv1);
        da2.setChuNhiem(nv3);
        da3.setChuNhiem(nv5);
        da4.setChuNhiem(nv2);
        da5.setChuNhiem(nv4);
        
        nv1.themTN(tn2, tn1);
        nv2.themTN(tn1, tn2);
        nv2.themTN(tn3, tn2);
        nv4.themTN(tn3, tn2);
        nv5.themTN(tn4, tn3);
        
        
        boolean isLoop = true;
        do {
            Config.menu();
            System.out.print("~> Nhap lua chon: ");
            int option;
            try { option = Integer.parseInt(Config.sc.nextLine());}
            catch (NumberFormatException ex) {
                System.out.println("INVALID INPUT!");
                continue;
            }
            switch (option) {
                case 1 -> {
                    Config.menuQLNV();
                    System.out.print("~> Nhap lua chon: ");
                    switch (Integer.parseInt(Config.sc.nextLine())) {
                        case 1->{ 
                            System.out.println("== > Nhap Thong tin NV:");
                            NhanVien nv = quanLyNhanVien.nhapNhanVien(quanLyPhongBan);
                            quanLyNhanVien.themNhanVien(nv);
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
                            System.out.print("[1]Tim kiem theo Ho Ten / Ma Nhan Vien\n[2]Tim kiem nhan vien theo ngay sinh\n[3]Tim kiem nhan vien theo phong ban\n[4]Tim kiem nhan vien theo do tuoi\n~> Nhap lua chon:");
                            switch (Integer.parseInt(Config.sc.nextLine())) {
                                case 1->{
                                    System.out.print("Nhap ten nhan vien can tim:");
                                    String hoTen  = Config.sc.nextLine();
                                    List<NhanVien> kq = quanLyNhanVien.timKiem(hoTen);
                                    if(kq.isEmpty())
                                        System.out.println("Khong tim thay ten nhan vien");
                                    else {
                                        System.out.printf("%-7s%-20s%-12s%-5s%-20s%s\n", "Ma NV", "Ho Ten", "Ngay Sinh", "GT", "Loai NV", "Email");
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
                            else {
                                System.out.println("------- Danh sach THAN NHAN ------- ");
                                quanLyNhanVien.timKiem(maNV).get(0).hienThiTatCaThanNhan();
                            }
                        }
                        case 7->{
                            System.out.print("Nhap Ten nhan vien can hien thi danh sach du an:");
                            String kw = Config.sc.nextLine();
                            System.out.printf("%-7s%-20s%-16s%-18s%-13s%s\n", "Ma DA", "Ten DA", "Ngay BD", "Ngay KT", "Tong KP", "Chu Nhiem");
                            quanLyNhanVien.hienThiDSDA(kw);
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
                                DuAn da = quanLyDuAn.nhapDA(quanLyDuAn, quanLyNhanVien);
                                quanLyDuAn.themDA(da);
                                System.out.print("THANH CONG !! Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 2 -> {
                            do {
                                quanLyDuAn.hienThi();
                                System.out.print("~> MA DU AN CAN XOA: ");
                                List<DuAn> kq = quanLyDuAn.timKiem(Config.sc.nextLine());
                                if (!kq.isEmpty()) {
                                    quanLyDuAn.xoaDuAn(kq.get(0));
                                    System.out.println("XOA THANH CONG!");
                                }
                                else
                                    System.out.println("Khong tim thay du an !!");
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 3 -> {
                            do {
                                quanLyDuAn.hienThi();
                                System.out.print("~> MA DU AN CAN SUA: ");
                                String maDA = Config.sc.nextLine();
                                List<DuAn> kq = quanLyDuAn.timKiem(maDA.toUpperCase());
                                if (kq.isEmpty())
                                    System.out.println("Khong tim thay Du An");
                                else 
                                    quanLyDuAn.suaDA(kq.get(0));
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 4 -> {
                            System.out.print("~> Nhap Ma DA can xem DSNV: ");
                            String maDA = Config.sc.nextLine();
                            List<DuAn> kq = quanLyDuAn.timKiem(maDA);
                            if (kq.isEmpty())
                                System.out.println("Khong tim thay Du An!!");
                            else 
                                kq.get(0).hienThiDSNV();
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
                            if (!quanLyDuAn.ganChuNhiem(quanLyNhanVien, maDA, maNV))
                                System.out.println("!!!!!! DA CO CHU NHIEM !!!!!");
                        }
                        case 8 -> {
                            do {
                                System.out.print("~> Ma Du An Can Gan: ");
                                String maDA = Config.sc.nextLine();
                                List<DuAn> da = quanLyDuAn.timKiem(maDA);
                                if (da.isEmpty()) {
                                    System.out.println("Khong tim thay Du An");
                                }
                                else {
                                    System.out.print("~> Ma Nhan Vien: ");
                                    String maNV = Config.sc.nextLine();
                                    if (quanLyDuAn.ganNhanVien(da.get(0), quanLyNhanVien.timKiem(maNV).get(0)))
                                        System.out.println("Them Thanh Cong !!");
                                    else
                                        System.out.println("Vuot qua so Du An cua Nhan Vien !!");
                                }
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 9 -> {
                            quanLyDuAn.hienThi();
                        }
                        case 10 -> {
                            System.out.print("~> Ma Du An Can Xoa: ");
                            List<DuAn> kq = quanLyDuAn.timKiem(Config.sc.nextLine());
                            if (kq.isEmpty())
                                System.out.println("KHONG TIM THAY DU AN !!");
                            else {
                                kq.get(0).hienThiDSNV();
                                do {
                                    System.out.print("~> Ma Nhan Vien Can Xoa: ");
                                    List<NhanVien> nv = quanLyNhanVien.timKiem(Config.sc.nextLine());
                                    if (nv.isEmpty()) 
                                        System.out.println("NHAN VIEN KHONG TON TAI !!");
                                    else {
                                        kq.get(0).xoaNV(nv.get(0));
                                        nv.get(0).xoaDA(kq.get(0));
                                    }
                                    System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                                } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                            }
                        }
                        default -> System.out.println("NHAP SAI LUA CHON! QUAY VE MENU CHINH");
                    }
                }
                case 3 -> {
                    Config.menuQLPB();
                    System.out.print("~> Nhap lua chon: ");
                    switch (Integer.parseInt(Config.sc.nextLine())) {
                        case 1 -> {
                            do {
                                quanLyPhongBan.themPB(quanLyPhongBan.nhapPhongBan());
                                System.out.println("THEM THANH CONG!");
                                System.out.print("Tiep tuc ? \n[1] Co \n[2] Khong\n~> Lua chon: ");
                            } while (Integer.parseInt(Config.sc.nextLine()) == 1);
                        }
                        case 2 -> {
                            quanLyPhongBan.hienThi();
                            System.out.print("~> Ten Phong Ban Can Xem: ");
                            List<PhongBan> kq = quanLyPhongBan.timKiem(Config.sc.nextLine());
                            if (kq.isEmpty())
                                System.out.println("Khong tim thay Phong Ban");
                            else {
                                kq.get(0).hienThiDSNV();
                            }
                        }
                    }
                }
                case 0 -> isLoop = false;
                default -> System.out.println("NHAP SAI !! VUI LONG NHAP LAI");
            }
        } while(isLoop);
    }
}
