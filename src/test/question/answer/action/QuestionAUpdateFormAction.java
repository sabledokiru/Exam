package test.question.answer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAWriterDao;
import test.question.answer.dto.QAWriterDto;

public class QuestionAUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1.가지고올 파라미터 num 가지고오기
		int num=Integer.parseInt(request.getParameter("num"));
		//2.dao 에 있는 getdata 메소드 이용하기
		List<QAWriterDto> dto=QAWriterDao.getInstance().getdata(num);
		//3. dto정보를 request에 담기
		request.setAttribute("dto", dto);
		//4. 수정할 글의 정보 출력해 주기
		return new ActionForward("updateform.jsp");
	}
	
}
