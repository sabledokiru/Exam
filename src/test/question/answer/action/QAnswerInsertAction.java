package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dto.QAAnswerDto;

public class QAnswerInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 저장할 파라미터값 가지고 오기
		String content=request.getParameter("content");
		int ref_num=Integer.parseInt(request.getParameter("ref_num"));
			
		//2. QAAnswerDto 객체 이용해서 dto에 담기
		QAAnswerDto dto=new QAAnswerDto();
		dto.setAnswerContent(content);
		dto.setAnswerRefnum(ref_num);
		
		//3. QAAnswerDao 메소드 이용해서 DB에 저장하기
		
		
		//4. 경로 이동시키기
		return new ActionForward("/");
	}

}
