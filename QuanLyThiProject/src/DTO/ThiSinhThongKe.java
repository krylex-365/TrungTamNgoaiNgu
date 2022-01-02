package DTO;

public class ThiSinhThongKe {
    private String mathisinh;
    private String tenthisinh;
    private String tentrinhdo;
    private String tenkhoathi;

    public String getMathisinh() {
        return mathisinh;
    }

    public void setMathisinh(String mathisinh) {
        this.mathisinh = mathisinh;
    }

    public String getTenthisinh() {
        return tenthisinh;
    }

    public void setTenthisinh(String tenthisinh) {
        this.tenthisinh = tenthisinh;
    }

    public String getTentrinhdo() {
        return tentrinhdo;
    }

    public void setTentrinhdo(String tentrinhdo) {
        this.tentrinhdo = tentrinhdo;
    }

    public String getTenkhoathi() {
        return tenkhoathi;
    }

    public void setTenkhoathi(String tenkhoathi) {
        this.tenkhoathi = tenkhoathi;
    }

    @Override
    public String toString() {
        return "ThiSinhThongKe{" +
                "mathisinh='" + mathisinh + '\'' +
                ", tenthisinh='" + tenthisinh + '\'' +
                ", tentrinhdo='" + tentrinhdo + '\'' +
                ", tenkhoathi='" + tenkhoathi + '\'' +
                '}';
    }
}
