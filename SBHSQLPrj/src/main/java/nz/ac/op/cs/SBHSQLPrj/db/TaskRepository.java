package nz.ac.op.cs.SBHSQLPrj.db;


import nz.ac.op.cs.SBHSQLPrj.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    //task data stored here
}
