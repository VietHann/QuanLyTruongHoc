package model;

/**
 * Sở hữu Vie - Xem thôi đừng copy
 */
public class GiaoVien extends Person {

    private String maGV;
    private String monDay;

    public GiaoVien(String maGV, String tenGV, String ngaySinh, String monDay) {
        super(ngaySinh);
        this.maGV = maGV;
        this.monDay = monDay;
    }

    public String layMaGV() {
        return maGV;
    }

    public void datMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String layMonDay() {
        return monDay;
    }

    public void datMonDay(String monDay) {
        this.monDay = monDay;
    }

    @Override
    public String toString() {
        return "GiaoVien{"
                + "maGV='" + maGV + '\''
                + ", ngaySinh='" + ngaySinh + '\''
                + ", monDay='" + monDay + '\''
                + '}';
    }
}
