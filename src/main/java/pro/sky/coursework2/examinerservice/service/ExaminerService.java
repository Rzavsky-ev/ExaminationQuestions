package pro.sky.coursework2.examinerservice.service;

import pro.sky.coursework2.examinerservice.domain.Question;


import java.util.Collection;

/**
 * Сервис для получения экзаменационных вопросов
 */
public interface ExaminerService {

    /**
     * Получение вопросов по Java
     *
     * @param amount количество вопросов для получения (должно быть положительным числом)
     * @return коллекция вопросов по Java указанного размера
     */
    Collection<Question> getJavaQuestions(int amount);

    /**
     * Получение вопросов по математике
     *
     * @param amount количество вопросов для получения (должно быть положительным числом)
     * @return коллекция вопросов по математике указанного размера
     */
    Collection<Question> getMathQuestions(int amount);
}