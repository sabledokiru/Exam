package test.controller;

import test.action.MainAction;
import test.action.SignInFormAction;
import test.action.SignUpFormAction;
import test.members.action.InsertMembersAction;
import test.product.action.ProductInsertformAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory(){}
	//자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance(){
		if(factory==null){
			factory=new UserActionFactory();
		}
		return factory;
	}
	//인자로 전달되는 command 를 수행할 Action Type 객체를 생성해서
	//리턴해주는 메소드
	public Action action(String command){
		Action action=null;
		if(command.equals("/main")){
			action = new MainAction();
		}
		else if(command.equals("/users/signin_form")){
			action = new SignInFormAction();
		}
		else if(command.equals("/users/signup_form")){
			action = new SignUpFormAction();
		}
		else if(command.equals("/views/users/sign")){
			action = new InsertMembersAction();
		}else if(command.equals("/views/product/private/insertform")){
			action = new ProductInsertformAction();
		}
		return action;
	}
}














