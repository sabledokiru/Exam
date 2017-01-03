package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;
import test.members.dto.MembersDto;

public class SigninAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 파라미터로 전달되는 값 내용 읽어오기
		String uri=request.getParameter("uri");
		String memberId=request.getParameter("id");
		String memberPwd=request.getParameter("pwd");
		// 2. 아이디 비밀번호를 MembersDto 에 담는다.
		MembersDto dto= new MembersDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		// 3. 유효한 정보인지 확인
		boolean isSuccess=MembersDao.getInstance().isValid(dto);
		if(isSuccess==true){
			request.getSession().setAttribute("id", memberId);
			request.setAttribute("msg", memberId+"님 로그인 되었습니다.");
			request.setAttribute("redirectUri", uri);
		}else{
			request.setAttribute("msg", "아이디 혹은 비밀번호가 틀려요!");
			String location=request.getContextPath()+"/users/signin_form.do?uri="+uri;
			request.setAttribute("redirectUri", location);
		}
		return new ActionForward("/views/users/alert.jsp");
	}

}
