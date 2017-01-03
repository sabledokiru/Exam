package test.members.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;
import test.members.dto.MembersDto;

public class GetlistMembersAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 회원목록을 얻어온다.
		List<MembersDto> list = MembersDao.getInstance().getList();
		//2. request 에 Model 을 담는다.
		request.setAttribute("list",list);
		//3. ActionForward 객체 리턴해주기 z
		return new ActionForward("list.jsp");
	}
	
}
