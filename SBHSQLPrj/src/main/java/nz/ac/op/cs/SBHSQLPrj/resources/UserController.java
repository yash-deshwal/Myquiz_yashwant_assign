package nz.ac.op.cs.SBHSQLPrj.resources;



import nz.ac.op.cs.SBHSQLPrj.models.QuizUser;
import nz.ac.op.cs.SBHSQLPrj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //controller for dispaying the users on rest api and for their functioning like get post put delete

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<QuizUser> getQuizUsers(){
        return userService.getAllQuizUsers();
    }
    @GetMapping("/users/{id}")
    public QuizUser getQuizUser(@PathVariable String id){
        return userService.getQuizUser(id);
    }
   // @RequestMapping(method=RequestMethod.POST, value="/users")
    @PostMapping("/users")
    public void addQuizUser(@RequestBody QuizUser quizUser){
        userService.addQuizUser(quizUser);

    }
    @PutMapping("/users")
    public void updateQuizUser(@RequestBody QuizUser quizUser){
        userService.updateQuizUser(quizUser);
    }
    @DeleteMapping("/users/{id}")
    public void deleteQuizUser(@PathVariable String id){
        userService.deleteQuizUser(id);
    }

}
