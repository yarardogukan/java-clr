package com.mezunSistemi.gradingProgram.Students;

import com.mezunSistemi.gradingProgram.Entities.Base.BaseEntity;
import com.mezunSistemi.gradingProgram.Grades.Grade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;
@Getter
@Setter
@Entity
public class Student extends BaseEntity {

    private String studentName;

    @OneToMany(mappedBy = "student")
    private Set<Grade> grades;
}
