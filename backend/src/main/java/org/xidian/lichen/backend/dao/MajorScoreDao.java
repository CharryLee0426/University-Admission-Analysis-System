package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.MajorScore;

import java.util.List;

@Mapper
@Repository
public interface MajorScoreDao {
    public List<MajorScore> listMajorBySchoolIdProvinceIdYear(@Param("school_id") String school_id,
                                                              @Param("province_id") String province_id,
                                                              @Param("year") String year);
}
