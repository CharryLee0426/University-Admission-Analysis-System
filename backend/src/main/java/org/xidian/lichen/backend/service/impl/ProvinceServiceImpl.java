package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.ProvinceDao;
import org.xidian.lichen.backend.entity.Province;
import org.xidian.lichen.backend.service.ProvinceService;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceDao provinceDao;

    @Override
    public List<Province> listAll() {
        return provinceDao.listAll();
    }

    @Override
    public Province getProvinceById(String province_id) {
        return provinceDao.getProvinceById(province_id);
    }

    @Override
    public Province getProvinceByName(String province_name) {
        return provinceDao.getProvinceByName(province_name);
    }
}
