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

//    private final JavaQuestionService javaQuestionService;
//    private final MathQuestionService mathQuestionService;

    private final List<QuestionService> listQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        listQuestionService = new ArrayList<>();
        listQuestionService.add(javaQuestionService);
        listQuestionService.add(mathQuestionService);
    }

    @Override
    public List<Question> getJavaQuestions(int amount) {
        if (amount > listQuestionService.get(1).getAllQuestion().size()) {
            throw new RongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> listQuestionService.get(1).getRandomQuestion())
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getMathQuestions(int amount) {
        if (amount > listQuestionService.get(2).getAllQuestion().size()) {
            throw new RongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> listQuestionService.get(2).getRandomQuestion())
                .collect(Collectors.toList());
    }
}
