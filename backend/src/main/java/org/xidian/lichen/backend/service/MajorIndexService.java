package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.entity.MajorIndex;

import java.util.List;

public interface MajorIndexService {
    List<MajorIndex> listIndexBySchoolAndMajor(String school_name, String major);

    List<MajorIndex> listThousandIndexBySchoolAndMajor(String school_name, String major);
}
