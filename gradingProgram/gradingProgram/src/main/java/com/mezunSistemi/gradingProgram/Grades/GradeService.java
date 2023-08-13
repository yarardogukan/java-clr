package com.mezunSistemi.gradingProgram.Grades;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade createOrUpdateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGradeById(Long id) {
        gradeRepository.deleteById(id);
    }
}
