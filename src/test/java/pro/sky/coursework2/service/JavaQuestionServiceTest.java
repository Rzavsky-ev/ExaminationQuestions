package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.JavaQuestionService;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {


    @InjectMocks
    private JavaQuestionService javaQuestionServiceTest;


    @Test
    public void getRandomQuestion_emptyList() {
        javaQuestionServiceTest.setQuestions(new HashSet<>());
        assertThrows(ExceptionEmptyList.class, () -> {
            javaQuestionServiceTest.getRandomQuestion();
        });
    }

    @Test
    public void getRandomQuestion() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.setQuestions(new HashSet<>(Set.of(question)));
        Question result = javaQuestionServiceTest.getRandomQuestion();
        assertEquals(question, result);
    }

    @Test
    public void addTest() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.add("A", "B");
        Iterator<Question> item = javaQuestionServiceTest.getAll().iterator();
        assertEquals(question, item.next());
    }

    @Test
    public void addTest_Question() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.add(question);
        Iterator<Question> item = javaQuestionServiceTest.getAll().iterator();
        assertEquals(question, item.next());
    }

    @Test
    public void removeTest() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.add(question);
        javaQuestionServiceTest.remove(question);
        assertEquals(javaQuestionServiceTest.getAll(), new HashSet<>());
    }

    @Test
    public void getAllTest() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.add(question);
        Collection<Question> result = javaQuestionServiceTest.getAll();
        Iterator<Question> item = result.iterator();
        assertEquals(question, item.next());
    }
}
