<%@page import="test.product.dao.ProductDao"%>
<%@page import="test.product.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<ProductDto> list2 = ProductDao.getInstance().getRankedViewCount();
	

%>
    
