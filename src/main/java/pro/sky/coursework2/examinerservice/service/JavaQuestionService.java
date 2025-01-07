package pro.sky.coursework2.examinerservice.service;

import org.springframework.stereotype.Service;


import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        javaQuestionRepository.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

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

    @Override
    public Collection<Question> getAllQuestion() {
        return javaQuestionRepository.getAll();
    }

}
