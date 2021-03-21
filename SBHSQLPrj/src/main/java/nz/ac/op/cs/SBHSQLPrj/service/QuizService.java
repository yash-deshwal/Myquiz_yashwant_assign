package nz.ac.op.cs.SBHSQLPrj.service;

import nz.ac.op.cs.SBHSQLPrj.db.QuizRepository;
import nz.ac.op.cs.SBHSQLPrj.models.Quiz;
import nz.ac.op.cs.SBHSQLPrj.models.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    //all the functioning for the provide function in model class for creating update post deleting

    @Autowired
    private QuizRepository quizRepository;


    public void createQuiz(QuizUser quizUser, Integer amount){
        Quiz quiz = new Quiz();
        quiz.setStart_date("23 March 2021");
        quiz.setAmount(amount);
        quiz.setUser(quizUser);

        quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzs(){
        List<Quiz> quizzes = new ArrayList<Quiz>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
        //return quizUsers;
    }

    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id).get();
    }
    public void deleteQuiz(Long id){
        quizRepository.deleteById(id);
    }
}
