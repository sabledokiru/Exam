package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 *  중간에 요청을 가로채서 인코딩 설정을 해줄 필터객체를 
 *  생성할 클래스 정의하기 
 */
public class EncodingFilter implements Filter{
	
	//인코딩 value 를 담을 맴버필드 정의하기
	private String myEncoding;
	
	@Override
	public void destroy() {
		
	}
	//필터가 동작 될때 호출되는 메소드 
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter()");
		
		//1. 요청을 가로 채서 해야할 작업 작성
		if(req.getCharacterEncoding()==null){
			//인코딩 설정하기
			req.setCharacterEncoding(myEncoding);
		}
		
		//2. 다음 작업 수행하기 
		chain.doFilter(req, res);
	}
	//필터가 최초 동작될때 호출되는 메소드 
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()");

		myEncoding=config.getInitParameter("myEncoding");
	}
	
}










