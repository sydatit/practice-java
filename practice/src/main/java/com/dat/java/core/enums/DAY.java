package com.dat.java.core.enums;

public enum DAY {
    MONDAY("Thứ hai"),
    TUESDAY("Thứ ba"),
    WEDNESDAY("Thứ tư"),
    THURSDAY("Thứ năm"),
    FRIDAY("Thứ sáu"),
    SATURDAY("Thứ bảy"),
    SUNDAY("Chủ nhật");


    private String vietnameseName;

    public String getVietnameseName() {
        return this.vietnameseName;
    }

    public void setVietnameseName(String vietnameseName) {
        this.vietnameseName = vietnameseName;
    }

    DAY(String vietnameseName) {
        this.vietnameseName = vietnameseName;
    }

    public static String getVietnameseNameByEnumName(String name) {
        for (DAY day : DAY.values()) {
            if (day.name().equalsIgnoreCase(name)) {
                return day.getVietnameseName();
            }
        }
        return null; // Nếu không tìm thấy
    }
}
