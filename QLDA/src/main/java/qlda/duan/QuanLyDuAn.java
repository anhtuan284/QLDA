package qlda.duan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import qlda.config.Config;
import qlda.nhanvien.NhanVien;
import qlda.nhanvien.QuanLyNhanVien;

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
    public boolean isTonTaiDA(DuAn da) {
        return this.dsDA.contains(da);
    }
    public void themDA(DuAn... da) {
        for (DuAn d: da)
            if (!isTonTaiDA(d))
                this.dsDA.add(d);
    }
    
    public void xoaDuAn(DuAn... d) {
        this.dsDA.removeAll(Arrays.asList(d));
    }
    
    public void suaDA(DuAn da) throws ParseException {
        System.out.println("Thong tin can sua: \n[1]: Ten Du An\n[2]: Thoi Diem Bat Dau\n[3]: Thoi Diem Ket Thuc\n[4]: Tong Kinh Phi");
        switch (Integer.parseInt(Config.sc.nextLine())) {
            case 1 -> {
                System.out.print("Ten du an: ");
                da.setTenDA(Config.sc.nextLine());
            }
            case 2 -> {
                System.out.print("Thoi gian bat dau: ");
                da.setThoiDiemBatDau(Config.f.parse(Config.sc.nextLine()));
            }
            case 3 -> {
                System.out.print("Thoi gian ket thuc: ");
                da.setThoiDiemKetThuc(Config.f.parse(Config.sc.nextLine()));
            }
            case 4 -> {
                System.out.print("Tong kinh phi: ");
                da.setTongKinhPhi(Double.parseDouble(Config.sc.nextLine()));
            }
            default -> System.out.println("Nhap sai lua chon!\nSUA THONG TIN THAT BAI!"); 
        }
        System.out.println("SUA THONG TIN THANH CONG !");
    }
    
    public void sapXepDuAn() {
        this.dsDA.sort(Comparator.comparing(DuAn::getTongKinhPhi).reversed());
    }
    
    public void hienThi() {
        this.dsDA.stream().forEach(System.out :: println);
    }


    public List<DuAn> timKiem(String tuKhoa) {
        return this.dsDA.stream()
                .filter(d -> d.getTenDA().equalsIgnoreCase(tuKhoa) || d.getMaDA().equalsIgnoreCase(tuKhoa))
                .collect(Collectors.toList());
    }

    public List<DuAn> timKiem(Date ngay) {
        return this.dsDA.stream()
                .filter(d -> d.getThoiDiemBatDau().equals(ngay))
                .collect(Collectors.toList());
    }
    
    public boolean ganChuNhiem(QuanLyNhanVien qlnv, String maDA, String maNV) {
        return this.timKiem(maDA).get(0).themCN(qlnv.timKiem(maNV).get(0));
    }
    public void ganNhanVien(QuanLyNhanVien qlnv, String maDA, String maNV) {
        NhanVien nv = qlnv.timKiem(maNV).get(0);
        DuAn da = timKiem(maDA).get(0);
        da.themNV(nv);
        nv.themDA(da);
    }
    // ================================= Getter Setter ===================================
    public List<DuAn> getDanhSachDuAn() {
        return dsDA;
    }
    public void setDanhSachDuAn(List<DuAn> danhSachDuAn) {
        this.dsDA = danhSachDuAn;
    }
}
