package test.evaluation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.evaluation.dao.EvaluationCommentDao;
import test.evaluation.dao.EvaluationDao;
import test.evaluation.dto.EvaluationCommentDto;

public class EvaluationCommentInsertAction extends Action{
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      // 파라미터로 전달되는 내용 읽어오기
	   int comNum = Integer.parseInt(request.getParameter("comNum"));
	   String writer = (String) request.getSession().getAttribute("id");
      int ref_group = Integer.parseInt(request.getParameter("ref_group"));
      String target_id = request.getParameter("target_id");
      String content = request.getParameter("content");
      int comment_group = Integer.parseInt(request.getParameter("comment_group"));
      int comSort_group = EvaluationCommentDao.getInstance().getSortSequence();
      
      EvaluationCommentDto dto = new EvaluationCommentDto();
      dto.setComNum(comNum);
      dto.setComWriter(writer);
      dto.setComRef_group(ref_group);
      dto.setComTarget_id(target_id);
      dto.setComContent(content);
      dto.setComSort_group(comSort_group);
      
      if(comment_group == 0)
    	  dto.setComComment_group(comSort_group);
      else
    	  dto.setComComment_group(comment_group);
      
     
      EvaluationCommentDao.getInstance().insert(dto);

      return new ActionForward("/views/product/product_info.do?productNum="+ref_group, true);
   }
}