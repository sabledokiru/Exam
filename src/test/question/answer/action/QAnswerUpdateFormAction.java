package test.question.answer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dto.QAAnswerDto;

public class QAnswerUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1.가지고올 정보의 파라미터 넘값 가지고 오기
		int num=Integer.parseInt(request.getParameter("num"));
		//2.가지고온 num파라미터로 dao getdata 출력하기
		List<QAAnswerDto> dto=QAAnswerDao.getInstance().getdata(num);
		//3. dto정보를 request에 담기
		request.setAttribute("dto", dto);
		//4. 수정할 글의 정보 출력해 주기
		return new ActionForward("aupdateform.jsp");
	}
	
}
