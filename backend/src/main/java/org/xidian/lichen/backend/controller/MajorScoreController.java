package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.MajorScore;
import org.xidian.lichen.backend.service.MajorScoreService;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorScoreController {
    @Autowired
    private MajorScoreService majorScoreService;

    @GetMapping("/list")
    public List<MajorScore> listMajorBySchoolIdProvinceIdYear(@RequestParam("school_id") String school_id,
                                                              @RequestParam("province_id") String province_id,
                                                              @RequestParam("year") String year) {
        return majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id, province_id, year);
    }
}
