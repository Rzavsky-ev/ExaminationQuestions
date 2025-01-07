package pro.sky.coursework2.examinerservice.repository;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Repository
public class JavaQuestionRepository implements QuestionRepository {


    private Set<Question> questions = new HashSet<>();


    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
