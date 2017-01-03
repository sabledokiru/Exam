package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationDao;
import test.evaluation.dto.EvaluationDto;

public class EvaluationDetailAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("evaNum"));
		
		EvaluationDto dto = EvaluationDao.getInstance().getData(num);
		
		request.setAttribute("dto", dto);
		return new ActionForward("/views/evaluation/detail.jsp");
	}
}
