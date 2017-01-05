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
		System.out.println(productNum);
		List<EvaluationDto> list = EvaluationDao.getInstance().getList();
		System.out.println("오류전");
		request.setAttribute("list", list);
		return new ActionForward("/views/evaluation/evaluation.jsp");
	}
}
