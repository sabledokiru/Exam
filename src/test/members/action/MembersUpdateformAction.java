package test.members.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.members.dao.MembersDao;
import test.members.dto.MembersDto;

public class MembersUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터로 전달되는 수정할 id 읽어오기
		String memberId=(String)request.getSession().getAttribute("id");
		//2. 수정할 글의 정보 얻어오기
		MembersDto dto=MembersDao.getInstance().getData(memberId);
		//3. request 에 dto 를 담고
		request.setAttribute("dto", dto);
		//4. forward 이동으로 경로 이동해준다.
		return new ActionForward("/views/users/private/user_modify_form.jsp");
	}

}
