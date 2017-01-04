package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class QAInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파라미터로 전달되는 내용 읽어오기 
		
		//댓글 내에서의 그룹번호를 읽어온다.
		//null 이면 원글에 대한 덧글이고 아니면 덧글에 대한 덧글이다.
		
		//저장할 댓글 번호를 미리 읽어온다.
		
		//새댓글 정보를 Dto 에 담는다.
		
		
		return null;
	}

}
