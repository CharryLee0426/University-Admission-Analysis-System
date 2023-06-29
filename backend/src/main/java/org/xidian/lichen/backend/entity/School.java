package org.xidian.lichen.backend.entity;

public class School {
    private int id;
    private String province_id;
    private String school_id;
    private String school_name;
    private String school_type;
    private String school_level;
    private boolean is_985;
    private boolean is_211;
    private boolean is_doubletoptier;

    public School(int id, String province_id,
                  String school_id,
                  String school_name,
                  String school_type,
                  String school_level,
                  boolean is_985,
                  boolean is_211,
                  boolean is_doubletoptier) {
        this.id = id;
        this.province_id = province_id;
        this.school_id = school_id;
        this.school_name = school_name;
        this.school_type = school_type;
        this.school_level = school_level;
        this.is_985 = is_985;
        this.is_211 = is_211;
        this.is_doubletoptier = is_doubletoptier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_type() {
        return school_type;
    }

    public void setSchool_type(String school_type) {
        this.school_type = school_type;
    }

    public String getSchool_level() {
        return school_level;
    }

    public void setSchool_level(String school_level) {
        this.school_level = school_level;
    }

    public boolean isIs_985() {
        return is_985;
    }

    public void setIs_985(boolean is_985) {
        this.is_985 = is_985;
    }

    public boolean isIs_211() {
        return is_211;
    }

    public void setIs_211(boolean is_211) {
        this.is_211 = is_211;
    }

    public boolean isIs_doubletoptier() {
        return is_doubletoptier;
    }

    public void setIs_doubletoptier(boolean is_doubletoptier) {
        this.is_doubletoptier = is_doubletoptier;
    }
}
