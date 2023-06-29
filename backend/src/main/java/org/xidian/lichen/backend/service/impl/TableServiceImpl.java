package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.entity.*;
import org.xidian.lichen.backend.service.*;
import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private MajorScoreService majorScoreService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private SchoolRankService schoolRankService;
    @Autowired
    private MajorIndexService majorIndexService;

    @Autowired
    private StudentService studentService;

    @Override
    public void generateMajorTable(MicrosoftDocxGenerator generator, String school_id, String province_id, String year) {
        List<MajorScore> majorScores = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id, province_id, year);
        School school = schoolService.getSchoolById(school_id);

        try {
            generator.addTable(9, new String[]{"学校名称", "学校级别", "招生类别", "专业类别", "所属大类", "专业名称", "最低分", "最低位次", "备注"});
            for (MajorScore majorScore : majorScores) {
                generator.addTableItem(new String[]{school.getSchool_name(),
                                                    majorScore.getLevel(),
                                                    majorScore.getCategory(),
                                                    majorScore.getClass_name(),
                                                    majorScore.getMajorcategory(),
                                                    majorScore.getMajor(),
                                                    String.valueOf(majorScore.getLowest()),
                                                    String.valueOf(majorScore.getLowest_rank()),
                                                    majorScore.getSelection()});
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateScienceSchoolRankTable(MicrosoftDocxGenerator generator, String year, String province_id) {
        List<SchoolRank> schoolRanks = schoolRankService.getScienceRankByYearAndProvince(year, province_id);

        try {
            int count = 1;
            generator.addTable(3, new String[]{"名次", "学校名称", "平均录取位次"});
            for (SchoolRank schoolRank : schoolRanks) {
                generator.addTableItem(new String[]{String.valueOf(count),
                                                    schoolRank.getSchool_name(),
                                                    String.valueOf(schoolRank.getSchool_rank())});
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateArtSchoolRankTable(MicrosoftDocxGenerator generator, String year, String province_id) {
        List<SchoolRank> schoolRanks = schoolRankService.getArtRankByYearAndProvince(year, province_id);

        try {
            int count = 1;
            generator.addTable(3, new String[]{"名次", "学校名称", "平均录取位次"});
            for (SchoolRank schoolRank : schoolRanks) {
                generator.addTableItem(new String[]{String.valueOf(count),
                                                    schoolRank.getSchool_name(),
                                                    String.valueOf(schoolRank.getSchool_rank())});
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorIndexTable(MicrosoftDocxGenerator generator, String school_id, String major) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorIndex> majorIndices = majorIndexService.listIndexBySchoolAndMajor(school.getSchool_name(), major);

        try {
            generator.addTable(2, new String[]{"年份", "全国平均排名"});
            for (MajorIndex majorIndex : majorIndices) {
                generator.addTableItem(new String[]{majorIndex.getYear(), String.valueOf(majorIndex.getMajor_index())});
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorThousandIndexTable(MicrosoftDocxGenerator generator, String school_id, String major) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorIndex> majorIndices = majorIndexService.listThousandIndexBySchoolAndMajor(school.getSchool_name(), major);

        try {
            generator.addTable(2, new String[]{"年份", "千量指数"});
            for (MajorIndex majorIndex : majorIndices) {
                generator.addTableItem(new String[]{majorIndex.getYear(), String.valueOf(majorIndex.getMajor_index())});
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateStudentMajorRate(MicrosoftDocxGenerator generator,
                                         String school_id,
                                         String province_id,
                                         String year) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorScore> majors = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id, province_id, year);

        try {
            generator.addTable(2, new String[]{"专业名称", "按专业录取率"});
            for (MajorScore majorScore : majors) {
                Student student = studentService.getStudentByMajorId(majorScore.getId());
                generator.addTableItem(new String[]{majorScore.getMajor(), String.valueOf(student.getMajor_rate())});
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateStudentMajorStat(MicrosoftDocxGenerator generator,
                                         String school_id,
                                         String province_id,
                                         String year) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorScore> majors = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id, province_id, year);

        try {
            generator.addTable(4, new String[]{"专业名称", "总人数", "男性比例", "女性比例"});
            for (MajorScore majorScore : majors) {
                Student student = studentService.getStudentByMajorId(majorScore.getId());
                generator.addTableItem(new String[]{
                        majorScore.getMajor(),
                        String.valueOf(student.getTotal_number()),
                        String.valueOf(student.getMajor_rate()),
                        String.valueOf(student.getFemale_rate())});
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
