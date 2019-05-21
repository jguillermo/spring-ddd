package com.lacafetalab.app.pepe.application.service;

import org.springframework.stereotype.Service;

import com.lacafetalab.app.pepe.domain.Question;
import com.lacafetalab.app.pepe.domain.QuestionRepository;

@Service
public class QuestionCreateUseCase {
	private QuestionRepository questionRepository;

	public QuestionCreateUseCase(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	public void execute(String id, String name) {
		Question question = Question.create(id, name);
		this.questionRepository.save(question);

	}
	
}
