package org.xidian.lichen.backend.entity;

public class MajorScore {
    private int id;
    private String year;
    private String province_id;
    private String school_id;
    private String group_id;
    private String level_id;
    private String level;
    private String category_id;
    private String category;
    private String class_id;
    private String class_name;
    private String majorcategory_id;
    private String majorcategory;
    private String major;
    private double lowest;
    private int lowest_rank;

    private String degree_id;
    private String degree;
    private String selection;
    private String is_selection;

    public MajorScore(int id,
                      String year,
                      String province_id,
                      String school_id,
                      String group_id,
                      String level_id,
                      String level,
                      String category_id,
                      String category,
                      String class_id,
                      String class_name,
                      String majorcategory_id,
                      String majorcategory,
                      String major,
                      double lowest,
                      int lowest_rank,
                      String degree_id,
                      String degree,
                      String selection,
                      String is_selection) {
        this.id = id;
        this.year = year;
        this.province_id = province_id;
        this.school_id = school_id;
        this.group_id = group_id;
        this.level_id = level_id;
        this.level = level;
        this.category_id = category_id;
        this.category = category;
        this.class_id = class_id;
        this.class_name = class_name;
        this.majorcategory_id = majorcategory_id;
        this.majorcategory = majorcategory;
        this.major = major;
        this.lowest = lowest;
        this.lowest_rank = lowest_rank;
        this.degree_id = degree_id;
        this.degree = degree;
        this.selection = selection;
        this.is_selection = is_selection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getMajorcategory_id() {
        return majorcategory_id;
    }

    public void setMajorcategory_id(String majorcategory_id) {
        this.majorcategory_id = majorcategory_id;
    }

    public String getMajorcategory() {
        return majorcategory;
    }

    public void setMajorcategory(String majorcategory) {
        this.majorcategory = majorcategory;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getLowest() {
        return lowest;
    }

    public void setLowest(double lowest) {
        this.lowest = lowest;
    }

    public int getLowest_rank() {
        return lowest_rank;
    }

    public void setLowest_rank(int lowest_rank) {
        this.lowest_rank = lowest_rank;
    }

    public String getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(String degree_id) {
        this.degree_id = degree_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getIs_selection() {
        return is_selection;
    }

    public void setIs_selection(String is_selection) {
        this.is_selection = is_selection;
    }
}
