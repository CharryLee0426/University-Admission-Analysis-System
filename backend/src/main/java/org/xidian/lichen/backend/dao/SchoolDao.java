package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.School;

import java.util.List;

@Mapper
@Repository
public interface SchoolDao {
    List<School> listAll();

    List<School> list985();
    List<School> list211();
    List<School> listDoubleTopTier();

    List<School> listByProvince(@Param("province_id") String province_id);

    School getSchoolByName(@Param("school_name") String school_name);

    School getSchoolById(@Param("school_id") String school_id);
    List<School> searchSchoolsByStr(@Param("str") String str);
}
