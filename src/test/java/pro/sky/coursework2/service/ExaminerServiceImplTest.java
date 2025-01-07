package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.ExaminerServiceImpl;
import pro.sky.coursework2.examinerservice.service.JavaQuestionService;
import pro.sky.coursework2.examinerservice.service.MathQuestionService;
import pro.sky.coursework2.exceptions.RongNumberException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceTestMock;

    @Mock
    private MathQuestionService mathQuestionServiceTestMock;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceTest;

    @Test
    public void getJavaQuestions_AmountWrong() {
        when(javaQuestionServiceTestMock.getAllQuestion()).thenReturn(emptyList());
        assertThrows(RongNumberException.class, () -> {
            examinerServiceTest.getJavaQuestions(1);
        });
    }

    @Test
    public void getJavaQuestions() {
        int amount = 1;
        Question question = new Question("A", "B");
        List<Question> result =
                new ArrayList<>(List.of(new Question("A", "B")));
        when(javaQuestionServiceTestMock.getRandomQuestion()).thenReturn(question);
        when(javaQuestionServiceTestMock.getAllQuestion()).thenReturn(result);
        List<Question> expectedResults = examinerServiceTest.getJavaQuestions(amount);
        assertEquals(question, expectedResults.get(0));

    }

    @Test
    public void getMathQuestions_AmountWrong() {
        when(mathQuestionServiceTestMock.getAllQuestion()).thenReturn(emptyList());
        assertThrows(RongNumberException.class, () -> {
            examinerServiceTest.getMathQuestions(1);
        });
    }

    @Test
    public void getMathQuestions() {
        int amount = 1;
        Question question = new Question("A", "B");
        List<Question> result =
                new ArrayList<>(List.of(new Question("A", "B")));
        when(mathQuestionServiceTestMock.getRandomQuestion()).thenReturn(question);
        when(mathQuestionServiceTestMock.getAllQuestion()).thenReturn(result);
        List<Question> expectedResults = examinerServiceTest.getMathQuestions(amount);
        assertEquals(question, expectedResults.get(0));

    }

}
