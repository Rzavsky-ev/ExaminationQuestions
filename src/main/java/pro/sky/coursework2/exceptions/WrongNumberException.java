package pro.sky.coursework2.exceptions;

/**
 * Исключение, выбрасываемое при передаче некорректного числового параметра
 */
public class WrongNumberException extends RuntimeException {
    public WrongNumberException() {
        super("Неправильное число");
    }
}
