package pro.sky.coursework2.examinerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;

/**
 * Глобальный обработчик исключений для контроллеров вопросов
 */
@ControllerAdvice
public class QuestionControllerAdvice {

    /**
     * Обработчик исключения MethodNotAllowedException
     *
     * @param e перехваченное исключение MethodNotAllowedException
     * @return ResponseEntity с сообщением об ошибке и статусом 405 METHOD_NOT_ALLOWED
     */
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<String> methodNotAllowed(MethodNotAllowedException e) {
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
