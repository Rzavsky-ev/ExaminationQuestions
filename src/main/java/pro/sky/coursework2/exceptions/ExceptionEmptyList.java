package pro.sky.coursework2.exceptions;

/**
 * Исключение, выбрасываемое при попытке выполнить операцию с пустой коллекцией вопросов
 */
public class ExceptionEmptyList extends RuntimeException {
    public ExceptionEmptyList() {
        super("Пустой список");
    }
}
