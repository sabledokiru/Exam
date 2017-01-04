package test.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test.controller.Action;
import test.controller.ActionForward;
import test.product.dao.ProductDao;
import test.product.dto.ProductDto;

public class productUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터로 전달되는 수정할 글번호 읽어오기
			int num=Integer.parseInt(request.getParameter("productNum"));
			//2. 수정할 글의 정보 얻어오기
			ProductDto dto=ProductDao.getInstance().getData(num);
			//3. request 에 dto 를 담고
			request.setAttribute("dto", dto);
			//4. 수정할 글의 정보 출력해 주기
			return new ActionForward("/private/updateform.jsp");
		
	}

}
