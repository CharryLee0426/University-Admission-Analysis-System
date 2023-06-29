package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.entity.School;

import java.util.List;

public interface SchoolService {
    List<School> listAll();

    List<School> list985();
    List<School> list211();
    List<School> listDoubleTopTier();

    List<School> listByProvince(String province_id);

    School getSchoolByName( String school_name);

    School getSchoolById( String school_id);
    List<School> searchSchoolsByStr(String str);
}
