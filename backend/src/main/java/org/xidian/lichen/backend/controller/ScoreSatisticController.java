package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.ScoreStatistic;
import org.xidian.lichen.backend.service.ScoreStatisticService;

import java.util.List;

@RestController
@RequestMapping("/scorestatistic")
public class ScoreSatisticController {
    @Autowired
    private ScoreStatisticService scoreStatisticService;

    @GetMapping("/science")
    public List<ScoreStatistic> listScienceByYearAndProvince(@RequestParam("year")String year, @RequestParam("province_id") String province_id) {
        return scoreStatisticService.listScienceByYearAndProvince(year, province_id);
    }

    @GetMapping("/art")
    public List<ScoreStatistic> listArtByYearAndProvince(@RequestParam("year")String year, @RequestParam("province_id") String province_id) {
        return scoreStatisticService.listArtByYearAndProvince(year, province_id);
    }
}
