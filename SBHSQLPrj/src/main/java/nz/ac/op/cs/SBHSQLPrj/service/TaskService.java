package nz.ac.op.cs.SBHSQLPrj.service;

import nz.ac.op.cs.SBHSQLPrj.db.QuizUserRepository;
import nz.ac.op.cs.SBHSQLPrj.db.TaskRepository;
import nz.ac.op.cs.SBHSQLPrj.models.QuizUser;
import nz.ac.op.cs.SBHSQLPrj.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    //all the functioning for the provide function in model class for creating update post deleting

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        List<Task> tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
        //return quizUsers;
    }

    public Task getTask(Integer id){
        return taskRepository.findById(id).get();

    }

    public void addTask(Task task){
        taskRepository.save(task);
        //quizUsers.add(user);
    }

    public void updateTask(Task task){
        taskRepository.save(task);
    }
    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }
}
