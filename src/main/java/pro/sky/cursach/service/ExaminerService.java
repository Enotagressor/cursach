package pro.sky.cursach.service;


import pro.sky.cursach.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}