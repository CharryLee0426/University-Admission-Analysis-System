package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.SchoolDao;
import org.xidian.lichen.backend.entity.School;
import org.xidian.lichen.backend.service.SchoolService;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public List<School> listAll() {
        return schoolDao.listAll();
    }

    @Override
    public List<School> list985() {
        return schoolDao.list985();
    }

    @Override
    public List<School> list211() {
        return schoolDao.list211();
    }

    @Override
    public List<School> listDoubleTopTier() {
        return schoolDao.listDoubleTopTier();
    }

    @Override
    public List<School> listByProvince(String province_id) {
        return schoolDao.listByProvince(province_id);
    }

    @Override
    public School getSchoolByName(String school_name) {
        return schoolDao.getSchoolByName(school_name);
    }

    @Override
    public School getSchoolById(String school_id) {
        return schoolDao.getSchoolById(school_id);
    }

    @Override
    public List<School> searchSchoolsByStr(String str) {
        return schoolDao.searchSchoolsByStr(str);
    }
}
