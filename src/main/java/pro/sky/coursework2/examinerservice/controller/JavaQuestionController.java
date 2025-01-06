package pro.sky.coursework2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.JavaQuestionService;


import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {

        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/java/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAll() {
        return javaQuestionService.getAllQuestion();
    }
}
