package com.lacafetalab.app.pepetest.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lacafetalab.app.pepe.application.service.QuestionFindByIdUseCase;
import com.lacafetalab.app.pepe.domain.Question;
import com.lacafetalab.app.pepe.domain.QuestionRepository;

@RunWith(SpringRunner.class)
public class QuestionFindByIdUseCaseTest {
	
	private QuestionFindByIdUseCase questionFindByIdUseCase;
	
	@MockBean
	private QuestionRepository questionRepository;
	
	
	@Before
	public void setUp() {
		questionFindByIdUseCase = new QuestionFindByIdUseCase(questionRepository);
		
		Question question = Question.create("123", "title"); 
		Mockito.when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
	}
	
	@Test
	public void whenValidId_thenQuestionFind() {
		Question question = questionFindByIdUseCase.execute("123");
		assertThat(question.getName()).isEqualTo("title");
	}
	
	@Test
	public void whenValidId_thenQuestionNotFound() {
		Question question = questionFindByIdUseCase.execute("1234");
		assertThat(question).isNull();
	}

}
