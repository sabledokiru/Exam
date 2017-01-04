package test.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test.controller.Action;
import test.controller.ActionForward;
import test.product.dao.ProductDao;
import test.product.dto.ProductDto;

public class ProductDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터로 전달되는 글번호를 읽어온다.
			int num=Integer.parseInt(request.getParameter("productNum"));
			//2. 조회수를 1 올린다.
			ProductDao.getInstance().increaseViewCount(num);
			//3. 글번호에 해당되는 글정보를 얻어온다.
			ProductDto dto=ProductDao.getInstance().getData(num);
			//4. request 에 글정보를 담는다.
			request.setAttribute("dto", dto);
			//5. 뷰페이지로 forward 이동해서 글정보를 응답한다.
			
				
			return new ActionForward("/views/product/detail.jsp");
	}

}
