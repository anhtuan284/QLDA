package qlda.duan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import qlda.config.Config;

public class QuanLyDuAn{
    private List<DuAn> dsDuAn = new ArrayList<>();

    public DuAn nhapDA() throws ParseException
    {
        System.out.print("\nTen du an: ");
        String tenDuAn = Config.sc.nextLine();
        System.out.print("Ngay bat dau du an: ");
        String ngayBD = Config.sc.nextLine();
        System.out.print("Ngay du kien ket thuc du an: ");
        String ngayDKKT = Config.sc.nextLine();
        System.out.print("Tong kinh phi dau tu: ");
        double tongKP = Config.sc.nextDouble();
        Config.sc.nextLine();
        return new DuAn(tenDuAn, ngayBD, ngayDKKT, tongKP, null);
    }
    
    public void sapXepDuAn() {
        this.dsDuAn.sort(Comparator.comparing(DuAn::getTongKinhPhi));
        
    }
    public void sapXepDuAn2() {
        this.dsDuAn.sort(Comparator.comparing(DuAn::getTongKinhPhi).thenComparing(DuAn::getTenDA));
        
    }
    public void hienThi() {
        this.sapXepDuAn();
        this.dsDuAn.stream().forEach(d -> System.out.println(d));
    }

    public void themDuAn(DuAn... d) {
        this.dsDuAn.addAll(Arrays.asList(d));
    }

    public void xoaDuAn(DuAn... d) {
        this.dsDuAn.removeAll(Arrays.asList(d));
    }

    public List<DuAn> timKiem(String tuKhoa) {
        return this.dsDuAn.stream().filter(d -> d.getTenDA().contains(tuKhoa) || d.getMaDA().contains(tuKhoa)).
            collect(Collectors.toList());
    }

    public List<DuAn> timKiem(Date ngay) {
        return this.dsDuAn.stream().filter(d -> d.getThoiDiemBatDau().equals(ngay)).collect(Collectors.toList());
    }
    // void hiển thị danh sách nhân viên...
     public List<DuAn> getDanhSachDuAn() {
        return dsDuAn;
    }

    public void setDanhSachDuAn(List<DuAn> danhSachDuAn) {
        this.dsDuAn = danhSachDuAn;
    }
}
