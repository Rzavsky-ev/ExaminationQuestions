package pro.sky.coursework2.examinerservice.domain;

public class Question {

    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question other = (Question) obj;

        if (!this.question.equals(other.question) || !this.answer.equals(other.answer)) {
            return false;
        }
        return true;
    }
}
