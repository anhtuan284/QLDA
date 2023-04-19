package qlda.nhanvien;

import java.text.ParseException;


public class KiemThuVien extends NhanVien{
    private double nError;

    public KiemThuVien(String hoTen, String ngaySinh, String gioiTinh, String email, LoaiNhanVien loaiNV, double nError) throws ParseException {
        super(hoTen, ngaySinh, gioiTinh, email, loaiNV);
        this.nError = nError;
    }

    @Override
    public double layHeSo() {
        return 1.4;
    }

    @Override
    public double layPhuCap() {
        return this.nError * 200;
    }

    // =============================== GETTER SETTER =============================
    public double getnError() {
        return nError;
    }

    public void setnError(double nError) {
        this.nError = nError;
    }
}
