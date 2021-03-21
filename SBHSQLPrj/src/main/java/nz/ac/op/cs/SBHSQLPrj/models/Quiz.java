package nz.ac.op.cs.SBHSQLPrj.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Quiz {
    //model class for creating the quiz but without questions from open tdb
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    Long id;
    String start_date;
    Integer amount;

    @ManyToOne
    QuizUser user;
    public Quiz(){

    }

    public Quiz(Long id, String start_date, Integer amount) {
        this.id = id;
        this.start_date = start_date;
        this.amount = amount;

    }

    public Quiz(Long id, String start_date, Integer amount, QuizUser user) {
        this.id = id;
        this.start_date = start_date;
        this.amount = amount;
        this.user = user;
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
}
