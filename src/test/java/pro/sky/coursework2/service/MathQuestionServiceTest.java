package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.MathQuestionRepository;
import pro.sky.coursework2.examinerservice.service.MathQuestionService;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @InjectMocks
    private MathQuestionService mathQuestionServiceTest;

    @Mock
    private MathQuestionRepository mathQuestionRepositoryMock;

    @Test
    public void addTest() {
        mathQuestionServiceTest.add("A", "B");
        verify(mathQuestionRepositoryMock).add(mathQuestionServiceTest.add("A", "B"));
    }

    @Test
    public void removeTest() {
        Question question = new Question("A", "B");
        mathQuestionServiceTest.remove(question);
        verify(mathQuestionRepositoryMock).remove(mathQuestionServiceTest.remove(question));
    }

    @Test
    public void getRandomQuestion_emptyList() {
        when(mathQuestionRepositoryMock.getAll()).thenReturn(emptyList());
        assertThrows(ExceptionEmptyList.class, () -> {
            mathQuestionServiceTest.getRandomQuestion();
        });
    }

    @Test
    public void getRandomQuestionTest() {
        Question question = new Question("A", "B");
        when(mathQuestionRepositoryMock.getAll()).thenReturn(
                new ArrayList<>(List.of(question)));
        Question result = mathQuestionServiceTest.getRandomQuestion();
        assertEquals(question, result);
    }
}
