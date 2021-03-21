package nz.ac.op.cs.SBHSQLPrj.models;

import javax.persistence.Entity;
import java.util.List;


public class MyUserAnswers {
    //model class for answers from user for the given questions
    String userId;
    Long quizId;
    List<MyAnswers> answers;

    public MyUserAnswers() {

    }

    public MyUserAnswers(String userId, Long quizId, List<MyAnswers> answers)  {
        this.userId = userId;
        this.quizId = quizId;
        this.answers = answers;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public List<MyAnswers> getAnswers() {
        return answers;
    }
    public void setAnswers(List<MyAnswers> answers) {
        this.answers = answers;
    }

}
