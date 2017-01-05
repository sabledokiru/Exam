package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class EvaluationInsertformAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		return new ActionForward("/views/evaluation/private/eval_insertform.jsp",true);
	}
}
