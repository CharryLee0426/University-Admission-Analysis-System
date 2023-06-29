package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

public interface TableService {
    void generateMajorTable(MicrosoftDocxGenerator generator, String school_id, String province_id, String year);

    void generateScienceSchoolRankTable(MicrosoftDocxGenerator generator, String year, String province_id);

    void generateArtSchoolRankTable(MicrosoftDocxGenerator generator, String year, String province_id);

    void generateMajorIndexTable(MicrosoftDocxGenerator generator, String school_id, String major);

    void generateMajorThousandIndexTable(MicrosoftDocxGenerator generator, String school_id, String major);

    void generateStudentMajorRate(MicrosoftDocxGenerator generator,
                                  String school_id,
                                  String province_id,
                                  String year);

    void generateStudentMajorStat(MicrosoftDocxGenerator generator,
                                  String school_id,
                                  String province_id,
                                  String year);
}
