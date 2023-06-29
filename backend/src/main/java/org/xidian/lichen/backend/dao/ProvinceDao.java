package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.Province;

import java.util.List;

@Mapper
@Repository
public interface ProvinceDao {
    List<Province> listAll();

    Province getProvinceById(@Param("province_id") String province_id);

    Province getProvinceByName(@Param("province_name") String province_name);
}
