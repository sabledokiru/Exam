package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAWriterDao;
import test.question.answer.dto.QAWriterDto;

public class QuestionAUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//저장할 num값과 그외의 정보 값들 불러오기
		int num=Integer.parseInt(request.getParameter("num"));
		String mainquestion=request.getParameter("mainquestion");
		String detailquestion=request.getParameter("detailquestion");
		
		//dto 객체 생성
		QAWriterDto dto=new QAWriterDto();
		dto.setWriterNum(num);
		dto.setWriterMainquestion(mainquestion);
		dto.setWriterDetailquestion(detailquestion);
		//dao에서 update 메소드 실행
		QAWriterDao.getInstance().update(dto);
		
		//redirect 이동
		return new ActionForward("list.do",true);
	}
	
}
