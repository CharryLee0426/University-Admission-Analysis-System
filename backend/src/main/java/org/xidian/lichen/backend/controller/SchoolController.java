package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.School;
import org.xidian.lichen.backend.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/list")
    public List<School> listAll() {
        return schoolService.listAll();
    }

    @GetMapping("/list985")
    public List<School> list985() {
        return schoolService.list985();
    }

    @GetMapping("/list211")
    public List<School> list211() {
        return schoolService.list211();
    }

    @GetMapping("/listDoubleTopTier")
    public List<School> listDoubleTopTier() {
        return schoolService.listDoubleTopTier();
    }

    @GetMapping("/listByProvince")
    public List<School> listByProvince(@RequestParam("province_id") String province_id) {
        return schoolService.listByProvince(province_id);
    }

    @GetMapping("/getSchoolByName")
    public School getSchoolByName(@RequestParam("school_name") String school_name) {
        return schoolService.getSchoolByName(school_name);
    }

    @GetMapping("/searchSchoolsByStr")
    public List<School> searchSchoolsByStr(@RequestParam("str") String str) {
        return schoolService.searchSchoolsByStr(str);
    }
}
