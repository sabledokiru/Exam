package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;

public class QAnswerDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//num값 파라미터 값으로 받아오기
		int num=Integer.parseInt(request.getParameter("num"));
		int productNum = Integer.parseInt(request.getParameter("productNum"));
		//dao에서 delete 실행
		QAAnswerDao.getInstance().delete(num);
		//경로 이동
		return new ActionForward("/views/product/product_info.do?productNum="+productNum, true);
	}
}
