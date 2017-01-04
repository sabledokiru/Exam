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
		
		String memberId=request.getParameter("id");
		String memberPwd=request.getParameter("pwd");	
		String goUri;
		// 2. 아이디 비밀번호를 MembersDto 에 담는다.
		MembersDto dto= new MembersDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		// 3. 유효한 정보인지 확인
		boolean isSuccess=MembersDao.getInstance().isValid(dto);
		System.out.println(isSuccess);
		if(isSuccess){
			goUri = "/index.jsp";
			System.out.println(goUri);
			request.getSession().setAttribute("id",memberId);
		}else{
			goUri = "/views/users/signin_form.do?uri=/";
			System.out.println(goUri);
		}
		return new ActionForward(goUri,true);
	}

}
