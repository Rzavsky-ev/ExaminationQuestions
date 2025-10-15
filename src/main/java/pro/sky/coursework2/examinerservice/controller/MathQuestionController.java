package pro.sky.coursework2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.examinerservice.service.MathQuestionService;


import java.util.Collection;

/**
 * Контроллер для управления вопросами по математике
 */
@RestController
@RequestMapping(path = "/exam")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    /**
     * Добавление нового вопроса по математике
     *
     * @param question текст вопроса (обязательный параметр)
     * @param answer   текст ответа на вопрос (обязательный параметр)
     * @return созданный объект вопроса
     */
    @GetMapping(path = "/math/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    /**
     * Удаление вопроса по математике
     *
     * @param question текст вопроса для удаления (обязательный параметр)
     * @param answer   текст ответа для удаления (обязательный параметр)
     * @return удаленный объект вопроса или null, если вопрос не найден
     */
    @GetMapping(path = "/math/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.remove(new Question(question, answer));
    }

    /**
     * Получение всех вопросов по математике
     *
     * @return коллекция всех вопросов по математике
     */
    @GetMapping(path = "/math")
    public Collection<Question> getAll() {
        return mathQuestionService.getAllQuestion();
    }
}
