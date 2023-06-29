package org.xidian.lichen.backend.service;

import org.apache.ibatis.annotations.Param;
import org.xidian.lichen.backend.entity.ScoreStatistic;

import java.util.List;

public interface ScoreStatisticService {
    public List<ScoreStatistic> listScienceByYearAndProvince(String year, String province_id);
    public List<ScoreStatistic> listArtByYearAndProvince(String year, String province_id);
}
