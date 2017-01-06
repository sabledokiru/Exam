package test.question.answer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dao.QAWriterDao;
import test.question.answer.dto.QAAnswerDto;
import test.question.answer.dto.QAWriterDto;

public class QuestionAGetlistAction extends Action{
	
	// 한 페이지에 나타낼 row의 갯수
		private static final int PAGE_ROW_COUNT=5;
		// 하단 display 페이지 갯수
		private static final int PAGE_DISPLAY_COUNT=5;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	
		// 방명록 목록 보기 요청처리
		
				// 보여줄 페이지의 번호
				int pageNum = 1;
				// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
				String strPageNum = request.getParameter("pageNum");
				if(strPageNum != null){ // 페이지 번호가 파라미터로 넘어온다면
					// 페이지 번호를 설정한다.
					pageNum = Integer.parseInt(strPageNum);
				}
				
				//보여줄 페이지 데이터의 시작 ResultSet row 번호
				int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
				//보여줄 페이지 데이터의 끝 ResultSet row 번호
				int endRowNum=pageNum*PAGE_ROW_COUNT;
				//전체 row 의 갯수를 DB 에서 얻어온다.
				int totalRow = QAWriterDao.getInstance().getCount();
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
				
				QAWriterDto dto = new QAWriterDto();
				dto.setStartRowNum(startRowNum);
				dto.setEndRowNum(endRowNum);
				int productNum = Integer.parseInt(request.getParameter("num"));
				
//				// 1. BoardDao 객체를 이용해서 글 목록을 얻어온다.
				List<QAWriterDto> list = QAWriterDao.getInstance().getList(dto);
//				// 2. 모델을 request 에 담는다.
				request.setAttribute("list", list);
				
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("startPageNum", startPageNum);
				request.setAttribute("endPageNum", endPageNum);
				request.setAttribute("productNum",productNum);
				// 전체 페이지의 갯수
				request.setAttribute("totalPageCount", totalPageCount);
				
				
				
				
		//1. 목록을 얻어온다.
		List<QAWriterDto> result_list = QAWriterDao.getInstance().getList(dto);
		List<QAAnswerDto> result_list2 = QAAnswerDao.getInstance().getList();
		//2. request 에 Model 을 담는다.
		request.setAttribute("list", result_list);
		request.setAttribute("list2", result_list2);
		//3. ActionForward 객체 리턴해주기
	
		
		return new ActionForward("/views/product/q&a.jsp");
	}

}
