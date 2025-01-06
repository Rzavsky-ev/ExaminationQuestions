package pro.sky.coursework2.examinerservice.repository;

import pro.sky.coursework2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

}
