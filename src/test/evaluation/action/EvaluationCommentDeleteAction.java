package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationCommentDao;

public class EvaluationCommentDeleteAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String ref_group = request.getParameter("ref_group");
		
		EvaluationCommentDao.getInstance().delete(num);
		return new ActionForward("/cafe/detail.do?num=" + ref_group , true);
	}
}
