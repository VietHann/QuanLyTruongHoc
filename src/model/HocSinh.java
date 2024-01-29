package model;

public class HocSinh extends Person {

    private String maSV;
    private String tenSV;
    private String lop;
    private double diem;

    public HocSinh(String maSV, String tenSV, String ngaySinh, String lop) {
        super(ngaySinh);
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Student{"
                + "maSV='" + maSV + '\''
                + ", ngaySinh='" + ngaySinh + '\''
                + ", lop='" + lop + '\''
                + ", diem=" + diem
                + '}';
    }
}
