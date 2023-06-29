package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

public interface ChartService {
    void generateMajorIndexBarChart(MicrosoftDocxGenerator generator,
                                           String school_id,
                                           String major,
                                           String title,
                                           String xTitle,
                                           String yTitle,
                                           String legendTitle);

    void generateMajorIndexLineChart(MicrosoftDocxGenerator generator,
                                    String school_id,
                                    String major,
                                    String title,
                                    String xTitle,
                                    String yTitle,
                                    String legendTitle);

    void generateMajorThousandIndexBarChart(MicrosoftDocxGenerator generator,
                                    String school_id,
                                    String major,
                                    String title,
                                    String xTitle,
                                    String yTitle,
                                    String legendTitle);

    void generateMajorThousandIndexLineChart(MicrosoftDocxGenerator generator,
                                     String school_id,
                                     String major,
                                     String title,
                                     String xTitle,
                                     String yTitle,
                                     String legendTitle);

    void generateMajorRateBarChart(MicrosoftDocxGenerator generator,
                                   String school_id,
                                   String province_id,
                                   String year,
                                   String title,
                                   String xTitle,
                                   String yTitle,
                                   String legendTitle);

    void generateMajorTotalBarChart(MicrosoftDocxGenerator generator,
                                    String school_id,
                                    String province_id,
                                    String year,
                                    String title,
                                    String xTitle,
                                    String yTitle,
                                    String legendTitle);

    void generateMajorTotalPieChart(MicrosoftDocxGenerator generator,
                                    String school_id,
                                    String province_id,
                                    String year,
                                    String title,
                                    String legendTitle);

    void generateMajorGenderRateBarChart(MicrosoftDocxGenerator generator,
                                         String school_id,
                                         String province_id,
                                         String year,
                                         String title,
                                         String xTitle,
                                         String yTitle,
                                         String legendTitle);
}
