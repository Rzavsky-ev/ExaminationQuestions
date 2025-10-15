package pro.sky.coursework2.examinerservice.service;


import org.springframework.stereotype.Service;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.MathQuestionRepository;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.*;

/**
 * Сервис для работы с вопросами по математике
 */
@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    /**
     * Добавляет новый вопрос по математике
     *
     * @param question текст математического вопроса (не должен быть null или пустой строкой)
     * @param answer   текст ответа на математический вопрос (не должен быть null или пустой строкой)
     * @return созданный и сохраненный объект математического вопроса
     */
    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        mathQuestionRepository.add(addQuestion);
        return addQuestion;
    }

    /**
     * Удаляет вопрос по математике
     *
     * @param question объект математического вопроса для удаления (не должен быть null)
     * @return удаленный объект математического вопроса
     */
    @Override
    public Question remove(Question question) {
        mathQuestionRepository.remove(question);
        return question;
    }

    /**
     * Получает случайный вопрос по математике
     *
     * @return случайный объект математического вопроса
     */
    @Override
    public Question getRandomQuestion() {
        if (mathQuestionRepository.getAll().isEmpty()) {
            throw new ExceptionEmptyList();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(mathQuestionRepository.getAll().size());
        return mathQuestionRepository.getAll().stream()
                .skip(randomIndex).limit(1).toList().get(0);
    }

    /**
     * Получает все вопросы по математике
     *
     * @return коллекция всех математических вопросов (не может быть null)
     */
    @Override
    public Collection<Question> getAllQuestion() {
        return mathQuestionRepository.getAll();
    }
}
