package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;
import test.members.dto.MembersDto;

public class InsertMembersAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터로 전달되는 값 불러오기
		String memberId = request.getParameter("id");
		String memberPwd = request.getParameter("pwd");
		String memberEmail = request.getParameter("email");
		String memberPhone = request.getParameter("phone");
		String memberAddr = request.getParameter("addr");
		//2. 아이디 ,비밀번호 ,이메일 ,번호 ,주소을 dto에 담는다.
		MembersDto dto=new MembersDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberEmail(memberEmail);
		dto.setMemberPhone(memberPhone);
		dto.setMemberAddr(memberAddr);
		//3. DB 에 저장한다.
		MembersDao.getInstance().insert(dto);
		//4. redirect 이동 처리
		return new ActionForward("/alert.jsp");
	}
	
}
