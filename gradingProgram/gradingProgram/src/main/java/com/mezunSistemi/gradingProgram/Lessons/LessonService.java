package com.mezunSistemi.gradingProgram.Lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson createOrUpdateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
    }
}
