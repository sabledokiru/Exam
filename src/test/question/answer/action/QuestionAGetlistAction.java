package test.question.answer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAWriterDao;
import test.question.answer.dto.QAWriterDto;

public class QuestionAGetlistAction extends Action{
	
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	
		

		//1. 목록을 얻어온다.
		List<QAWriterDto> list = QAWriterDao.getInstance().getList();
		//2. request 에 Model 을 담는다.
		request.setAttribute("list", list);
		//3. ActionForward 객체 리턴해주기
		for(QAWriterDto tmp : list){
		System.out.println(tmp.getWriterWriter());
		}
		return new ActionForward("/views/product/q&a.jsp");
	}

}
