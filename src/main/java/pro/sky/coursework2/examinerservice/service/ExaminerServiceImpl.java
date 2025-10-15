package pro.sky.coursework2.examinerservice.service;

import org.springframework.stereotype.Service;

import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.exceptions.WrongNumberException;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Реализация сервиса для получения экзаменационных вопросов
 */
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
        this.javaQuestionService = javaQuestionService;
    }

    /**
     * Получение случайных вопросов по Java
     *
     * @param amount количество вопросов для получения
     * @return список случайных вопросов по Java указанного размера
     * @throws WrongNumberException если запрашиваемое количество вопросов
     *                              превышает доступное количество в хранилище
     */
    @Override
    public List<Question> getJavaQuestions(int amount) {
        if (amount > javaQuestionService.getAllQuestion().size()) {
            throw new WrongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> javaQuestionService.getRandomQuestion())
                .collect(Collectors.toList());
    }

    /**
     * Получение случайных вопросов по математике
     *
     * @param amount количество вопросов для получения
     * @return список случайных вопросов по математике указанного размера
     * @throws WrongNumberException если запрашиваемое количество вопросов превышает доступное количество в хранилище
     */
    @Override
    public List<Question> getMathQuestions(int amount) {
        if (amount > mathQuestionService.getAllQuestion().size()) {
            throw new WrongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> mathQuestionService.getRandomQuestion())
                .collect(Collectors.toList());
    }
}
