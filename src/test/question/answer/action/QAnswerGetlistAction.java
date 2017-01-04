package test.question.answer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dto.QAAnswerDto;

public class QAnswerGetlistAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 목록을 얻어온다.
		List<QAAnswerDto> list = QAAnswerDao.getInstance().getList();
		//2. request 에 Model 을 담는다.
		request.setAttribute("alist", list);
		//3. ActionForward 객체 리턴해주기
		return new ActionForward("/");
	}

}
