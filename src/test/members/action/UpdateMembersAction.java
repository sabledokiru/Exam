package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;
import test.members.dto.MembersDto;

public class UpdateMembersAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. form 전송되는 파라미터 추출
		String memberId=request.getParameter("id");
		String memberPwd=request.getParameter("pwd");
		String memberEmail=request.getParameter("email");
		String memberPhone=request.getParameter("phone");
		String memberAddr=request.getParameter("addr");
		//2. MemberDto 에 파라미터값 담기
		MembersDto dto=new MembersDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberEmail(memberEmail);
		dto.setMemberPhone(memberPhone);
		dto.setMemberAddr(memberAddr);
		//3. DB 에 수정 반영 
		boolean isSuccess  = MembersDao.getInstance().update(dto);
		request.setAttribute("isSuccess",isSuccess);
		return new ActionForward("/views/users/result.jsp");
	}
	
}
