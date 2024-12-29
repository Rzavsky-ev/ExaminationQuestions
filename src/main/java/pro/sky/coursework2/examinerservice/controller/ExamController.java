package pro.sky.coursework2.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.ExaminerService;
import pro.sky.coursework2.exceptions.RongNumberException;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }


    @ExceptionHandler(RongNumberException.class)
    public ResponseEntity<String> rongNumber(RongNumberException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
