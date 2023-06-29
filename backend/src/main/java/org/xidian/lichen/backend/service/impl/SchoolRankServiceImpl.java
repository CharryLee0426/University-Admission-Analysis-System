package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.SchoolRankDao;
import org.xidian.lichen.backend.entity.SchoolRank;
import org.xidian.lichen.backend.service.SchoolRankService;

import java.util.List;

@Service
public class SchoolRankServiceImpl implements SchoolRankService {
    @Autowired
    private SchoolRankDao schoolRankDao;

    @Override
    public List<SchoolRank> getScienceRankByYearAndProvince(String year, String province_id) {
        return schoolRankDao.getScienceRankByYearAndProvince(year, province_id);
    }

    @Override
    public List<SchoolRank> getArtRankByYearAndProvince(String year, String province_id) {
        return schoolRankDao.getArtRankByYearAndProvince(year, province_id);
    }
}
