package test.evaluation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.crypto.provider.RSACipher;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationCommentDao;
import test.evaluation.dao.EvaluationDao;
import test.evaluation.dto.EvaluationCommentDto;
import test.evaluation.dto.EvaluationDto;

public class EvaluationListAction extends Action{
	// 한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT = 5;
	// 하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT = 5;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 보여줄 페이지 번호
		int pageNum = 1;
		// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum = request.getParameter("pageNum");
		// 페이지 번호가 파라미터로 넘어온다면
		if(strPageNum != null){
			// 페이지 번호를 설정한다.
			pageNum = Integer.parseInt(strPageNum);
		}
		
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum * PAGE_ROW_COUNT;
		// 전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = EvaluationDao.getInstance().getCount();
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
		// 끝 페이지 번호가 잘못된 값이라면
		if (totalPageCount < endPageNum) {
			endPageNum = totalPageCount; // 보정해준다.
		}

		// 시작 row 번호와 끝 row 번호를 dto 에 담는다.
		EvaluationDto dto = new EvaluationDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		int productNum = Integer.parseInt(request.getParameter("num"));

		List<EvaluationDto> list = EvaluationDao.getInstance().getList(productNum);
		List<EvaluationCommentDto> commentList = EvaluationCommentDao.getInstance().getList(productNum);
		System.out.println(productNum);
		
		System.out.println(productNum);
		request.setAttribute("list", list);
		
		request.setAttribute("productNum",productNum);
		request.setAttribute("commentList",commentList);
		// 현재 페이지 번호
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		// 전체 페이지 갯수
		request.setAttribute("totalPageCount", totalPageCount);
		
		return new ActionForward("/views/evaluation/evaluation.jsp");
	}
}
