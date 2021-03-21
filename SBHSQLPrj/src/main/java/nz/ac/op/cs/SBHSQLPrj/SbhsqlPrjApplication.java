package nz.ac.op.cs.SBHSQLPrj;

import nz.ac.op.cs.SBHSQLPrj.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SbhsqlPrjApplication {
	//created beans for each and every service to run the function in it or to make program work
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	@Bean
	public QuestionService getQuestionService(){
		return new QuestionService();
	}
	@Bean
	public TaskService getTaskService(){
		return new TaskService();
	}
	@Bean
	public QuizService getQuizService(){
		return new QuizService();
	}

	@Bean
	public MyQuizService getMyQuizService(){
		return new MyQuizService();
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SbhsqlPrjApplication.class, args);
	}

}
