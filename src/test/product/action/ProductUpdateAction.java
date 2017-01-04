package test.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class ProductUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수정할 글정보 얻어옴
		int num = Integer.parseInt(request.getParameter("num"));
		
		//db에 반영
		return null;
	}

}
