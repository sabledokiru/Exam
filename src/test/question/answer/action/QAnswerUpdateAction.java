package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dto.QAAnswerDto;

public class QAnswerUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1.수정할 num값 가지고오기
		int num=Integer.parseInt(request.getParameter("num"));
		//2.수정할 content내용 가지고오기
		String content=request.getParameter("content");
		//3. DB에 저장할 dto 객체 생성
		QAAnswerDto dto=new QAAnswerDto();
		//4. DB에 수정된 값들 저장하기
		dto.setAnswerContent(content);
		dto.setAnswerNum(num);
		QAAnswerDao.getInstance().update(dto);
		
		//5. redirect 이동
		return new ActionForward("alist.do",true);
	}
	
}
