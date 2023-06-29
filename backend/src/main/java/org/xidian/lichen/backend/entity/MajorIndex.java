package org.xidian.lichen.backend.entity;

public class MajorIndex {
    private String year;
    private double major_index;

    public MajorIndex(String year, double major_index) {
        this.year = year;
        this.major_index = major_index;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMajor_index() {
        return major_index;
    }

    public void setMajor_index(double major_index) {
        this.major_index = major_index;
    }
}
