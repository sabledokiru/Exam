package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationDao;

public class EvaluationDeleteAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("evaNum"));
		
		EvaluationDao.getInstance().delete(num);
		
		return new ActionForward("/views/evaluation/list.do");
	}
}
