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
    private List<DuAn> dsDA = new ArrayList<>();

    public QuanLyDuAn() {}
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
        return new DuAn(tenDuAn, ngayBD, ngayDKKT, tongKP);
    }
    public boolean isTonTai(DuAn da) {
        return this.dsDA.contains(da);
    }
    public void themDA(DuAn... da) {
        for (DuAn d: da)
            if (!isTonTai(d))
                this.dsDA.add(d);
    }
    
    public void sapXepDuAn() {
        this.dsDA.sort(Comparator.comparing(DuAn::getTongKinhPhi).thenComparing(DuAn::getTenDA));
        
    }
    public void hienThi() {
        this.sapXepDuAn();
        this.dsDA.stream().forEach(d -> System.out.println(d));
    }

    public void xoaDuAn(DuAn... d) {
        this.dsDA.removeAll(Arrays.asList(d));
    }

    public List<DuAn> timKiem(String tuKhoa) {
        return this.dsDA.stream().filter(d -> d.getTenDA().contains(tuKhoa) || d.getMaDA().contains(tuKhoa)).
            collect(Collectors.toList());
    }

    public List<DuAn> timKiem(Date ngay) {
        return this.dsDA.stream().filter(d -> d.getThoiDiemBatDau().equals(ngay)).collect(Collectors.toList());
    }
    
    // ================================= Getter Setter ===================================
    public List<DuAn> getDanhSachDuAn() {
        return dsDA;
    }

    public void setDanhSachDuAn(List<DuAn> danhSachDuAn) {
        this.dsDA = danhSachDuAn;
    }
}
