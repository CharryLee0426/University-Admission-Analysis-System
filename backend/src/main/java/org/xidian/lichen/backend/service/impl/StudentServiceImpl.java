package org.xidian.lichen.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidian.lichen.backend.dao.StudentDao;
import org.xidian.lichen.backend.entity.Student;
import org.xidian.lichen.backend.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public Student getStudentByMajorId(int major_id) {
        return studentDao.getStudentByMajorId(major_id);
    }
}
