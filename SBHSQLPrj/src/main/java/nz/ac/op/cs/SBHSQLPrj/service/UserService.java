package nz.ac.op.cs.SBHSQLPrj.service;


import nz.ac.op.cs.SBHSQLPrj.db.QuizUserRepository;
import nz.ac.op.cs.SBHSQLPrj.models.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private QuizUserRepository userRepository;

    //all the functioning for the provide function in model class for creating update post deleting


    public List<QuizUser> getAllQuizUsers(){
        List<QuizUser> users = new ArrayList<QuizUser>();
        userRepository.findAll().forEach(users::add);
        return users;

    }

    public QuizUser getQuizUser(String id){
        return userRepository.findById(id).get();

    }

    public void addQuizUser(QuizUser user){
        userRepository.save(user);

    }

    public void updateQuizUser(QuizUser user){
        userRepository.save(user);
    }
    public void deleteQuizUser(String id){
        userRepository.deleteById(id);
    }

}
