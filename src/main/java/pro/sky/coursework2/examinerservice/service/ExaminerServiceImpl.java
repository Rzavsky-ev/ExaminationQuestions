package pro.sky.coursework2.examinerservice.service;

import org.springframework.stereotype.Service;

import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.exceptions.RongNumberException;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    // private final List<QuestionService> listQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
//        listQuestionService = new ArrayList<>();
//        listQuestionService.add(javaQuestionService);
//        listQuestionService.add(mathQuestionService);
        this.mathQuestionService = mathQuestionService;
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public List<Question> getJavaQuestions(int amount) {
        if (amount > javaQuestionService.getAllQuestion().size()) {
            throw new RongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> javaQuestionService.getRandomQuestion())
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getMathQuestions(int amount) {
        if (amount > mathQuestionService.getAllQuestion().size()) {
            throw new RongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> mathQuestionService.getRandomQuestion())
                .collect(Collectors.toList());
    }
}
