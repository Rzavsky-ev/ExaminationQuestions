package pro.sky.coursework2.examinerservice.service;


import org.springframework.stereotype.Service;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.QuestionRepository;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {


    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        //throw new MethodNotAllowedException("Method Not Allowed");
        Question addQuestion = new Question(question, answer);
        mathQuestionRepository.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException("Method Not Allowed");
//        mathQuestionRepository.remove(question);
//        return question;
    }

    @Override
    public Question getRandomQuestion() {
        throw new MethodNotAllowedException("Method Not Allowed");
//        if (mathQuestionRepository.getAll().isEmpty()) {
//            throw new ExceptionEmptyList();
//        }
//        Random random = new Random();
//        int randomIndex = random.nextInt(mathQuestionRepository.getAll().size());
//        return mathQuestionRepository.getAll().stream()
//                .skip(randomIndex).limit(1).toList().get(0);
    }

    @Override
    public Collection<Question> getAllQuestion() {
       // throw new MethodNotAllowedException("Method Not Allowed");
       return mathQuestionRepository.getAll();
    }

}
