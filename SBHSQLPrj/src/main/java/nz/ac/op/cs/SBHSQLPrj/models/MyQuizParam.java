package nz.ac.op.cs.SBHSQLPrj.models;

public class MyQuizParam {

    //parameter to post data in database by using post in post man
    String start_date;
    Integer amount;
    String userId;

    public MyQuizParam(){

    }

    public MyQuizParam(String start_date, Integer amount, String userId) {
        this.start_date = start_date;
        this.amount = amount;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
