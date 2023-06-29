package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.ScoreStatisticDao;
import org.xidian.lichen.backend.entity.ScoreStatistic;
import org.xidian.lichen.backend.service.ScoreStatisticService;

import java.util.List;

@Service
public class ScoreStatisticServiceImpl implements ScoreStatisticService {
    @Autowired
    private ScoreStatisticDao scoreStatisticDao;

    @Override
    public List<ScoreStatistic> listScienceByYearAndProvince(String year, String province_id) {
        return scoreStatisticDao.listScienceByYearAndProvince(year, province_id);
    }

    @Override
    public List<ScoreStatistic> listArtByYearAndProvince(String year, String province_id) {
        return scoreStatisticDao.listArtByYearAndProvince(year, province_id);
    }
}
