package com.lacafetalab.app.pepetest.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.lacafetalab.app.pepe.domain.Question;
import com.lacafetalab.app.pepe.domain.QuestionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Test
	public void whenFindById_thenReturnQuestion() {
		// given
		Question questionOne = Question.create("123", "title");
		entityManager.persist(questionOne);
		entityManager.flush();
		
		// when 
		Question questionFound = questionRepository.findById(questionOne.getId()).orElse(null);
		
		//then
		assertThat(questionFound.getName()).isEqualTo(questionOne.getName());
		
		
	}

}
