package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dao.QAWriterDao;
import test.question.answer.dto.QAAnswerDto;

public class QuestionADeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파라미터 num값 받아오기
		int num=Integer.parseInt(request.getParameter("num"));
		int productNum = Integer.parseInt(request.getParameter("productNum"));
		//dao를 통해 delete 메소드 실행
		QAWriterDao.getInstance().delete(num);
		
		//만약에 답글이 존재한다면...
		//일단 ref_num 값을 가지고온다.
		int ref_num=Integer.parseInt(request.getParameter("ref_num"));
		if(num==ref_num){//만약에 질문글의 num값과 답변글의 ref_num값이 같은것이 존재한다면...
			//ref_num을 삭제하라.
			QAAnswerDao.getInstance().delete(ref_num); 
		}
		//경로 이동시켜준다.
		return new ActionForward("/views/product/product_info.do?productNum="+productNum, true);
	}
	
}
