package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;

public class DeleteMembersAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. GET 방식 파라미터로 넘어오는 삭제할 회원의 번호 읽어오기
		String id=request.getParameter("id");
		//2. DB에서 삭제하기 
		MembersDao.getInstance().delete(id);
		//3. ActionForward 객체 생성해서 리턴해주기 z
		return new ActionForward("/alert.jsp");
	}
	
}
