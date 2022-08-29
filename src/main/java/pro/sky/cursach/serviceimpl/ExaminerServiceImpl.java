package pro.sky.cursach.serviceimpl;


import org.springframework.stereotype.Service;
import pro.sky.cursach.domain.Question;
import pro.sky.cursach.exceptions.TooManyQuestionsRequestException;
import pro.sky.cursach.service.ExaminerService;
import pro.sky.cursach.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionServices.get(0).getAll().size() +
                questionServices.get(1).getAll().size()) {
            throw new TooManyQuestionsRequestException();
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionServices.get(random.nextInt(2)).getRandomQuestion());
        }
        return questions;
    }
}