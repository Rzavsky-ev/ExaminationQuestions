package pro.sky.coursework2.exceptions;

/**
 * Исключение, выбрасываемое при попытке выполнить операцию, которая не разрешена бизнес-логикой приложения
 */
public class MethodNotAllowedException extends RuntimeException {
    public MethodNotAllowedException(String message) {
        super(message);
    }
}

