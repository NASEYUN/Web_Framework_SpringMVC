package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Offer {
	
	private int id;
	private int year;
	private int semester;
	@Size(min=5, max=20, message="'Code' must be between 5 and 20 chars")
	private String subjectcode;
	@Size(min=5, max=20, message="'Code' must be between 5 and 20 chars")
	private String subject;
	@Size(min=2, max=10, message="'Code' must be between 2 and 10 chars")
	private String division;
	private int grade;
}
