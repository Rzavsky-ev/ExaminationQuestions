package pro.sky.coursework2.examinerservice.repository;

import pro.sky.coursework2.examinerservice.domain.Question;

import java.util.Collection;

/**
 * Репозиторий для работы с вопросами
 */
public interface QuestionRepository {

    /**
     * Добавляет вопрос в репозиторий
     *
     * @param question объект вопроса для добавления (не должен быть null)
     * @return добавленный объект вопроса
     */
    Question add(Question question);

    /**
     * Удаляет вопрос из репозитория
     *
     * @param question объект вопроса для удаления (не должен быть null)
     * @return удаленный объект вопроса или null, если вопрос не найден
     */
    Question remove(Question question);

    /**
     * Возвращает все вопросы из репозитория
     *
     * @return коллекция всех вопросов (не может быть null)
     */
    Collection<Question> getAll();
}
