package qlda.phongban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qlda.config.Config;

public class QuanLyPhongBan {
    private static QuanLyPhongBan qlpb;
    List<PhongBan> dsPB = new ArrayList<>();

    static {
        qlpb = new QuanLyPhongBan();
    }
    private QuanLyPhongBan() {}
    
    public PhongBan nhapPhongBan() {
        System.out.print("Ten phong ban: ");
        String tenPB =Config.sc.nextLine();
        return new PhongBan(tenPB);
    }

    public boolean isTonTaiPB(PhongBan pb) {
        return this.dsPB.contains(pb);
    }
    public void hienThi() {
        this.dsPB.stream().forEach(System.out :: println);
    }

    public void themPB(PhongBan... pbs) {
        for (PhongBan pb : pbs)
            if (!isTonTaiPB(pb))
                this.dsPB.addAll(Arrays.asList(pb));
    }

    public List<PhongBan> timKiem(String kw) {
        return this.dsPB.stream()
                .filter(pb -> pb.getTenPB().equalsIgnoreCase(kw))
                .collect(Collectors.toList());
    }
       
    // ============================== Getter Setter =====================================
    public List<PhongBan> getDanhSachPhongBan() {
        return dsPB;
    }

    public void setDanhSachPhongBan(List<PhongBan> danhSachPhongBan) {
        this.dsPB = danhSachPhongBan;
    }

    public static QuanLyPhongBan getQlpb() {
        return qlpb;
    }
}
