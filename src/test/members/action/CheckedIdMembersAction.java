package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;

public class CheckedIdMembersAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. input요소에서의 아이디값을 불러온다.
		String memberId = request.getParameter("id");
		//2. DB에서 아이디값들을 불러와 inpt요소의 아이디값과 비교한다.
		boolean isSuccess=MembersDao.getInstance().checkedId(memberId);
		System.out.println(isSuccess);
		//3. ActionForward 객체 생성해서 리턴해주기 
		request.setAttribute("isSuccess",isSuccess);
		return new ActionForward("/views/users/result.jsp");
	}
	
}
