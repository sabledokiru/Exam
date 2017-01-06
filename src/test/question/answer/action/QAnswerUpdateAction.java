package test.question.answer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.question.answer.dao.QAAnswerDao;
import test.question.answer.dto.QAAnswerDto;

public class QAnswerUpdateAction extends Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      //1.수정할 num값 가지고오기
      int answerRef_num=Integer.parseInt(request.getParameter("num"));
      int productNum = Integer.parseInt(request.getParameter("productNum"));
      //2.수정할 content내용 가지고오기
      String answerContent=request.getParameter("content");
      System.out.println(answerContent);
      System.out.println(answerRef_num);
      //3. DB에 저장할 dto 객체 생성
      QAAnswerDto dto=new QAAnswerDto();
      //4. DB에 수정된 값들 저장하기
      dto.setAnswerContent(answerContent);
      dto.setAnswerRef_num(answerRef_num);
      
      QAAnswerDao.getInstance().update(dto);
      System.out.println(dto.getAnswerContent());
      System.out.println(dto.getAnswerRef_num());
      //5. redirect 이동
      return new ActionForward("/views/product/product_info.do?productNum="+productNum, true);
   }
   
}