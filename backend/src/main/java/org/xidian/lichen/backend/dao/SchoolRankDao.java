package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.SchoolRank;

import java.util.List;

@Mapper
@Repository
public interface SchoolRankDao {
    List<SchoolRank> getScienceRankByYearAndProvince(@Param("year") String year, @Param("province_id") String province_id);

    List<SchoolRank> getArtRankByYearAndProvince(@Param("year") String year, @Param("province_id") String province_id);
}
