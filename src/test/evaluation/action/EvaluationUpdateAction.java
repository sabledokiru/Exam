package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationDao;
import test.evaluation.dto.EvaluationDto;

public class EvaluationUpdateAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 폼 전송된 수정할 글의 정보얻어오기
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("ir1");
		
		// 2. DB에 수정 반영
		EvaluationDto dto = new EvaluationDto();
		dto.setEvaNum(num);
		dto.setEvaTitle(title);
		dto.setEvaContent(content);
		
		EvaluationDao.getInstance().update(dto);
		
		return new ActionForward("/evaluation/detail.do");
	}
}
