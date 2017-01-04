package test.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.product.dto.ProductDto;

public class ProductUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수정할 글정보 얻어옴
		int num = Integer.parseInt(request.getParameter("productNum"));
		String productName = request.getParameter("productName");
		String brand  = request.getParameter("brand");
		String content = request.getParameter("content");
		int price = Integer.parseInt("price");
		String saveFileName = request.getParameter("saveFileName");
		long fileSize = Long.parseLong(request.getParameter("fileSize"));
		//db에 반영
		ProductDto dto = new ProductDto();
		
		dto.setProductName(productName);
		dto.setBrand(brand);
		dto.setContent(content);
		dto.setPrice(price);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		
		return new ActionForward("/private/product_list.do", true);
	}

}
