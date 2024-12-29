package pro.sky.coursework2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.examinerservice.domain.Question;
import pro.sky.coursework2.exceptions.ExceptionEmptyList;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question getRandomQuestion() {
        if (getAll().isEmpty()) {
            throw new ExceptionEmptyList();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        return questions.stream().skip(randomIndex)
                .limit(1).toList().get(0);
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        questions.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
