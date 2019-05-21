package com.lacafetalab.app.pepe.infrastructure.handler;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacafetalab.app.pepe.application.service.QuestionCreateUseCase;
import com.lacafetalab.app.pepe.application.service.QuestionFindByIdUseCase;
import com.lacafetalab.app.pepe.domain.Question;

@RestController
@RequestMapping("/pepe/question")
public class QuestionHandler {
	private QuestionCreateUseCase questionCreateUseCase;
	private QuestionFindByIdUseCase questionFindByIdUseCase;
	

	public QuestionHandler(QuestionCreateUseCase questionCreateUseCase,
			QuestionFindByIdUseCase questionFindByIdUseCase) {
		
		this.questionCreateUseCase = questionCreateUseCase;
		this.questionFindByIdUseCase = questionFindByIdUseCase;
	}

	@GetMapping("")
	public ResponseEntity<String> onGet(){
		UUID uuid = UUID.randomUUID();
		this.questionCreateUseCase.execute(uuid.toString(), "cursos");
		return ResponseEntity.ok().body(uuid.toString());
	}
	
	@GetMapping("/{question_id}")
	public ResponseEntity<Question> onGetById(@PathVariable("question_id") String id){
		
		Question question = this.questionFindByIdUseCase.execute(id);
		
		return ResponseEntity.ok().body(question);
	}
	
	
}
