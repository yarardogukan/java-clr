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
        double not = (grade.getVizeNotu() * 0.4) + (grade.getFinalNotu() * 0.6);
        grade.setOrtalamaNot(not);

        String harfKarsiligi = calculateLetterGrade(not);
        grade.setHarfKarsiligi(harfKarsiligi);
        return gradeRepository.save(grade);
    }

    public void deleteGradeById(Long id) {
        gradeRepository.deleteById(id);
    }
    private String calculateLetterGrade(double ortalamaNot) {
        if (ortalamaNot >= 85) {
            return "AA";
        } else if (ortalamaNot >= 70) {
            return "BA";
        } else if (ortalamaNot >= 60) {
            return "BB";
        } else if (ortalamaNot >= 50) {
            return "CB";
        } else {
            return "FF";
        }
    }
}
