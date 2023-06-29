package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.entity.MajorIndex;
import org.xidian.lichen.backend.entity.Province;
import org.xidian.lichen.backend.entity.School;
import org.xidian.lichen.backend.service.*;
import org.xidian.lichen.backend.util.GPTUtil;
import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

import java.util.List;

@Service
public class DocxServiceImpl implements DocxService {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private TableService tableService;
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private ChartService chartService;

    @Autowired
    private MajorIndexService majorIndexService;

    @Override
    public void generateMajorPara(MicrosoftDocxGenerator generator, String name, String year) {
        School school = schoolService.getSchoolByName(name);
        generator.addHeading("全国招生专业信息统计");
        List<Province> provinces = provinceService.listAll();
        for (Province province : provinces) {
            if (province.getProvince_name().equals("香港") || province.getProvince_name().equals("澳门")) {
                continue;
            } else {
                generator.addSubHeading(province.getProvince_name());

                generator.addParagraph("{} 在 [] 招收学生。详细见下表。"
                        .replace("{}", name)
                        .replace("[]", province.getProvince_name()));
                tableService.generateMajorTable(generator, school.getSchool_id(), province.getProvince_id(), year);

                generator.addQuote(year + " 年数据");
                generator.addParagraph("");
            }
        }
    }

    @Override
    public void generateSchoolRankPara(MicrosoftDocxGenerator generator, String name, String year) {
        School school = schoolService.getSchoolByName(name);

        generator.addHeading("分省\"二一一\"招生平均位次排名");

        List<Province> provinces = provinceService.listAll();

        for (Province province : provinces) {
            if (province.getProvince_name().equals("香港") || province.getProvince_name().equals("澳门")) {
                continue;
            } else {
                generator.addParagraph("理工类");
                tableService.generateScienceSchoolRankTable(generator, year, province.getProvince_id());

                generator.addParagraph("");

                generator.addParagraph("文史类");
                tableService.generateArtSchoolRankTable(generator, year, province.getProvince_id());

                generator.addParagraph("");
            }
        }
    }

    @Override
    public void generateMajorIndexPara(MicrosoftDocxGenerator generator, String school_name, String major, boolean isGPT) {
        School school = schoolService.getSchoolByName(school_name);
        List<MajorIndex> majorIndices = majorIndexService.listIndexBySchoolAndMajor(school_name, major);

        generator.addHeading("热门专业全国平均排名");

        generator.addParagraph("\"全国平均排名\"指数 是根据历史经验总结的一个适用于分析学校招收热门专业的指标。对于分析招生工作效果十分有参考意义。");
        generator.addParagraph("\"全国平均排名\"指数的趋势可以看出某学校专业的受欢迎程度。通常来说，该指标值越低越好（该值越低说明排名越靠前）。如果该值呈现下降趋势说明该专业正在越来越受欢迎。");

        generator.addQuote("全国平均排名指数 = 各省专业最低排位的平均值");

        generator.addSubHeading(major);

        tableService.generateMajorIndexTable(generator, school.getSchool_id(), major);

        generator.addParagraph("下面是该专业全国平均排名的图表");

        generator.addParagraph("");

        generator.addParagraph("条形图 📊");

        chartService.generateMajorIndexBarChart(generator,
                                                school.getSchool_id(),
                                                major,
                                                school.getSchool_name() + major + "专业全国平均排名统计",
                                            "年份",
                                            "全国平均排名",
                                            "全国平均排名");

        generator.addParagraph("");

        generator.addParagraph("折线图 📉");

        chartService.generateMajorIndexLineChart(generator,
                school.getSchool_id(),
                major,
                school.getSchool_name() + major + "专业全国平均排名趋势",
                "年份",
                "全国平均排名",
        "全国平均排名");

        if (isGPT) {
            String prompt = "\"全国平均排名\"指数 是根据历史经验总结的一个适用于分析学校招收热门专业的指标。对于分析招生工作效果十分有参考意义。 " +
                    "\"全国平均排名\"指数的趋势可以看出某学校专业的受欢迎程度。通常来说，该指标值越低越好（该值越低说明排名越靠前）。如果该值呈现下降趋势说明该专业正在越来越受欢迎。" +
                    "“全国平均排名指数“的定义是”全国平均排名指数 = 各省专业最低排位的平均值“。" +
                    "{}[]专业的“全国平均排名” 分别是: "
                            .replace("{}", school_name)
                            .replace("[]", major);
            String requirement = "。请你用生动的语言对这些数据进行分析并得出一些趋势和结论。";
            String data = "";

            for (MajorIndex majorIndex : majorIndices) {
                data = data + "{}年[]  ".replace("{}",majorIndex.getYear())
                        .replace("[]", String.valueOf(majorIndex.getMajor_index()));
            }

            prompt = prompt + data + requirement;

            System.out.println(prompt);

            GPTUtil gptUtil = new GPTUtil();

            String response = gptUtil.getAnswer(prompt);

            generator.addParagraph(response);

            generator.addParagraph("");
        }

        generator.addParagraph("");
    }

