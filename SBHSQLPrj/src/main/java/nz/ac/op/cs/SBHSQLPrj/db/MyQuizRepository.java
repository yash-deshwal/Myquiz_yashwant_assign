package nz.ac.op.cs.SBHSQLPrj.db;

import nz.ac.op.cs.SBHSQLPrj.models.MyQuiz;
import org.springframework.data.repository.CrudRepository;


public interface MyQuizRepository extends CrudRepository<MyQuiz, Long> {
    //database for quiz with questions
}
