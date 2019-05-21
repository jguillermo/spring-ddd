package com.lacafetalab.app.pepe.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name="questions")
public class Question {
	@Id
	@Column(length = 36, unique = true, nullable = false)
	private String id;
	private String name;
	
	public static Question create(String id, String name) {
		Question question = new Question();
		question.id = id;
		question.name = name;
		return question;
	}
	
}
