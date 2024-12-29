package pro.sky.coursework2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.exceptions.RongNumberException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new RongNumberException();
        }
        return IntStream.range(0, amount)
                .mapToObj(i -> questionService.getRandomQuestion())
                .collect(Collectors.toList());


    }
}
