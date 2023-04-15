package qlda.config;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Config {
    public static final Scanner sc = new Scanner(System.in);
    public static SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyy");
    
    
   // ================ CONST ======================
    public static final double soDuAnToiDa = 3;
    public static final double soNhanVienToiDa = 10;
    public static final double soNhanVienToiThieu = 5;
    
    public static void menu() {
        System.out.println("========================= MENU =============================");
        System.out.println("| [1]: Quan ly nhan vien                                   |");
        System.out.println("| [2]: Quan ly du an                                       |");
        System.out.println("| [0]: Thoat                                               |");
        System.out.println("============================================================");
    }
    
    public static void menuQLNV() {
        System.out.println("==================== Quan Ly Nhan Vien =====================");
        System.out.println("| [1]: Nhap Nhan vien");
        System.out.println("| [2]: Xoa Nhan vien");
        System.out.println("| [3]: Hien thi bang luong");
        System.out.println("| [4]: Hien danh sach Nhan Vien");
        System.out.println("| [5]: Tim kiem Nhan Vien");
        System.out.println("| [6]: Danh sach Than Nhan");
        System.out.println("| [7]: Danh sach Du An Nhan Vien Tham Gia");
        System.out.println("| [0]: Thoat ra MENU Chinh");
        System.out.println("============================================================");
    }
    
    public static void menuQLDA() {
        System.out.println("==================== Quan Ly Du An ====================");
        System.out.println("| [1]: Nhap Du An");
        System.out.println("| [2]: Xoa Du An");
        System.out.println("| [3]: Sua Du An");
        System.out.println("| [4]: Hien danh sach Nhan Vien cua Du An");
        System.out.println("| [5]: Tim kiem Du An");
        System.out.println("| [6]: Sap xep theo tong kinh phi");
        System.out.println("| [7]: Gan Chu Nhiem Du An");
        System.out.println("| [8]: Gan Nhan Vien tham gia Du An");
        System.out.println("| [9]: Hien thi danh sach Du An hien tai");
        System.out.println("| [0]: Thoat ra MENU Chinh");
        System.out.println("============================================================");
    }
}
