package com.mezunSistemi.gradingProgram.Lessons;

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
public class Lesson extends BaseEntity {

    private String lessonName;

    @OneToMany(mappedBy = "lesson")
    private Set<Grade> grades;

}
