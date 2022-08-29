package pro.sky.cursach.service;


import org.junit.jupiter.api.Test;
import pro.sky.cursach.domain.Question;
import pro.sky.cursach.exceptions.DuplicateQuestionException;
import pro.sky.cursach.exceptions.QuestionNotFoundException;
import pro.sky.cursach.repositoryimpl.QuestionRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.cursach.constant.Constants.*;

class QuestionRepositoryTest {
    private final QuestionRepositoryImpl out;

    QuestionRepositoryTest() {
        out = new QuestionRepositoryImpl();
    }

    @Test
    void shouldCorrectAddQuestion() {
        int size = out.getAll().size();
        assertEquals(J_QUEST1, out.add(J_QUEST1));
        assertEquals(size + 1, out.getAll().size());
    }

    @Test
    void shouldThrowExceptionWhenAddDuplicate() {
        out.add(J_QUEST1);
        assertThrows(DuplicateQuestionException.class, () -> out.add(J_QUEST1));
    }

    @Test
    void shouldCorrectRemoveQuestion() {
        int size = out.getAll().size();
        out.add(J_QUEST2);
        assertEquals(J_QUEST2, out.remove(J_QUEST2));
        assertEquals(size, out.getAll().size());
    }

    @Test
    void shouldThrowExceptionWhenQuestionNotFound() {
        out.add(J_QUEST1);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(new Question(JAVA_QUESTION1, JAVA_ANSWER2)));
    }

    @Test
    void getAll() {
        out.add(J_QUEST1);
        out.add(J_QUEST2);
        out.add(J_QUEST3);
        out.add(J_QUEST4);
        out.add(J_QUEST5);
        assertEquals(JAVA_QUESTIONS_SET, out.getAll());
    }

}