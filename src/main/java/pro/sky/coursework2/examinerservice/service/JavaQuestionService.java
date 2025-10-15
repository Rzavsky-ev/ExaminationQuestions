package pro.sky.coursework2.examinerservice.service;

import org.springframework.stereotype.Service;


import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.*;


/**
 * Сервис для работы с вопросами по Java
 */
@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    /**
     * Добавляет новый вопрос по Java
     *
     * @param question текст вопроса по Java (не должен быть null или пустой строкой)
     * @param answer   текст ответа на вопрос (не должен быть null или пустой строкой)
     * @return созданный и сохраненный объект вопроса
     */
    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        javaQuestionRepository.add(addQuestion);
        return addQuestion;
    }

    /**
     * Удаляет вопрос по Java
     *
     * @param question объект вопроса для удаления
     * @return удаленный объект вопроса
     */
    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

    /**
     * Получает случайный вопрос по Java
     *
     * @return случайный объект вопроса по Java
     * @throws ExceptionEmptyList если в репозитории нет вопросов
     */
    @Override
    public Question getRandomQuestion() {
        if (javaQuestionRepository.getAll().isEmpty()) {
            throw new ExceptionEmptyList();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(javaQuestionRepository.getAll().size());
        return javaQuestionRepository.getAll().stream()
                .skip(randomIndex).limit(1)
                .toList().get(0);
    }

    /**
     * Получает все вопросы по Java
     *
     * @return коллекция всех вопросов по Java
     */
    @Override
    public Collection<Question> getAllQuestion() {
        return javaQuestionRepository.getAll();
    }
}
