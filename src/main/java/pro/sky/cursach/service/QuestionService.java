package pro.sky.cursach.service;

import pro.sky.cursach.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}