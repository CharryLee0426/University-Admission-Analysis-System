package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.MajorScore;
import org.xidian.lichen.backend.entity.Province;
import org.xidian.lichen.backend.entity.School;
import org.xidian.lichen.backend.entity.Student;
import org.xidian.lichen.backend.service.MajorScoreService;
import org.xidian.lichen.backend.service.ProvinceService;
import org.xidian.lichen.backend.service.SchoolService;
import org.xidian.lichen.backend.service.StudentService;
import org.xidian.lichen.backend.util.RandomNumberGenerator;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorScoreService majorScoreService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/insert")
    public String insert() {
        // ~ 32s
        School schools = schoolService.getSchoolByName("西安电子科技大学");
        List<Province> provinces = provinceService.listAll();

        for (Province province : provinces) {
            List<MajorScore> majorScores = majorScoreService.listMajorBySchoolIdProvinceIdYear(schools.getSchool_id(),
                    province.getProvince_id(), "2021");

            for (MajorScore majorScore : majorScores) {
                Student student = new Student(majorScore.getId(),
                                    RandomNumberGenerator.randDoubleInRange(0, 1),
                                    RandomNumberGenerator.randIntInRange(40, 60),
                                    RandomNumberGenerator.randIntInRange(40, 60));
                studentService.insertStudent(student);
            }
        }
        return "success";
    }
}
