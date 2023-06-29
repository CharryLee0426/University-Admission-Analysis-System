package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.ScoreStatistic;

import java.util.List;

@Mapper
@Repository
public interface ScoreStatisticDao {
    public List<ScoreStatistic> listScienceByYearAndProvince(@Param("year") String year, @Param("province_id") String province_id);
    public List<ScoreStatistic> listArtByYearAndProvince(@Param("year") String year, @Param("province_id") String province_id);
}
