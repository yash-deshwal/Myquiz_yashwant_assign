package nz.ac.op.cs.SBHSQLPrj.db;

import nz.ac.op.cs.SBHSQLPrj.models.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz,Long> {
    //strong quiz data but without question
}
