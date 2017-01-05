package test.question.answer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dto.QAAnswerDto;
import test.question.answer.dto.QAWriterDto;

public class QAnswerGetdataAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 값 가지고오기
		int num= Integer.parseInt(request.getParameter("num"));
		// dao 이용해서 데이터 출력하기
		List<QAAnswerDto> dto=QAAnswerDao.getInstance().getdata(num);
		request.setAttribute("dto", dto);
		
		return new ActionForward("/");
	}

}
