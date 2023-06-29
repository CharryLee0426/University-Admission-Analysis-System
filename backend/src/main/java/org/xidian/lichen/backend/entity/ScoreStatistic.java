package org.xidian.lichen.backend.entity;

public class ScoreStatistic {
    private String year;
    private String province_id;
    private String group_id;
    private int score;
    private int number_in_this_score;
    private int number_not_less_than_this_score;

    public ScoreStatistic(String year,
                          String province_id,
                          String group_id,
                          int score,
                          int number_in_this_score,
                          int number_not_less_than_this_score) {
        this.year = year;
        this.province_id = province_id;
        this.group_id = group_id;
        this.score = score;
        this.number_in_this_score = number_in_this_score;
        this.number_not_less_than_this_score = number_not_less_than_this_score;
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

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber_in_this_score() {
        return number_in_this_score;
    }

    public void setNumber_in_this_score(int number_in_this_score) {
        this.number_in_this_score = number_in_this_score;
    }

    public int getNumber_not_less_than_this_score() {
        return number_not_less_than_this_score;
    }

    public void setNumber_not_less_than_this_score(int number_not_less_than_this_score) {
        this.number_not_less_than_this_score = number_not_less_than_this_score;
    }
}
