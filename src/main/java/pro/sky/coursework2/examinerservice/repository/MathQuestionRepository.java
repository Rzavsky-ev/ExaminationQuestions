package pro.sky.coursework2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursework2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Реализация репозитория для работы с вопросами по математике
 */
@Repository
public class MathQuestionRepository implements QuestionRepository {

    private Set<Question> questions = new HashSet<>();

    /**
     * Добавляет математический вопрос в репозиторий
     *
     * @param question объект математического вопроса для добавления (не должен быть null)
     * @return добавленный объект вопроса
     * @throws IllegalArgumentException если переданный вопрос равен null
     */
    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        questions.add(question);
        return question;
    }

    /**
     * Удаляет математический вопрос из репозитория
     *
     * @param question объект математического вопроса для удаления (не должен быть null)
     * @return удаленный объект вопроса
     * @throws IllegalArgumentException если переданный вопрос равен null
     */
    @Override
    public Question remove(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        questions.remove(question);
        return question;
    }

    /**
     * Возвращает все математические вопросы из репозитория
     *
     * @return коллекция всех математических вопросов (не может быть null)
     */
    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
