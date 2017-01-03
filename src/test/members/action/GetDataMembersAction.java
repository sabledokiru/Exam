package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;

public class GetDataMembersAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 출력할 id의 파라미터 값을 가지고온다.
		String memberId=request.getParameter("id");
		//2. DB에서 출력한다.
		MembersDao.getInstance().getData(memberId);
		//3. forward 객체를 생성해서 이동시켜준다.
		return new ActionForward("index.jsp");
	}

}
