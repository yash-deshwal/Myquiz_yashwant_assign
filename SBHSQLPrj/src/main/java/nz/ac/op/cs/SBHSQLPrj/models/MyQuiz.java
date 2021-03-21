package nz.ac.op.cs.SBHSQLPrj.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class MyQuiz {
    //model class for getting question assiging question to user and amount of questions also
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    Long id;
    String start_date;
    Integer amount;
    @ManyToOne
    QuizUser user;

    @OneToMany( targetEntity=Question.class )
    private List<Question> questions;

    public MyQuiz(){
    }


    public MyQuiz(Long id, String start_date, Integer amount) {
        this.id = id;
        this.start_date = start_date;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public QuizUser getUser() {
        return user;
    }

    public void setUser(QuizUser user) {
        this.user = user;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
