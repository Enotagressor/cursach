package pro.sky.cursach.repository;

import pro.sky.cursach.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}