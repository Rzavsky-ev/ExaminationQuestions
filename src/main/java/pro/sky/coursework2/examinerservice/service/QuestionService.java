package pro.sky.coursework2.examinerservice.service;


import pro.sky.coursework2.examinerservice.domain.Question;

import java.util.Collection;



public interface QuestionService {

    Question add(String question, String answer);

    Question remove(Question question);

    Question getRandomQuestion();

    Collection<Question> getAllQuestion();
}
