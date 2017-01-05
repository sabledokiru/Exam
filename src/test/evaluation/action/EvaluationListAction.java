package test.evaluation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationDao;
import test.evaluation.dto.EvaluationDto;

public class EvaluationListAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int productNum = Integer.parseInt(request.getParameter("num"));
		List<EvaluationDto> list = EvaluationDao.getInstance().getList(productNum);
		request.setAttribute("list", list);
		request.setAttribute("productNum",productNum);
		return new ActionForward("/views/evaluation/evaluation.jsp");
	}
}
