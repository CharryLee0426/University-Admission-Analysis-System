package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.MajorScoreDao;
import org.xidian.lichen.backend.entity.MajorScore;
import org.xidian.lichen.backend.service.MajorScoreService;

import java.util.List;

@Service
public class MajorScoreServiceImpl implements MajorScoreService {
    @Autowired
    private MajorScoreDao majorScoreDao;

    @Override
    public List<MajorScore> listMajorBySchoolIdProvinceIdYear(String school_id, String province_id, String year) {
        return majorScoreDao.listMajorBySchoolIdProvinceIdYear(school_id, province_id, year);
    }
}
