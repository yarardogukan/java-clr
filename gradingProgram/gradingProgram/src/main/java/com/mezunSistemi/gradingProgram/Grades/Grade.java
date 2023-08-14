package com.mezunSistemi.gradingProgram.Grades;

import com.mezunSistemi.gradingProgram.Entities.Base.BaseEntity;
import com.mezunSistemi.gradingProgram.Lessons.Lesson;
import com.mezunSistemi.gradingProgram.Students.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Grade extends BaseEntity {

    private int vizeNotu;
    private int finalNotu;
    private double ortalamaNot;
    private String harfKarsiligi;

    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Student student;

}
