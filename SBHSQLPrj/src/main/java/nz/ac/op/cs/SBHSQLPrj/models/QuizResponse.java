package nz.ac.op.cs.SBHSQLPrj.models;

import java.util.List;

public class QuizResponse {
    //model class of response of the questions
    int response_code;
    List<Question> results;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}
