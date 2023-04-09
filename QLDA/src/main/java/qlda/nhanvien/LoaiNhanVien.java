package qlda.nhanvien;


public enum LoaiNhanVien {
    NHAN_VIEN_THUONG {
        @Override
        public String getTypeName() {
            return "Nhan Vien Thường";
        }
    },
    NHAN_VIEN_QUAN_LY {
        @Override
        public String getTypeName() {
            return "Nhân Viên Quản Lý";
        }
    },
    LAP_TRINH_VIEN {
        @Override
        public String getTypeName() {
            return "Lập Trình Viên";
        }
    },
    THIET_KE_VIEN {
        @Override
        public String getTypeName() {
            return "Thiết Kế Viên";
        }
    },
    KIEM_THU_VIEN {
        @Override
        public String getTypeName() {
            return "Kiểm Thử Viên";
        }
    };
    
    public double tinhLuongPhu(double luong){
        return luong;
    }
    public abstract String getTypeName();
}