    @Override
    public void generateMajorThousandIndexPara(MicrosoftDocxGenerator generator, String school_name, String major, boolean isGPT) {
        School school = schoolService.getSchoolByName(school_name);
        List<MajorIndex> majorThousandIndices = majorIndexService.listThousandIndexBySchoolAndMajor(school_name, major);

        generator.addHeading("热门专业\"千量指数\"");

        generator.addParagraph("\"千量指数\"指数 是根据历史经验总结的一个适用于分析学校招收热门专业的指标。对于分析招生工作效果十分有参考意义。");
        generator.addParagraph("\"千量指数\"指数的趋势可以看出某学校专业的招生学院的稳定程度。通常来说，该指标值越低说明该专业招收学生的生源质量更稳定");

        generator.addQuote("千量指数 = （各省专业排位的最大值-最小值）/1,000");

        generator.addSubHeading(major);

        tableService.generateMajorThousandIndexTable(generator, school.getSchool_id(), major);

        generator.addParagraph("下面是该专业千量指数图表");

        generator.addParagraph("");

        generator.addParagraph("条形图 📊");

        chartService.generateMajorThousandIndexBarChart(generator,
                school.getSchool_id(),
                major,
                school.getSchool_name() + major + "专业千量指数统计",
                "年份",
                "千量指数",
                "千量指数");

        generator.addParagraph("");

        generator.addParagraph("折线图 📉");

        chartService.generateMajorThousandIndexLineChart(generator,
                school.getSchool_id(),
                major,
                school.getSchool_name() + major + "专业千量指数趋势",
                "年份",
                "千量指数",
                "千量指数");

        generator.addParagraph("");

        if (isGPT) {
            String prompt = "\"千量指数\"指数 是根据历史经验总结的一个适用于分析学校招收热门专业的指标。对于分析招生工作效果十分有参考意义。 " +
                    "\"千量指数\"指数的趋势可以看出某学校专业的招生学院的稳定程度。通常来说，该指标值越低说明该专业招收学生的生源质量更稳定。" +
                    "“千量指数“的定义是”（各省该专业招录最低分的最大值-各省该专业招录最低分的最小值）/ 1000“。" +
                    "{}[]专业的“千量指数” 分别是: "
                            .replace("{}", school_name)
                            .replace("[]", major);
            String requirement = "。请你用生动的语言对这些数据进行分析并得出一些趋势和结论。";
            String data = "";

            for (MajorIndex majorIndex : majorThousandIndices) {
                data = data + "{}年[]  ".replace("{}",majorIndex.getYear())
                        .replace("[]", String.valueOf(majorIndex.getMajor_index()));
            }

            prompt = prompt + data + requirement;

            System.out.println(prompt);

            GPTUtil gptUtil = new GPTUtil();

            String response = gptUtil.getAnswer(prompt);

            generator.addParagraph(response);

            generator.addParagraph("");
        }
    }

    @Override
    public void generateStudentMajorRatePara(MicrosoftDocxGenerator generator,
                                             String name,
                                             String year) {
        School school = schoolService.getSchoolByName(name);
        generator.addHeading("全国招生专业信息统计");
        List<Province> provinces = provinceService.listAll();

        for (Province province : provinces) {
            if (province.getProvince_name().equals("香港") || province.getProvince_name().equals("澳门")) {
                continue;
            } else {
                generator.addSubHeading(province.getProvince_name());

                generator.addParagraph("{} 在 [] 招收专业录取率统计表。"
                        .replace("{}", name)
                        .replace("[]", province.getProvince_name()));
                tableService.generateStudentMajorRate(generator, school.getSchool_id(), province.getProvince_id(), year);

                generator.addQuote(year + " 年数据");
                generator.addParagraph("");

                generator.addParagraph("各专业招收录取率统计图。");

                chartService.generateMajorRateBarChart(generator,
                        school.getSchool_id(),
                        province.getProvince_id(),
                        year,
                        "专业录取率统计柱状图",
                        "专业名称",
                        "按志愿录取率",
                        "专业名词"
                        );

                generator.addParagraph("");

                generator.addParagraph("{} 在 [] 招收专业录取学生统计数据表。"
                        .replace("{}", name)
                        .replace("[]", province.getProvince_name())
                );

                tableService.generateStudentMajorStat(generator, school.getSchool_id(), province.getProvince_id(), year);

                generator.addQuote(year + " 年数据");
                generator.addParagraph("");

                generator.addParagraph("录取人数总量图。");

                chartService.generateMajorTotalBarChart(generator,
                        school.getSchool_id(),
                        province.getProvince_id(),
                        year,
                        "[]在{}专业录取人数统计图".replace("[]", school.getSchool_name())
                                .replace("{}", province.getProvince_name()),
                        "专业名称",
                        "录取人数",
                        "录取人数");

                generator.addParagraph("");

                generator.addParagraph("录取人数分布比例图。");

                chartService.generateMajorTotalPieChart(generator,
                        school.getSchool_id(),
                        province.getProvince_id(),
                        year,
                        "[]在{}专业录取人数分布比例图".replace("[]", school.getSchool_name())
                                .replace("{}", province.getProvince_name()),
                        "录取人数");

                generator.addParagraph("");

                generator.addParagraph("各专业男女比例分布图。");

                chartService.generateMajorGenderRateBarChart(generator,
                        school.getSchool_id(),
                        province.getProvince_id(),
                        year,
                        "[]在{}各专业录取新生男女比例图".replace("[]", school.getSchool_name())
                                .replace("{}", province.getProvince_name()),
                        "专业:性别",
                        "该性别所占比例",
                        "专业:性别");

                generator.addParagraph("");
            }
        }
    }
}
