package nz.ac.op.cs.SBHSQLPrj.models;

public class MyAnswers {
    //model class for answers of questions from opentdb

    Long questionId;
    Integer answer;

    public MyAnswers(Long questionId, Integer answer){
        this.questionId = questionId;
        this.answer = answer;
    }

    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswer() {
        return answer;
    }
    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
