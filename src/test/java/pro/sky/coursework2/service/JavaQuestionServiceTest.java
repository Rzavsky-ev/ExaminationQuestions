package pro.sky.coursework2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.JavaQuestionRepository;
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
    private JavaQuestionRepository javaQuestionRepositoryMock;

    @DisplayName("Добавление нового вопроса")
    @Test
    public void addTest() {
        javaQuestionServiceTest.add("A", "B");
        verify(javaQuestionRepositoryMock).add(javaQuestionServiceTest.add("A", "B"));
    }

    @DisplayName("Удаление существующего вопроса")
    @Test
    public void removeTest() {
        Question question = new Question("A", "B");
        javaQuestionServiceTest.remove(question);
        verify(javaQuestionRepositoryMock).remove(javaQuestionServiceTest.remove(question));
    }

    @DisplayName("Получение случайного вопроса из пустого списка (должно бросать исключение)")
    @Test
    public void getRandomQuestionEmptyList() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(emptyList());
        assertThrows(ExceptionEmptyList.class, () -> javaQuestionServiceTest.getRandomQuestion());
    }

    @DisplayName("Успешное получение случайного вопроса")
    @Test
    public void getRandomQuestionTest() {
        Question question = new Question("A", "B");
        when(javaQuestionRepositoryMock.getAll()).thenReturn(
                new ArrayList<>(List.of(question)));
        Question result = javaQuestionServiceTest.getRandomQuestion();
        assertEquals(question, result);
    }
}
