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
    private static QuanLyDuAn qlda;
    private List<DuAn> dsDA = new ArrayList<>();

    static {
        qlda = new QuanLyDuAn();
    }
    private QuanLyDuAn() {}
    
    public DuAn nhapDA(QuanLyDuAn qlda, QuanLyNhanVien qlnv) throws ParseException
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
        List<DuAn> kq = qlda.timKiem(tenDuAn);
        if (kq.isEmpty())
            return new DuAn(tenDuAn, ngayBD, ngayDKKT, tongKP, qlnv);
        System.out.println("DA CO DU AN NAY !!!");
        return kq.get(0);
    }
    public boolean isTonTaiDA(DuAn da) {
        return this.dsDA.contains(da);
    }
    public void themDA(DuAn... da) {
        for (DuAn d: da)
            if (!isTonTaiDA(d))
                this.dsDA.add(d);
    }
    
    public void xoaDuAn(String maDA) {
        DuAn temp = timKiem(maDA).get(0);
        temp.getDsNVThamGia().forEach(nv -> {
            nv.xoaDA(temp);
        });
        dsDA.remove(temp);
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
    
    public boolean ganNhanVien(DuAn da, NhanVien nv) {
        if (nv.isFullDA())
            return false;
        da.themNV(nv);
        return true;
    }
    // ================================= Getter Setter ===================================
    public List<DuAn> getDanhSachDuAn() {
        return dsDA;
    }
    public void setDanhSachDuAn(List<DuAn> danhSachDuAn) {
        this.dsDA = danhSachDuAn;
    }

    public static QuanLyDuAn getQlda() {
        return qlda;
    }
}
