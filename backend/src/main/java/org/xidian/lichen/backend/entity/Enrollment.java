package org.xidian.lichen.backend.entity;

public class Enrollment {
    private String year;
    private String province_id;
    private double enrollment;

    public Enrollment(String year, String province_id, double enrollment) {
        this.year = year;
        this.province_id = province_id;
        this.enrollment = enrollment;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public double getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(double enrollment) {
        this.enrollment = enrollment;
    }
}
