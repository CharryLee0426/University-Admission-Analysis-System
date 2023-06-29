package org.xidian.lichen.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xidian.lichen.backend.entity.Student;

@Mapper
@Repository
public interface StudentDao {
    void insertStudent(Student student);

    Student getStudentByMajorId(int major_id);
}
