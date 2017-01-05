package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationCommentDao;
import test.evaluation.dto.EvaluationCommentDto;

public class EvaluationCommentUpdateAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String content = request.getParameter("content");
		int ref_group = Integer.parseInt(request.getParameter("ref_group"));
		int num = Integer.parseInt(request.getParameter("comNum"));
		
		EvaluationCommentDto dto = new EvaluationCommentDto();
		dto.setComNum(num);
		dto.setComContent(content);
		
		EvaluationCommentDao.getInstance().update(dto);
		
		return new ActionForward("/evaluation/detail.do?num=" + ref_group , true);
	}
}
