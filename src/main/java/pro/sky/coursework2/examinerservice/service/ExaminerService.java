package pro.sky.coursework2.examinerservice.service;


import pro.sky.coursework2.examinerservice.domain.Question;


import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getJavaQuestions (int amount);
    Collection<Question> getMathQuestions (int amount);
}
