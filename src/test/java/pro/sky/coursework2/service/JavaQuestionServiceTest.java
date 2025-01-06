package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.QuestionRepository;
import pro.sky.coursework2.examinerservice.service.JavaQuestionService;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {


    @InjectMocks
    private JavaQuestionService javaQuestionServiceTest;

    @Mock
    private QuestionRepository questionRepositoryMock;

    @Test
    public void addTest() {
        javaQuestionServiceTest.add("A", "B");
        verify(questionRepositoryMock).add(javaQuestionServiceTest.add("A", "B"));
    }

    @Test
    public void removeTest() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.remove(question);
        verify(questionRepositoryMock).remove(javaQuestionServiceTest.remove(question));
    }

    @Test
    public void getRandomQuestion_emptyList() {
        when(questionRepositoryMock.getAll()).thenReturn(emptyList());
        assertThrows(ExceptionEmptyList.class, () -> {
            javaQuestionServiceTest.getRandomQuestion();
        });
    }

    @Test
    public void getRandomQuestionTest() {
        Question question = new Question("A", "B");
        when(questionRepositoryMock.getAll()).thenReturn(
                new ArrayList<>(List.of(question)));
        Question result = javaQuestionServiceTest.getRandomQuestion();
        assertEquals(question, result);
    }

}
