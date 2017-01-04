package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class SignOutMemberAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1.세션에 있는 아이디값 제거하기
		request.getSession().removeAttribute("id");
		// 2.응답하기
		return new ActionForward("/index.jsp",true);
	}

}
