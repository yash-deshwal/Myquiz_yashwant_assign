package nz.ac.op.cs.SBHSQLPrj.db;

import nz.ac.op.cs.SBHSQLPrj.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    //storing data for question from opentdb
}
