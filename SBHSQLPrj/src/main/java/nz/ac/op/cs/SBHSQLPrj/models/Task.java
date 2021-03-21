package nz.ac.op.cs.SBHSQLPrj.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@JsonIgnoreProperties
@Entity
public class Task {
    //extra feature for students to know important dates and other things
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String text;
    String day;
    Boolean reminder;

    public Task() {

    }

    public Task(Integer id, String text, String day, Boolean reminder) {
        this.id = id;
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Boolean getReminder() {
        return reminder;
    }

    public void setReminder(Boolean reminder) {
        this.reminder = reminder;
    }
}
