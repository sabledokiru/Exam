package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAWriterDao;
import test.question.answer.dto.QAWriterDto;

public class QuestionAInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파라미터로 전달되는 내용 읽어오기 
		
		//int writerNum = Integer.parseInt(request.getParameter("writerNum"));
		String writerMainquestion = request.getParameter("writerMainquestion");
		String writerDetailquestion = request.getParameter("writerDetailquestion");		
		String id = (String)request.getSession().getAttribute("id");
		int productNum = Integer.parseInt(request.getParameter("productNum"));
		//새댓글 정보를 Dto 에 담는다.
		QAWriterDto dto=new QAWriterDto();
		
		//dto.setWriterNum(writerNum);
		dto.setWriterWriter(id);
		dto.setWriterMainquestion(writerMainquestion);
		dto.setWriterDetailquestion(writerDetailquestion);

		//QAWriterDao 객체를 이용해서 insert 시키기
		QAWriterDao.getInstance().insert(dto);
		return new ActionForward("/views/product/product_info.do?productNum="+productNum, true);
	}

}
