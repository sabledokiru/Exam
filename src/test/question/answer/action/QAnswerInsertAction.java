package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dto.QAAnswerDto;

public class QAnswerInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int writerNum=Integer.parseInt(request.getParameter("writerNum"));
		
		//1. 저장할 파라미터값 가지고 오기
		String answerContent=request.getParameter("answerContent");
		int answerRef_num=writerNum;
			
		//2. QAAnswerDto 객체 이용해서 dto에 담기
		QAAnswerDto dto=new QAAnswerDto();
		dto.setAnswerContent(answerContent);
		dto.setAnswerRef_num(answerRef_num);
		
		//3. QAAnswerDao 메소드 이용해서 DB에 저장하기
		QAAnswerDao.getInstance().insert(dto);
		return new ActionForward("/views/product/product_list.jsp");
	}

}
