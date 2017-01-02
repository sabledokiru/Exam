package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추상 클래스 
public abstract class Action {
	//추상 메소드 정의하기 
	public abstract ActionForward execute
		(HttpServletRequest request, HttpServletResponse response);
}
