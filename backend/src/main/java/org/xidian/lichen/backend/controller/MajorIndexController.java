package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.MajorIndex;
import org.xidian.lichen.backend.service.MajorIndexService;

import java.util.List;

@RestController
@RequestMapping("/majorindex")
public class MajorIndexController {
    @Autowired
    private MajorIndexService majorIndexService;

    @GetMapping("/list/index")
    public List<MajorIndex> listIndexBySchoolAndMajor(@RequestParam("school_name") String school,
                                                      @RequestParam("major") String major) {
        return majorIndexService.listIndexBySchoolAndMajor(school, major);
    }

    @GetMapping("/list/thousand")
    public List<MajorIndex> listThousandIndexBySchoolAndMajor(@RequestParam("school_name") String school,
                                                              @RequestParam("major") String major) {
        return majorIndexService.listThousandIndexBySchoolAndMajor(school, major);
    }
}
