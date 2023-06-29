package org.xidian.lichen.backend.service;

import org.xidian.lichen.backend.dao.StudentDao;
import org.xidian.lichen.backend.entity.Student;

public interface StudentService {
    void insertStudent(Student student);

    Student getStudentByMajorId(int major_id);
}
