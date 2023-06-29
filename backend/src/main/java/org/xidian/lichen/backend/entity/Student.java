package org.xidian.lichen.backend.entity;

public class Student {
    private int major_id;
    private double major_rate;
    private int male_number;
    private int female_number;
    private int total_number;
    private double male_rate;
    private double female_rate;

    public Student(int major_id, double major_rate, int male_number, int female_number) {
        this.major_id = major_id;
        this.major_rate = major_rate;
        this.male_number = male_number;
        this.female_number = female_number;
        this.total_number = this.male_number + this.female_number;
        this.male_rate = (double) this.male_number / this.total_number;
        this.female_rate = (double) this.female_number / this.total_number;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public double getMajor_rate() {
        return major_rate;
    }

    public void setMajor_rate(double major_rate) {
        this.major_rate = major_rate;
    }

    public int getMale_number() {
        return male_number;
    }

    public void setMale_number(int male_number) {
        this.male_number = male_number;
    }

    public int getFemale_number() {
        return female_number;
    }

    public void setFemale_number(int female_number) {
        this.female_number = female_number;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public double getMale_rate() {
        return male_rate;
    }

    public void setMale_rate(double male_rate) {
        this.male_rate = male_rate;
    }

    public double getFemale_rate() {
        return female_rate;
    }

    public void setFemale_rate(double female_rate) {
        this.female_rate = female_rate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major_id=" + major_id +
                ", major_rate=" + major_rate +
                ", male_number=" + male_number +
                ", female_number=" + female_number +
                ", total_number=" + total_number +
                ", male_rate=" + male_rate +
                ", female_rate=" + female_rate +
                '}';
    }
}
