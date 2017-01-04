package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationDao;
import test.evaluation.dto.EvaluationDto;

public class EvaluationInsertAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터로 전송되는 글 제목, 글 내용 읽어오기
				String title = request.getParameter("title");
				String content = request.getParameter("ir1");
				
				// 세션에 저장된 id 정보 읽어오기
				String id = (String)request.getSession().getAttribute("id");
				
				// CafeDto 에 정보 담기
				EvaluationDto dto = new EvaluationDto();
				dto.setEvaWriter(id);
				dto.setEvaTitle(title);
				dto.setEvaContent(content);
				
				// CafeDao 객체를 이용해서 DB에 저장하기
				EvaluationDao.getInstance().insert(dto);
				
				return new ActionForward("/evaluation/list.do", true);
	}
}
