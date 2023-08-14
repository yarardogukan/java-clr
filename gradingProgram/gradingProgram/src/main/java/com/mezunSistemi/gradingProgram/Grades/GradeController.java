package com.mezunSistemi.gradingProgram.Grades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id);
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createOrUpdateGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        grade.setId(id);
        return gradeService.createOrUpdateGrade(grade);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGradeById(id);
    }
}
