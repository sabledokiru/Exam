package test.product.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.product.dao.ProductDao;
import test.product.dto.ProductDto;

public class ProductInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
	      //파일을 저장할 폴더의 절대 경로를 얻어온다.
	      String realPath=application.getRealPath("/upload");
	      //파일이 저장되는 경로를 콘솔에 테스트로 출력해보기
	      System.out.println(realPath);
	      //최대 업로드 사이즈
	      int sizeLimit=1024*1000*50; //50 MByte
	      
	      //cos.jar 라이브러리에 있는 클래스를 이용해서 객체 생성하기 
	      MultipartRequest mr = null;
	      try {
	         mr = new MultipartRequest(request, 
	               realPath,       //파일을 저장할 실제 경로
	               sizeLimit,       //사이즈 제한
	               "utf-8",      //한글 파일명 깨지지 않도록
	               new DefaultFileRenamePolicy());
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }//파일명 겹치지 않도록 
	      //업로드된 파일에 대한 정보는 mr 객체를 통해서 얻어온다.
	     
	    
	      String productName = mr.getParameter("productName");
	      String brand = mr.getParameter("brand");
	      int price = Integer.parseInt(mr.getParameter("price"));
	      String content = mr.getParameter("ir1");
	      String saveFileName=mr.getFilesystemName("myFile");
	      long fileSize=mr.getFile("myFile").length();
	      //업로드된 파일의 정보를 FileDto 객체에 담는다.
	      ProductDto dto=new ProductDto();
	      dto.setProductName(productName);
	      dto.setBrand(brand);
	      dto.setPrice(price);
	      dto.setContent(content);
	      dto.setSaveFileName(saveFileName);
	      dto.setFileSize(fileSize);
	      //FileDao 객체를 이용해서 파일의 정보를 DB 에 저장한다.
	      ProductDao.getInstance().insert(dto);

		return new ActionForward("/product/private/product_list.do", true);
	}

}
