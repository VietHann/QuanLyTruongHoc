package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sở hữu Vie - Xem thôi đừng copy
 */
public class Person {

    protected String ngaySinh;

    public Person(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String layNgaySinh() {
        return ngaySinh;
    }

    public void datNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    protected Date chuyenChuoiSangNgay() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(ngaySinh);
    }

    public int layTuoi() {
        try {
            Date ngaySinhDate = chuyenChuoiSangNgay();
            Date ngayHienTai = new Date();
            long soNgay = ngayHienTai.getTime() - ngaySinhDate.getTime();
            return (int) (soNgay / (1000L * 60 * 60 * 24 * 365));
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Person{"
                + "ngaySinh='" + ngaySinh + '\''
                + '}';
    }
}
