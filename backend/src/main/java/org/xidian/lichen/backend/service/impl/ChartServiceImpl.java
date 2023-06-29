package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.entity.MajorIndex;
import org.xidian.lichen.backend.entity.MajorScore;
import org.xidian.lichen.backend.entity.School;
import org.xidian.lichen.backend.entity.Student;
import org.xidian.lichen.backend.service.*;
import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    private MajorIndexService majorIndexService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorScoreService majorScoreService;

    @Override
    public void generateMajorIndexBarChart(MicrosoftDocxGenerator generator,
                                           String school_id,
                                           String major,
                                           String title,
                                           String xTitle,
                                           String yTitle,
                                           String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorIndex> majorIndices = majorIndexService.listIndexBySchoolAndMajor(school.getSchool_name(), major);

        String[] xAxisData = new String[majorIndices.size()];
        Double[] yAxisData = new Double[majorIndices.size()];

        int i = 0;
        for (MajorIndex majorIndex : majorIndices) {
            xAxisData[i] = majorIndex.getYear();
            yAxisData[i] = majorIndex.getMajor_index();
            i++;
        }

        try {
            generator.addDoubleBar(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorIndexLineChart(MicrosoftDocxGenerator generator,
                                            String school_id,
                                            String major,
                                            String title,
                                            String xTitle,
                                            String yTitle,
                                            String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorIndex> majorIndices = majorIndexService.listIndexBySchoolAndMajor(school.getSchool_name(), major);

        String[] xAxisData = new String[majorIndices.size()];
        Double[] yAxisData = new Double[majorIndices.size()];

        int i = 0;
        for (MajorIndex majorIndex : majorIndices) {
            xAxisData[i] = majorIndex.getYear();
            yAxisData[i] = majorIndex.getMajor_index();
            i++;
        }

        try {
            generator.addDoubleLine(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorThousandIndexBarChart(MicrosoftDocxGenerator generator,
                                                   String school_id,
                                                   String major,
                                                   String title,
                                                   String xTitle,
                                                   String yTitle,
                                                   String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorIndex> majorIndices = majorIndexService.listThousandIndexBySchoolAndMajor(school.getSchool_name(), major);

        String[] xAxisData = new String[majorIndices.size()];
        Double[] yAxisData = new Double[majorIndices.size()];

        int i = 0;
        for (MajorIndex majorIndex : majorIndices) {
            xAxisData[i] = majorIndex.getYear();
            yAxisData[i] = majorIndex.getMajor_index();
            i++;
        }

        try {
            generator.addDoubleBar(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorThousandIndexLineChart(MicrosoftDocxGenerator generator,
                                                    String school_id,
                                                    String major,
                                                    String title,
                                                    String xTitle,
                                                    String yTitle,
                                                    String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorIndex> majorIndices = majorIndexService.listThousandIndexBySchoolAndMajor(school.getSchool_name(), major);

        String[] xAxisData = new String[majorIndices.size()];
        Double[] yAxisData = new Double[majorIndices.size()];

        int i = 0;
        for (MajorIndex majorIndex : majorIndices) {
            xAxisData[i] = majorIndex.getYear();
            yAxisData[i] = majorIndex.getMajor_index();
            i++;
        }

        try {
            generator.addDoubleLine(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorRateBarChart(MicrosoftDocxGenerator generator,
                                          String school_id,
                                          String province_id,
                                          String year,
                                          String title,
                                          String xTitle,
                                          String yTitle,
                                          String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorScore> majorScores = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id,
                province_id, year);

        String[] xAxisData = new String[majorScores.size()];
        Double[] yAxisData = new Double[majorScores.size()];

        int i = 0;
        for (MajorScore majorScore : majorScores) {
            Student student = studentService.getStudentByMajorId(majorScore.getId());
            xAxisData[i] = majorScore.getMajor();
            yAxisData[i] = student.getMajor_rate();
            i++;
        }

        try {
            generator.addDoubleBar(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorTotalBarChart(MicrosoftDocxGenerator generator,
                                           String school_id,
                                           String province_id,
                                           String year,
                                           String title,
                                           String xTitle,
                                           String yTitle,
                                           String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorScore> majorScores = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id,
                province_id, year);

        String[] xAxisData = new String[majorScores.size()];
        Integer[] yAxisData = new Integer[majorScores.size()];

        int i = 0;
        for (MajorScore majorScore : majorScores) {
            Student student = studentService.getStudentByMajorId(majorScore.getId());
            xAxisData[i] = majorScore.getMajor();
            yAxisData[i] = student.getTotal_number();
            i++;
        }

        try {
            generator.addIntBar(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorTotalPieChart(MicrosoftDocxGenerator generator,
                                           String school_id,
                                           String province_id,
                                           String year,
                                           String title,
                                           String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorScore> majorScores = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id,
                province_id, year);

        String[] xAxisData = new String[majorScores.size()];
        Integer[] yAxisData = new Integer[majorScores.size()];

        int i = 0;
        for (MajorScore majorScore : majorScores) {
            Student student = studentService.getStudentByMajorId(majorScore.getId());
            xAxisData[i] = majorScore.getMajor();
            yAxisData[i] = student.getTotal_number();
            i++;
        }

        try {
            generator.addIntPie(title, xAxisData, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void generateMajorGenderRateBarChart(MicrosoftDocxGenerator generator,
                                                String school_id,
                                                String province_id,
                                                String year,
                                                String title,
                                                String xTitle,
                                                String yTitle,
                                                String legendTitle) {
        School school = schoolService.getSchoolById(school_id);
        List<MajorScore> majorScores = majorScoreService.listMajorBySchoolIdProvinceIdYear(school_id,
                province_id, year);

        String[] xAxisData = new String[2 * majorScores.size()];
        Double[] yAxisData = new Double[2 * majorScores.size()];

        int i = 0;
        for (MajorScore majorScore : majorScores) {
            Student student = studentService.getStudentByMajorId(majorScore.getId());
            xAxisData[i] = majorScore.getMajor().substring(0, 2)+ "...男";
            yAxisData[i] = student.getMale_rate();
            i++;
            xAxisData[i] = majorScore.getMajor().substring(0, 2) + "...女";
            yAxisData[i] = student.getFemale_rate();
            i++;
        }

        try {
            generator.addDoubleBar(title, xTitle, xAxisData, yTitle, yAxisData, legendTitle);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
