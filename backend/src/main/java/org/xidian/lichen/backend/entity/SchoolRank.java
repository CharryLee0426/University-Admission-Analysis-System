package org.xidian.lichen.backend.entity;

public class SchoolRank {
    private String school_name;
    private double school_rank;

    public SchoolRank(String school_name, double school_rank) {
        this.school_name = school_name;
        this.school_rank = school_rank;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public double getSchool_rank() {
        return school_rank;
    }

    public void setSchool_rank(double school_rank) {
        this.school_rank = school_rank;
    }
}
