package nz.ac.op.cs.SBHSQLPrj.resources;

import nz.ac.op.cs.SBHSQLPrj.models.Quiz;
import nz.ac.op.cs.SBHSQLPrj.models.QuizUser;
import nz.ac.op.cs.SBHSQLPrj.models.Task;
import nz.ac.op.cs.SBHSQLPrj.service.QuizService;
import nz.ac.op.cs.SBHSQLPrj.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    //controller for dispaying the quiz on rest api and for their functioning like get post put delete

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz")
    public List<Quiz> getQuiz(){
        return quizService.getAllQuizzs();
    }
    @GetMapping("/quiz/{id}")
    public Quiz getQuiz(@PathVariable Long id)
    {
        return quizService.getQuiz(id);
    }
    @PostMapping("/quiz")
    public void addQuiz(@RequestBody QuizUser quizUser){
        quizService.createQuiz(quizUser, 10);

    }
    @DeleteMapping("/quiz/{id}")
    public void deleteQuizUser(@PathVariable Long id){

        quizService.deleteQuiz(id);
    }
}
