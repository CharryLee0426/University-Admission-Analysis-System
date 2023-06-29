package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.entity.SchoolRank;

import java.util.List;

public interface SchoolRankService {
    List<SchoolRank> getScienceRankByYearAndProvince(String year, String province_id);

    List<SchoolRank> getArtRankByYearAndProvince(String year, String province_id);
}
