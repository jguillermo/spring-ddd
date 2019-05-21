package com.lacafetalab.app.pepe.application.service;

import org.springframework.stereotype.Service;

import com.lacafetalab.app.pepe.domain.Question;
import com.lacafetalab.app.pepe.domain.QuestionRepository;

@Service
public class QuestionFindByIdUseCase {
	private QuestionRepository questionRepository;

	public QuestionFindByIdUseCase(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	public Question execute(String id) {
		return this.questionRepository.findById(id).orElse(null);

	}
	
	
}
