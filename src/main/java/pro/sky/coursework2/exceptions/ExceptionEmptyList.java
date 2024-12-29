package pro.sky.coursework2.exceptions;

public class ExceptionEmptyList extends RuntimeException {
    public ExceptionEmptyList() {
        super("Пустой список");
    }
}
