package qlda;

import java.text.ParseException;
import qlda.config.Config;
import qlda.nhanvien.LapTrinhVien;
import qlda.nhanvien.LoaiNhanVien;
import qlda.nhanvien.NhanVien;
public class Demo {

    public static void main(String[] args) throws ParseException {
        NhanVien nv1 = new LapTrinhVien("20/3/2003", "Anh Tuan ", "at@", "Nam", LoaiNhanVien.LAP_TRINH_VIEN, 20);
        System.out.println(nv1.tinhLuong());
    }
}
