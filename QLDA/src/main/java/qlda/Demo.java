package qlda;

import java.text.ParseException;
import qlda.config.Config;
import qlda.duan.DuAn;
import qlda.nhanvien.KiemThuVien;
import qlda.nhanvien.LapTrinhVien;
import qlda.nhanvien.LoaiNhanVien;
import qlda.nhanvien.NhanVien;
import qlda.phongban.PhongBan;
import qlda.thannhan.ThanNhan;

public class Demo {
    public static void main(String[] args) throws ParseException {
        NhanVien nv1 = new LapTrinhVien("Anh Tuan ","20/3/2003", "Nam",  "at@",  LoaiNhanVien.LAP_TRINH_VIEN, 20);
        NhanVien nv2 = new KiemThuVien("Nguyen huu Tu ","20/3/2003", "Nam", "huutu1098@gmail.com", LoaiNhanVien.KIEM_THU_VIEN, 39);
        
//        PhongBan pb1 = new PhongBan("An Ninh");
//        DuAn da1 = new DuAn("Pha nha", "2/2/2022", "3/3/2023", 1200.1, nv2);
//        DuAn da2 = new DuAn("Xay Nha", "2/2/2022", "3/3/2023", 1200.1, nv1);
//        DuAn da3 = new DuAn("Ok", "2/2/2022", "3/3/2023", 1200.1, nv1);
//        
//        nv1.themDA(da2);
//        nv1.themDA(da2, da1, da3);
//        System.out.println("Các du an NV1 tham gia: ");
//        nv1.hienThiDuAnThamGia();
        
        ThanNhan tn1 = new ThanNhan("Thao Van", "2/2/2022", "Nu", "Nguoi yeu");
        ThanNhan tn2 = new ThanNhan("Quoc Huy", "3/2/2022", "Nam", "Nguoi yeu");
        ThanNhan tn3 = new ThanNhan("An Tien", "22/2/2022", "Nam", "Nguoi yeu");
        
        nv1.themTN(tn1);
        nv1.themTN(tn1, tn1, tn2, tn2, tn3);
        System.out.println("\nNguoi than cua NV1:");
        nv1.hienThiTatCaThanNhan();
    }
}
