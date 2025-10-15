package pro.sky.coursework2.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.ExaminerService;
import pro.sky.coursework2.exceptions.WrongNumberException;

import java.util.Collection;

/**
 * Контроллер для работы с экзаменационными вопросами.
 * Предоставляет REST API для получения вопросов по различным предметам.
 */
@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    /**
     * Получение вопросов по Java в указанном количестве
     *
     * @param amount количество вопросов для получения (должно быть > 0)
     * @return коллекция вопросов по Java
     * @throws WrongNumberException если указано некорректное количество вопросов
     */
    @GetMapping(path = "/java/get/{amount}")
    public Collection<Question> getJavaQuestions(@PathVariable int amount) {
        return examinerService.getJavaQuestions(amount);
    }

    /**
     * Получение вопросов по математике в указанном количестве
     *
     * @param amount количество вопросов для получения (должно быть > 0)
     * @return коллекция вопросов по математике
     * @throws WrongNumberException если указано некорректное количество вопросов
     */
    @GetMapping(path = "/math/get/{amount}")
    public Collection<Question> getMathQuestions(@PathVariable int amount) {
        return examinerService.getMathQuestions(amount);
    }

    /**
     * Обработчик исключения для некорректного количества вопросов
     *
     * @param e перехваченное исключение
     * @return ResponseEntity с сообщением об ошибке и статусом 400
     */
    @ExceptionHandler(WrongNumberException.class)
    public ResponseEntity<String> WrongNumber(WrongNumberException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
