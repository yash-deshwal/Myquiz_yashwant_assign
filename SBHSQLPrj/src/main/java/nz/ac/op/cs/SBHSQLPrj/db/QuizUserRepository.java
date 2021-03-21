package nz.ac.op.cs.SBHSQLPrj.db;


import nz.ac.op.cs.SBHSQLPrj.models.QuizUser;
import org.springframework.data.repository.CrudRepository;

public interface QuizUserRepository  extends CrudRepository<QuizUser, String>{
    //user data stored here
}
