package pro.sky.coursework2.examinerservice.domain;

/**
 * Record-класс, представляющий вопрос с ответом
 *
 * @param question текст вопроса (не может быть null)
 * @param answer   текст ответа на вопрос (не может быть null)
 */
public record Question(String question, String answer) {
}
