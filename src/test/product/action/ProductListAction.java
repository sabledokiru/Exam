package test.product.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test.controller.Action;
import test.controller.ActionForward;
import test.product.dao.ProductDao;
import test.product.dto.ProductDto;

public class ProductListAction extends Action{
	
	
	
	//한 페이지에 나타낼 로우의 갯수
			private static final int PAGE_ROW_COUNT=9;
			//하단 디스플레이 페이지 갯수
			private static final int PAGE_DISPLAY_COUNT=5;
			
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		//BoardDto 객체를 생성해서
		ProductDto dto=new ProductDto();
		if(keyword != null){ //검색어가 전달된 경우
			if(condition.equals("productName")){ //상품명 검색
				dto.setProductName(keyword);
		
			}else if(condition.equals("brand")){//제조사 검색
				dto.setBrand(keyword);
			}
			// list.jsp 뷰페이지에서 필요한 내용을 request 에 담는다.
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}
		
		//보여줄 페이지의 번호
		int pageNum=1;
		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
			//페이지 번호를 설정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		//전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = ProductDao.getInstance().getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount=
				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=
			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; //보정해준다. 
		}
		
		//시작 row 번호와 끝 row 번호를 dto 에 담는다. 
		
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

//1. 카페 글 목록을 읽어온다.
List<ProductDto> list=ProductDao.getInstance().getList(dto);
//2. request 에 담는다
request.setAttribute("list", list);

//2. 조회수가 가장많은 아이템5개의 리스트를 가져옴
List<ProductDto> list2 = ProductDao.getInstance().getRankedViewCount();
request.setAttribute("list2", list2);

//3.쿠키 가져오기
List<Integer> recentNums=null;
if(recentNums==null){
	recentNums=new ArrayList<Integer>();
	//request.getSession().setAttribute("recentNums",num1);
}else{
	int re =Integer.parseInt((String) request.getSession().getAttribute("num1"));
	//(List<Integer>)request.getSession().getAttribute("num1");
	recentNums.add(re);
	System.out.println(recentNums.get(0));
}



// 현재 페이지 번호 
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		// 전재 페이지의 갯수
		request.setAttribute("totalPageCount", totalPageCount);
		
//3. 뷰페이지로 forward 이동 해서 글 목록 출력하기
return new ActionForward("/views/product/product_list.jsp");		
	}

}
