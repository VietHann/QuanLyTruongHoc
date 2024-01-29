package model;

/**
 * Sở hữu Vie - Xem thôi đừng copy
 */
public class Student {
    private String maSV;
    private String tenSV;
    private String ngaySinh;
    private String lop;
    private double diem;

    public Student(String maSV, String tenSV, String ngaySinh, String lop) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public double getDiem() {
        return diem;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Student{" +
                "maSV='" + maSV + '\'' +
                ", tenSV='" + tenSV + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", lop='" + lop + '\'' +
                ", diem=" + diem +
                '}';
    }
}
