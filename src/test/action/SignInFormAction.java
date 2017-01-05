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
		return new ActionForward("/views/users/signin_form.jsp",true);
	}
}
