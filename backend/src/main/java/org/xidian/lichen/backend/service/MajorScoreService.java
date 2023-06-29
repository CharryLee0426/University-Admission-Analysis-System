package org.xidian.lichen.backend.service;

import org.apache.ibatis.annotations.Param;
import org.xidian.lichen.backend.entity.MajorScore;

import java.util.List;

public interface MajorScoreService {
    public List<MajorScore> listMajorBySchoolIdProvinceIdYear(String school_id,
                                                              String province_id,
                                                              String year);
}
