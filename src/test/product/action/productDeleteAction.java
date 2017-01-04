package test.product.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test.controller.Action;
import test.controller.ActionForward;
import test.product.dao.ProductDao;

public class productDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//어플리케이션 객체 얻어오기
		ServletContext application = request.getServletContext();
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		//삭제할 파일의 저장된 파일명(saveFileName)을 읽어온다.
		String saveFileName=
				ProductDao.getInstance().getData(num).getSaveFileName();
		
		//db에서 파일정보 삭제
		ProductDao.getInstance().delete(num);
		//파일 시스템에서 삭제.
		String path = application.getRealPath("/upload")+ 
				File.separator+saveFileName;
		//파일객체 생성해서 삭제한다.
		new File(path).delete();
		
		return new ActionForward("/product/product_list.do");
	}

}
