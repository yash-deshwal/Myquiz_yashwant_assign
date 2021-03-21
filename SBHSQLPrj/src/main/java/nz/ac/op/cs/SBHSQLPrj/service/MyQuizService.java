package nz.ac.op.cs.SBHSQLPrj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nz.ac.op.cs.SBHSQLPrj.db.MyQuizRepository;
import nz.ac.op.cs.SBHSQLPrj.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class MyQuizService {

    //all the functioning for the provide function in model class for creating update post deleting

    @Autowired
    private MyQuizRepository myQuizRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    public void createQuiz(QuizUser quizUser, Integer amount) throws JsonProcessingException {
        MyQuiz quiz = new MyQuiz();
        quiz.setStart_date("March 2021");
        quiz.setAmount(amount);
        quiz.setUser(quizUser);
        List<Question> questions = getQuestionsList(amount);
        questionService.addQuestions(questions);
        quiz.setQuestions(questions);

        myQuizRepository.save(quiz);
    }

    public void createQuiz(MyQuizParam quizParam) throws JsonProcessingException {
        MyQuiz quiz = new MyQuiz();
        quiz.setStart_date(quizParam.getStart_date());
        quiz.setAmount(quizParam.getAmount());
        quiz.setUser(userService.getQuizUser(quizParam.getUserId()));
        List<Question> questions = getQuestionsList(quizParam.getAmount());
        processQuestionsList(questions);
        questionService.addQuestions(questions);
        quiz.setQuestions(questions);

        myQuizRepository.save(quiz);
    }


    public void updateQuiz(MyUserAnswers quizAnswers) throws JsonProcessingException {
        MyQuiz quiz = myQuizRepository.findById(quizAnswers.getQuizId()).get();

        for(Question q: quiz.getQuestions()) {
            q.setMyAnswerCorrect(0);
            for (MyAnswers a: quizAnswers.getAnswers()) {
                if (
                        Objects.equals(a.getQuestionId(), q.getId())
                    &&
                        Objects.equals(a.getAnswer(), q.getCorrectAnsIdx())
                ) {
                    q.setMyAnswerCorrect(1);
                }
            }
        }
        myQuizRepository.save(quiz);
    }


    public List<MyQuiz> getAllQuiz(){
        List<MyQuiz> quiz = new ArrayList<MyQuiz>();
        myQuizRepository.findAll().forEach(quiz::add);
        return quiz;
        //return quizUsers;
    }

    public MyQuiz getQuiz(Long id) {
        return myQuizRepository.findById(id).get();
    }

    public void deleteQuiz(Long id){
        myQuizRepository.deleteById(id);
    }

    public List<Question> getQuestionsList(Integer amount) throws JsonProcessingException {

        String url ="https://opentdb.com/api.php?amount="+amount +"&category=9&difficulty=easy&type=multiple";
        String jsonRes = restTemplate.getForObject(url,String.class);
        System.out.println(jsonRes);
        ObjectMapper mapper = new ObjectMapper();
        QuizResponse quizResponse = mapper.readValue(jsonRes,QuizResponse.class);
        System.out.println(quizResponse.getResults().size());
        //return  JSON List
        return quizResponse.getResults();
    }

    //this for randomizing the answers of question

    private void  processQuestionsList(List<Question> questions){
        for(Question q: questions){
            Random rnd=new Random();
            int idx = rnd.nextInt(4);
            q.setCorrectAnsIdx(idx);
            //List<String > ans = q.getAnswers();
            //ans.add(idx,q.getCorrect_answer());
            q.getAnswers().add(idx,q.getCorrect_answer());

        }

    }

}
