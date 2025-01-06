package pro.sky.coursework2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.MathQuestionService;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping(path = "/math/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        //throw new MethodNotAllowedException("Method Not Allowed");
       return mathQuestionService.add(question, answer);
    }

    @GetMapping(path = "/math/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "/math")
    public Collection<Question> getAll() {
        //throw new MethodNotAllowedException("Method Not Allowed");
        return mathQuestionService.getAllQuestion();
    }
}
