package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.entity.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> listAll();

    Province getProvinceById(String province_id);

    Province getProvinceByName(String province_name);
}
