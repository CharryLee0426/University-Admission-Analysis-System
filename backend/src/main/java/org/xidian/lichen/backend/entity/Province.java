package org.xidian.lichen.backend.entity;

public class Province {
    private String province_id;
    private String province_name;

    public Province(String province_id, String province_name) {
        this.province_id = province_id;
        this.province_name = province_name;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }
}
