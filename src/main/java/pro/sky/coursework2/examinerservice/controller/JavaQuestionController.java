package pro.sky.coursework2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.JavaQuestionService;


import java.util.Collection;

/**
 * Контроллер для управления вопросами по Java
 */
@RestController
@RequestMapping(path = "/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    /**
     * Добавление нового вопроса по Java
     *
     * @param question текст вопроса (обязательный параметр)
     * @param answer   текст ответа на вопрос (обязательный параметр)
     * @return созданный объект вопроса
     */
    @GetMapping(path = "/java/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    /**
     * Удаление вопроса по Java
     *
     * @param question текст вопроса для удаления (обязательный параметр)
     * @param answer   текст ответа для удаления (обязательный параметр)
     * @return удаленный объект вопроса или null, если вопрос не найден
     */
    @GetMapping(path = "/java/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    /**
     * Получение всех вопросов по Java
     *
     * @return коллекция всех вопросов по Java
     */
    @GetMapping(path = "/java")
    public Collection<Question> getAll() {
        return javaQuestionService.getAllQuestion();
    }
}
