package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.SynchronizedStack;

import test.controller.Action;
import test.controller.ActionForward;

public class SignInFormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uri = request.getParameter("uri");
		String contextName=request.getContextPath();
		//순수 요청 경로를 추출 한다.
		// command => /fortune or /time or /signin 
		String command=uri.substring(contextName.length(),
				uri.length());
		request.getSession().setAttribute("uri", command);
		return new ActionForward("/views/users/signin_form.jsp",true);
	}
}
