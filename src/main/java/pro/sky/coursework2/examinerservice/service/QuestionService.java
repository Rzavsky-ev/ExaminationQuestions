package pro.sky.coursework2.examinerservice.service;


import pro.sky.coursework2.examinerservice.domain.Question;

import java.util.Collection;


/**
 * Сервис для работы с вопросами
 */
public interface QuestionService {

    /**
     * Добавление нового вопроса
     *
     * @param question текст вопроса (не должен быть null или пустой строкой)
     * @param answer   текст ответа на вопрос (не должен быть null или пустой строкой)
     * @return созданный и сохраненный объект вопроса
     */
    Question add(String question, String answer);

    /**
     * Удаление вопроса
     *
     * @param question объект вопроса для удаления (не должен быть null)
     * @return удаленный объект вопроса
     */
    Question remove(Question question);

    /**
     * Получение случайного вопроса
     *
     * @return случайный объект вопроса
     * @throws IllegalStateException если в хранилище нет вопросов
     */
    Question getRandomQuestion();

    /**
     * Получение всех вопросов
     *
     * @return коллекция всех вопросов (не может быть null)
     */
    Collection<Question> getAllQuestion();
}