package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.MajorIndex;

import java.util.List;

@Mapper
@Repository
public interface MajorIndexDao {
    List<MajorIndex> listIndexBySchoolAndMajor(@Param("school_name") String school, @Param("major") String major);

    List<MajorIndex> listThousandIndexBySchoolAndMajor(@Param("school_name") String school,
                                                       @Param("major") String major);
}
