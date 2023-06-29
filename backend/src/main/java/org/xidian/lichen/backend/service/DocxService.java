package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

public interface DocxService {
    void generateMajorPara(MicrosoftDocxGenerator generator, String name, String year); // a computing resource limit

    void generateSchoolRankPara(MicrosoftDocxGenerator generator, String name, String year);

    void generateMajorIndexPara(MicrosoftDocxGenerator generator,
                                String school_name,
                                String major,
                                boolean isGPT);

    void generateStudentMajorRatePara(MicrosoftDocxGenerator generator,
                                      String name,
                                      String year);

    void generateMajorThousandIndexPara(MicrosoftDocxGenerator generator,
                                        String school_name,
                                        String major,
                                        boolean isGPT);
}
