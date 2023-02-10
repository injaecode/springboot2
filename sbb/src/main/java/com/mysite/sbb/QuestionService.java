package com.mysite.sbb;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class QuestionService {
	//JPA메소드를 사용하기 위해 (생성자를 이용한 객체 자동 주입)
	private final QuestionRepository questionRepository;
	//메소드: question 테이블의 List 정보를 가져오는 메소드
	public List<Question> getList() {
		 return this.questionRepository.findAll();
		 }
	//상세 페이지를 처리하는 메소드 : id를 받아서 question테이블을 select (findById(1))
		//select한 레코드를 Question객체에 담아서 리턴
	public Question getQuestion(Integer id) {
		
		//select * from question where id=?
		Optional<Question> op = this.questionRepository.findById(id);
		if(op.isPresent()) {
		return op.get();
		}else {
			//사용자 정의 예외 - throw : 예외를 강제로 발생
						//- throws : 예외를 요청한 곳에서 처리하도록 미루는 것
			throw new DataNotFoundException("요청한 파일을 찾지 못했습니다");
		}
	}
}
