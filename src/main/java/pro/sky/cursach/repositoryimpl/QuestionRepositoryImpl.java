package pro.sky.cursach.repositoryimpl;


import pro.sky.cursach.domain.Question;
import pro.sky.cursach.exceptions.DuplicateQuestionException;
import pro.sky.cursach.exceptions.QuestionNotFoundException;
import pro.sky.cursach.repository.QuestionRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class QuestionRepositoryImpl implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new DuplicateQuestionException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}