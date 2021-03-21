package nz.ac.op.cs.SBHSQLPrj.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import nz.ac.op.cs.SBHSQLPrj.models.*;
import nz.ac.op.cs.SBHSQLPrj.service.MyQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyQuizController {
    @Autowired
    private MyQuizService myQuizService;

    //controller for dispaying the my quiz on rest api and for their functioning like get post put delete

    @GetMapping("/myquiz")
    public List<MyQuiz> getQuiz(){
        return myQuizService.getAllQuiz();
    }
    @GetMapping("/myquiz/{id}")
    public MyQuiz getQuiz(@PathVariable Long id)
    {
        return myQuizService.getQuiz(id);
    }

    @PostMapping("/myquiz")
    public void addQuiz(@RequestBody MyQuizParam quizParam) throws JsonProcessingException {
        myQuizService.createQuiz(quizParam);
    }
    @PutMapping("/myquiz")
    public void updateQuizUser(@RequestBody MyUserAnswers quizAnswers) throws JsonProcessingException {
        myQuizService.updateQuiz(quizAnswers);
    }
    @DeleteMapping("/myquiz/{id}")
    public void deleteQuiz(@PathVariable Long id){
        myQuizService.deleteQuiz(id);
    }

}
