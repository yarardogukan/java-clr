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
    private BigDecimal ortalamaNot;
    private String harfKarsiligi;

    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Student student;

    public void calculateAndSetOrtalamaAndHarfKarsiligi() {
        BigDecimal vizeAgirlikliOrtalama = BigDecimal.valueOf(vizeNotu * 0.4);
        BigDecimal finalAgirlikliOrtalama = BigDecimal.valueOf(finalNotu * 0.6);
        ortalamaNot = vizeAgirlikliOrtalama.add(finalAgirlikliOrtalama);

        // Harf karşılığı hesaplama işlemi
        if (ortalamaNot.compareTo(BigDecimal.valueOf(85)) >= 0) {
            harfKarsiligi = "AA";
        } else if (ortalamaNot.compareTo(BigDecimal.valueOf(70)) >= 0) {
            harfKarsiligi = "BA";
        } else if (ortalamaNot.compareTo(BigDecimal.valueOf(60)) >= 0) {
            harfKarsiligi = "BB";
        } else if (ortalamaNot.compareTo(BigDecimal.valueOf(50)) >= 0) {
            harfKarsiligi = "CB";
        } else if (ortalamaNot.compareTo(BigDecimal.valueOf(40)) >= 0) {
            harfKarsiligi = "CC";
        } else if (ortalamaNot.compareTo(BigDecimal.valueOf(30)) >= 0) {
            harfKarsiligi = "DC";
        } else if (ortalamaNot.compareTo(BigDecimal.valueOf(20)) >= 0) {
            harfKarsiligi = "DD";
        } else {
            harfKarsiligi = "FF";
        }
    }
}
