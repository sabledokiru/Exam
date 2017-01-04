package test.controller;

import test.action.MainAction;
import test.action.SignInFormAction;
import test.action.SignUpFormAction;
import test.evaluation.action.EvaluationDeleteAction;
import test.evaluation.action.EvaluationDetailAction;
import test.evaluation.action.EvaluationInsertAction;
import test.evaluation.action.EvaluationInsertformAction;
import test.evaluation.action.EvaluationListAction;
import test.evaluation.action.EvaluationUpdateAction;
import test.evaluation.action.EvaluationUpdateformAction;
import test.members.action.CheckedIdMembersAction;
import test.members.action.InsertMembersAction;
import test.members.action.MembersUpdateformAction;
import test.members.action.SignOutMemberAction;
import test.members.action.SigninAction;
import test.members.action.UpdateMembersAction;
import test.product.action.ProductInsertformAction;
import test.product.action.ProductListAction;
import test.product.action.ProductUpdateAction;
import test.product.action.productDeleteAction;
import test.product.action.productUpdateFormAction;
import test.question.answer.action.QAInsertAction;

public class UserActionFactory {
	private static UserActionFactory factory;

	private UserActionFactory() {
	}

	// 자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance() {
		if (factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}

	// 인자로 전달되는 command 를 수행할 Action Type 객체를 생성해서
	// 리턴해주는 메소드
	public Action action(String command){
		Action action=null;
		if(command.equals("/main")){
			action = new MainAction();
		}else if(command.equals("/views/main")){
			action = new MainAction();
		}else if(command.equals("/views/users/signin_form")){
			action = new SignInFormAction();
		}else if(command.equals("/views/users/signin")){
			action = new SigninAction();
		}else if(command.equals("/views/users/signup_form")){
			action = new SignUpFormAction();
		}else if(command.equals("/views/users/signup")){
			action = new InsertMembersAction();
		}else if(command.equals("/views/users/private/update_form")){
			action = new MembersUpdateformAction();
		}else if(command.equals("/views/users/private/update")){
			action = new UpdateMembersAction();
		}else if(command.equals("/views/users/idCheck")){
			action = new CheckedIdMembersAction();	
		}else if(command.equals("/views/users/logout")){
			action = new SignOutMemberAction();
		}else if(command.equals("/views/product/private/insertform")){
			action = new ProductInsertformAction();
		}else if(command.equals("/views/product/list")){
			action = new ProductListAction();
		}
		
//		else if(command.equals("/views/evaluation/private/insertform")){
//			action = new EvaluationInsertformAction();
//		}
//		else if(command.equals("/views/evaluation/insert")){
//			action = new EvaluationInsertAction();
//		}
//		else if(command.equals("/views/evaluation/private/updateform")){
//			action = new EvaluationUpdateformAction();
//		}
//		else if(command.equals("/views/evaluation/update")){
//			action = new EvaluationUpdateAction();
//		}
		else if(command.equals("/views/evaluation/delete")){
			action = new EvaluationDeleteAction();
		}
		else if(command.equals("/views/evaluation/detail")){
			action = new EvaluationDetailAction();
		}else if(command.equals("/views/evaluation/list")){
			action = new EvaluationListAction();
		}else if(command.equals("/views/question/insert")){
			action = new QAInsertAction();
		}
		return action;
	}
}
