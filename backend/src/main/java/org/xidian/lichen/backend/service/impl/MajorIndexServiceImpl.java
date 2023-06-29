package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.MajorIndexDao;
import org.xidian.lichen.backend.entity.MajorIndex;
import org.xidian.lichen.backend.service.MajorIndexService;

import java.util.List;

@Service
public class MajorIndexServiceImpl implements MajorIndexService {
    @Autowired
    private MajorIndexDao majorIndexDao;

    @Override
    public List<MajorIndex> listIndexBySchoolAndMajor(String school, String major) {
        return majorIndexDao.listIndexBySchoolAndMajor(school, major);
    }

    @Override
    public List<MajorIndex> listThousandIndexBySchoolAndMajor(String school, String major) {
        return majorIndexDao.listThousandIndexBySchoolAndMajor(school, major);
    }
}
