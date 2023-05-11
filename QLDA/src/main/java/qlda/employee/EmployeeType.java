package qlda.employee;


public enum EmployeeType {
    NHAN_VIEN_THUONG(1, 0) {
        @Override
        public String toString() {
            return "Nhan Vien Thuong";
        }
        
    },
    NHAN_VIEN_QUAN_LY(1.2, 0) {
        @Override
        public String toString() {
            return "Nhan Vien Quan Ly";
        }
    },
    LAP_TRINH_VIEN(1.5, 4000) {
        @Override
        public String toString() {
            return "Lap Trinh Vien";
        }
    },
    THIET_KE_VIEN(1.6, 2000) {
        @Override
        public String toString() {
            return "Thiet Ke Vien";
        }
    },
    KIEM_THU_VIEN(1.7, 20 * 200) {
        @Override
        public String toString() {
            return "Kiem Thu Vien";
        }
    };
    private double heSoLuong;
    private double phuCap;
    
    private EmployeeType(double heSoLuong, double phuCap) {
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }
    
    public double tinhLuongPhu(double luong){
        return luong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
}
