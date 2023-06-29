package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.SchoolRank;
import org.xidian.lichen.backend.service.SchoolRankService;

import java.util.List;

@RestController
@RequestMapping("/schoolrank")
public class SchoolRankController {
    @Autowired
    private SchoolRankService schoolRankService;

    @GetMapping("/science")
    public List<SchoolRank> getScienceRankByYearAndProvince(@RequestParam("year") String year,
                                                            @RequestParam("province_id") String province_id) {
        return schoolRankService.getScienceRankByYearAndProvince(year, province_id);
    }

    @GetMapping("/art")
    public List<SchoolRank> getArtRankByYearAndProvince(@RequestParam("year") String year,
                                                        @RequestParam("province_id") String province_id) {
        return schoolRankService.getArtRankByYearAndProvince(year, province_id);
    }
}
